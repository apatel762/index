package com.aspatel.index.issue.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IssueDTO {

  private final String summary;
  private final LocalDateTime createdAt;
  private final String author;
  private final String description;
}
