package uz.pdp.appspringjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringjpa.model.Student;
import uz.pdp.appspringjpa.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    //C R U D

    //Get all students list
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    //Delete student by id
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student added";
    }

    //Get student by id
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return student;
        }else {
            return new Student();
        }
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return "Student deleted";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String editeStudent(@PathVariable Integer id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student editingStudent = optionalStudent.get();
            editingStudent.setFirstName(student.getFirstName());
            editingStudent.setLastName(student.getLastName());
            editingStudent.setPhoneNumber(student.getPhoneNumber());
            studentRepository.save(editingStudent);
            return "Student edited";
        }
        return "Student not found";
    }
}
