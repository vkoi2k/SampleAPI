package com.example.demo.transform;

import java.text.DateFormat;
import java.text.ParseException;

import com.example.demo.dto.CreateStudentDTO;
import com.example.demo.dto.UpdateStudentDTO;
import com.example.demo.entity.Student;


public class StudentTransform {

	private DateFormat dateFormat;

	public StudentTransform(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Student apply(CreateStudentDTO dto) {
		Student student = new Student();
		student.setName(dto.getName());
		student.setGender(dto.getGender());
		student.setIdentityNumber(dto.getIdentityNumber());
		try {
			student.setDob(dateFormat.parse(dto.getDob()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void apply(Student student, UpdateStudentDTO dto) {
		if (dto.getName() != null)
			student.setName(dto.getName());
		if (dto.getGender() != null)
			student.setGender(dto.getGender());
		try {
			if (dto.getDob() != null)
				student.setDob(dateFormat.parse(dto.getDob()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
