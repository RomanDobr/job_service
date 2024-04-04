package org.javaacademy.job_service.company;

import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;

@Data
public class Vacancy {
  @NonNull
  private String vacancy;
  @NonNull
  private String jobTitles;
  @NonNull
  private BigDecimal price;
  @NonNull
  @Value("${job.price.currency}")
  private String currency;
}
