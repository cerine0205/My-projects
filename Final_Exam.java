
import java.util.Scanner;


public class Final_Exam {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        
    loop: while(true) { //start while loop
            int choice = menu();
            
            switch (choice) {  //start switch
                case 1:
                    program1();
                    break;
                case 2:
                    program2();
                    break;
                case 3:
                    program3();
                    break;
                case 4: // """ text block """
                      System.out.println(""" 
                                         Student Name: Cerine 
                                         Student Major: Computer Science
                                         """);
                      break;
                case 0:
                    System.out.println("Thank you :) ");
                    break loop;
                default:
                    System.out.println("Incorrect choice, please try again.");
               } //end switch
            
        } // end while loop
     
       
    } //end main

    
//-------------------------METHODS-------------------------
   
    public static int menu()
    {
        System.out.print("-------------------------------------------\n"
                         + "CPCS 202 Final Lap Exam      \n"
                         + "Enter 1 to start program 1.  \n"
                         + "Enter 2 to start program 2.  \n"
                         + "Enter 3 to start program 3.  \n"
                         + "Enter 4 to show information about me.  \n"
                         + "Enter 0 to exit.  \n"
                         + "-------------------------------------------\n"
                         + "Enter your choice: ");
        return sc.nextInt();
    }
    
//-------------------------program1----------------------------             
    public static double calcR(int x,int y,int z,int k)
    {
        double part1 = Math.pow(x-y,5);
        double part2 =  Math.abs(z-k) ; 
        double part3 = k*(y*z/ (double)x);
        
        double r = k+ Math.sqrt(part1 + part2 - part3);
        
        return r;
    }
    
    public static void program1()
    {
        System.out.print("Enter x: ");
        int x = sc.nextInt();
        
        System.out.print("Enter y: ");
        int y = sc.nextInt();
        
        System.out.print("Enter z: ");
        int z = sc.nextInt();
        
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.printf("r(%d,%d,%d,%d) = %.2f\n"
                ,x,y,z,k,calcR(x,y,z,k)  );

    }
    
 //-------------------------program2--------------------------    
    public static char getGrade(double score, double best)
    {
        if(score >= best-10)
            return 'A';
        if(score >= best-20)
            return 'B';
        if(score >= best-30)
            return 'C';
        if(score >= best-40)
            return 'D';
        
        return 'F';
       
    }
    
    public static double getBestScore(double[] scores) 
    {
        if(scores == null  ) return -1;
        if(scores.length == 0  ) return 0;
          
        double best = scores[0];
        for (int i = 1; i < scores.length ; i++)
        {
            if(scores[i] > best)
                best = scores[i];
        }
        
        return best;
 
    }
    
    public static double getTotalScores(double[] scores)
    {
      if(scores == null  ) return -1;
        if(scores.length == 0  ) return 0;
          
        double total = scores[0];
        for (int i = 1; i < scores.length ; i++)
        {
              total += scores[i];
        }
        
        return total;
   
    }
    
    public static void program2()
    {
        //ask the user for the num of score
        System.out.print("Enter the num of scores: ");
        int num = sc.nextInt();
        
        //creat 1d array for scores
        double[] scores = new double[num];
        
        //store the scores in the array
        for (int i = 0; i < num; i++) 
        {
            System.out.print("Enter score #"+ (i+1) +" : ");
            scores[i] = sc.nextDouble();
            
        }
        
        //best grade
        double best = getBestScore(scores);
        System.out.printf("----\n"
                + "The best grade is %.2f\n",best);
        
        // print the grade
        for (int i = 0; i < scores.length; i++) 
        {
            System.out.printf("[%d] - Score: %.2f, Grade: %c\n"
                    ,(i+1) ,scores[i] , getGrade(scores[i] , best) );
            
        }
        //total and avg
        double total = getTotalScores(scores);
        double avg = total / num;
        System.out.printf("----\n"
                + "The total scores: %.2f"
                + "\nThe average scores: %.2f, Grade: %c\n"
                ,total,avg,getGrade(avg, best));
    }
    
 //--------------------------program3---------------------------
    public static void toggle(char[] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if(Character.isUpperCase(arr[i]) )
                arr[i] = Character.toLowerCase(arr[i]);
            
            else
                arr[i] = Character.toUpperCase(arr[i]);
            
        }
        
         
    }
    
    public static void program3() 
    {
       char[] arr = new char[100];
       
       System.out.println("Enter character, enter anything else to terminate"
                             + "\ninputting process: ");
       
       //let the user enter the character
        for (int i = 0; i < 100; i++) 
        {
            char c = sc.next().charAt(0);
            
            //if it was not character terminate loop
            if(Character.isAlphabetic(c) == false)
                break;
            
            //if it was char save it in the arr
            arr[i] = c;
        }
        
        //print arr after toggle 
        toggle(arr);
        System.out.println("result: ");

        for (int i = 0; i < 100 ; i++) 
        {
            if(arr[i] != (char)0 && // (char)0 --> for space 
               Character.isAlphabetic(arr[i]) )  
                System.out.print(arr[i] +" ");
        }
        
        //for new line
        System.out.println("");
           
     }
    
// end methodes 
    
}//end class
