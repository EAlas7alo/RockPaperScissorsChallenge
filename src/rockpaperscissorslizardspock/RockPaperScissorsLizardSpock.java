/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorslizardspock;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Wed
 */
public class RockPaperScissorsLizardSpock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] rock = {1, -1, 0, 1, -1};
        int[] paper = {-1, 0, 1, -1, 1};
        int[] scissors = {0, 1, -1, 1, -1};
        int[] lizard = {-1, 1, -1, 0, 1};
        int[] spock = {1, -1, 1, -1, 0};
        
        int[][] winValues = {scissors, paper, rock, lizard, spock};
        int gamesPlayed = 0;
        int computerWins = 0;
        double computerWinPercent; //Percentage values are calculated after the loop
        int playerWins = 0;
        double playerWinPercent;
        int drawAmount = 0;
        double drawPercent;
        
        Scanner lukija = new Scanner(System.in);
        String[] acceptedInputs = {"scissors", "paper", "rock", "lizard", "spock"};
        List<String> inputs = Arrays.asList(acceptedInputs);
        System.out.println("How many games?");
        int howMany = Integer.parseInt(lukija.nextLine());
        System.out.println("AI learning or non-learning? Y/N");
        String learningOrNot = lukija.nextLine();
        AI ai = new AI(learningOrNot.equals("Y"), winValues);

        while (gamesPlayed < howMany) {
            System.out.print("Player Picks: ");
            String playerChoice = lukija.nextLine();
            while (!inputs.contains(playerChoice)) {
                System.out.println("Invalid input!");
                playerChoice = lukija.nextLine();
            }
            
            String computerChoice = acceptedInputs[ai.aiChoice()];
            System.out.println("Computer Picks: " + computerChoice);
            
            int pChoice = inputs.indexOf(playerChoice);
            int cChoice = inputs.indexOf(computerChoice);
            
            if (winValues[pChoice][cChoice] == 0) {
                System.out.println("Draw!\n");
                drawAmount++;
            } else if (winValues[pChoice][cChoice] == -1) {
                System.out.println("Computer wins!\n");
                computerWins++;
            } else {
                System.out.println("Player wins!\n");
                playerWins++;
            }
            ai.learn(playerChoice);
            gamesPlayed++;
        }
        
        computerWinPercent = Math.round(computerWins * 100.0/gamesPlayed);
        playerWinPercent = (Math.round(playerWins * 100.0/gamesPlayed));
        drawPercent = (Math.round(drawAmount * 100.0/gamesPlayed));
        
        System.out.println("Games played: " + gamesPlayed + "\n"
                + "Computer wins: " + computerWins + " (" + computerWinPercent + "%)\n"
                + "Player wins: " + playerWins + " (" + playerWinPercent + "%)\n" 
                + "Draws: " + drawAmount + " (" + drawPercent + "%)");

    }

}
