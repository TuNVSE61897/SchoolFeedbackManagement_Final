package com.sample.sfms.controller;

import com.sample.sfms.entity.PrivilegeRole;
import com.sample.sfms.entity.User;
import com.sample.sfms.model.report.reportSemester.ReportSemesterModel;
import com.sample.sfms.service.interf.ReportService;
import com.sample.sfms.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private static String SEE_SELF_REPORT = "SEE_SELF_REPORT";
    private static String SEE_ALL_REPORT = "SEE_ALL_REPORT";
    private static String SEE_DEPARTMENT_REPORT = "SEE_DEPARTMENT_REPORT";

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;

    @GetMapping
    private ModelAndView viewListReport() {
        User user = userService.getCurrentAuthenticatedUser();
        List<PrivilegeRole> list = new ArrayList<>(user.getRoleByRoleId().getPrivilegeRolesById());
        if (list.isEmpty()) {
            return new ModelAndView("forbidden");
        }
        ModelAndView mav = new ModelAndView("forbidden");
        for (PrivilegeRole p : list) {
            if (p.getPrivilege().getName().equals(SEE_ALL_REPORT)) {
                mav.setViewName("view-report");
                mav.addObject("feedbackTarget", reportService.loadListFeedbackTargetWrapper());
            } else if (p.getPrivilege().getName().equals(SEE_SELF_REPORT)) {
                mav.addObject("clazzes", user.getClazzesById());
                mav.setViewName("view-my-report");
            } else if (p.getPrivilege().getName().equals(SEE_DEPARTMENT_REPORT)) {
                mav.addObject("department", user.getDepartmentByDepartmentId());
                mav.setViewName("view-my-report");
            }
        }

        return mav;
    }

    @GetMapping("/semester-detail")
    private ModelAndView semesterDetail(@RequestParam("typeId") int typeId, @RequestParam("semId") int semId, @RequestParam("targetId") int targetId) {
        ModelAndView mav = new ModelAndView("view-report-semester");
        ReportSemesterModel reportSemesterModel = reportService.getReportSemesterDetail(typeId, semId, targetId);
        mav.addObject("report", reportSemesterModel);
        return mav;
    }
}
