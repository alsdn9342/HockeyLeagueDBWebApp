/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import beans.Player;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Minwoo Park
 */
public class PlayerDAO {

    DBManager dbm = new DBManager();

    public void createRedPlayer(Player player) {
        String sql = "INSERT INTO redplayers (name, address, team, role, active)"
                + "VALUE ('"
                + player.getName() + "', '"
                + player.getAddress() + "', '"
                + player.getTeam() + "', '"
                + player.getRole() + "', '"
                + player.isActive() + "' )";

        dbm.executeUpdate(sql);
    }
    
    public void createBluePlayer(Player player) {
        String sql = "INSERT INTO blueplayers (name, address, team, role, active)"
                + "VALUE ('"
                + player.getName() + "', '"
                + player.getAddress() + "', '"
                + player.getTeam() + "', '"
                + player.getRole() + "', '"
                + player.isActive() + "' )";

        dbm.executeUpdate(sql);
    }

    public void deleteRedPlayerByID(int id) {
        String sql = "DELETE FROM redPlayers WHERE id = " + id + ";";
        dbm.executeUpdate(sql);
    }
    
    public void deleteBluePlayerByID(int id) {
        String sql = "DELETE FROM bluePlayers WHERE id = " + id + ";";
        dbm.executeUpdate(sql);
    }
    

    public void updateRedPlayer(Player player) {
        
        String sql = "UPDATE redplayers " + " SET "
                + "name = '"+player.getName()+"',"
                + "address = '"+player.getAddress()+"',"
                + "team = '"+player.getTeam()+"' ,"
                + "role = '"+player.getRole()+"' ,"
                + "active = '"+player.isActive()+"'"
                +"WHERE id="+player.getID()+" "
                +";";
        
        dbm.executeUpdate(sql);
    }
    
    public void updateBluePlayer(Player player) {
        
        String sql = "UPDATE blueplayers " + " SET "
                + "name = '"+player.getName()+"',"
                + "address = '"+player.getAddress()+"',"
                + "team = '"+player.getTeam()+"' ,"
                + "role = '"+player.getRole()+"' ,"
                + "active = '"+player.isActive()+"'"
                +"WHERE id="+player.getID()+" "
                +";";
        
        dbm.executeUpdate(sql);
    }
    
    public ArrayList<Player> retrieveAllRedPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();

        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM redplayers ";
            rs = dbm.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Player player = new Player();
                    player.setID(rs.getInt("id"));
                    player.setName(rs.getString("name"));
                    player.setAddress(rs.getString("address"));
                    player.setTeam(rs.getString("team"));
                    player.setRole(rs.getString("role"));
                    
                    boolean active;
                    if (rs.getString("active").equals("Activated")) {
                        active = true; 
                        player.setActive(active);
                        player.setActveOrNot("Activated");
                    } else {
                        active = false; 
                        player.setActive(active);
                        player.setActveOrNot("Not Activated");
                    }
                    
                   

                    players.add(player);
                }
            }

        } catch (Exception e) {
            System.out.println("Error retrieving cities" + e);
        }
        return players;
    }
    
    public ArrayList<Player> retrieveAllBluePlayers() {
        ArrayList<Player> players = new ArrayList<Player>();

        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM blueplayers ";
            rs = dbm.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Player player = new Player();
                    player.setID(rs.getInt("id"));
                    player.setName(rs.getString("name"));
                    player.setAddress(rs.getString("address"));
                    player.setTeam(rs.getString("team"));
                    player.setRole(rs.getString("role"));

                    boolean active;
                    if (rs.getString("active").equals("Activated")) {
                        active = true;
                        player.setActveOrNot("Activated");
                    } else {
                        active = false;
                        player.setActveOrNot("Non Activated");
                    }
                    player.setActive(active);

                    players.add(player);
                }
            }

        } catch (Exception e) {
            System.out.println("Error retrieving cities" + e);
        }
        return players;
    }

    public Player retrieveRedPlayerByID(int ID){
        Player player= null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * from redplayers WHERE ID="+ID+";";
            rs = dbm.executeQuery(sql);
            if(rs != null && rs.next()){
                player = new Player();
                player.setID(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setAddress(rs.getString("address"));
                player.setTeam(rs.getString("team"));
                player.setRole(rs.getString("role"));
                boolean active;
                
                if(rs.getString("active").equals("Activated")){
                    active = true;
                    player.setActive(active);
                }else{
                    active = false;
                    player.setActive(active);
                }
            }
        }catch(Exception e){
            System.out.println("Error retrieving city "+e);
        }
        
        
        return player;
    }
    
    public Player retrieveBluePlayerByID(int ID){
        Player player= null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * from blueplayers WHERE ID="+ID+";";
            rs = dbm.executeQuery(sql);
            if(rs != null && rs.next()){
                player = new Player();
                player.setID(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setAddress(rs.getString("address"));
                player.setTeam(rs.getString("team"));
                player.setRole(rs.getString("role"));
                boolean active;
                
                if(rs.getString("active").equals("Activated")){
                    active = true;
                    player.setActive(active);
                }else{
                    active = false;
                    player.setActive(active);
                }
            }
        }catch(Exception e){
            System.out.println("Error retrieving city "+e);
        }
        
        
        return player;
    }
}
