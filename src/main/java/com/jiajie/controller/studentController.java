package com.jiajie.controller;

import com.jiajie.pojo.Student;
import com.jiajie.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentController {


    private final StudentService studentService;

    @Autowired
    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/test")
    public List<Student> test(){
        return studentService.getStudent();
    }

    @PostMapping("/student/add")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String pwd){
        studentService.updateStudent(id,name,pwd);
    }

}
