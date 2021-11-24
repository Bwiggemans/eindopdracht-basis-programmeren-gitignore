package nl.novi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Guinea Pig Race!!" + "\n");

        //Step 1: the game board
        String[] board = new String[10];

        for (int i = 0; i < 10; i++) {
            board[i] = " ";
        }

        Player player1 = new Player("PlayerA", "@");
        Player player2 = new Player("PlayerB","#");

        board[0] = player1.getToken();
        board[1] = player2.getToken();

        Board.printBoard(board);

        boolean hasWon = false;

        //Step 2: play game:
        while (hasWon == false){
            GenerateNumber generateNumber = new GenerateNumber();
            System.out.println("Guess the random number between 0 and 3 and win the game! ");

            Scanner userInput = new Scanner(System.in);

            int guessPlayer1;
            //Input validation Player1
            do {
                System.out.println("Please enter a number between 0 and 3:");
                while (!userInput.hasNextInt()) {
                    System.out.println("That's not a number. Please guess again!");
                    userInput.next(); // this is important!
                }
                guessPlayer1 = userInput.nextInt();
            } while (guessPlayer1 <= 0 || guessPlayer1 >= 3);
            System.out.println(player1.getName() + " has chosen " + guessPlayer1);

            int guessPlayer2;
            //Inputvalidation Player2
            do {
                System.out.println("Please enter a number between 0 and 3:");
                while (!userInput.hasNextInt()) {
                    System.out.println("That's not a number. Please guess again!");
                    userInput.next(); // this is important!
                }
                guessPlayer2 = userInput.nextInt();
            } while (guessPlayer2 <= 0 || guessPlayer2 >= 3);
            System.out.println(player2.getName() + " has chosen " + guessPlayer2);

            System.out.println();

            if (guessPlayer1 == generateNumber.getRandomNumber() && board[0] == player1.getToken()){
                board[2] = player1.getToken();
                board[0] = " ";
                guessPlayer1 = 0;

            }else if (guessPlayer2 == generateNumber.getRandomNumber() && board[1] == player2.getToken()){
                board[3] = player2.getToken();
                board[1] = " ";
                guessPlayer2 = 0;
            }
            if (guessPlayer1 == generateNumber.getRandomNumber() && board[2] == player1.getToken()){
                board[4] = player1.getToken();
                board[2] = " ";
                guessPlayer1 = 0;
            }else if (guessPlayer2 == generateNumber.getRandomNumber() && board[3] == player2.getToken()){
                board[5] = player2.getToken();
                board[3] = " ";
                guessPlayer2 = 0;
            }
            if (guessPlayer1 == generateNumber.getRandomNumber() && board[4] == player1.getToken()){
                board[6] = player1.getToken();
                board[4] = " ";
                guessPlayer1 = 0;
            }else if (guessPlayer2 == generateNumber.getRandomNumber() && board[5] == player2.getToken()){
                board[7] = player2.getToken();
                board[5] = " ";
                guessPlayer2 = 0;
            }
            if (guessPlayer1 == generateNumber.getRandomNumber() && board[6] == player1.getToken()){
                board[8] = player1.getToken();
                board[6] = " ";
                guessPlayer1 = 0;
            }else if (guessPlayer2 == generateNumber.getRandomNumber() && board[7] == player2.getToken()){
                board[9] = player2.getToken();
                board[7] = " ";
                guessPlayer2 = 0;
            }
            //Step 3: Game is over
            Board.printBoard(board);
            hasWon = hasPlayerWon(board, player1, player2);
        }
    /*  Step 4: Write encrypted content to file and decrypt again
        Step 4.1: generate file and determine content
     */
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String player1Name = (String.valueOf(player1.getName() + " has the following score: "));
        String playerAScore = (String.valueOf("\t" + player1.getScore()));
        String encryptedStringNameA = AES.encrypt(player1Name, secretKey);
        String encryptedStringScoreA = AES.encrypt(playerAScore, secretKey);

        String player2Name = (String.valueOf(player2.getName() + " has the following score: "));
        String playerBScore = (String.valueOf("\t" + player2.getScore()));
        String encryptedStringNameB = AES.encrypt(player2Name, secretKey);
        String encryptedStringScoreB = AES.encrypt(playerBScore, secretKey);

        String decryptedStringNameA = AES.decrypt(encryptedStringNameA, secretKey);
        String decryptedStringScoreA = AES.decrypt(encryptedStringScoreA, secretKey);
        String decryptedStringNameB = AES.decrypt(encryptedStringNameB, secretKey);
        String decryptedStringScoreB = AES.decrypt(encryptedStringScoreB, secretKey);

        File scoresFile = new File(Config.getPathScoreFile());
        FileWriter fileWriter = new FileWriter(scoresFile);

        if (Config.getVersion()=="dev") {

        }
        //Step: 4.2: write Content to file
        fileWriter.write(String.valueOf(player1.getName() + " has the following score: "));
        fileWriter.write(String.valueOf("\t" + player1.getScore()));
        fileWriter.write(String.valueOf("\n" + player2.getName() + " has the following score: "));
        fileWriter.write(String.valueOf("\t" + player2.getScore()));
        fileWriter.write(String.valueOf("\n"));

        //Step: 4.3 write encrypted content
        fileWriter.write(String.valueOf("\n" + encryptedStringNameA));
        fileWriter.write(String.valueOf("\t" + encryptedStringScoreA));
        fileWriter.write(String.valueOf("\n" + encryptedStringNameB));
        fileWriter.write(String.valueOf("\t" + encryptedStringScoreB));
        fileWriter.write(String.valueOf("\n"));

        //Step 4.4 write decrypted content
        fileWriter.write(String.valueOf("\n" + decryptedStringNameA));
        fileWriter.write(String.valueOf("\t" + decryptedStringScoreA));
        fileWriter.write(String.valueOf("\n" + decryptedStringNameB));
        fileWriter.write(String.valueOf("\t" + decryptedStringScoreB));
        fileWriter.write(String.valueOf("\n"));

        fileWriter.close();
    }
    /*  Step 5: determine winner of the game
        public static Outputdatatype methodeNaam(inputDatatype inputdataTypeNaam)
     */
    public static boolean hasPlayerWon(String[] board, Player player1, Player player2){
        if (board[8] == player1.getToken()){
            player1.setScore(1);
            System.out.println("Congratulations " + player1.getName() + ":" + " you have won the game!");
            System.out.println("Score " + player1.getName() + " is " + player1.getScore());
            System.out.println("Score " + player2.getName() + " is " + player2.getScore());
            return true;
        }
        else if (board[9] == player2.getToken()){
            System.out.println("Congratulations " + player2.getName() + ":" + " you have won the game!");
            player2.setScore(1);
            System.out.println("Score " + player1.getName() + " is " + player1.getScore());
            System.out.println("Score " + player2.getName() + " is " + player2.getScore());
            return true;
        }
        return false;
    }
}



