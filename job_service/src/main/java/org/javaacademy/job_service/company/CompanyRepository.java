package org.javaacademy.job_service.company;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CompanyRepository {
  private final Map<String, Company> companies = new HashMap<>();

  public void add(Company company) {
    companies.put(company.getName(), company);
  }

  public Optional<Company> findByName(String name) {
    return Optional.ofNullable(companies.get(name));
  }

  public List<Company> findAll() {
    return new ArrayList<>(companies.values());
  }
}
