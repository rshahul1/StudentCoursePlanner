package studentCoursePlanner.state;

import java.util.ArrayList;

public class Student {
	
	private int student_id;
	ArrayList <String> course_preference = new ArrayList<String>();
	ArrayList <String> courses_allocated= new ArrayList<String>();
	private int[] course_semester = new int[50];
	ArrayList<String> waitlist = new ArrayList<String>();
	int count =0 ;
	int countcopy =0;
	int semester =1;
    int wc=0,i=0;	
    int checkcount=0;                   // check the focus of major
	public Student(int sid,ArrayList<String> c_pref){
		this.setStudent_id(sid);
		this.setCourse_preference(c_pref);
	
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public ArrayList<String> getCourse_preference() {
		return course_preference;
	}

	public void setCourse_preference(ArrayList<String> course_pref) {
		this.course_preference = course_pref;
	}

	public ArrayList<String> getCourses_allocated() {
		return courses_allocated;
	}

	public void setCourses_allocated(String c_allocated) {
		
		(this.courses_allocated).add(c_allocated);
		//System.out.println("Student course allocated:"+courses_allocated);
		if(courses_allocated.size()%3==0) {
			semester++;
		}
	}
	public int getsemester() {
		return semester;
	}

	public ArrayList<String> getWaitlist() {
		return waitlist;
	}

	public void setWaitlist(String wl) {
		//System.out.println("inside Waitlist:"+wl);
		(this.waitlist).add(wl);
	}

	public int getCheckcount() {
		
		return checkcount;
	}

	public void setCheckcount(int groupcount) {
		
		checkcount=groupcount;
		
	}

	public int[] getCourse_semester() {
		return course_semester;
	}

	public void setCourse_semester(int course_semester) {
		this.course_semester[i++] = course_semester;
	}
}
