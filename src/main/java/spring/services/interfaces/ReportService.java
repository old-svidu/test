package spring.services.interfaces;

import spring.models.pojo.Report;

import java.util.List;


public interface ReportService {
    List<Report> getReportByType(String type);
}
