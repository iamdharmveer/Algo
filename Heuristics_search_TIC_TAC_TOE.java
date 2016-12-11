package Tic_Tac_Toe;

import java.util.*;
class Heuristics_search_TIC_TAC_TOE{
    public static void drawBoard(char Board[]){
        System.out.println("|" + Board[6] + "|" + Board[7] + "|" + Board[8]+ "|");
        System.out.println("|" + Board[3] + "|" + Board[4] + "|" + Board[5]+ "|");
        System.out.println("|" + Board[0] + "|" + Board[1] + "|" + Board[2]+ "|");
    }
    public static char[] inputPlayerLetter(){
        char letter;
        char turn[] =new char[2];
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter your Mark('X' or 'O'): ");
        letter =sc.next().charAt(0);
        if(letter == 'X'){
            turn[0] ='X';	
            turn[1] ='O';
            return turn;
        }
        else{
            turn[0] ='O';	
            turn[1] ='X';
            return turn;	
        }
    }
    public static int whogoesFirst(){
        int turn;
        while(true){
            System.out.print("Enter who will start(1-Computer, 0-User): ");
            Scanner sc =new Scanner(System.in);
            turn =sc.nextInt();
            if(turn == 0 || turn == 1)
                return turn;
        }
    }
    public static void place(char Board[], char letter, int move){
        Board[move] =letter;
    }
    public static Boolean Winner(char Board[], char letter){
        if( (Board[6] == letter && Board[6] == Board[7] && Board[7] == Board[8]) || 
            (Board[3] == letter && Board[3] == Board[4] && Board[4] == Board[5]) || 
            (Board[0] == letter && Board[0] == Board[1] && Board[1] == Board[2]) ){
            return true;
        }
        if( (Board[6] == letter && Board[6] == Board[3] && Board[3] == Board[0]) || 
            (Board[7] == letter && Board[7] == Board[4] && Board[4] == Board[1]) || 
            (Board[8] == letter && Board[8] == Board[5] && Board[5] == Board[2]) ){
            return true;
        }
        if( (Board[6] == letter && Board[6] == Board[4] && Board[4] == Board[2]) ||
            (Board[8] ==letter && Board[8] == Board[4] && Board[4] == Board[0])){
            return true;
        }
        return false;
    }
    public static char[] getBoardCopy(char Board[]){
        char dupBoard[] =new char[9];
        for(int i =0;i<9;++i){
            dupBoard[i] =Board[i];
        }
        return dupBoard;
    }
    public static Boolean isspacefree(char Board[], int move){
        return Board[move] == ' ';
    }
    public static int getPlayerMove(char Board[]){
        int move;
        while(true){
            System.out.println("Enter your Move(1-9): ");
            Scanner sc =new Scanner(System.in);
            move =sc.nextInt();
            if(move == 1 || move == 2 || move == 3 || move == 4 || move == 5 || move == 6 || move == 7 || move == 8 || move == 9)
                if(isspacefree(Board, move-1))
                    return move-1;
        }
    }
    public static int chooseRandomMovefromList(char Board[], int movesList[]){
        ArrayList<Integer> possibleMoves =new ArrayList<Integer>();
        for(int i =0;i<movesList.length;++i){
            if(isspacefree(Board, movesList[i]))
                possibleMoves.add(movesList[i]);
        }
        if(possibleMoves.size()!=0){
            Random random =new Random();
            int randomnumber =possibleMoves.get(random.nextInt(possibleMoves.size()));
            return randomnumber;
        }
        else
            return -1;
    }
    public static int getComputerMove(char Board[], char computerletter){
        char playerletter;
        if(computerletter == 'X'){
            playerletter ='O';
        }
        else{
            playerletter ='X';
        }
        char copy[] =new char[9];
        //if we can win 
        for(int i =0;i<9;++i){
            copy =getBoardCopy(Board);
            if(isspacefree(copy, i)){
                place(copy, computerletter, i);
                if(Winner(copy, computerletter)){
                    return i;
                }
            }
        }
        //if player is winning
        for(int i =0;i<9;++i){
            copy =getBoardCopy(Board);
            if(isspacefree(copy, i)){
                place(copy, playerletter, i);
                if(Winner(copy, playerletter)){
                    return i;
                }
            }
        }
        //choose corners
        int move;
        int corners[] =new int[4];
        corners[0] =0;
        corners[1] =2;
        corners[2] =6;
        corners[3] =8;
        move =chooseRandomMovefromList(Board, corners);
        if(move != -1){
            return move;
        }
        //choose center
        if(isspacefree(Board, 4)){
            return 4;
        }
        //choose other than corner and center
        int sides[] =new int[4];
        sides[0] =1;
        sides[1] =3;
        sides[2] =5;
        sides[3] =7;
        return chooseRandomMovefromList(Board, sides);
    }
    public static Boolean isFull(char Board[]){
        Boolean f =true;
        for(int i =0;i<9;++i){
            if(Board[i] == ' ')
                f =false;
            }
        return f;
    }
    public static void main(String[] args){
        char Board[] =new char[9];
        for(int i =0;i<9;++i){
                Board[i] =' ';
        }
        char turns[] =new char[2];
        Scanner sc =new Scanner(System.in);
        turns =inputPlayerLetter();
        char playerletter =turns[0];
        char computerletter =turns[1];
        int turn =whogoesFirst();
        if(turn == 1){
            System.out.println("The Computer will go first.");	
        }
        else{
            System.out.println("The User will go first.");
        }
        Boolean gameisPlaying =true;
        while(gameisPlaying){
            if(turn == 0){
                //Player's Turn
                drawBoard(Board);
                System.out.println("");
                int move =getPlayerMove(Board);
                place(Board, playerletter, move);
                if(Winner(Board, playerletter)){
                    drawBoard(Board);
                    System.out.println("Hurray!!! You Won");
                    gameisPlaying =false;
                }
                else{
                    if(isFull(Board)){
                        drawBoard(Board);
                        System.out.println("The Game is a Tie!!!");
                        break;
                    }
                    else{
                        turn =1;
                    }
                }
            }
            else{
                //Computer's Turn
                drawBoard(Board);
                System.out.println("");
                int move =getComputerMove(Board, computerletter);
                place(Board, computerletter, move);
                if(Winner(Board, computerletter)){
                    drawBoard(Board);
                    System.out.println("You Lose");
                    gameisPlaying =false;
                }
                else{
                    if(isFull(Board)){
                        drawBoard(Board);
                        System.out.println("The Game is a Tie!!!");
                        break;
                    }
                    else{
                        turn =0;
                    }
                }
            }
        }
    }
}