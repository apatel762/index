package com.aspatel.index.dashboard.controller;

import com.aspatel.index.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DashboardController {

  private final DashboardService dashboardService;

  @GetMapping("/")
  public String dashboard(final Model model) {
    model.addAllAttributes(dashboardService.populateDashboard());
    return "dashboard";
  }
}
