import java.util.Scanner;
public class SyntacticAnalaysisGithub {



 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg;
//------------take the text from user and check if it is empty------------
        do 
        {
           System.out.print("Enter your text message: ");
           msg =sc.nextLine();
        }
        while( msg.isEmpty());
        
// -----------------------loop1-------------------
loop1: while(true)
{
        displayMainMenu();
        int choice = sc.nextInt();
        sc.nextLine();
        
//        -----------------switch1----------------------
        switch(choice)
        {
            case 1:
                TokensCounter(msg);
                break;
            case 2:
                 System.out.println(" number of capital word = " +startWithCapital(msg));
                break;
            case 3:
                break;
            case 4:
                System.out.print("enter the word: ");
                String word = sc.nextLine();
                if (findWord(msg, word)) {
                    System.out.println("the word " + word + " exists in the message");
                } else {
                    System.out.println("the word " + word + " dose not exists in the message");
                }
                break;
            case 5:
                 System.out.println(">     Exiting the program.....\n>     Goodbye!");
                 System.exit(0);
                break;
            default:
                System.out.println("Wrong selection. Try again.");
         //    -----------------end of switch1----------------------
        }
//        ------------if choice =3 and loop2---------------
if(choice==3)
{  
    loop2: while(true)
    {    
                displayPrintMenu();
                int choice2 = sc.nextInt();
                sc.nextLine();
                //  -----------------switch2----------------------
                switch(choice2)
                {
                    case 1:
                        printTokens(msg);
                        break;
                    case 2:
                        printTokens( msg, 0);
                        break;
                    case 3:
                        printTokens( msg, 1);
                        break;
                    case 4:
                        break loop2;
                    default:
                         System.out.println("Wrong selection. Try again.");
                         continue;
                }
    }
}
             //  -----------------end of switch2 -------------and loop2-------and if----------
// -----------------------end loop 1------------------
                
        }
    }
     
    
    
//    -------------- dsisplay Main Menu Method------------------
    public static void displayMainMenu()
    {
        String mainMenu ="|---------------------------------------------------------------|\n"
                        +"|---------    Syntactic Analysis for a Text message   ----------|\n"
                        +"|---------------------------------------------------------------|\n"
                        +"|   1. compute tokens number (word, digits,..).                 |\n"
                        +"|   2. compute the num of words starting with a capital letter. |\n"
                        +"|   3. print the list of tokens.                                |\n"
                        +"|   4. find a word in the message.                              |\n"
                        +"|   5. exit.                                                    |\n"
                        +"|---------------------------------------------------------------|\n"
                        +"> please enter your choice: ";
                
        System.out.print(mainMenu);
  }
    
//    -------------- dsisplay Print Menu Method------------------
    public static void displayPrintMenu()
    {
        String printMenu ="|---------------------------------------------------------------|\n"
                        +"|---------    Syntactic Analysis for a Text message   ----------|\n"
                        +"|---------------------------------------------------------------|\n"
                        +"|                          print Menu                           |\n"
                        +"|   1. print all the tokens.                                    |\n"
                        +"|   2. print the digit tokens.                                  |\n"
                        +"|   3. print the word tokens.                                   |\n"
                        +"|   4. return to the main menu.                                 |\n"
                        +"|---------------------------------------------------------------|\n"
                        +"> please enter your choice: ";
                
        System.out.print(printMenu);
    }
    
//     ---------------print Tokens Array----------------
    public static void printTokens(String msg)
         {
             String[ ] word = msg.split(" ");
             for(int i=0; i < word.length; i++)
             {
             System.out.print(word[i]+" ,");
             }
              System.out.println();
         }
     
    
//    --------------  Print Tokens 2 Method------------------
    public static void printTokens(String msg, int token)
 {
         String [] list = msg.split(" ");
       boolean isDigit = false;
       int count =0;
          //  digit token     option 2 from print mnue

          // count the num of digits
          for(int j =0; j < msg.length(); j++)  {
               isDigit = Character.isDigit(msg.charAt(j));
           if(isDigit)
               count++;  }
               
             
      if (token == 0) 
      {
    // check if there is at least one number
          // if there is
         if (count != 0) 
         {
//print these numbers
         for (int i = 0; i < list.length; i++) 
             {
                 if (list[i].charAt(0) >= '0' && list[i].charAt(0) <= '9') 
                 {
                     System.out.print(list[i] + " ,");
                 }
             }
             System.out.println();
         }
        // if there is no number
         else 
         {
             System.out.println("No digit token in the message !!");
         }
     }
         
         //  word token      optin 3 from print mnue
         else if(token == 1) 
         {
         
        
            for(int i =0  ; i< list.length ; i++ )
            {
                 if(  (list[i].charAt(0))  >= 'a' &&  list[i].charAt(0)<= 'z')
                     System.out.print(list[i]+ " ,");
            
                 if(  (list[i].charAt(0))  >= 'A' &&  list[i].charAt(0)<= 'Z')
                     System.out.print(list[i]+" , ");
            }
            
           System.out.println();
         }
           
 }
    
//    --------------  Tokens Counter Method------------------
    public static void TokensCounter(String msg)
     {
       
        int token =1;
        int length  = msg.length();
//                 System.out.println("length-------> is "+ length);

        for(int i = 0; i< length; i++)
        {
            if(msg.charAt(i) == ' ')
            {
                token++;
            }
            
        }
        
        System.out.println("number of token is "+ token);
            
     }
    
//    --------------  start With Capital Method------------------
    public static int startWithCapital(String msg) {
        msg = msg.trim();
        String[] list = msg.split(" ");
        int count = 0;
        boolean isLastToken = false;
        int i = 0;
        while (isLastToken == false) {
            if (msg.indexOf(" ") == -1) {
                isLastToken = true;
            }
            String word;
            if (isLastToken == true) {
                word = msg;
            } else {
                word = msg.substring(0, msg.indexOf(" "));
            }

            char firstLetter = word.charAt(0);
            if (Character.isUpperCase(firstLetter)) {
                count++;
            }
            if (isLastToken != true) {
                msg = msg.substring(msg.indexOf(" ") + 1);
            }
        }
        return count;
    }

//    --------------  find Word Method------------------
    public static boolean findWord(String msg,String word)
          {
             boolean c = msg.toLowerCase().contains(word.toLowerCase());
              return c;
          }
    
    
    
}
