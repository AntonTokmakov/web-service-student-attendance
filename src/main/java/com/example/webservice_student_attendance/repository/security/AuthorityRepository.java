package com.example.webservice_student_attendance.repository.security;

import com.example.webservice_student_attendance.entity.securityEntity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
