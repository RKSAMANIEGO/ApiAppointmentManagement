package com.project.appointmentmangement.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.Map;

@RestController
@RequestMapping("/api/greeting")
public class ControllerGreeting {

    @GetMapping("/private/admin/{username}")
    public ResponseEntity<Map<String,String>> greetingPrivateAdmin(@PathVariable String username){
        return new ResponseEntity<>(Map.of("message","Welcome, "+username), HttpStatus.OK);
    }

    @GetMapping("/private/user/{username}")
    public ResponseEntity<Map<String,String>> greetingPrivateUser(@PathVariable String username){
        return new ResponseEntity<>(Map.of("message","Welcome, "+username), HttpStatus.OK);
    }

    @GetMapping("/public")
    public ResponseEntity<Map<String,String>> greetingPublic(){
        return new ResponseEntity<>(Map.of("message","Welcome, to application web."), HttpStatus.OK);
    }

}
