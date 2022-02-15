package uz.pdp.L5Task1.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.L5Task1.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    static List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(1, "Abror", "+998885856666", "Math"),
            new Student(2, "Bahodir", "+998845856666", "Pyhsics"),
            new Student(3, "Sukhrob", "+998885856005", "Computer Science"),
            new Student(4, "Nurbek", "+99888585313666", "Programming"),
            new Student(5, "Hayot", "+998885856600", "Software engineering")
    ));

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {

        return studentList;
    }


    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Student getOneStudent(@PathVariable Integer id) {
        for (Student student : studentList) {
            if (id == student.getId()) {
                return student;
            }
        }
        return new Student();
    }


}
