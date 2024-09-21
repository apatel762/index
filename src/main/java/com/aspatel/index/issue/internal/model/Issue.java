package com.aspatel.index.issue.internal.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Issue {

  private long id;
  private String summary;
  private LocalDateTime createdAt;
  private String author;
  private String description;
}
