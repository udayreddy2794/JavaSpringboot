package com.udayreddy.springboot.learning.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

//    Inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

//    Expose new endpoint "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+ coachName +", Team Name: "+ teamName;
    }

//    expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

//    expose a new endpoint "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

//    expose a new endpoint "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }
}
