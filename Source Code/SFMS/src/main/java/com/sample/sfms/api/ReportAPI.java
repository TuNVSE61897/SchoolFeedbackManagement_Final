package com.sample.sfms.api;

import com.sample.sfms.service.interf.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Binh Nguyen on 25-Feb-18.
 */
@RestController
@RequestMapping("/api/reports")
public class ReportAPI  {

    @Autowired
    ReportService reportService;

    @GetMapping
    private List<Object> getListReport(@RequestParam("type") String type)
    {
        return reportService.loadListReport(type);
    }
}
