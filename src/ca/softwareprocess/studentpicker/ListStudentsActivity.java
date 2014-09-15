package ca.softwareprocess.studentpicker;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ListStudentsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_students);
		
		StudentListManager.initManager(this.getApplicationContext());
		
		ListView listView = (ListView) findViewById(R.id.studentListView);
		Collection<Student> students = StudentListController.getStudentList().getStudents();
		final ArrayList<Student> list = new ArrayList<Student>(students);
		final ArrayAdapter<Student> studentAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(studentAdapter);
		
		// Added a change observer!
		StudentListController.getStudentList().addListener(new Listener() {			
			@Override
			public void update() {
				list.clear();
				Collection<Student> students = StudentListController.getStudentList().getStudents();
				list.addAll(students);
				studentAdapter.notifyDataSetChanged();
			}
		});
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				AlertDialog.Builder adb = new AlertDialog.Builder(ListStudentsActivity.this);
				adb.setMessage("Delete "+list.get(position).toString()+"?");
				adb.setCancelable(true);
				final int finalPosition = position;
				adb.setPositiveButton("Delete", new OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Student student = list.get(finalPosition);				
						StudentListController.getStudentList().removeStudent(student);												
					}										
				});
				adb.setNegativeButton("Cancel", new OnClickListener() {					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				//Toast.makeText(ListStudentsActivity.this, "Is the on click working?", Toast.LENGTH_SHORT).show();
				adb.show();
				return false;
			}			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_students, menu);
		return true;
	}

	public void addStudentAction(View v) {
		Toast.makeText(this, "Adding a student!", Toast.LENGTH_SHORT).show();
		StudentListController st = new StudentListController();
		EditText textView = (EditText) findViewById(R.id.addStudentNameText);
		st.addStudent(new Student(textView.getText().toString()));
	}
	
}
 