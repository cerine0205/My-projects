import java.util.Scanner;

public class Bank_ATM {
static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        //user information
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
  
        double[] currentBalance = new double[1];
        System.out.print("Enter your current balance: ");
        currentBalance[0] = sc.nextDouble();
        //
        
        loop1: while(true){ // start while
            char choice = menu();
            switch(Character.toLowerCase(choice)){//start switch
                case 'w':
                    withdraw(currentBalance);
                    break;
                case 'd':
                    deposit(currentBalance);
                    break;
                case 't':
                    Transfere_Money(currentBalance);
                    break;
                case 'p':
                    info(name, currentBalance);
                    break;
                case 'e':
                    System.out.println("we are glad to serve you :) ");
                    break loop1;
                default:
                    System.out.println("Invalid input try again");
             }//end switch
            
        } // end while
       
       
        
    }//end main
    
//-----------------------Methodes------------------------------
    public static char menu() 
    {
        System.out.print("""
                           ---------------------------------------------
                           |          Welcome to The Bank ATM          |
                           ---------------------------------------------
                               > Enter W to Withdraw
                               > Enter D to Doposit
                               > Enter T to Transfere Money
                               > Enter P to Print user information
                               > Enter E to Exit
                           ---------------------------------------------
                           
                           Enter your choice:""" +" "); // +" " for space
        return sc.next().charAt(0);
        
    }
    
    public static double withdraw(double[] currentBalance) 
    {
        while (true) {//start while
            System.out.print("\n\t## you can withdraw up to 5,000 Riyals ##\n"
                    + "\t> Enter the amount to withdraw: ");
            double amount = sc.nextDouble();

            //---------------------check current balance---------------------
            if (amount > 5000) {
                System.out.println("\t> you cannot withdraw more than 5,000 Riyals");
                continue;
            }
            if (amount > currentBalance[0]) {
                System.out.println("\t> you do not have enough money\n");
                continue;
            }
            //---------------------------------------------------------------
            
            currentBalance[0] -= amount;

            //print the withdraw process
            System.out.printf("\t> You have been withdraw %.2f and your cuurent balance is %.2f Riyals\n",
                     amount, currentBalance[0]);

            return currentBalance[0];
        }//end while
    }
    
    public static double deposit(double[] currentBalance) 
    {
        while(true){//start while
         System.out.print("\n\t## you can deposit up to 10,000 Riyals ##\n"
                       + "\t> Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        
        //---------------------check current balance---------------------
        if(amount > 10000)
        {
            System.out.println("\t> you cannot deposit more than 10,000 Riyals");
            continue;
        }
        //-------------------------------------------------------------------
        currentBalance[0] += amount;
        
        //print the deposit process
        System.out.printf("\t> You have been deposit %.2f and your cuurent balance is: %.2f Riyals\n"
        ,amount, currentBalance[0]);
        
        return currentBalance[0];
        }//end while
    }
    
    public static double Transfere_Money(double[] currentBalance) 
    {  //declear 
        String[] receivingInfo;
        String receiving_Account,receiving_Name;
        
    while(true){//start while
         System.out.print("\n\t## you can transfere up to 8,000 Riyals ##\n"
                       + "\t> Enter the amount of money that you want to transfere: ");
        double amount = sc.nextDouble();
        
        //---------------------check current balance---------------------
        if(amount > 8000)
        {
            System.out.println("\t> you cannot transfere more than 8,000 Riyals");
            continue;
        }
        if(amount > currentBalance[0])
        {
            System.out.println("\t> you do not have enough money\n");
            continue;
        }
        //-------------------------------------------------------
        //modify the current balance
        currentBalance[0] -= amount;
        
        // ask for receivinf information
        receivingInfo = receiving_Info();
        receiving_Account = receivingInfo[0];
        receiving_Name = receivingInfo[1];
        
        //print the transfere process
        System.out.printf("\t> You have been transfere %.2f to %s and your cuurent balance is %.2f Riyals\n"
        ,amount, receiving_Name,currentBalance[0]);
        
        return currentBalance[0];
        }//end while
    }
    
    public static String[] receiving_Info()
    {
        String[] receivingInfo = new String[2];
        
        loop1:while (true) { //start while
            //ask for the number
            System.out.print("\n\t> Enter the Account number to send to"
                    + " (Must be consist of 10 digits) :");
            receivingInfo[0]= sc.next();
            
            //checking
            if (receivingInfo[0].length() != 10) { 
                System.out.println("\t it must be 10 digits");
                continue loop1;
            }//end checking
         break;   
        }//end while
        sc.nextLine();//clear the scanner
        
        loop2: while(true){//start while
        //ask for the name
        System.out.print("\t> Enter the Account Name: ");
        receivingInfo[1] = sc.nextLine();
        
        return receivingInfo;
        }//end while
    }
    
    public static void info(String name, double[] currentBalance )
    {
        System.out.printf("""
                          -----------------------------------
                                   Account Information
                          -----------------------------------
                          Account Name: %s
                          Account Balance: %.2f
                          ----------------------------------
                          """,name,currentBalance[0]); 
    }
    
//end methodes    
}//end class
