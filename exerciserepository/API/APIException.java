package com.example.exerciserepository.API;

import lombok.AllArgsConstructor;
import lombok.Data;

public class APIException extends RuntimeException{
    public APIException (String message){
        super(message);}}

