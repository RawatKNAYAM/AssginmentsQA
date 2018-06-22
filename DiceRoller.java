
import java.util.Random;
import java.util.Scanner;

public class DiceRoller 
{
    public static void main(String []args)
    {
        Random z = new Random();
        Scanner t = new Scanner(System.in);
        int faces;
        int result;
        char ch;
       do
       {
            System.out.println("How many faces.");
            faces = t.nextInt();
            if(faces==2)
              {
                 int r=z.nextInt(faces)+1;	
                 if (r==1) {
              	   System.out.println("ONE");
              			  }
                 else if(r==2)
                 {
              	   System.out.println("TWO");
                 }
              }
                 else if( faces == 4 || faces == 6 )
                
                    {
                       result = z.nextInt(faces) + 1;
                       if (result==1) {
                    	   System.out.println("ONE");
                    			  }
                       else if(result==2)
                       {
                    	   System.out.println("TWO");
                       }
                       else if(result==3) {
                    	   System.out.println("THREE");
                       }
                       else if(result==4) {
                    	   System.out.println("FOUR");
                       }
                       else if(result==5) {
                    	   System.out.println("FIVE");
                       }
                       else {
                    	   System.out.println("SIX");
                       }
                    }
            
                 else {
                	 System.out.println("Wrong choice");
                	 }
            System.out.println("Do you wish to continue : press y else anything ");
                 ch=t.next().charAt(0);
        } while(ch=='y');
        } 
  
}