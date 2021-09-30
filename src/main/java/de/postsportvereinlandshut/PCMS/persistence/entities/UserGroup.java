package de.postsportvereinlandshut.PCMS.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Maintained in UserRepository
 */
@Entity
public class UserGroup {
    @Id
    private String name;

    /**
     * Starts at 0 and increments per UserGroup and set of rights
     * e.g.
     * -> Admin = 2
     * -> Moderator = 1
     * -> User = 0
     * 
     */
    private int rank;

    public UserGroup(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }
    
}
