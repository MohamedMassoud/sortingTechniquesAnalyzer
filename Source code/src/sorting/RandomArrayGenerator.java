/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Crap
 */
public class RandomArrayGenerator {
    
    private ArrayList<Integer>a;
    private int samples;

    public RandomArrayGenerator() {
        this.a = new ArrayList<Integer>();
    }
    
    public ArrayList<Integer> create(int samples){
        Random rand = new Random();
        
        for(int i=0;i<samples;i++){
            int randomNumber = rand.nextInt(samples)+1;//100
            a.add(randomNumber);
        }
        
        return a;
    }
    
    
}
