package com.example.exerciserepository.Service;

import com.example.exerciserepository.API.APIException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repositry.UserRepositry;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class UserService {

    private final UserRepositry userRepositry;

    public List<User> getall(){
        return userRepositry.findAll();
    }

    public void add(User user){
        userRepositry.save(user);
    }

    public void update(Integer id, User user){
        if (userRepositry.findByID(id)!=null)
        {
            User retriveUser=userRepositry.findByID(id);
            retriveUser.setUsername(user.getUsername());
            retriveUser.setName(user.getName());
            retriveUser.setAge(user.getAge());
            retriveUser.setEmail(user.getEmail());
            retriveUser.setPassword(user.getPassword());
            retriveUser.setRole(user.getRole());
            userRepositry.save(retriveUser);
        }throw  new APIException("Not found"+id);
    }

    public void delete(Integer id){
        if (userRepositry.findByID(id)!=null)
            userRepositry.delete(userRepositry.findByID(id));

    throw  new APIException("Not found"+id);}


    public User checkValidUser(String username, String password){
        if(userRepositry.login(username,password)!=null){
            return userRepositry.login(username,password);
        }
        throw new APIException("failed login");

    }

    public User getbyemail(String email){
        if(userRepositry.findByEmail(email)!=null){
            return userRepositry.findByEmail(email);
        }
        throw new APIException("failed login");

    }

    public List<User> listRole(String role){
        if (!userRepositry.getRole(role).isEmpty())
            return userRepositry.getRole(role);
        throw new APIException("NO LIST ROLE");
    }

    public List<User> listAge(Integer age){
        if (!userRepositry.getageAbove(age).isEmpty())
            return userRepositry.getageAbove(age);
        throw new APIException("NO LIST ROLE");
    }
}
