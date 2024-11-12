
import java.util.Scanner;


public class X_O_Enhanced {

   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) 
    {

        // print the instructions
        System.out.println(" F --> first row or column"
                       + "\n S --> second row or column"
                       + "\n T --> third row or column");
      
       // dclare and initialize variables
       String X_or_O = "X" , keepPlaying = "";
       int row = 0, coulmn = 0,round = 1,win = 0,count_win_X=0 ,count_win_O =0,count_no_win =0;
     
       // declare, creat and initialize an 2D aaray
       String[][] Allchar = Allchar_XO("|", row, coulmn);
       
       //-------------cloning Allchar with out choice------------------------
       String[][] keepPlayingTable = clone(Allchar);
       //-------------------------------------------------------
       
       //print empty table
       print_X_O(Allchar);
    
       
//******************************start loop 1******************************//
loop1: while(true)
       {
           
    //------------------------start loop 2------------------------------//       
    loop2: while(X_or_O.equals("X"))
           {
               //ask the player which row they want
               row = row_choice(X_or_O);
               //ask the player which column they want
               coulmn = coulmn_choice(X_or_O);
               
               //--------------check if the cell is empty-----------------
               if(isCellEmpty(Allchar, row, coulmn) == false)
               {
                   System.err.println("\t\t!! this place is already taken !!"
                           + "\n\t\t    << choose another one >>");
                   continue loop2;
               }
               //-----------------finished checking cell-----------------
               
               
               // add the player choice to 2D array
               Allchar[row][coulmn] = X_or_O;
               
               //print the table with player choice
              print_X_O(Allchar);
            
            
            //<<<<<<<< check all probabilities of win for player X >>>>>>>>
            if( check_all_probabilities(Allchar) )
                    
              {
                  /* increade num of win and
                   count for the summary in the end of game */
                   win++; count_win_X++;
                   
                  // if he won print this 
                   System.err.println("\u001B[32m\t\t\tPlayer " + X_or_O + " won\u001B[0m");
  
                   //ask him if he want to keep playing
                   System.out.print("\ndo you want to keep playing (enter Y or N)? ");
                   keepPlaying = sc.next();
                    
                    //if the player want to keep play
                    if(keepPlaying.equalsIgnoreCase("y"))
                    { 
                        // make a copy so that the orginal dose not affect
                        Allchar = clone(keepPlayingTable);

                        //resst values
                        round = 1; win = 0; X_or_O ="X";   //player X start playing

                        // go back to beginning of the game
                        continue loop1;
                    }
                  
                  //if the player dose not want to keep play
                  else
                    {
                        //print summary
                        gameOver(count_win_X, count_win_O, count_no_win);
                           
                        //exit game
                        return;
                    }

              }
            //-----------------finished checking all probabilities---------------

            /* if no one win yet continue tha game until round 
            over or one of the player wins */
            
              //increase the number of rounds
              round++; 
             
              //changing player to O
              X_or_O = "O";
           }
    //------------------------end loop 2------------------------------//       
     
    // check if anyone win
            if(round >= 9 && win == 0)
            { 
                //count for the summary in the end of game
                count_no_win++;
                
                System.out.println("\u001B[31m\t\t<< No own win >>\u001B[0m");

                //resst values
                round =1;

                // make a copy so that the orginal dose not affect
                Allchar = clone(keepPlayingTable);

                 //ask him if he want to keep playing
                   System.out.print("\ndo you want to keep playing (enter Y or N)? ");
                   keepPlaying = sc.next();
                
                //if the player want to keep play
                    if(keepPlaying.equalsIgnoreCase("y"))
                    {
                        // make a copy so that the orginal dose not affect
                        Allchar = clone(keepPlayingTable);

                        //resst values
                        round = 1; win = 0; X_or_O ="X";   //player X start playing

                        // go back to beginning of the game
                        continue loop1;
                    }
                  
                  //if the player dose not want to keep play
                  else
                    {
                        //print summary
                        gameOver(count_win_X, count_win_O, count_no_win);
                           
                      //exit game
                      return;
                    }
            }
    //end check
    
    //------------------------start loop 3------------------------------//       
    loop3: while(X_or_O.equals("O"))
           {
               //ask the player which row they want
               row = row_choice(X_or_O);
               //ask the player which column they want
               coulmn = coulmn_choice(X_or_O);
               
               
               //--------------check if the cell is empty-----------------
               if(isCellEmpty(Allchar, row, coulmn) == false)
               {
                   System.err.println("\t\t!! this place is already taken !!"
                           + "\n\t\t    << choose another one >>");
                   continue loop3;
               }
               //-----------------finished checking cell------------------
               
               
               // add the player choice to 2D array
               Allchar[row][coulmn] = X_or_O;
               
               //print the table with player choice
               print_X_O(Allchar);
              
             
             //<<<<<<<< check all probabilities of win for player O >>>>>>>>
             if(  check_all_probabilities(Allchar)  )
              {
                  /* increade num of win and
                   count for the summary in the end of game */
                   win++; count_win_O++; 
                   
                   // if he won print this 
                   System.err.println("\u001B[36m\t\t\tPlayer " + X_or_O + " won\u001B[0m");
                  
                   //ask him if he want to keep playing
                   System.out.print("\ndo you want to keep playing (enter Y or N)? ");
                   keepPlaying = sc.next();
                  
                  //if the player want to keep play
                  if(keepPlaying.equalsIgnoreCase("y"))
                  {
                       // make a copy so that the orginal dose not affect
                       Allchar = clone(keepPlayingTable);
                       
                       //resst values
                       round = 1; win = 0;  X_or_O ="X";  //player X start playing
                       
                       // go back to beginning of the game
                       continue loop1; 
                  }
                  
                  //if the player dose not want to keep play
                  else
                    {
                        //print summary
                        gameOver(count_win_X, count_win_O, count_no_win);
                           
                      //exit game
                      return;
                    }
              }
              //-----------------finished checking all probabilities---------------

            /* if no one win yet continue tha game until round 
            over or one of the player wins */
            
             
             //increase the number of rounds
              round++;
             
              //changing player to X
              X_or_O = "X";
           }
    //------------------------end loop 3------------------------------//       
       
   
        }      
//******************************end loop 1******************************//      
      
               
    }
