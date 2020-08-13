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
public class MergeSort extends SortingTechnique{
   
    private double elapsedTime;
    private static MergeSort ms;
    private MergeSort(){}
    
    
    public static MergeSort create(){
        if(ms == null){
            ms = new MergeSort();
        }
        return ms;
    }
    
    
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> a){
        Timer timer = new Timer();
        timer.start();
        ArrayList<Integer> sortedList = mergeSort(a);
        timer.end();
        elapsedTime = timer.getElapsedTime();
        return sortedList;
    }
    
    public ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
        
        if(a.size()==1){
            return a;
        }
        
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        ArrayList<Integer> s2 = new ArrayList<Integer>();
        
        for(int i=0;i<a.size()/2;i++){
            s1.add(a.get(i));
        }
        for(int i=a.size()/2;i<a.size();i++){
            s2.add(a.get(i));
        }
        
        
        //System.out.println("-"+s1);
        //System.out.println("--"+s2);
        
        return merge(sort(s1), sort(s2));
    }

   
    
    public ArrayList<Integer> merge(ArrayList<Integer>a, ArrayList<Integer>b){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        //System.out.println("To be merged... a: " + a+ "   b: "+ b);
        int i=0;
        int j=0;
        while(i<a.size() && j<b.size()){

            if(a.get(i)<b.get(j)){
                ans.add(a.get(i));
                i++;
            }
            else if(a.get(i)>b.get(j)){
                ans.add(b.get(j));
                j++;
                
            }
            else{
                ans.add(a.get(i));
                ans.add(a.get(i));
                i++;
                j++;
            }
        }
        
        while(i<a.size()){
                ans.add(a.get(i));
                i++;
            }
            
        while(j<b.size()){
            ans.add(b.get(j));
            j++;
        }
            //System.out.println("Merged: " + ans);
        return ans;
            
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
