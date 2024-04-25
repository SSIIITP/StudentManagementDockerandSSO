package com.studentmanagement.StudentManagementDockerandSSO.Service;

import com.studentmanagement.StudentManagementDockerandSSO.Model.Student;
import com.studentmanagement.StudentManagementDockerandSSO.Repository.StuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StuService {
    @Autowired
    private StuRepo repo;

    public void addemp(Student student){
        repo.save(student);
    }
    public List<Student> getAllEmp(){
        return repo.findAll();
    }
    public Student getEmpById(int id){
        Optional<Student> e = repo.findById(id);
        return e.orElse(null);
    }
    public void deleteEmpById(int id){
        repo.deleteById(id);
    }
}

