/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rockpaperscissorslizardspock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Wed
 */
public class AI {
    
    private final int SCISSORS = 0;
    private final int PAPER = 1;
    private final int ROCK = 2;
    private final int LIZARD = 3;
    private final int SPOCK = 4;
    
    private Random rand;
    private boolean isLearning;
    private Map<String,Integer> playerPicks;
    private int[][] counters;
    
    public AI(boolean isLearning, int[][] counters) {
        this.rand = new Random();
        this.isLearning = isLearning;
        this.playerPicks = new HashMap<>();
        this.counters = counters;
    }
    
    public int aiChoice() {
        if (!isLearning || playerPicks.isEmpty()) {
            int randomChoice = rand.nextInt(5);
            return randomChoice;
        }
        int amountOfPicks = Collections.max(playerPicks.values());
        String mostFrequent = "";
        for (String pick : playerPicks.keySet()) {
            if (playerPicks.get(pick) == amountOfPicks) {
                mostFrequent = pick;
            }
        }
        return getCounter(mostFrequent);
        
    }
    
    public void learn(String playerPick) {
        if (!playerPicks.containsKey(playerPick)) {
            playerPicks.put(playerPick, 1);
        } else {
            playerPicks.put(playerPick, playerPicks.get(playerPick) + 1);
        }
        
        
    }
    
    private int getCounter(String playerChoice) {
        if (playerChoice.equals("scissors")) {
            if (playerPicks.size() % 2 != 0) {
                return ROCK;
            }
            return SPOCK;
        } else if (playerChoice.equals("paper")) {
            if (playerPicks.size() % 2 != 0) {
                return SCISSORS;
            }
            return LIZARD;
        } else if (playerChoice.equals("rock")) {
            if (playerPicks.size() % 2 != 0) {
                return PAPER;
            }
            return SPOCK;
        } else if (playerChoice.equals("lizard")) {
            if (playerPicks.size() % 2 != 0) {
                return ROCK;
            }
            return SCISSORS;
        } else {
            if (playerPicks.size() % 2 != 0) {
                return PAPER;
            }
            return LIZARD;
        }
        
       
    }
}
