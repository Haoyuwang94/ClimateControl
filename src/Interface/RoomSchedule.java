/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shinnaylin
 */
public class RoomSchedule {
    
    Schedule schedule = new Schedule();
    LocalTime time; Duration duration; Double desiredTemp; int occupancy;
    
    public Schedule getSchedule(String roomNo) {
        String URL = "jdbc:sqlite:climatecontrol";
        String USER = "username";
        String PASS = "password";
        
        Connection conn = null;
        Statement stmt = null; 
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(RoomSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RoomSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql= "SELECT * FROM SCHEDULE where ROOM= '"+roomNo +"'";
        
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(RoomSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            while(rs.next()){
                time = LocalTime.parse(rs.getString("TIME"));
                duration = Duration.parse("PT"+rs.getString("DURATION")+"H");
                desiredTemp = rs.getDouble("DESIREDTEMP");              
                occupancy = rs.getInt("OCCUPANCY");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        try {
            rs.close();
            stmt.close(); 
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RoomSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        schedule = new Schedule(time, duration, desiredTemp, occupancy);
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
