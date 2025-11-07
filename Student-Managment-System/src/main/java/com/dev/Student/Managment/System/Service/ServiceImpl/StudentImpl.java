package com.dev.Student.Managment.System.Service.ServiceImpl;

import com.dev.Student.Managment.System.DTOs.StudentDto;
import com.dev.Student.Managment.System.Entity.Student;
import com.dev.Student.Managment.System.Repository.StudentRepo;
import com.dev.Student.Managment.System.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {

    @Autowired
    private final StudentRepo studentRepo;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    @CacheEvict(value = {"students"}, allEntries = true)  // clear list cache
    public StudentDto addStudent(StudentDto studentDto) {
        Student stu = modelMapper.map(studentDto, Student.class);
        Student saved = studentRepo.save(stu);
        return modelMapper.map(saved, StudentDto.class);
    }

    @Override
    @Cacheable(value = "students") // cache the entire list
    public List<StudentDto> getStudentList() {
        System.out.println("Fetching from MySQL (not Redis cache)");
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "student", key = "#id") // cache individual student
    public StudentDto getStudentById(Long id) {
        System.out.println("Fetching Student " + id + " from MySQL (not Redis cache)");
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found by ID : " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    @CachePut(value = "student", key = "#id") // update cache entry for that ID
    @CacheEvict(value = "students", allEntries = true) // clear list cache
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found by ID : " + id));
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        student.setEmail(studentDto.getEmail());

        Student updated = studentRepo.save(student);
        return modelMapper.map(updated, StudentDto.class);
    }

    @Override
    @CacheEvict(value = {"student", "students"}, allEntries = true) // remove both caches
    public boolean deleteStudent(Long id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
