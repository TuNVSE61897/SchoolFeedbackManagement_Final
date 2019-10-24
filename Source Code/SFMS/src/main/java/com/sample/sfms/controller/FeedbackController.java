package com.sample.sfms.controller;

import com.sample.sfms.entity.Feedback;
import com.sample.sfms.service.interf.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping
    private ModelAndView getListFeedback() {
        ModelAndView mav = new ModelAndView("view-list-feedback");
        List<Feedback> feedbackList = feedbackService.findAllFeedback();
        mav.addObject("feedbackList", feedbackList);
        return mav;
    }

}