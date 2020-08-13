/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author Crap
 */
public class QuickSort extends SortingTechnique{
    private double elapsedTime;
    private static QuickSort qs;
    private int p,r;
    //private ArrayList A;
    private Random rn = new Random();
    private int temp;
    
    private QuickSort(){}
    
    
    public static QuickSort create(){
        if(qs == null){
            qs = new QuickSort();
        }
        return qs;
    }
    
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> a) {
        Timer timer = new Timer();
        timer.start();
        Sort(a,0,a.size()-1);
        timer.end();
        elapsedTime = timer.getElapsedTime();
        return a;
    }
    
    
    
    public void Sort(ArrayList<Integer>a ,int p,int r){
        if(p < r){
            thirdMedian(a);
            int q = Randomized_Partition(a,p,r);
            Sort(a, p ,q-1);
            Sort(a, q+1 ,r);
        }
    }
    public int Randomized_Partition(ArrayList<Integer> a, int p,int r){
        
        int i = rn.nextInt(r-p)+p;
        temp = (int) a.get(i);
        a.set(i, a.get(r));
        a.set(r, temp);
        return Partition(a,p,r);
    }
    public int Partition(ArrayList<Integer> a,int p,int r){
        int x = (int) a.get(r);
        int b = p-1;
        int j;
        for(j = p; j <= r-1;j++){
            if((int)a.get(j) <= x){
                b=b+1;
                temp = (int) a.get(j);
                a.set(j, a.get(b));
                a.set(b, temp);
            }
        }
        temp = (int) a.get(r);
        a.set(r, a.get(b+1));
        a.set(b+1, temp);
        return b+1;
        
    }
    
    private void thirdMedian(ArrayList<Integer> a){
        int x,y,z,min,mid,max;
        x=a.get(0);
        y=a.get(a.size()/2);
        z=a.get(a.size()-1);
        
        if(x>y){
            if(x>z){
                max=x;
                if(y>z){
                    min=z;
                    mid=y;
                }else{
                    min=y;
                    mid=z;
                }
            }else{
                max=z;
                if(x>y){
                    mid=x;
                    min=y;
                }else{
                    mid=y;
                    min=x;
                }
            }
        }else{
            if(y>z){
                max=y;
                if(x>z){
                    mid=x;
                    min=z;
                }else{
                    mid=z;
                    min=x;
                }
            }else{
                max=z;
                if(x>y){
                    mid=x;
                    min=y;
                }else{
                    mid=y;
                    min=x;
                }
            }
        }
        
        a.set(0, min);
        a.set(a.size()/2, mid);
        a.set(a.size()-1, max);
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
