package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Student;


public interface StudentRepository {

	List<Student> findAll();

	Student findById(long id);

	void insert(Student s);

	void update(Student s);

	void delete(Student s);

}
