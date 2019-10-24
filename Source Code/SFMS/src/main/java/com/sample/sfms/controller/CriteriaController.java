package com.sample.sfms.controller;

import com.sample.sfms.entity.Criteria;
import com.sample.sfms.service.interf.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by MyPC on 25/03/2018.
 */

@RestController
@RequestMapping("/criteria")
public class CriteriaController {
    @Autowired
    private CriteriaService criteriaService;

    @GetMapping(value = "/list")
    private ModelAndView getListConductFeedback() {
        ModelAndView mav = new ModelAndView("view-list-criteria");
        mav.addObject("alltypes",criteriaService.loadAllTypes().getBody());
        return mav;
    }
}
