package com.dev.Student.Managment.System.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    public Long id;
    public String firstname;
    public String lastname;
    public String email;
}
