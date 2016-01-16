package tp.rochetvivier.modele;

import java.io.Serializable;

/**
 *
 * @author Dino
 */
public class UserBean implements Serializable { 
    
    private String name; 
    private String surname; 
    private int age; 
    private String pwd; 
    private String preference; 
    
    public UserBean() {} 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    
}
