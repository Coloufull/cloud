package com.cloud.feign;


import com.cloud.Stu.Student;
import com.cloud.feign.Impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {
    @GetMapping("/student/findAll")
    public Collection<Student>findAll();
    @GetMapping("/student/index")
    public String index();
}
