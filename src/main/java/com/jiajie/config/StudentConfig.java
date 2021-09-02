package com.jiajie.config;

import com.jiajie.Repository.StudentRepository;
import com.jiajie.pojo.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student jiajie = new Student("jiajie", "123456", LocalDate.of(2004, Month.JANUARY,12));
            Student jason = new Student("jason", "22222",LocalDate.of(2012,Month.JANUARY,23));
            LinkedList<Student> slist = new LinkedList<>();
            slist.add(jiajie);
            slist.add(jason);
            repository.saveAll(slist);
        };
    }
}
