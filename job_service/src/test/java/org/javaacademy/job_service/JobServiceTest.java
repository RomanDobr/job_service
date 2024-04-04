package org.javaacademy.job_service;

import lombok.extern.slf4j.Slf4j;
import org.javaacademy.job_service.company.Company;
import org.javaacademy.job_service.company.CompanyService;
import org.javaacademy.job_service.job_service.JobService;
import org.javaacademy.job_service.resume.Resume;
import org.javaacademy.job_service.resume.ResumeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
@Slf4j
@SpringBootTest
@ActiveProfiles("china")
public class JobServiceTest {
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ResumeService resumeService;

    @Test
    void createResumeSuccess() {
        Assertions.assertDoesNotThrow(() ->
                jobService.createResume(" ", "0"));
    }

    @Test
    void createResumeFail() {
        Assertions.assertThrows(NumberFormatException.class,
                () -> jobService.createResume(" ", "1o1"));
    }

    @Test
    void createUserSuccess() {
        Assertions.assertDoesNotThrow(() ->
                jobService.createUser("aaa", "bbb", createResume()));
    }

    @Test
    void createUserFail() {
        Assertions.assertThrows(NullPointerException.class,
                () -> jobService.createUser(Mockito.any(), "asd", createResume()));
    }

    @Test
    void createResumesSuccess() {
        List<Resume> resumes = jobService.takeResumes();
        log.info(String.valueOf(resumes.size()));
        Assertions.assertEquals(1, resumes.size());
    }

    @Test
    void createCompanySuccess() {
        Assertions.assertDoesNotThrow(() -> jobService.createCompany("Oil"));
    }

    @Test
    void faultCreateCompanySuccess() {
        Assertions.assertThrows(NullPointerException.class, () -> jobService.createCompany(Mockito.any()));
    }

    @Test
    void createVacancy() {
       Company company = jobService.createCompany("ПСБ");
        Assertions.assertDoesNotThrow(() -> jobService.createVacancy(company,
                "Java", "Разработчик", BigDecimal.valueOf(100L)));
        log.info(jobService.takeVacancies(company).toString());
    }

    @Test
    void faultCreateVacancy() {
        Assertions.assertThrows(RuntimeException.class, () ->
                jobService.createVacancy(Mockito.any(),"Java", "Разработчик", BigDecimal.valueOf(100L)));
    }

    @Test
    void takeVacanciesSuccess() {
        Company company = jobService.createCompany("ПСБ");
        jobService.createVacancy(company, "Java", "Разработчик", BigDecimal.valueOf(100L));
        Assertions.assertDoesNotThrow(() -> jobService.takeVacancies(company));
    }

    Resume createResume() {
        return resumeService.createResume("aaa", BigDecimal.valueOf(100L));
    }
}
