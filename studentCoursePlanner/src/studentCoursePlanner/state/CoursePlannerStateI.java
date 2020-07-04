package studentCoursePlanner.state;
import java.util.ArrayList;
import studentCoursePlanner.state.Student;

public class CoursePlannerStateI implements CoursePlannerInterface{
	CourseContext course;
	Student student;
	int groupAcount = 0;
	String c;
	int state =0;


	public CoursePlannerStateI(CourseContext Course,Student s) {
		
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
     
     groupAcount++;
		
     if(groupAcount>student.getCheckcount()) {
    	 course.setState(state);
    	 student.setCheckcount(groupAcount);
    	 
     }
	}
    public int check(String s) {
    	int i;
    	int flag=0;
    	int sem=student.getsemester();
    
		  int[] sem_array=student.getCourse_semester();
    	ArrayList<String> c_allocated = student.getCourses_allocated();
    
		for( i=0;i<c_allocated.size();i++) {
		  if((c_allocated.get(i)).equals(s)) {
		
			  break;
		  }
		}
		 if(sem!=sem_array[i])
			  flag=1;
		return flag;
    }

	@Override
	public String checkPrerequisite(String s) {
		
		if(s.equals("A")) {
			return "True";
		}
		else if(s.equals("B")) {
			int flag = check("A");
			      if(flag==1)
				  return "True";
			  }
			
		else if(s.equals("C")) {
			int flag1=check("A");
			int flag2=check("B");
			
			if(flag1==1&&flag2==1)
				return "True";
		}	
		
		else {
			
			int flag1=check("A");
			int flag2=check("B");
			int flag3=check("C");
			
			
			if(flag1==1&&flag2==1&&flag3==1)
				return "True";	
		}
		return "false";
	}


	

}
