package org.javaacademy.job_service;

import org.javaacademy.job_service.job_service.JobService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JobServiceApplication {
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(JobServiceApplication.class, args);
    JobService jobService = context.getBean(JobService.class);
  }
}
