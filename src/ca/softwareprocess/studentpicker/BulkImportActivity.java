package ca.softwareprocess.studentpicker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

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

}
