package ca.softwareprocess.studentpicker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;


public class StudentListManager {
	static final String prefFile = "StudentList";
	static final String slKey = "studentList"; 
	
	Context context;
	
	static private StudentListManager studentListManager = null;
	
	public static void initManager(Context context) {
		if (studentListManager == null) {
			if (context==null) {
				throw new RuntimeException("missing context for StudentListManager");
			}
			studentListManager = new StudentListManager(context);
		}		
	}
	
	public static StudentListManager getManager() {
		if (studentListManager==null) {
			throw new RuntimeException("Did not initialize Manager");
		}
		return studentListManager;
	}
	
	
	public StudentListManager(Context context) {
		this.context = context;
	}

	public StudentList loadStudentList() throws ClassNotFoundException, IOException {
		SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
		String studentListData = settings.getString(slKey, "");
		if (studentListData.equals("")) {
			return new StudentList();
		} else {
			return studentListFromString(studentListData);
		}
	}
	static public StudentList studentListFromString(String studentListData) throws ClassNotFoundException, IOException {
		ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(studentListData, Base64.DEFAULT));
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (StudentList)oi.readObject();	
	}
	static public String studentListToString(StudentList sl) throws IOException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(sl);
		oo.close();
		byte bytes[] = bo.toByteArray();
		return Base64.encodeToString(bytes,Base64.DEFAULT);
	}
	
	public void saveStudentList(StudentList sl) throws IOException {
		SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
		Editor editor = settings.edit();
		editor.putString(slKey, studentListToString(sl));
		editor.commit();
	}

}
