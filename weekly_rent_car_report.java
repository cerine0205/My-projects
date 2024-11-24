
import java.util.Scanner;


public class weekly_rent_car_report {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) 
    {
         
       String[] days = {"Sunday","Monday","Tuesday","Wenesday","Thursday"};
       String[] vehicelsName = {"Sedan","Luxury","SUVs"};
       int[] totalNumOfRented ={74,37,44};

        int[][] rented = Num_Of_Rented_Vehicles( days);
        Report(days, rented, totalNumOfRented, vehicelsName);

        
    }//end main
    
//---------------------methodes-------------------------
    public static int[][] Num_Of_Rented_Vehicles(String[] days)
    {
        String[] messages = {"\tNumber of sedan cars rented: "
                           ,"\tNumber of luxury cars rented: "
                           ,"\tNumber of SUVs cars rented: "};
      
       int[][] rented = new int[5][3];
       
        for (int row = 0; row < rented.length; row++)
        {
            System.out.printf("\nPlease enter the number of rented vehicles for %s:\n",days[row]);
            for (int column = 0; column < rented[row].length; column++)
            {
                System.out.print(messages[column]); 
                rented[row][column] = sc.nextInt();
            }
        }
        return rented;
    }
    
    public static void Report(String[] days,int [][] rentedes
            , int[]totalNumOfRented, String[] vehiclesNames) 
    {
        // print the header
        System.out.println("""
                           
      ---------------------------------------------------------------------------------------------------------------------
                                       ******   Jeddah Rent_A_Car Weekly Report   ******
      ---------------------------------------------------------------------------------------------------------------------
                           """);
        int rented,unrented;
        double persent,avg,totalPersent;
       
        for (int row = 0; row < rentedes.length; row++)
        {
            totalPersent =0;
            System.out.printf("Day %d: %s\n"
                    + "\t%s  \t  %s  \t  %s  \t  %s\n"
            ,(row+1),days[row]
            ,"Vehicle Type","No. of Vehicles rented"
            ,"No. of Vehicles unrented","% of vehicles rented");
            
            for (int coulmn = 0; coulmn < rentedes[row].length; coulmn++) 
            { 
                 rented = rentedes[row][coulmn];
                 unrented = totalNumOfRented[coulmn] - rented ; 
                 persent = (double)rented / totalNumOfRented[coulmn] *100;
               
                System.out.printf("\t%s  %25d %27d %30.2f%s\n"
                ,vehiclesNames[coulmn], rented, unrented, persent,"%");
                
                totalPersent += persent;
            }
            
            avg = totalPersent / 3;
            System.out.printf("\nAverage Percentage for Rentedd vehicels:"
                    + " %.2f%s\n%s\n\n"
                    ,avg,"%","---------------------------------------------------------------------------------------------------------------------");

        }
        
    }
    
    //end methodes
}//end class
