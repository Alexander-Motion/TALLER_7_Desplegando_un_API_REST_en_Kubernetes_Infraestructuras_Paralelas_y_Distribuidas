package com.univalle.demo.controller;
import com.univalle.demo.entity.Student;
import com.univalle.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.InetAddress;
import java.util.*;
@RestController @RequestMapping("/student") @RequiredArgsConstructor
public class StudentController {
  private final StudentRepository repo;
  @PostMapping("/save") public ResponseEntity<Student> save(@RequestBody Student s) { return ResponseEntity.ok(repo.save(s)); }
  @GetMapping("/all") public ResponseEntity<List<Student>> all() { return ResponseEntity.ok(repo.findAll()); }
  @GetMapping("/{id}") public ResponseEntity<Student> byId(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
  @GetMapping("/pod-info") public ResponseEntity<Object> pod() throws Exception { return ResponseEntity.ok(Map.of("pod", InetAddress.getLocalHost().getHostName(), "ip", InetAddress.getLocalHost().getHostAddress())); }
}