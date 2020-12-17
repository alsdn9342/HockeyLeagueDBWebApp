/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Minwoo Park
 */
public class Player implements Serializable {
   
    private int ID;
    private String name;
    private String address;
    private String team;
    private String role;
    private boolean active;
    private String actveOrNot;

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public  String isActive() {

        if (this.active == true) {
            return "Activated";
        } else {
            return "Non Activated";
        }
    }

    public String getActveOrNot() {
        return actveOrNot;
    }

    public void setActveOrNot(String actveOrNot) {
        this.actveOrNot = actveOrNot;
    }

    

}
