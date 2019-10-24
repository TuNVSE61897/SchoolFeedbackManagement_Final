package com.sample.sfms.service.impl;
import com.sample.sfms.repository.CourseRepository;
import com.sample.sfms.repository.DepartmentRepository;
import com.sample.sfms.repository.MajorRepository;
import com.sample.sfms.service.interf.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Binh Nguyen on 25-Feb-18.
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private DepartmentRepository depRepo;

    @Autowired
    private MajorRepository majorRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<Object> loadListReport(String type) {
        List<Object> results = new ArrayList<>();
        switch (type) {
            case "major":
                results.addAll(majorRepo.filtering());
                break;
            case "course":
                results.addAll(courseRepo.filtering());
                break;
            case "department":
                results.addAll(depRepo.filtering());
                break;
            default: break;
        }
        return results;
    }
}
