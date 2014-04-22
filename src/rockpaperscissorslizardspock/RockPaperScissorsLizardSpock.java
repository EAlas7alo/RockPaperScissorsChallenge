/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorslizardspock;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
        // TODO code application logic here
        int[] rock = {1, -1, 0, 1, -1};
        int[] paper = {-1, 0, 1, -1, 1};
        int[] scissors = {0, 1, -1, 1, -1};
        int[] lizard = {-1, 1, -1, 0, 1};
        int[] spock = {1, -1, 1, -1, 0};
        
        int[][] winValues = {scissors, paper, rock, lizard, spock};
        int gamesPlayed = 0;
        int computerWins = 0;
        double computerWinPercent = 0;
        int playerWins = 0;
        double playerWinPercent = 0;
        int drawAmount = 0;
        double drawPercent = 0;
        
        Scanner lukija = new Scanner(System.in);
        String[] acceptedInputs = {"scissors", "paper", "rock", "lizard", "spock"};
        List<String> inputs = Arrays.asList(acceptedInputs);

        while (gamesPlayed < 5) {
            System.out.print("Player Picks: ");
            String playerChoice = lukija.nextLine();
            while (!inputs.contains(playerChoice)) {
                System.out.println("Invalid input!");
                playerChoice = lukija.nextLine();
            }
            
            String computerChoice = acceptedInputs[new Random().nextInt(acceptedInputs.length - 1)];
            System.out.println("Computer Picks: " + computerChoice);
            
            int pChoice = inputs.indexOf(playerChoice);
            int cChoice = inputs.indexOf(computerChoice);
            
            if (winValues[pChoice][cChoice] == 0) {
                System.out.println("Draw!");
                drawAmount++;
            } else if (winValues[pChoice][cChoice] == -1) {
                System.out.println("Computer wins!");
                computerWins++;
            } else {
                System.out.println("Player wins!");
                playerWins++;
            }
            gamesPlayed++;
        }
        computerWinPercent = Math.round(computerWins * 100.0/gamesPlayed);
        playerWinPercent = (Math.round(playerWins * 100.0/gamesPlayed));
        drawPercent = (Math.round(drawAmount * 100.0/gamesPlayed));
        
        System.out.println("Games played: " + gamesPlayed + "\n"
                + "Computer wins: " + computerWins + " " + computerWinPercent + "%\n"
                + "Player wins: " + playerWins + " " + playerWinPercent + "%\n" 
                + "Draws: " + drawAmount + " " + drawPercent + "%");

    }

}
