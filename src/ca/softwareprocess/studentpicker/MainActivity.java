/*
Student Picker: Randomly pick students to answer questions

Copyright (C) 2014 Abram Hindle abram.hindle@softwareprocess.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.

*/
package ca.softwareprocess.studentpicker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StudentListManager.initManager(this.getApplicationContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void editStudents(MenuItem menu) {
		Toast.makeText(this, "Edit Students", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, ListStudentsActivity.class);
		startActivity(intent);
	}

	public void bulkImport(MenuItem menu) {
		Toast.makeText(this, "Bulk Import", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, BulkImportActivity.class);
		startActivity(intent);
	}
	
	public void chooseAStudent(View v) {		
		Toast.makeText(this, "Choose A Student", Toast.LENGTH_SHORT).show();
		StudentListController st = new StudentListController();
		try {
			Student s = st.chooseStudent();
			TextView view = (TextView) findViewById( R.id.chosenStudentTextView );
			view.setText(s.getName());
		} catch (EmptyStudentListException e) {
			Toast.makeText(this, "There are no students!", Toast.LENGTH_SHORT).show();
		}		
	}

}