//############################## END MAIN ##################################
           
  
    
    
    
    
//************************************************************************
                             //METHODES//
//************************************************************************

    //player choice which row
    public static int row_choice(String X_or_O) {
        
        // dclare and initialize variables
        String choice = "";
        int row = 0;
        
//**************************** start loop **********************************
        loop1: do
        {
            // ask the player
            System.out.print("Enter a row(F, S, or T) for player "+X_or_O+" : ");
            choice = sc.next().toLowerCase();
         
         //check the choice
         switch (choice) {
            case "f":
                row = 0;
                break loop1;
            case "s":
                row = 1;
                break loop1;
            case "t":
                row = 2;
                break loop1;
            default:
                System.err.println("\t\t!! wrong slection try again !!");
                continue;
                         }
        }       
        while(true);
//**************************** end loop **********************************
        return row;
    }
    
    //player choice which coulmn
    public static int coulmn_choice(String X_or_O) {
        
       // dclare and initialize variables
       String choice = "";
        int column = 0;
 
 //**************************** start loop **********************************
        loop1: do
        {
            // ask the player
            System.out.print("Enter a column(F, S, or T) for player "+X_or_O+" : ");
            choice = sc.next().toLowerCase();
            
        //check the choice    
        switch (choice) 
             {
            case "f":
                column = 1;
                break loop1;
            case "s":
                column = 3;
                break loop1;
            case "t":
                column = 5;
                break loop1;
            default:
                System.err.println("\t\t!! wrong slection try again !!");
                continue;
             }
        }
        while(true);
//**************************** end loop **********************************
        return column;
    }
    
    //2D array with players choices
    public static String[][] Allchar_XO(String X_or_O,int rowChoice,
            int coulmnChoice ) {
        
        // (2D arr) table with empty choices 
        String[][] choices = {
                            {"|",  " "  ,"|",   " "   ,"|",  " "  ,"|\n","-------------------\n"},
                            {"|",  " "  ,"|",   " "   ,"|",  " "  ,"|\n","-------------------\n"},
                            {"|",  " "  ,"|",   " "   ,"|",  " "  ,"|\n","-------------------\n"},
                          };
        
        // add player choice to the table (2D arr)
        choices[rowChoice][coulmnChoice] = X_or_O;
        
       
       return choices;
}
    
    //print the 2D array
    public static void print_X_O(String[][] arr) {
    
     //header
     System.out.println("  -------------------");
       
        for (int row = 0; row < arr.length; row++) {
            for (int coulmn = 0; coulmn < arr[row].length; coulmn++){
        System.out.print("  "+arr[row][coulmn]);
          
            }
       }
        
    }
     
    //get the element of the left/right diameter in 1D arrat
    public static String[] diameter(String[][] arr,int z,int j,int k) 
    {
        String [] X_O = {"1","2","3"}; //default values
        
            if(arr[0][z] !=" ")    
            X_O[0] = arr[0][z];    //first element
            
            if(arr[1][j] !=" ")
            X_O[1] = arr[1][j];   //second element
            
            if(arr[2][k] !=" ")
            X_O[2] = arr[2][k];   //third element
        
 
        return X_O;
    }

    //get the element of the first/second/third row in 1D array
    public static String[] row(String[][] arr,int z, int j , int k, int y) 
    {
        String [] X_O = {"1","2","3"};//default values
        
            if(arr[z][j] !=" ") 
            X_O[0] = arr[z][j];    //first element
            
            if(arr[z][k] !=" ") 
            X_O[1] = arr[z][k];   //second element
            
            if(arr[z][y] !=" ") 
            X_O[2] = arr[z][y];   //third element
     
     
        return X_O;
    }
    
    //get the element of the first/second/third coulmn in 1D array
    public static String[] coulmn(String[][] arr,int z, int j , int k, int y) 
    {
        String [] X_O = {"1","2","3"};//default values
        
       
            if(arr[j][z] !=" ")
            X_O[0] = arr[j][z];     //first element
            
            if(arr[k][z] !=" ")
            X_O[1] = arr[k][z];     //second element
            
            if(arr[y][z] !=" ")
            X_O[2] = arr[y][z];     //third element
     
        return X_O;
    }
     
    //check if all element in diameter/row/column is the same
    public static boolean is_the_same(String[] arr)
     {          // arr --> diameter or row or coulmn <-- arr //
         
        // first_element =   diameter[0]  or  row[0]   or coulmn[0]
        String first_element = arr[0]; 
        for (int i = 1; i < arr.length; i++)   
        {
             if( first_element.equals(arr[i]) == false )
                  return false; // if there is eny diffrent element 
        }
        
        return true;  // if all element is the same
    }
    
    
    public static boolean check_all_probabilities(String[][] Allchar) {
        
        boolean check_all  = ( is_the_same(diameter(Allchar, 1, 3, 5))
               || is_the_same(diameter(Allchar, 5, 3, 1))
               || is_the_same(row(Allchar, 0, 1, 3, 5))
               || is_the_same(row(Allchar, 1, 1, 3, 5)) 
               || is_the_same(row(Allchar, 2, 1, 3, 5))
               || is_the_same(coulmn(Allchar, 1, 0, 1, 2))
               || is_the_same(coulmn(Allchar, 3, 0, 1, 2))
               || is_the_same(coulmn(Allchar, 5, 0, 1, 2)) );
        
        
        return check_all;
    }
    
    
    // check if the cell is empty
    public static boolean isCellEmpty(String[][] Allchar,
            int rowChoice, int coulmnChoice) {
        
        
        if(Allchar[rowChoice][coulmnChoice].equals("X")
        || Allchar[rowChoice][coulmnChoice].equals("O"))
            return false; // if it was not empty
        
         
        return true; //if it was empty
    }
    
    //cloning 2D array
    public static String[][] clone(String[][] Allchar) {
        String[][] clone = new String[Allchar.length][Allchar[0].length];
        
        for (int row = 0; row < Allchar.length; row++) {
            for (int column = 0; column < Allchar[row].length; column++) {
                
               clone[row][column] = Allchar[row][column];
            }
            
        }
        
        return clone;
    }

    //game over
    public static void gameOver(int count_win_X 
            ,int count_win_O, int count_no_win) 
             {
                      
                System.err.println("\n\t\t\t  GAME OVER");
                        
                            //print summary
                 System.out.printf( "\t|--------------------------------------------|\n"
                                   + "\t|      X       |      O       |     draw     |\n"
                                   + "\t|--------------------------------------------|\n"
                                   + "\t|%7d       |%7d       |%7d       |            \n"
                                   + "\t|              |              |              |\n"
                                   + "\t|--------------------------------------------|\n"
               ,count_win_X , count_win_O,count_no_win);
                      
                    }
        
    
    
}
