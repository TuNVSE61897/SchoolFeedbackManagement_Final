package com.sample.sfms.model.question;

import com.sample.sfms.model.Model;
import com.sample.sfms.model.StaticVariables;
import com.sample.sfms.model.option.OptionCreateModel;

import java.util.Arrays;

public class AddQuestionModel extends Model {

    private String type;
    private String suggestion;
    private int criteriaId;
    private int feedbackId;
    private boolean required;
    private String questionContent;
    private OptionCreateModel[] optionCreateModel;
    private boolean requireOther;


    public AddQuestionModel() {

    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public int getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(int criteriaId) {
        this.criteriaId = criteriaId;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public boolean isRequireOther() {
        return requireOther;
    }

    public void setRequireOther(boolean requireOther) {
        this.requireOther = requireOther;
    }

    public OptionCreateModel[] getOptionCreateModel() {
        return optionCreateModel;
    }

    public void setOptionCreateModel(OptionCreateModel[] optionCreateModel) {
        this.optionCreateModel = optionCreateModel;
    }

    @Override
    public boolean valid() {
        if (type == null)
            return false;

        if (Arrays.asList(StaticVariables.OPTION_NEEDED_QUESTION_TYPE).contains(this.type))
            return this.optionCreateModel != null;
        else return this.optionCreateModel == null;
    }
}
