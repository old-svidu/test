package spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.models.dao.ReportDao;
import spring.models.pojo.Report;
import spring.services.interfaces.ReportService;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportDao reportDao;

    @Override
    public List<Report> getReportByType(String type) {
        return reportDao.selectByType(type);
    }
}
