package com.vb.fitnessapp.controller;

import com.vb.fitnessapp.dto.ReportDataDTO;
import com.vb.fitnessapp.dto.UserDTO;
import com.vb.fitnessapp.service.ReportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
final class ReportController extends AbstractController {

    private final ReportDataService reportDataService;

    @Autowired
    public ReportController(final ReportDataService reportDataService) {
        this.reportDataService = reportDataService;
    }

    @GetMapping(value = "/report")
    public final String viewMainReportPage() {
        return REPORT_TEMPLATE;
    }

    @GetMapping(value = "/report/get")
    @ResponseBody
    public final List<ReportDataDTO> getReportData(final HttpServletRequest request) {
        final UserDTO userDTO = currentAuthenticatedUser(request);
        return reportDataService.findByUser(userDTO.getId());
    }

}
