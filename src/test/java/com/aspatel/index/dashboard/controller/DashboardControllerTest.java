package com.aspatel.index.dashboard.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aspatel.index.dashboard.service.DashboardService;
import com.aspatel.index.issue.dto.IssueDTO;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DashboardController.class)
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class DashboardControllerTest {

  @MockBean private DashboardService dashboardService;

  private final MockMvc mockMvc;

  @Test
  @DisplayName("Verify that the dashboard page is rendered properly.")
  void testDashboardPage() throws Exception {

    Map<String, Object> dashboardData = new HashMap<>();
    dashboardData.put("user", "John Doe");
    dashboardData.put(
        "issues",
        List.of(
            IssueDTO.builder()
                .summary("Issue 1")
                .createdAt(LocalDateTime.of(2024, 9, 21, 10, 0))
                .author("Alice")
                .description("Description of issue 1")
                .build(),
            IssueDTO.builder()
                .summary("Issue 2")
                .createdAt(LocalDateTime.of(2024, 9, 20, 14, 30))
                .author("Bob")
                .description("Description of issue 2")
                .build()));

    given(dashboardService.populateDashboard()).willReturn(dashboardData);

    mockMvc
        .perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .string(
                    equalTo(
                        """
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Dashboard</title>
                        </head>
                        <body>
                            <header>
                                <h1>Welcome back, John Doe</h1>
                            </header>
                            <main>
                                <h2>What's top of mind.</h2>
                                <hr>
                                <h3>Issue 1</h3>
                                <h4>2024-09-21T10:00</h4>
                                <h4>Alice</h4>
                                <p>Description of issue 1</p>
                                <hr>
                                <h3>Issue 2</h3>
                                <h4>2024-09-20T14:30</h4>
                                <h4>Bob</h4>
                                <p>Description of issue 2</p>
                                <hr>
                            </main>
                            <footer/>
                        </body>
                        </html>""")));
  }
}
