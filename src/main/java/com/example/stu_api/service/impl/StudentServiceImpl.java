package com.example.stu_api.service.impl;

import com.example.stu_api.dto.StudentRequestDto;
import com.example.stu_api.dto.StudentResponseDto;
import com.example.stu_api.entity.Student;
import com.example.stu_api.repository.StudentRepository;
import com.example.stu_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student(null,studentRequestDto.getName(),studentRequestDto.getEmail(),studentRequestDto.getAge());
        Student savedStudent = studentRepository.save(student);
        return new StudentResponseDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getEmail(),
                savedStudent.getAge()
        );
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getAge()
                )).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge()
        );
    }
}
