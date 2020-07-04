package studentCoursePlanner.state;

import java.util.ArrayList;

import studentCoursePlanner.state.Student;

public class CourseContext {
	Student Student;

	CoursePlannerInterface CoursePlannerStateI;
	CoursePlannerInterface CoursePlannerStateII;
	CoursePlannerInterface CoursePlannerStateIII;
	CoursePlannerInterface CoursePlannerStateIV;
	CoursePlannerInterface CoursePlannerStateV;
	
//	CoursePlannerStateI state1 = new CoursePlannerStateI(this,Student);
	
	
	ArrayList<String> Coursepref=new ArrayList<String>();
	int Currentstate = 0;
	
	public CourseContext(ArrayList<String> Coursepref,Student s) {
		this.Student=s;
		CoursePlannerStateI state1 = new CoursePlannerStateI(this,Student);
		CoursePlannerStateII state2 = new CoursePlannerStateII(this,Student);
		CoursePlannerStateIII state3 = new CoursePlannerStateIII(this,Student);
		CoursePlannerStateIV state4 = new CoursePlannerStateIV(this,Student);
		CoursePlannerStateV state5 = new CoursePlannerStateV(this,Student);
		
		String[] groupA = {"A","B","C","D"};
    	String[] groupB = {"E","F","G","H"};
		String[] groupC = {"I","J","K","L"};
	    String[] groupD = {"M","N","O","P"};
	 	String[] groupE = {"Q","R","S","T","U","V","W","X","Y","Z"};
		
		this.Coursepref =Coursepref;
		
        
	 for(int i=0;i<Coursepref.size();i++) {   
		   //
		//  System.out.println("initial i:"+Coursepref.get(i));
			int sem1 =Student.getsemester();
			//System.out.println("SEM1:"+sem1+"Course:"+Coursepref.get(i));
		     if(sem1==1) {
		  //  	System.out.println("Inside sem:"+sem1);
			  for(int j=0;j<4;j++) {                             //GROUP A
				
				if((Coursepref.get(i)).equals(groupA[j])) {	
					String check=state1.checkPrerequisite(Coursepref.get(i));
				//	System.out.println("CHECK:"+check);
					if(check.equals("True")) {
						//System.out.println("Inside if");
						state1.assign(Coursepref.get(i));
						//Coursepref.remove(i);
						
					//	System.out.println(Coursepref);
					}
					else {
						Student.setWaitlist(Coursepref.get(i));
					 //   System.out.println("Waitlist"+Student.getWaitlist());
					    //Coursepref.remove(i);
					  //  System.out.println(Coursepref);
					}
			     }	
		     }
			
			for(int j=0;j<4;j++) {                              //GROUP B
				
				if(Coursepref.get(i).equals(groupB[j])) {	
					String check=state2.checkPrerequisite(Coursepref.get(i));
					if(check.equals("True")) {
						state2.assign(Coursepref.get(i));
					//	Coursepref.remove(i);
					}
					else {
						Student.setWaitlist(Coursepref.get(i));
					//	 System.out.println("Waitlist"+Student.getWaitlist());
					 //   Coursepref.remove(i);
					    }
				}
			}
		     
	            
			
			for(int j=0;j<4;j++) {                                 //GROUP C
				
				if(Coursepref.get(i).equals(groupC[j])) {	
					String check=state3.checkPrerequisite(Coursepref.get(i));
					if(check.equals("True")) {
						state3.assign(Coursepref.get(i));
					//	Coursepref.remove(i);
					}
					else {
						Student.setWaitlist(Coursepref.get(i));
						// System.out.println("Waitlist"+Student.getWaitlist());
					  //  Coursepref.remove(i);
					    }
				}	
			}
		     
		           
			
			for(int j=0;j<4;j++) {                               //GROUP D
				
				if(Coursepref.get(i).equals(groupD[j])) {	
					String check=state4.checkPrerequisite(Coursepref.get(i));
					if(check.equals("True")) {
						state4.assign(Coursepref.get(i));
						Coursepref.remove(i);
					}
					else {
						Student.setWaitlist(Coursepref.get(i));
					   // Coursepref.remove(i);
					//	 System.out.println("Waitlist"+Student.getWaitlist());
					    }
				}	
		     }
 			 
 			for(int j=0;j<4;j++) {                             //GROUP E
 				
 				if(Coursepref.get(i).equals(groupE[j])) {	
 				//	System.out.println("GROUPE:"+Coursepref.get(i));
 					String check=state5.checkPrerequisite(Coursepref.get(i));
 					if(check.equals("True")) {
 						state5.assign(Coursepref.get(i));
 						//Coursepref.remove(i);
 					//	 System.out.println("Waitlist"+Student.getWaitlist());
 					}
 				}	
 		     }
		     }//End of first semester
		     
		     else {
		    	   ArrayList<String> wl= Student.getWaitlist();
		    	   
		    	//   System.out.println("wl:"+wl);
		    	
		    	 for(int g=0;g<wl.size();g++) {
		    		// int h=0;
		    		 int flagcheck=0;
		    	//	 System.out.println("Sizewl:"+wl.size());
		    	//	 System.out.println("g:"+g+" "+"valg:"+wl.get(g)+"valh:"+wl.get(g));
		    		 
		    		 for(int j=0;j<4;j++) {
		    			if((wl.get(g)).equals(groupA[j])) {	
		 					String check=state1.checkPrerequisite(wl.get(g));
		 					if(check.equals("True")) {
		 						state1.assign(wl.get(g));
		 						 flagcheck=1;
		 						 wl.remove(g);
		 				//		 System.out.println("Waitlist"+Student.getWaitlist());
		 				//		 System.out.println("afterg:"+g);
		 					}
		 				}	 
		    	    }
		    		 if(flagcheck==1)
		    			 continue;
		    		 
		    		 for(int j=0;j<4;j++) {
			    			if((wl.get(g)).equals(groupB[j])) {	
			 					String check=state2.checkPrerequisite(wl.get(g));
			 			//		System.out.println("Check:"+check);
			 					if(check.equals("True")) {
			 						state2.assign(wl.get(g));
			 						flagcheck=1;
			 						 wl.remove(g);
			 				//		 System.out.println("Waitlist"+Student.getWaitlist());
			 				//		 System.out.println("afterg:"+g);
			 					}
			 				}	 
			    	    }
		    		 if(flagcheck==1)
		    			 continue;
		    		 
		    		 
		    		 for(int j=0;j<4;j++) {
			    			if((wl.get(g)).equals(groupC[j])) {	
			 					String check=state3.checkPrerequisite(wl.get(g));
			 				//	System.out.println("Check:"+check);
			 					if(check.equals("True")) {
			 						state3.assign(wl.get(g));
			 						flagcheck=1;
			 						 wl.remove(g);
			 					//	 System.out.println("Waitlist"+Student.getWaitlist());
			 					}
			 				}	 
			    	    }
		    		 if(flagcheck==1)
		    			 continue;
		    		 
		    		 
		    		 for(int j=0;j<4;j++) {
			    			if((wl.get(g)).equals(groupD[j])) {	
			 					String check=state4.checkPrerequisite(wl.get(g));
			 				//	System.out.println("Check:"+check);
			 					if(check.equals("True")) {
			 						state4.assign(wl.get(g));
			 						flagcheck=1;
			 						 wl.remove(g);
			 				//		 System.out.println("Waitlist"+Student.getWaitlist());
			 					}
			 				}	 
			    	    }
		    		 if(flagcheck==1)
		    			 continue;
		    		 
		    		 for(int j=0;j<4;j++) {                            
		  				
		  				if(wl.get(g).equals(groupE[j])) {	
		  				//	System.out.println("GROUPE:"+Coursepref.get(i));
		  					String check=state5.checkPrerequisite(wl.get(g));
		  					if(check.equals("True")) {
		  						state5.assign(wl.get(g));
		  						wl.remove(g);
		  						//Coursepref.remove(i);
		  				//		 System.out.println("Waitlist"+Student.getWaitlist());
		  					}
		  				}	
		  		     }  
		    	 }
		    	   //end of waitlist
		    	 
		    	 for(int j=0;j<4;j++) {                             //GROUP A
						
						if((Coursepref.get(i)).equals(groupA[j])) {	
							String check=state1.checkPrerequisite(Coursepref.get(i));
						//	System.out.println("CHECK:"+check);
							if(check.equals("True")) {
								state1.assign(Coursepref.get(i));
							}
							else {
								Student.setWaitlist(Coursepref.get(i));
					//		    System.out.println("Waitlist"+Student.getWaitlist());
							}
					     }	
				     }
		    	 

					for(int j=0;j<4;j++) {                              //GROUP B
						
						if(Coursepref.get(i).equals(groupB[j])) {	
							String check=state2.checkPrerequisite(Coursepref.get(i));
							if(check.equals("True")) {
								state2.assign(Coursepref.get(i));
							//	Coursepref.remove(i);
							}
							else {
								Student.setWaitlist(Coursepref.get(i));
							//	 System.out.println("Waitlist"+Student.getWaitlist());
							 //   Coursepref.remove(i);
							    }
						}
					}
					

					for(int j=0;j<4;j++) {                                 //GROUP C
						
						if(Coursepref.get(i).equals(groupC[j])) {	
							String check=state3.checkPrerequisite(Coursepref.get(i));
							if(check.equals("True")) {
								state3.assign(Coursepref.get(i));
							//	Coursepref.remove(i);
							}
							else {
								Student.setWaitlist(Coursepref.get(i));
						//		 System.out.println("Waitlist"+Student.getWaitlist());
							  //  Coursepref.remove(i);
							    }
						}	
					}
					
					
					for(int j=0;j<4;j++) {                               //GROUP D
						
						if(Coursepref.get(i).equals(groupD[j])) {	
							String check=state4.checkPrerequisite(Coursepref.get(i));
							if(check.equals("True")) {
								state4.assign(Coursepref.get(i));
							//	Coursepref.remove(i);
							}
							else {
								Student.setWaitlist(Coursepref.get(i));
							   // Coursepref.remove(i);
						//		 System.out.println("Waitlist"+Student.getWaitlist());
							    }
						}	
				     }
					
					for(int j=0;j<10;j++) {                             //GROUP E
		 				
		 				if(Coursepref.get(i).equals(groupE[j])) {	
		 				//	System.out.println("GROUPE:"+Coursepref.get(i));
		 					String check=state5.checkPrerequisite(Coursepref.get(i));
		 					if(check.equals("True")) {
		 						state5.assign(Coursepref.get(i));
		 						//Coursepref.remove(i);
		 					//	 System.out.println("Waitlist"+Student.getWaitlist());
		 					}
		 				}	
		 		     } 
		     }
		     
		     if(state1.groupAcount>=2&&state2.groupBcount>=2&&state3.groupCcount>=2&&state4.groupDcount>=2&&state5.groupEcount>=2) {
		    	 break;
		     }
		     
		    }
	}	

		
	
	public void setState(int state) {
		this.Currentstate=state;
	}
	public int getState() {
		// TODO Auto-generated method stub
		return Currentstate;
		
	}
	
	
	
	}
	
	
	

