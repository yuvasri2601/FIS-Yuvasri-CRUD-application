import java.util.*;

import java.sql.*;
public class Project {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int ch;
		do
		{
			int choice;
			
			
			System.out.println("Select Menu:");
			System.out.println("1.INSERT");
			System.out.println("2.DELETE");
			System.out.println("3.SEARCH");
			System.out.println("4.UPDATE");
			System.out.println("5.SHOW");
			choice=sc.nextInt();
			//StudentService obj = new StudentService();
			switch(choice)
			{
			
				//Insert the data
				case 1:
				{
					StudentService.insert();
				}
					
				break;
				
				//Delete data
				case 2:
				{
					StudentService.delete();
				}
						
				break;	
				
				case 3:
				{
					StudentService.search();
				}
					
					
				break;
				
				case 4:
				{
					StudentService.update();
				}
					
					
				break;
				
				//display data
				case 5:
				{
					StudentService.search1();
						
					
				}	
				break;
				
				default:
					System.out.println("You have selected wrong Menu!!!! Please Try again!!!");
			}
			System.out.println("Do you want to continue?(1/0):  ");
			ch = sc.nextInt();
			
			
		}while(ch==1);

		  
	}

}
