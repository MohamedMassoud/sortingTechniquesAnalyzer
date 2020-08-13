/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Crap
 */
public interface SortingTechniqueInterface {
    
    ArrayList<Integer> sort(ArrayList<Integer>a);
    void draw(ArrayList<Integer>a, JTextArea txtArea);
    double getElapsedTime();
}
