package com.jiajie.service;

import com.jiajie.Repository.StudentRepository;
import com.jiajie.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentByName = studentRepository.findStudentByName(student.getName());
        if(studentByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
        studentRepository.save(student);
        System.out.println(student);

    }

    public void deleteStudent(Long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
        else{
            throw new IllegalStateException("ID NOT exists");
        }

    }

    @Transactional
    public void updateStudent(Long id, String name, String pwd) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("no match id exist"));

        if(name != null && !name.equals(student.getName())){
            student.setName(name);
        }
        if(pwd != null && !pwd.equals(student.getPwd())){
            student.setPwd(pwd);
        }
    }

}
