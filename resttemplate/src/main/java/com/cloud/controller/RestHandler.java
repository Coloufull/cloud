package com.cloud.controller;

import com.cloud.Stu.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }
    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("finById/{id}")
    public Student finById(@PathVariable("id") long id){
        return restTemplate.getForEntity("http://localhost:8010/student/finById/{id}",Student.class,id).getBody();
    }
    @GetMapping("finById2/{id}")
    public Student finById2(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8010/student/finById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
         restTemplate.postForEntity("http://localhost:8010/student/save",student,null).getBody();
    }
    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
       restTemplate.postForObject("http://localhost:8010/student/save2",student,null);
    }

    @PutMapping ("/update")
    public void Update(@RequestBody Student student){
      restTemplate.put("http://localhost:8010/student/update",student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/student/delete/{id}",id);
    }
}
