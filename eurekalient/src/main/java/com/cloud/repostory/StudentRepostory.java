package com.cloud.repostory;

import com.cloud.Sutdent.Student;

import java.util.Collection;

public interface StudentRepostory {
    public Collection<Student> findAll();
    public Student finById(long id);
    public void saveOrUpdate(Student Student);
    public void deleteById(long id);
}
