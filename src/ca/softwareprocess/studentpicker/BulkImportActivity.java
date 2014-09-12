package ca.softwareprocess.studentpicker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BulkImportActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bulk_student_import);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bulk_import, menu);
		return true;
	}

	public void addStudentsAction(View v) {
		EditText view = (EditText) findViewById(R.id.bulkStudentText);
		String text = view.getText().toString();
		StudentListController st = new StudentListController();
		st.bulkImport(text);
		view.setText("");
		Toast.makeText(this, "Thanks for the students!", Toast.LENGTH_SHORT).show();
	}
	
}
