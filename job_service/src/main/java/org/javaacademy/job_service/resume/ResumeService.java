package org.javaacademy.job_service.resume;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {
  private final ResumeRepository resumeRepository;

  public Resume createResume(String skills, BigDecimal price) {
    return new Resume(skills, price);
  }

  public User createUser(String name, String email, Resume resume) {
    User user = new User(name, email, resume);
    resumeRepository.addResume(user);
    return user;
  }

  public Resume getResumeByName(String name) {
    return resumeRepository.findByName(name).orElseThrow();
  }

  public List<Resume> getResumes() {
    return resumeRepository.findAll();
  }
}
