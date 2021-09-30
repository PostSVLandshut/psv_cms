package de.postsportvereinlandshut.PCMS.persistence.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.postsportvereinlandshut.PCMS.persistence.entities.User;
import de.postsportvereinlandshut.PCMS.persistence.entities.UserGroup;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    //findAll() -> CRUD Repository
    //findOne(User) -> CRUD Repository
    //count(User)   -> CRUD Repository
    //insert user   -> CRUD Repository(save)

    //Query for login request
    @Query(value = "select * from User u where u.username = :username")
    public User findByUsername(@Param("username") String username);

    /**
     * Query for reseting forgotten passwords (Only for Administrator use)
     * 
     * @param user Target user
     * @param psswdHsh Default password (hashed)
     */
    @Query(value = "update User u set u.psswdHsh = :psswdHsh where u.id = :#{#user.id}")
    public void resetPsswdHsh(@Param("user") User user, @Param("psswdHsh") String psswdHsh);

    // **************************
    //Querys / DML for UserGroup
    //*************************** 

    @Transactional
    @Modifying
    @Query(value = "update UserGroup u set u.name = :newName where u.name = :#{#userGroup.name}")
    public void setName(@Param("userGroup") UserGroup userGroup, @Param("newName") String newName);

    @Transactional
    @Modifying
    @Query(value = "update UserGroup u set u.rank = :newRank where u.name = :#{#userGroup.name}")
    public void setRank(@Param("userGroup") UserGroup userGroup, @Param("newRank") String newName);

    @Transactional
    @Query(value = "insert into UserGroup (name, rank) values (':name', :rank)", nativeQuery = true)
    public void createUserGroup(@Param("name") String name, @Param("rank") Integer rank);

    @Transactional
    @Query(value = "delete from UserGroup u where u.name = :#{#userGroup.name}", nativeQuery = true)
    public void deleteUserGroup(@Param("userGroup") UserGroup userGroup);

    @Query(value = "select * from UserGroup u where u.name = #{#userGroup.name}")
    public UserGroup findUserGroupByName(@Param("name")String name);
    
    @Query(value = "select * form UserGroup")
    public ArrayList<UserGroup> findAllUserGroups();
}
