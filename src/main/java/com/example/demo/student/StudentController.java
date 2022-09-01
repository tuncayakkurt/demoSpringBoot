package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //GET
    //http://localhost:8080/api/v1/student
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //POST
    //http://localhost:8080/api/v1/student
    //{
    //    "name": "tunca",
    //    "email": "tunca@yy",
    //    "dob":"1995-12-11"
    //}
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    //DELETE
    //http://localhost:8080/api/v1/student/1
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    //PUT (update)
    //http://localhost:8080/api/v1/student/1?name=abc&email=abc@mail
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
