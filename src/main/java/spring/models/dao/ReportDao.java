package spring.models.dao;

import spring.models.pojo.Report;
import spring.models.pojo.Types;

import java.util.List;

public interface ReportDao {
    List<Report> selectByType(String type);
}
