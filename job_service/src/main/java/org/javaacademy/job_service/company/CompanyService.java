package org.javaacademy.job_service.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {
  private final CompanyRepository companyRepository;

  public Company createCompany(String name) {
    Company company = new Company(name);
    companyRepository.add(company);
    return company;
  }

  public Company getCompanyByName(String name) {
    return companyRepository.findByName(name).orElseThrow();
  }

  public List<Company> getCompanies() {
    return companyRepository.findAll();
  }

  public void createVacancy(Company company, String vacancy, String jobTitles, BigDecimal price, String currency) {
    company.getVacancies().addLast(new Vacancy(vacancy, jobTitles, price, currency));
  }

  public LinkedList<Vacancy> takeVacancies(String nameCompany) {
    Company company = getCompanyByName(nameCompany);
    return company.getVacancies();
  }
}
