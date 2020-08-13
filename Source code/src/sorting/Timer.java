/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Crap
 */
public class Timer {
    
    private double startTime;
    private double endTime;
    
    public void start(){
        startTime = System.nanoTime();
    }
    
    public void end(){
        endTime = System.nanoTime();
    }
    
    public double getElapsedTime(){
        return (endTime-startTime)/1000000000;
    }
}
