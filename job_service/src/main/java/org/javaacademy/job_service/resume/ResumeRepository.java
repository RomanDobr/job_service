package org.javaacademy.job_service.resume;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ResumeRepository {
  private final Map<String, Resume> resumes = new HashMap<>();

  public void addResume(User user) {
    resumes.put(user.getName(), user.getResume());
  }

  public Optional<Resume> findByName(String name) {
    return Optional.ofNullable(resumes.get(name));
  }

  public List<Resume> findAll() {
    return new ArrayList<>(resumes.values());
  }
}
