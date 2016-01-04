/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * La classe User sert à enregistrer un utilisateur ainsi que ses données.
 * Cette classe est utilisée également dans le tp4.
 * 
 * @author dave
 */
public class User {
    
    public User(String username, String password, String firstName, String lastName, int age) {
        m_username = username;
        m_password = password;
        m_lastName = lastName;
        m_firstName = firstName;
        m_age = age;
    }
    
    public User(String firstName, String lastName, int age, String password) {
        m_username = "";
        m_lastName = lastName;
        m_firstName = firstName;
        m_age = age;
        m_password = password;
    }
    
    
    

    public String getUsername() {
        return m_username;
    }

    public String getPassword() {
        return m_password;
    }

    public String getLastName() {
        return m_lastName;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public int getAge() {
        return m_age;
    }

    private String m_username;
    private String m_password;
    private String m_lastName;
    private String m_firstName;
    private int m_age;
    
}
