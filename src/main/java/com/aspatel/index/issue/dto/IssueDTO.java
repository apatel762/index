package com.aspatel.index.issue.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class IssueDTO {

  @NonNull private final String summary;
  @NonNull private final LocalDateTime createdAt;
  @NonNull private final String author;
  @NonNull private final String description;
}
