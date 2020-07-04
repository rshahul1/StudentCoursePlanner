package studentCoursePlanner.state;
import java.util.ArrayList;
import studentCoursePlanner.state.Student;

public class CoursePlannerStateIII implements CoursePlannerInterface{
	CourseContext course;
	Student student;
	int groupCcount = 0;
	String c;
   int state =2;
	

	public CoursePlannerStateIII(CourseContext course, Student s) {
		this.course=course;
		this.student=s;
		
	}

	@Override
	public void assign(String s) {
		
		
		c=s;
	//	System.out.println("inside assign");
   //  student.setCourses_allocated(c);
     int course_semester = student.getsemester();
     student.setCourse_semester(course_semester);
     student.setCourses_allocated(c);
     groupCcount++;
		
     if(groupCcount>student.getCheckcount()) {
    	 course.setState(state);
    	 student.setCheckcount(groupCcount);
    	 
       }
	}
	
	public int check(String s) {
    	int i;
    	int flag=0;
    	int sem=student.getsemester();
		  int[] sem_array=student.getCourse_semester();
		//  for(int u=0;u<sem_array.length;u++)
		 // System.out.println(sem_array[u]);
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
		if(s.equals("I")) {
			return "True";
		}
		else if(s.equals("J")) {
			int flag = check("I");
			      if(flag==1)
				  return "True";
			  }
			
		else if(s.equals("L")) {
			int flag1=check("I");
			int flag2=check("J");
			
			if(flag1==1&&flag2==1)
				return "True";
		}	
		
		else {
			
			int flag1=check("I");
			int flag2=check("J");
			int flag3=check("K");
			
			
			if(flag1==1&&flag2==1&&flag3==1)
				return "True";	
		}
		return "false";
	
	}

}
