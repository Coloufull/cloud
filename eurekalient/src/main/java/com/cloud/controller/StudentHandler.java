package com.cloud.controller;

import com.cloud.Sutdent.Student;
import com.cloud.repostory.StudentRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHandler {
    @Autowired
    private StudentRepostory studentRepostory;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepostory.findAll();
    }
    @GetMapping("/finById/{id}")
    public Student finById(@PathVariable("id") Long id){
        return studentRepostory.finById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
         studentRepostory.saveOrUpdate(student);
    }

    @PutMapping("/update")
    public void Update(@RequestBody Student student){
        studentRepostory.saveOrUpdate(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        studentRepostory.deleteById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "当前端口"+this.port;
    }
}
