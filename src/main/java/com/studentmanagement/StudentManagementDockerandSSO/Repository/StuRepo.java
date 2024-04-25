package com.studentmanagement.StudentManagementDockerandSSO.Repository;

import com.studentmanagement.StudentManagementDockerandSSO.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuRepo extends JpaRepository<Student, Integer> {

}
