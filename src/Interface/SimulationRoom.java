/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.time.LocalTime;

/**
 *
 * @author shinnaylin
 */
public class SimulationRoom {

    int currentCo2, currentHumidity;
    LocalTime currentTime;
    double currentTemp;
    
    public SimulationRoom(){
    }
    
    public SimulationRoom(int currentCo2, int currentHu, String currentTime, double currentTemp){
        this.currentCo2 = currentCo2;
        this.currentHumidity = currentHu;
        this.currentTime = LocalTime.parse(currentTime);
        this.currentTemp = currentTemp;
    }
    
    public int getCurrentCo2() {
        return currentCo2;
    }

    public void setCurrentCo2(int currentCo2) {
        this.currentCo2 = currentCo2;
    }

    public int getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(int currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = LocalTime.parse(currentTime);
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }
}
