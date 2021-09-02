package com.jiajie.Repository;

import com.jiajie.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s where s.name = ?1")
    Optional<Student> findStudentByName(String name);
}
