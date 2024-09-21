package com.aspatel.index.issue.service;

import com.aspatel.index.issue.dto.IssueDTO;
import com.aspatel.index.issue.internal.IssueConverter;
import com.aspatel.index.issue.internal.model.Issue;
import com.aspatel.index.issue.internal.repository.IssueRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class IssueService {

  private final IssueRepository issueRepository;
  private final IssueConverter issueConverter;

  public List<IssueDTO> findAll() {

    final List<IssueDTO> answer = new ArrayList<>();

    for (Issue issue : issueRepository.selectAll()) {
      answer.add(issueConverter.convert(issue));
    }

    return answer;
  }
}
