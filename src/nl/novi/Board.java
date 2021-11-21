package nl.novi;

public class Board {
    /* - methode: public static outputdatatype methodeNaam(inputDatatype inputDatatypenaam)
       show board:
     */
    public static void printBoard(String[] board){

        for (int i = 0; i< board.length; i++){

            boolean sideEndTrack = (i + 1) % 2 == 0;
            boolean isField2 = i == 1;
            boolean isField11 = i == 7;
            boolean isField14 = i == 9;

            if ( i < 10){
                System.out.print(board[i] + "  | ");
            }else{
                System.out.print(board[i] + " | ");
            }
            if (sideEndTrack){
                System.out.println();
            }
            if (sideEndTrack && isField2){
                System.out.print("------------Start");
                System.out.println();
            }
            if (sideEndTrack && isField11){
                System.out.print("------------Finish");
                System.out.println();
            }
        }
    }
}
