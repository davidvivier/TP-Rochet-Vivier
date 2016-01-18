
package tp.rochetvivier.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * La classe User sert à enregistrer un utilisateur ainsi que ses données.
 * Elle contient également des méthodes statiques pour traiter une liste d'utilisateurs.
 * 
 * @author dave
 */
public class User {
    
    
    /** on stocke la liste des utilisateurs directement en statique dans la classe User.
     */
    public static HashMap<String, User> users;
    
    /** On initialise la liste des utilisateurs.
     * Comme cet attribut est statique, on l'initialise dans le bloc statique.
     */
    static {
        users = new HashMap<>();
        User user = new User("david.vivier", "dv", "David", "Vivier", 20);
        users.put(user.getUsername(), user);
        user = new User("valentin.rochet", "vr", "Valentin", "Rochet", 18);
        users.put(user.getUsername(), user);
        user = new User("christophe.jaloux",  "cj", "Christophe", "Jaloux", 25);
        users.put(user.getUsername(), user);
    }
    
    public User(String username, String password, String firstName, String lastName, int age) {
        m_username = username;
        m_password = password;
        m_lastName = lastName;
        m_firstName = firstName;
        m_age = age;
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

    /**
     * Retourne l'User correspondant au nom d'utilisateur fourni.
     * @param username 
     * @return l'objet User, null si aucun utilisateur n'a ce nom d'utilisateur
     */
    public static User getUser(String username) {
        if (users.containsKey(username))
            return users.get(username);
        return null;
    }
    
    /** Retourne une liste des utilisateurs stockés
     * 
     * @return liste d'objets User
     */
    public static List<User> getListUsers() {
        return new ArrayList<>(users.values());
    }
    
    /**
     * Retourne un utilisateur au hasard parmi ceux stockés en statique dans la classe
     * @return objet User au hasard
     */
    public static User getRandomUser() {
        // on tire un nombre au hasard, inférieur strictement au nombre d'utilisateurs
        Random rand;
        rand = new Random();
        int index = rand.nextInt(users.size());
        return (new ArrayList<>(users.values())).get(index);
    }
    
    private String m_username;
    private String m_password;
    private String m_lastName;
    private String m_firstName;
    private int m_age;
    
}
