/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Crap
 */
public class Heap extends SortingTechnique{
    
    private static Heap heap;
    private boolean old;
    private double elapsedTime;
    
    
    
    public double getElapsedTime(){
        if(elapsedTime!=0){
            return elapsedTime;
        }
        System.out.println("No sortion processed");
        return 0;
    }
    
    public static Heap create(){
        if(heap == null){
            heap = new Heap();
        }
        return heap;
    }
    
    public void maxHeapify(ArrayList<Integer> a, int index, int size){
        
        int largest = index;
        int leftChild = 2*index+1;
        int rightChild = 2*index+2;
        
        if(leftChild < size && a.get(leftChild) > a.get(largest)){
            largest = leftChild;
        }
        
        if(rightChild < size && a.get(rightChild) > a.get(largest)){
            largest = rightChild;
        }
        
        if(largest != index){
            if(leftChild<size && rightChild<size){
            }
            int temp;
            temp = a.get(largest);
            a.set(largest, a.get(index));
            a.set(index, temp);
            
            maxHeapify(a, largest, size);
        }else{
            if(leftChild<size && rightChild<size){
            }
        }
    }
    
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer>a){
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        tempList.addAll(a);
        Timer timer = new Timer();
        timer.start();
        buildMaxHeap(a);
        for(int i=a.size()-1;i>=0;i--){
            int temp;
            temp = a.get(i);
            a.set(i, a.get(0));
            a.set(0, temp);
            maxHeapify(a, 0, i);
        }
        
        timer.end();
        sortedList.addAll(a);
        elapsedTime = timer.getElapsedTime();
        a.addAll(tempList);
        return sortedList;
    }
    
    
    
    
    
    public void buildMaxHeap(ArrayList<Integer>a){

        for (int i = a.size()/2-1; i>=0; i--){
            maxHeapify(a, i, a.size());
        }
            
    }
   
    public void drawTree(ArrayList<Integer> a, ArrayList<JLabel> labelList){
        for(int i=0;i<a.size();i++){
            if(i<31){
                labelList.get(i).setText(a.get(i).toString());
                System.out.println(labelList.get(i).getText());
            }
            
        }
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