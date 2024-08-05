package com.pandulove.demo.rest;

import com.pandulove.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>(List.of(new Student("Uday", "Reddy"),
                new Student("Harshitha", "Anthan"),new Student("Pandu", "Challa")));
    }

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // just index into the list .... keep it simple for now

        // check the studentId against the list size

        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("studentId not found - "+ studentId);
        }

        return theStudents.get(studentId);
    }

    // add an Exception Handler using @ExceptionHandler annotation



}
