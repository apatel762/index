package com.aspatel.index.issue.internal;

import com.aspatel.index.issue.dto.IssueDTO;
import com.aspatel.index.issue.internal.model.Issue;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IssueConverter implements Converter<Issue, IssueDTO> {
  @NonNull
  @Override
  public IssueDTO convert(@NonNull Issue source) {
    return IssueDTO.builder()
        .summary(source.getSummary())
        .createdAt(source.getCreatedAt())
        .author(source.getAuthor())
        .description(source.getDescription())
        .build();
  }
}
