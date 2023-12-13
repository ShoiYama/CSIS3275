package com.example.lab4_part1.Web;

import com.example.lab4_part1.Repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path = "/index")
    public String students() {
        return "students";
    }
}
