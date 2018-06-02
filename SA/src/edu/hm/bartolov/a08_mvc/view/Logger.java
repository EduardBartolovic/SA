/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.bartolov.a08_mvc.view;

import java.util.Observable;
import javax.swing.text.View;

/**
 *
 * @author Computer
 */
public class Logger implements Viewer{
    
    Logger(Object... args) {
        
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("I don't know what I'm doing!");
    }
}
