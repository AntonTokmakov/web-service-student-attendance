package com.example.webservice_student_attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WebServiceStudentAttendanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebServiceStudentAttendanceApplication.class, args);
	}
}
