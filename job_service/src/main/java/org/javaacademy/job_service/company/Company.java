package org.javaacademy.job_service.company;

import java.util.LinkedList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Company {
  @NonNull
  @Setter
  private String name;
  private final LinkedList<Vacancy> vacancies = new LinkedList<>();
}
