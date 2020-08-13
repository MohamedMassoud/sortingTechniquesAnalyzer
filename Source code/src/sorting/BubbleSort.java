/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Crap
 */
public class BubbleSort extends SortingTechnique{

    private double elapsedTime;
    private static BubbleSort bs;
    private BubbleSort(){}
    
    
    public static BubbleSort create(){
        if(bs == null){
            bs = new BubbleSort();
        }
        return bs;
    }
    
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> a) {
        Timer timer = new Timer();
        timer.start();
        for(int i=0; i<a.size()-1; i++){
            for(int j=0; j<a.size()-1-i;j++){
                if(a.get(j)>a.get(j+1)){
                    int temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                }
            }
        }
        timer.end();
        elapsedTime = timer.getElapsedTime();
        return a;
    }

    
    

    @Override
    public double getElapsedTime() {
        return elapsedTime;
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
    
}
