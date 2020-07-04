package studentCoursePlanner.state;
import studentCoursePlanner.state.Student;

public class CoursePlannerStateV implements CoursePlannerInterface{

	CourseContext course;
	Student student;
	int groupEcount = 0;
	String c;
	int state=4;
   
	public CoursePlannerStateV(CourseContext Course, Student s) {
		// TODO Auto-generated constructor stub
		this.course=Course;
		this.student=s;
	}

	@Override
	public void assign(String s) {
		
		c=s;
	//	System.out.println("inside assign");
    
     int course_semester = student.getsemester();
     student.setCourse_semester(course_semester);
     student.setCourses_allocated(c);
     groupEcount++;
		
     if(groupEcount>student.getCheckcount()) {
    	 course.setState(state);
    	 student.setCheckcount(groupEcount);
    	 
       }

     }


	@Override
	public String checkPrerequisite(String s) {
		// TODO Auto-generated method stub
		return "True";
	}
}
