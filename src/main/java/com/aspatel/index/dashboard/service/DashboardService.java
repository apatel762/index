package com.aspatel.index.dashboard.service;

import com.aspatel.index.issue.service.IssueService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DashboardService {

  private final IssueService issueService;

  public Map<String, Object> populateDashboard() {
    final Map<String, Object> tags = new HashMap<>();
    tags.put("user", "Jelly Combs");
    tags.put("issues", issueService.findAll());
    return tags;
  }
}
