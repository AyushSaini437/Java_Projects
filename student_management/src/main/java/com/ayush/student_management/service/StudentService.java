package com.ayush.student_management.service;

import com.ayush.student_management.dto.AddStudentRequestDto;
import com.ayush.student_management.dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createdNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
