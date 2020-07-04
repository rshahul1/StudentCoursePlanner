package studentCoursePlanner.driver;

import java.awt.List;
import java.util.ArrayList;

import java.util.Arrays;

import studentCoursePlanner.state.CourseContext;
import studentCoursePlanner.state.Student;
//import java.util.List;
import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.util.Results;

public class Driver {

	public static void main(String args[]){
          
		if ( (args.length != 2) || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program needs to accept only 2 argumnets.");
		    System.exit(0);
	    }
	
		int student_id;
		
		String[] init_values_s;
		FileProcessor fp=new FileProcessor();
		String student_info;
		student_info=fp.readLine(args[0]);
			
			init_values_s=student_info.split(":");
			student_id=Integer.parseInt(init_values_s[0]);
						
			
			String[] Cpref=init_values_s[1].split(" ");
			ArrayList <String> Cpreferences = new ArrayList<String>(Arrays.asList(Cpref));
			
	      //	System.out.println(Cpreferences);	
			Student student = new Student(student_id,Cpreferences);
			 CourseContext course = new CourseContext(Cpreferences,student);
			
			    String output= student.getStudent_id()+":"+(student.getCourses_allocated())+" "+student.getsemester()+" "+course.getState();
			    
	     //  System.out.println(output);
			    Results r = new Results();
			    r.writeToStdout(output);
				r.writeToFile(output,args[1]);
				
			    
	      
}
}

