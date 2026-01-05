package com.example.stu_api.service;

import com.example.stu_api.dto.StudentRequestDto;
import com.example.stu_api.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto createStudent(StudentRequestDto studentRequestDto);
   List<StudentResponseDto> getAllStudents();
   StudentResponseDto getStudentById(Long id);
   StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto);
}
