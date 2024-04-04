package org.javaacademy.job_service.resume;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
  @NonNull
  private final String name;
  @NonNull
  private final String email;
  private final Resume resume;
}
