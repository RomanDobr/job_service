package org.javaacademy.job_service.resume;

import lombok.Data;
import lombok.NonNull;
import java.math.BigDecimal;

@Data
public class Resume {
  @NonNull
  private final String skills;
  @NonNull
  private final BigDecimal price;
}
