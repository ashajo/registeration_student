package se.lexicon.registeration_student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.registeration_student.entity.Student;
import se.lexicon.registeration_student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    StudentRepository studentRepository;
@Autowired
    public void setStudentRepository(StudentRepository studentRepository){
this.studentRepository=studentRepository;
    }

@GetMapping("/api/student")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentList= new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentList::add);
        return ResponseEntity.ok(studentList);
    }

}
