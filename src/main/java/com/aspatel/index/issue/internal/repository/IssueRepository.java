package com.aspatel.index.issue.internal.repository;

import com.aspatel.index.issue.internal.model.Issue;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IssueRepository {

  @Select(
      """
      SELECT id, summary, created_at, author, description
      FROM Issue
      """)
  List<Issue> selectAll();

  @Insert(
      """
      INSERT INTO Issue (summary, created_at, author, description)
      VALUES (#{summary}, #{createdAt}, #{author}, #{description})
      """)
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Issue issue);
}
