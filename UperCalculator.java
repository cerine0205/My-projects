
import java.util.Scanner;
public class UperCalculator {

   
    public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       
        String welcome, ridesTab,rides,optionTab,option,provideTab,ratingTab,summary,answer =" ";
        int number,CancellationFee,MinimumFee,rating,count,
                xi,xe,xr,li,le,lr,bi,be,br;
        double baseFare ,costPerMinute ,costPerKM ,serviceFee ,rideDisKM,rideTimeMin,expected;
     CancellationFee = MinimumFee = xi = li = bi = xe = le = be = xr = lr = br = count = 0;
     baseFare = costPerMinute = costPerKM = serviceFee = 0;
     boolean isbreak = false;
        
// -----------------------welcome------------------------  

        welcome = "------------------------------------------------------\n"
                + "###       Welcome to Uper Fare Calculator          ###\n"
                + "------------------------------------------------------\n"
                + "| 1  : Get fare information about availabale rides   |\n"
                + "| 2  : Get a Fare Estimate for your Journey          |\n"
                + "| 3  : Submit Rating of your Ride                    |\n"
                + "| 4  : Exit and display summary                      |\n"
                +"-------------------------------------------------------\n"
                + "> Plaease enter your choice...";

       
 
// ----------------------WHILE-------------------------------
loop1 : do
{
     System.out.print(welcome);
        number = sc.nextInt();
        
        if (number == 4)
            break loop1;
  
    if (number > 4 ||  number <= 0 )
     {
        System.out.println("Invalid Input!!!Please Try Again...");
       
         continue; 
     }
  
    
// -----------------------rides------------------------------- 
loop2 : while(true)
{
        ridesTab = "\n\n----------------------------------------\n"
                + "***              RIDES              ***\n"
                + "------------------------------------------\n"
                + "| X or x  : UberX                        |\n"
                + "| L or l  : UberXL                       |\n"
                + "| B or b  : UberBlack1                   |\n"
                + "| R or r  : Return to Main Menu          |\n"
                +"-------------------------------------------\n"
                + "> Plaease enter your choice...";
        
        System.out.print(ridesTab);
        rides = sc.next().toUpperCase();
        
        
        
        switch (rides)
        {
            case "X":
                baseFare = 3.2;
                costPerMinute = 0.25;
                costPerKM  = 0.9;
                serviceFee = 0;
                CancellationFee =8;
                MinimumFee = 8;
                break;
                   
            case "L":
                baseFare = 5.5 ;
                costPerMinute = 0.4;
                costPerKM  = 1.25;
                serviceFee = 0;
                CancellationFee = 12;
                MinimumFee = 12;
                break;
                
            case "B":
                baseFare = 9.5;
                costPerMinute = 0.85;
                costPerKM  = 1.8;
                serviceFee = 1.3;
                CancellationFee =20;
                MinimumFee = 20;
                break;
            case "R":
              isbreak = true;
              break;
              
            default:
                System.out.print("Invalid Input!!! Please enter (X,L,B,R)");
                continue;
             
       }
        
        if (isbreak == true){
            isbreak = false;
            break loop2;}
       
// -------------------number == 1-----------------------
 if ( number == 1)
    {
      loop3: while(true)
      {
                
            optionTab = "\n\n----------------------------------------\n"
                + "***              OPTIONS              ***\n"
                + "------------------------------------------\n"
                + "| B or b  : Base fare                    |\n"
                + "| M or m  : Cost per minute              |\n"
                + "| K or k  : Cost per Km                  |\n"
                + "| S or s  : Service fee                  |\n"
                + "| C or c  : Cancellation fee             |\n"
                + "| F or f  : Minimum fee                  |\n"
                + "| R or r  : Previous Menu                |\n"
                +"-------------------------------------------\n"
                + "> Plaease enter your choice...";
            
             System.out.print(optionTab);
             option = sc.next().toUpperCase();
             
             
             
             switch (option)
             {
                 case "B" :
                     option = baseFare + "";
                     break;
                 case "M":
                     option = costPerMinute + "";
                      break;
                 case "K":
                     option = costPerKM  + "";
                      break;
                 case "S" :
                     option = serviceFee + "";
                      break;
                 case "C":
                     option = CancellationFee + "";
                      break;
                 case "F":
                     option = MinimumFee + "";
                     break;
                 case "R":
                     isbreak = true;
                     break;
                 default:
                     System.out.print("Invalid Input!!! Please enter (B,M,K,S,C,F,R)");
                       continue;
                     
             }
             
             if ( isbreak == true){
                 isbreak = false;
                  break loop3;}
             
             System.out.println("the cost is " + option+" SR");
             
           switch (rides)
        {
            case "X":
                xi++;
                break;
            case "L":
               li++;
                break;
            case "B":
               bi++;
         }  
           
         break loop2;  
        }

    }    
//-------------------------number == 2---------------------------------
 else if ( number == 2)
   {
       loop4: while(true)
       {
         System.out.print("\n\nPlease provide the information about your journey: \n"
                        + "---------------------------------------------------------\n"
                        + "Ride time in minutes: ");
          rideTimeMin = sc.nextDouble();
          System.out.print("Ride time in KM(s): ");
          rideDisKM =sc.nextDouble();
          expected = (baseFare + ( rideTimeMin * costPerMinute) + ( rideDisKM * costPerKM ) + serviceFee) ;
          System.out.printf("---------------------------------------------------------\n"
          + ">  Expected ride fare: %.2f SR <\n ", expected );
           System.out.printf("---------------------------------------------------------\n\n");
        
        
          switch (rides)
        {
            case "X":
                xe++;
                break;
            case "L":
               le++;
                break;
            case "B":
               be++;
         } 
         break loop2;
       }
     
   }
       
        
//---------------------------number == 3 ---------------------------------
else
   {
       loop5 : while(true)
       {
            ratingTab = "\n\n----------------------------------------\n"
                + "***              RATING              ***\n"
                + "------------------------------------------\n"
                + "| 1  : Poor                         |\n"
                + "| 2  : Borderline                   |\n"
                + "| 3  : Satisfactor                  |\n"
                + "| 4  : Good                         |\n"
                + "| 5  : Outstanding                  |\n"
                +"-------------------------------------------\n"
                + "> Plaease enter your choice...  (1-5): ";
            
            System.out.print(ratingTab);
            rating = sc.nextInt();
            
              System.out.print("\nThank you for your rating!\n"
                +"-------------------------------------------\n"
                + "you give rating > "+ rating +" < \n "
                + "-------------------------------------------\n");
            
              switch (rides)
        {
            case "X":
                xr++;
                break;
            case "L":
               lr++;
                break;
            case "B":
               br++;
         } 
              break loop2;
        }
   }     
        
 }
}
while(number !=4);
//----------------------------END LOOP----------------------------------------
        
    System.out.println("\n\n---------------------------------------------------------------------------------------\n"
                + "###                                     SUMMARY                                     ###\n"
                + "----------------------------------------------------------------------------------------\n"
                + "| Ride             | # of fare info.    |  # Fare Est.       | # of Submitted Ratings |\n");
    System.out.printf("| %10s       |%11d         |%11d         |%12d            |\n","UberX",xi,xe,xr);
    System.out.printf("| %10s       |%11d         |%11d         |%12d            |\n","UberXL",li,le,lr);
    System.out.printf("| %10s       |%11d         |%11d         |%12d            |\n","UberBlack",bi,be,br);
    System.out.println("----------------------------------------------------------------------------------------\n"
                + "  Thank you for using Uber Fare Calculation System!");
        
        
        
        
        
        
        
        
    }
    
}
