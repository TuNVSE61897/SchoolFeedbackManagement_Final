package com.sample.sfms.model;

import com.sample.sfms.entity.*;

import java.util.List;

/**
 * Created by MyPC on 23/02/2018.
 */
public class ModifyFeedbackModel {
    private Feedback feedback;
    private List<FeedbackDetailsModel> selectedObjs;

    public ModifyFeedbackModel() {
    }

    public ModifyFeedbackModel(Feedback feedback, List<FeedbackDetailsModel> selectedObjs) {
        this.feedback = feedback;
        this.selectedObjs = selectedObjs;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public List<FeedbackDetailsModel> getSelectedObjs() {
        return selectedObjs;
    }

    public void setSelectedObjs(List<FeedbackDetailsModel> selectedObjs) {
        this.selectedObjs = selectedObjs;
    }

}