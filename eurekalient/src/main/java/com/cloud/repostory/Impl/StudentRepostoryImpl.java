package com.cloud.repostory.Impl;

import com.cloud.Sutdent.Student;
import com.cloud.repostory.StudentRepostory;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepostoryImpl implements StudentRepostory {
    private static Map<Long,Student> StudentMap;

    static {
        StudentMap = new HashMap<>();
        StudentMap.put(1l,new Student(1L,"王鑫",22));
        StudentMap.put(2l,new Student(2l,"张三",18));
        StudentMap.put(3l,new Student(3l,"王五",25));
    }

    @Override
    public Collection<Student> findAll() {
        return StudentMap.values();
    }

    @Override
    public Student finById(long id) {
        return StudentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student Student) {
//        StudentMap.put(Student.getId(),Student);
        StudentMap.put(Student.getId(),Student);
    }

    @Override
    public void deleteById(long id) {
        StudentMap.remove(id);
    }
}
