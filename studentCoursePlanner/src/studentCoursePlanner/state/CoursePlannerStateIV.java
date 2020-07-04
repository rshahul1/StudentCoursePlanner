package studentCoursePlanner.state;
import java.util.ArrayList;

import studentCoursePlanner.state.Student;

public class CoursePlannerStateIV implements CoursePlannerInterface{

	CourseContext course;
	Student student;
	int groupDcount = 0;
	String c;
	int state=3;
   
	public CoursePlannerStateIV(CourseContext Course, Student s) {
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
     groupDcount++;
		
     if(groupDcount>student.getCheckcount()) {
    	 course.setState(state);
    	 student.setCheckcount(groupDcount);
    	 
     }
	}

	 public int check(String s) {
	    	int i;
	    	int flag=0;
	    	int sem=student.getsemester();
	    //	System.out.println("SEM:"+sem+" COURSE:"+s);
			  int[] sem_array=student.getCourse_semester();
	    	ArrayList<String> c_allocated = student.getCourses_allocated();
	    //	System.out.println("Allocated array:"+c_allocated);
			for( i=0;i<c_allocated.size();i++) {
			  if((c_allocated.get(i)).equals(s)) {
		//		  System.out.println("C_allocated:"+c_allocated.get(i));
				  break;
			  }
			}
			 if(sem!=sem_array[i])
				  flag=1;
			return flag;
	    }
	@Override
	public String checkPrerequisite(String s) {
	
		if(s.equals("M")) {
			return "True";
		}
		else if(s.equals("N")) {
			int flag = check("M");
			      if(flag==1)
				  return "True";
			  }
			
		else if(s.equals("O")) {
			int flag1=check("M");
			int flag2=check("N");
			
			if(flag1==1&&flag2==1)
				return "True";
		}	
		
		else {
			
			int flag1=check("M");
			int flag2=check("N");
			int flag3=check("O");
			
			
			if(flag1==1&&flag2==1&&flag3==1)
				return "True";	
		}
		return "False";
	}

}
