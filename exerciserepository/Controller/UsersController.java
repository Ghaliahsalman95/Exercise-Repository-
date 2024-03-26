package com.example.exerciserepository.Controller;


import com.example.exerciserepository.API.APIResponse;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController@RequestMapping("api/v1/user")
public class UsersController {


    private final UserService userService;

    @GetMapping("/get-all-users")
    public ResponseEntity getuserService() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getall());
    }
    @PostMapping("/add-user")
    public ResponseEntity add(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        userService.add(user);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Add sucessfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        userService.update(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("deleted successfully"));
    }

    @GetMapping("/get-above-ages/{age}")
    public ResponseEntity getages(@PathVariable Integer age){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAge(age));
    }

    @GetMapping("/get-user-by-email/{email}")
    public ResponseEntity getbyemil(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getbyemail(email));
    }
    @GetMapping("/get-all-role/{role}")
    public ResponseEntity getages(@PathVariable String role){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listRole(role));
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity getages(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(HttpStatus.OK).body(userService.checkValidUser(username,password));
    }

}
