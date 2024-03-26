package com.example.exerciserepository.Repositry;

import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositry extends JpaRepository<User,Integer> {
    User findByID(Integer id);
    @Query("select u from User u where u.username=?1 and u.password=?2")
    User login(String username,String password);
    //User findByUsernameAndPassword(String username ,String password);
    User findByEmail(String email);
    @Query("select u from User u where u.role=?1")
    List<User> getRole(String role);
   // List<User> findAllByRole(String role);
    @Query("select u from User u where u.age>=?1")
    List<User> getageAbove(Integer age);
   // List<User> findAllByAgeAfter();
}
