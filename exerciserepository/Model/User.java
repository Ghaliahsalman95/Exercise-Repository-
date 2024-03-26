package com.example.exerciserepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Entity@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;
   // @NotEmpty(message = "name not empty")
  //  @Column(columnDefinition = "name varchar(10) not null check ( length(name)>4 ) ")
    @Size(min = 4,message = "name must be more 4 character")
    private String name;
  //  @NotEmpty(message = "username not empty")
  //  @Column(columnDefinition = " varchar(10) not null")
    @Size(min = 4,message = "username must be more 6 character")
    private String username;
 //   @NotEmpty(message = "password not empty")
   // @Column(columnDefinition = "varchar(10) not null )")
    private String password;
  //  @NotEmpty(message = "email not empty")
    @Email(message = "email valid")
    //@Column(columnDefinition = "varchar(10) not null unique")
    private  String email;
  //  @NotEmpty(message = "email not empty")
    @Pattern(regexp = "User|Admin")
  //  @Column(columnDefinition = "varchar(5) not null check ( role='admin' or role='user' )")
    private String role;
    @Min(value = 18, message = "at least 18")
    @Column(columnDefinition = "int not null ")
    private Integer age;



}
