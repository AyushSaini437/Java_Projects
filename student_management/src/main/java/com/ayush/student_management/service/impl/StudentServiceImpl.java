package com.ayush.student_management.service.impl;

import com.ayush.student_management.dto.AddStudentRequestDto;
import com.ayush.student_management.dto.StudentDto;
import com.ayush.student_management.entity.Student;
import com.ayush.student_management.repository.StudentRepository;
import com.ayush.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(
                        student -> new StudentDto(
                                student.getId(),
                                student.getName(),
                                student.getEmail()
                        )
                )
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->  new IllegalArgumentException("Student with id " + id + " does not exist"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createdNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id: " + id);
        }
        studentRepository.deleteById(id);

    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Student not found with id: " + id));

        modelMapper.map(addStudentRequestDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Student not found with id: " + id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
