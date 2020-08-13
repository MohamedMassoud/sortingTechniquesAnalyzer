/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Crap
 */
public class SortingTechnique implements SortingTechniqueInterface{
    
    protected static SortingTechnique ast;
    protected double elapsedTime;
    
    protected SortingTechnique(){}
    
    public static SortingTechnique create(){
        if(ast==null){
            ast = new SortingTechnique();
        }
        return ast;
    }
    
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> a) {
        return null;
    }

    @Override
    public void draw(ArrayList<Integer> a, JTextArea txtArea) {
    }

    @Override
    public double getElapsedTime() {
        return elapsedTime;
    }
    
}
