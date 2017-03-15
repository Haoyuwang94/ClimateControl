/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import org.sqlite.JDBC;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wang
 */
public class NewClass {
    static Connection c = null;
    static Statement stmt = null;
      public static void main(String[] args) throws SQLException{
        init();
      // createTable();
         
      
          System.out.println();
        

//        try {
//            //    insertData();
//            ResultSet rs=stmt.executeQuery( "SELECT * FROM CURRENTSTATUS WHERE ROOM = 102" );
//            
//            while(rs.next()){
//              //  System.out.println("Room"+rs.getString("ROOM")+rs.getString("TIME")
//              //          +rs.getString("DURATION")+rs.getString("DESIREDTEMP")+rs.getString("OCCUPANCY"));
//                System.out.println(rs.getString("ROOM"));
//            }
//            
//            stmt.close();
//            c.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
      }
      
      public static String[] getRoom(int room) throws SQLException{
          init();
          String[] result=new String[5];
          try {
            //    insertData();
            ResultSet rs=stmt.executeQuery( "SELECT * FROM CURRENTSTATUS WHERE ROOM = "+room );
             
            while(rs.next()){
               System.out.println(rs.getString("STATUS")+"sssssssssssssssss");
                result=new String[]{rs.getString("ROOM"),
                rs.getString("CURRENTTEMPERATURE"),
                rs.getString("STATUS"),
               "",
                rs.getString("PREHEAT")}; 
              
                System.out.println(result[0]+"---------");
            }
            String intArrayString = Arrays.toString(result);
            System.out.println(intArrayString+"---------");

        //   stmt.close();
         //   c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return result;
      }
      
      
      public static void init(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:localhost");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      public static void insertData(){
        try {
//            String sql = "INSERT INTO SCHEDULE (ROOM,TIME,DURATION,DESIREDTEMP,OCCUPANCY) " +
//                    "VALUES ('101', '10:10', '2', 12.2, 60 );";
//            stmt.executeUpdate(sql);
//            String sql2 = "INSERT INTO SCHEDULE (ROOM,TIME,DURATION,DESIREDTEMP,OCCUPANCY) " +
//                    "VALUES ('102', '20:20', '2', 12.2, 670 );";
//            stmt.executeUpdate(sql2);
//            String sql3 = "INSERT INTO SCHEDULE (ROOM,TIME,DURATION,DESIREDTEMP,OCCUPANCY) " +
//                    "VALUES ('201', '5:10', '2', 12.2, 600 );";
//            stmt.executeUpdate(sql3);
//            String sql4 = "INSERT INTO SCHEDULE (ROOM,TIME,DURATION,DESIREDTEMP,OCCUPANCY) " +
//                    "VALUES ('202', '7:10', '2', 12.2, 900 );";
//            stmt.executeUpdate(sql4);
//            
//            
//            String sql11 = "INSERT INTO CURRENTSTATUS (ROOM,CURRENTTEMPERATURE,STATUS,PREHEAT) " +
//                    "VALUES ('101', 22.2, '2', 'TRUE' );";
//            stmt.executeUpdate(sql11);
//            String sql22 = "INSERT INTO CURRENTSTATUS (ROOM,CURRENTTEMPERATURE,STATUS,PREHEAT) " +
//                    "VALUES ('102', 19.0, '22', 'FALSE' );";
//            stmt.executeUpdate(sql22);
//            String sql33 = "INSERT INTO CURRENTSTATUS (ROOM,CURRENTTEMPERATURE,STATUS,PREHEAT) " +
//                    "VALUES ('201', 24.3, 'ff', 'TRUE' );";
//            stmt.executeUpdate(sql33);
//            String sql44 = "INSERT INTO CURRENTSTATUS (ROOM,CURRENTTEMPERATURE,STATUS,PREHEAT) " +
//                    "VALUES ('202', 20.5, 'sss', 'TRUE' );";
//            stmt.executeUpdate(sql44);
            
             String sql12 = "INSERT INTO DAILYENERGYUSAGE (DATE,USAGE,ROOM) " +
                    "VALUES ('101', 22.2, '102' );";
            stmt.executeUpdate(sql12);
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      }
      
      public static void createTable(){
   
    try {
     
//      String sql = "CREATE TABLE SCHEDULE   " +
//                   "(ROOM VARCHAR(5) PRIMARY KEY     NOT NULL," +
//                   " TIME           VARCHAR(10)    NOT NULL, " + 
//                   " DURATION            VARCHAR(3)     NOT NULL, " + 
//                   " DESIREDTEMP        DOUBLE, " + 
//                   " OCCUPANCY         INTEGER)"; 
//      
// //     stmt.executeUpdate(sql);
//      
//      String sql2 = "CREATE TABLE CURRENTSTATUS   " +
//                   "(ROOM VARCHAR(5) PRIMARY KEY     NOT NULL," +
//                   " CURRENTTEMPERATURE           DOUBLE    NOT NULL, " + 
//                   " STATUS            VARCHAR(15)     NOT NULL, " + 
//                   " PREHEAT         BOOLEAN)"; 
//      
//      stmt.executeUpdate(sql2);
      
      String sql3 = "CREATE TABLE DAILYENERGYUSAGE   " +
                   "(DATE VARCHAR(20) PRIMARY KEY     NOT NULL," +
                   " USAGE           DOUBLE    NOT NULL, " + 
                   " ROOM           VARCHAR(5)     NOT NULL )"; 
      
      stmt.executeUpdate(sql3);
      
      
    String sql4 = "CREATE TABLE HOURLYENERGYUSAGE   " +
                   "(ROOM VARCHAR(5) PRIMARY KEY     NOT NULL," +
                   " HOUR           DOUBLE    NOT NULL, " +
                    " USAGE           DOUBLE    NOT NULL, " + 
                   " TOTAL           DOUBLE     NOT NULL )"; 
      
      stmt.executeUpdate(sql4);
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
    
}
