/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness.DomainModel;

/**
 *
 * @author felesiah
 */
public class Customer {
    private String username, password,firstName,lastName,email;
    public boolean valid;

    public Customer(){
        
    }

    public Customer(String username, String password, String firstName, String lastName,String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
       
    }
    

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    public void removeUserName() {
        username = null;
         }
    public void removeLastName() {
        lastName = null;
         }
    public void removeFirstName() {
        firstName = null; 
    }
    public void removeEmail() {
        email = null; 
    }
    public void add(String username, String password) {
    String user = username +"-"+ password;
    }
}
 

