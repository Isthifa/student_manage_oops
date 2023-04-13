package com.isthifa.Student.rest;

import com.isthifa.Student.dao.StudentDAO;
import com.isthifa.Student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRest {
    private StudentDAO studentDAO;

    @Autowired
    public StudentRest(StudentDAO studentD) {
        studentDAO = studentD;
    }

    @GetMapping("/student/listall")
    public List<Student> findall() {
        List<Student> temp = studentDAO.findAll();
        return temp;
    }

    @PostMapping ("/student/save")
    public String save(@RequestBody Student student)
    {
        Student student1=studentDAO.save(student);
        return "Student saved "+student1.getId();
    }
    @PutMapping("/student/update")
    public String update(@RequestBody Student student)
    {
        Student student1=studentDAO.update(student);
        return "Student updated"+student1.getId();
    }
    @GetMapping("/student/{studentId}")
    public Student findbyid(@PathVariable int studentId)
    {
        Student student=studentDAO.findById(studentId);
        return student;
    }
    @DeleteMapping("/student/{studentId}")
    public String delete(@PathVariable int studentId)
    {
        Student student=studentDAO.findById(studentId);
        System.out.println(student);
       studentDAO.delete(studentId);
        return "Student deleted "+studentId;
    }
}
