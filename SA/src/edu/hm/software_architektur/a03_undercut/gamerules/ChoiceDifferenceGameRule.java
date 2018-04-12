/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.software_architektur.a03_undercut.gamerules;

/**
 *
 * @author Computer
 */
public class ChoiceDifferenceGameRule implements GameRule{

    @Override
    public int[] calculateScore(int playerAChoice, int playerBChoice) {
        final int[] scores = new int[2]; // int[0] score of player A, int[1] score of player B
        
        if(playerAChoice == playerBChoice - 1) {
            scores[0] += playerAChoice + playerBChoice;
        } else if(playerBChoice == playerAChoice - 1) {
            scores[1] += playerAChoice + playerBChoice;
        } else if (Math.abs(playerAChoice - playerBChoice) == 2) {
            scores[0] += playerAChoice;
            scores[1] += playerBChoice;
        } else if (playerAChoice - playerBChoice > 2) {
            scores[0] += playerAChoice + playerBChoice;
        } else if (playerBChoice - playerAChoice > 2) {
            scores[1] += playerAChoice + playerBChoice;
        }
        return scores;
    }
    
}
