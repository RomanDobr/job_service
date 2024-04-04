package org.javaacademy.job_service.job_service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.job_service.company.Company;
import org.javaacademy.job_service.company.CompanyService;
import org.javaacademy.job_service.company.Vacancy;
import org.javaacademy.job_service.resume.Resume;
import org.javaacademy.job_service.resume.ResumeService;
import org.javaacademy.job_service.resume.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
  @Value("${job.price.currency}")
  private String currency;
  private final CompanyService companyService;
  private final ResumeService resumeService;

  public Company createCompany(String name) {
    return companyService.createCompany(name);
  }

  public void createVacancy(Company company, String vacancy, String jobTitles, BigDecimal price) {
    companyService.createVacancy(company, vacancy, jobTitles, price, currency);
  }

  public LinkedList<Vacancy> takeVacancies(Company company) {
    return companyService.takeVacancies(company.getName());
  }

  public User createUser(String name, String email, Resume resume) {
    return resumeService.createUser(name, email, resume);
  }

  public Resume createResume(String skills, String price) {
    return resumeService.createResume(skills, new BigDecimal(price));
  }

  public List<Resume> takeResumes() {
    return resumeService.getResumes();
  }
}
