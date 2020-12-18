package com.vb.fitnessapp.dto.converter;

import com.vb.fitnessapp.domain.ReportData;
import com.vb.fitnessapp.dto.ReportDataDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReportDataToReportDataDTO implements Converter<ReportData, ReportDataDTO> {

    @Override

    public ReportDataDTO convert(final ReportData reportData) {
        ReportDataDTO dto = null;
        if (reportData != null) {
            dto = new ReportDataDTO();
            dto.setId(reportData.getId());
            dto.setUserId(reportData.getUser().getId());
            dto.setDate(reportData.getDate());
            dto.setPounds(reportData.getPounds());
            dto.setNetCalories(reportData.getNetCalories());
            dto.setNetPoints(reportData.getNetPoints());
        }
        return dto;
    }

}
