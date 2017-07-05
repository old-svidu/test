package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.models.pojo.Report;
import spring.models.pojo.Types;
import spring.services.interfaces.ReportService;
import spring.services.interfaces.TypesService;

import java.util.List;

@RestController
public class PageController {
    @Autowired
    private TypesService typesService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/data/types", method = RequestMethod.GET)
    public List<Types> getDataFromCombobox(){
        List<Types> types = typesService.getAllTypes();
        return types;
    }

    @RequestMapping(value = "/data/report", method = RequestMethod.GET)
    public List<Report> getDataForTable(@RequestParam("type") String type){
        List<Report> reports = reportService.getReportByType(type);
        return reports;
    }
}



