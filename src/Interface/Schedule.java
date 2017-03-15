/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.time.Duration;
import java.time.LocalTime;

/**
 *
 * @author shinnaylin
 */
public class Schedule {
    LocalTime time;
    Duration duration;
    Double desiredTemp;
    int occupancy;

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Double getDesiredTemp() {
        return desiredTemp;
    }

    public void setDesiredTemp(Double desiredTemp) {
        this.desiredTemp = desiredTemp;
    }
    
    public Schedule(){
        
    }
    
    public Schedule(LocalTime time, Duration duration, Double desiredTemp, int occupancy){
        this.time = time;
        this.duration = duration;
        this.desiredTemp = desiredTemp;
        this.occupancy = occupancy;
    }
}
