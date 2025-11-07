package com.dev.Student.Managment.System.Service;

import com.dev.Student.Managment.System.DTOs.StudentDto;

import java.util.List;

public interface StudentService {
    public StudentDto addStudent(StudentDto studentDto);
    public List<StudentDto> getStudentList();
    public StudentDto getStudentById(Long id);
    public StudentDto updateStudent(Long id, StudentDto studentDto);
    public boolean deleteStudent(Long id);
}
