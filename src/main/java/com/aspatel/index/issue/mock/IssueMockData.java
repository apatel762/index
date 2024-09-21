package com.aspatel.index.issue.mock;

import com.aspatel.index.issue.internal.model.Issue;
import com.aspatel.index.issue.internal.repository.IssueRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class IssueMockData implements CommandLineRunner {

  private final IssueRepository issueRepository;

  @Override
  public void run(final String... args) throws Exception {
    issueRepository.insert(
        Issue.builder()
            .summary("nothing is working!!")
            .createdAt(LocalDateTime.of(2024, 12, 21, 16, 20))
            .author("Karen K.")
            .description(
                "the stupid website doesn't work! you need to fix this or else i;m telling your"
                    + " boss you *$(*\"^%(*£$(\"*$!!")
            .build());
    issueRepository.insert(
        Issue.builder()
            .summary("Downtime reported")
            .createdAt(LocalDateTime.of(2024, 12, 22, 13, 17))
            .author("Chadji P.T.")
            .description(
                "Reports of downtime reported by Ms. Karen K. during the hours of 16:00-17:00"
                    + " yesterday. Please investigate.")
            .build());
  }
}
