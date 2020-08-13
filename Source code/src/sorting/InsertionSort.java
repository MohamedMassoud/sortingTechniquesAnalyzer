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
public class InsertionSort extends SortingTechnique{

    private static InsertionSort is;
    private double elapsedTime;
    
    private InsertionSort(){}
    
    public static InsertionSort create(){
        if(is==null){
            is = new InsertionSort();
        }
        return is;
    }
    
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> a) {
        Timer timer = new Timer();
        timer.start();
        
        for(int i=0; i<a.size(); i++){
            int j = i;
            while(j>0 && a.get(j) < a.get(j-1)){
                int temp = a.get(j);
                a.set(j, a.get(j-1));
                a.set(j-1, temp);
                j--;
            }
        }
        timer.end();
        elapsedTime = timer.getElapsedTime();
        return a;
    }

    @Override
    public void draw(ArrayList<Integer> a, JTextArea txtArea) {
        if(elapsedTime==0){
            txtArea.setText(a.toString());
        }else{
            txtArea.setText(a.toString()+"\t[Sorting Time: " + elapsedTime+" Seconds]");
            elapsedTime=0;
        }
    }

    @Override
    public double getElapsedTime() {
        return elapsedTime;
    }
    
}
