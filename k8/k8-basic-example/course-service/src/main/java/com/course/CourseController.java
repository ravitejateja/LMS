package com.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @GetMapping("/{id}")
    public ResponseEntity<String> getCourse(@PathVariable String id) {
        return ResponseEntity.ok("Course for ID: " + id);
    }
}