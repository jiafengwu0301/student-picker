package ca.softwareprocess.studentpicker;

import java.io.IOException;

public class StudentListController {
	
	// Lazy Singleton 
	private static StudentList studentList = null;
	// Warning: throws a runTimeException
	static public StudentList getStudentList() {
		if (studentList == null) {
			try {
				studentList = StudentListManager.getManager().loadStudentList();
				studentList.addListener(new Listener() {					
					@Override
					public void update() {
						saveStudentList();
					}
				});
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("Could not deserialize StudentList from StudentListManager");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("Could not deserialize StudentList from StudentListManager");
			}
		}
		return studentList;			
	}
	
	static public void saveStudentList() {
		try {
			StudentListManager.getManager().saveStudentList(getStudentList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Could not deserialize StudentList from StudentListManager");
		}		
	}
	
	public Student chooseStudent() throws EmptyStudentListException {
		return getStudentList().chooseStudent();		
	}

	public void addStudent(Student student) { 
		getStudentList().addStudent(student);
	}

	public void bulkImport(String text) {
		String [] lines = text.split("\n");
		StudentList sl = getStudentList();
		for (int  i = 0 ; i < lines.length ; i++) {
			String line = lines[i].trim();
			if (!line.equals("")) {
				Student s = new Student(line);
				sl.addStudent(s);
			}
		}
	}
}
