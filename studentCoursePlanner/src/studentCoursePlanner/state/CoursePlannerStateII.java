package studentCoursePlanner.state;
import java.util.ArrayList;

import studentCoursePlanner.state.Student;

public class CoursePlannerStateII implements CoursePlannerInterface{

	CourseContext course;
	Student student;
	int groupBcount = 0;
	String c;
	int state =1;
   
	
	public CoursePlannerStateII(CourseContext Course, Student s) {
		// TODO Auto-generated constructor stub
		this.course=Course;
		this.student=s;
	}

	
	
	@Override
	public void assign(String s) {
		// TODO Auto-generated method stub
		c=s;
		//System.out.println("inside assign");
     
     int course_semester = student.getsemester();
     student.setCourse_semester(course_semester);
     student.setCourses_allocated(c);
     groupBcount++;
		
     if(groupBcount>student.getCheckcount()) {
    	 course.setState(state);
    	 student.setCheckcount(groupBcount);
    	 
       }
	    	 
	     }
	
	public int check(String s) {
    	int i;
    	int flag=0;
    	int sem=student.getsemester();
    //	System.out.println("SEM:"+sem+" COURSE:"+s);
		  int[] sem_array=student.getCourse_semester();
    	ArrayList<String> c_allocated = student.getCourses_allocated();
    	//System.out.println("Allocated array:"+c_allocated);
		for( i=0;i<c_allocated.size();i++) {
		  if((c_allocated.get(i)).equals(s)) {
		//	  System.out.println("C_allocated:"+c_allocated.get(i));
			  break;
		  }
		}
		 if(sem!=sem_array[i])
			  flag=1;
		return flag;
    }
	
	@Override
	public String checkPrerequisite(String s) {
		
		if(s.equals("E")) {
			return "True";
		}
		else if(s.equals("F")) {
			int flag = check("E");
			      if(flag==1)
				  return "True";
			  }
			
		else if(s.equals("G")) {
			int flag1=check("E");
			int flag2=check("F");
			
			if(flag1==1&&flag2==1)
				return "True";
		}	
		
		else {
			
			int flag1=check("E");
			int flag2=check("F");
			int flag3=check("G");
			
			
			if(flag1==1&&flag2==1&&flag3==1)
				return "True";	
		}
		return "false";
	
	}
	}


