
import java.util.Scanner;

public class CoustomerMangmentSystem {
     static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       String ageMsg,purchaseMsg,yearMsg,genderMsg,cityMsg,idMsg, firstNameMsg,lastNameMsg;
 
//-------------------------------MESSAGES-----------------------------------------     
{   
    idMsg = "\nEnter coustomer ID: ";
    firstNameMsg ="Enter coustomer first name: ";
    lastNameMsg = "Enter coustomer last name: ";
    ageMsg ="Enter the age of customer: ";
    purchaseMsg = "Enter the customer total number purchases: ";
    yearMsg = "Enter the customer regisrtation year: ";
    genderMsg = "Enter the gender of customer: ";
    cityMsg = "Enter the city of customer: "; 
}
//-----------------------------END MESSAGES------------------------------------------

  int size = welcome();
 //----------------------------CREATE ARRAYS--------------------------------------
    int[] ID = new int[size];
    String[] firstNames = new String[size];
    String[] lastNames = new String[size];
    double[] purchases = new double[size];
    int[] yeares = new int[size];
    int[] ages = new int[size];
    String[] genderes = new String[size];
    String[] cities = new String[size];
 //---------------------------- END CREATE ARRAYS--------------------------------

 int i = -1; 
 int numberOfcoustomerInSystem = 0;
// ****************************LOOP 1**********************************
 loop1 :while(true)
 {
    minu();
 
 
 
char choice = check_choice();
//--------------------------ADDING TO THE ARRAY-------------------------------------
       //-----------------if choice was 'a'------------------------------
        if(choice == 'a')
        {
                     if(numberOfcoustomerInSystem >= size)
                     {
                         System.out.println("you cannot add more coustome!");
                         continue;
                     }
            i++;
            ID[i] = ID(idMsg);
            sc.nextLine();
            firstNames[i] = firstName(firstNameMsg);
            lastNames[i]=  lastName(lastNameMsg);
            purchases[i]= purchase(purchaseMsg);
            sc.nextLine();
            yeares[i]= year(yearMsg);
            sc.nextLine();
            ages[i] = age(ageMsg);
            sc.nextLine();
            genderes[i]= gender(genderMsg);
            cities[i]=  city(cityMsg);
            System.out.printf("\n***************************************************\n"
              +"%s (ID #%d) has been added to the system successfully.\n"
              ,firstNames[i]+" "+lastNames[i],ID[i]);
            
            numberOfcoustomerInSystem++;
       }
        //------------------------END ADDING TO THE ARRAY-------------------------------------
        
        //-----------------if choice was 'd'------------------------------       
        else if(choice == 'd')
        {
            //----------------nothing added to the array----> NOTHING DISPLAY------------------
            if(numberOfcoustomerInSystem == 0)
            {
                System.out.println("\nnothing added yet!!\n"
                        + "<< you have to add the coustomeres first. >>");
                continue;
            }
            
            //----------------DISPLAY INFORMATION-----------------------------
            else //-------------else 1-------------------
            { 
         // ****************************LOOP 2*******************************
loop2 : while(true)
{
                System.out.print("\n> Enter 1 to search/display customer by ID number\n"
                        + "> Enter 2 to search/display customer by name\n"
                        + "> Enter 0 to return to the Main Menu\n\n"
                        + "> Enter choice: ");
                int searchChoice = sc.nextInt();
                
                //--------------------------SWITCH----------------------------
                int index = -1;
                switch(searchChoice)
                {
                    case 1:
                        System.out.print("Enter customer id: ");
                        int coustomerID = sc.nextInt();
                        index = search(ID, coustomerID, numberOfcoustomerInSystem);
                        break;
                    case 2:
                        System.out.print("Enter customer first name: ");
                        String firstName = sc.next();
                        System.out.print("Enter customer last name: ");
                        String lastName = sc.next();
                        index = search(firstNames, lastNames, firstName, lastName, numberOfcoustomerInSystem);
                        break;
                    case 0:
                        continue loop1;
                    default:
                        System.out.println("Invalid input\n");
                        continue;
                }
               
                //-----------------------END SWITCH---------------------------
                if(index < 0)
                {
                    System.out.println("\n<< coustomer not fonud >>\n");
                    continue;
                }
                
            DisplayInformation(ID[index], firstNames[index],lastNames[index], purchases[index]
                    , yeares[index] , ages[index], genderes[index], cities[index]);
            
            
            }
            
}
          // ****************************END LOOP 2**********************************
         //-------------------------end else 1---------------------------------------
        }
        
        //-----------------if choice was 'e'------------------------------
        else
        {
            System.out.println("Thank you for using the Customer Mangment System ^_^\n"
                    + "Good Bye.\n");
            System.exit(0);
        }
        
        
 }
 // ****************************END LOOP 1**********************************

 }
    
    
    
    
    //------------------------------METHODES----------------------------------------
    public static int welcome()
    { 
     System.out.printf("-------------------------------------------------------------------\n"
                + "--------\t  %28s   \t---------\n-------------------------------------------------------------------\n"
                ,"Welcome to the Customer Mangment System");
        System.out.print("> Please enter the registration year (ex: 2017): ");
        int year = sc.nextInt();
        System.out.print("> How many customers do you want to register in year "+ year+": ");
        int coustomerNum = sc.nextInt();
        System.out.println("-------------------------------------------------------------------");

        return coustomerNum;
    }
    
    public static void minu() {
        System.out.printf("\n\n-------------------------------------------------------------------\n"
                + "--------\t\t%28s\t\t---------\n--------\t\t\t%15s\t\t\t---------\n"
                + "-------------------------------------------------------------------\n"
                + "|%20s\t\t\t\t|\n|%20s\t\t\t|\n|%20s\t\t\t|\n"
                + "-------------------------------------------------------------------\n"
                ,"Customer Mangment System", "*MAIN MENU*", "A/a: Enter A or a for Adding a Customer",
                 "D/d: Enter D or d for printing Customer Details",
                 "E/e: Enter E or e for Exiting the program");
    }

    public static char check_choice() 
    {
        while(true)
        {
            System.out.print("Please enter your choice: ");
           char choice = (sc.next()).charAt(0);
           
//     --------------------SWITCH------------------------
           
           switch(Character.toLowerCase(choice))
           {
               case 'a':
                   return 'a';
               case 'd':
                   return 'd';
               case 'e':
                   return 'e';
               default:
                   System.out.println("\n<< Invalid selection! Please try again >>\n");
                   continue;

           }
 //     --------------------END SWITCH------------------------
              
       
        }
      
    }
    
     public static int ID(String msg) 
     {
         
         System.out.print(msg);
         int id = sc.nextInt();
         return id;
     }
     
     public static String firstName(String msg)
    {
        System.out.print(msg);
        String firstName = sc.nextLine();
        return firstName;
    }
    
     public static String lastName(String msg)
    {
        System.out.print(msg);
        String lastName = sc.nextLine();
        return lastName;
    }
     
    public static int age(String msg) 
    {
        while(true)
        {
            System.out.print(msg);
            int age = sc.nextInt();
            
            if(age < 15 || age > 90)
            {
                System.out.println("\n>     Invalid input! (age must be between 15 and 90)\n"
                        + ">     please try again.\n");
                continue;
            }
            
            else
                return age;
        }
        
    }
    
    public static double purchase(String msg) 
     {
         
         System.out.print(msg);
         double total = sc.nextDouble();
         return total;
     }
     
    public static int year(String msg) 
    {
        System.out.print(msg);
        int year = sc.nextInt();
        return year;
    }
    
    public static String gender(String msg)
    {
     while(true)
     {
         System.out.print(msg);
        String gender = sc.nextLine();
        
            if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))
            { 
                    return gender;
            }
            
            else
            {
               System.out.println("\n>    Invalid input! (gender must be male or female)\n"
                        + ">    please try again.\n");
                continue;
            }
     }         
    }
    
    public static String city(String msg)
    {
        while(true)
        {
        System.out.print(msg);
        String city = sc.nextLine();
        
        return city;
        }
        
    }
    
    public static int search(int[] id, int coustomerID, int count)
    {
        for(int i =0; i< count; i++)
        {
            if(coustomerID == id[i])
                return i;
        }
        
       return -1;  
    }
    
     public static int search(String[] firstNames ,String[] lastNames , String firstName , String lastName ,int count)
    {
        int Findex = -1, Lindex = -2;
        for(int i =0; i< count; i++)
        {
            if(firstName.equalsIgnoreCase(firstNames[i]))
                  Findex = i;
        }
        
        for(int i =0; i< count; i++)
        {
            if(lastName.equalsIgnoreCase(lastNames[i]))
                 Lindex = i;
        }
        
        if(Findex == Lindex)
            return Findex;
        else
            return -1;  
}
     
     public static void DisplayInformation(int ID, String firstName, String lastName, double totalPurchases, int year, int age, String gender, String city) 
     {
         System.out.printf("> Coustomer Details:\n"
                 + "> %5s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\n"
                 + "> --------------------------------------------------------------------------------------------------------------------------\n"
                 + " %5d\t  %15s\t%5.2f\t%15d\t%20d\t%15s\t%15s\n"
                 ,"ID","Name","Number of purchases","Registration Year","Age","Gender","City"
                 ,ID,firstName+" "+lastName,totalPurchases,year,age,gender,city);
         
     }
}

}

  