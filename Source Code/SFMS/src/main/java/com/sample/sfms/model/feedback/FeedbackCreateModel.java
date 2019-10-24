package com.sample.sfms.model.feedback;

import com.sample.sfms.model.Model;
import com.sample.sfms.model.question.AddQuestionModel;

import java.util.List;

public class FeedbackCreateModel extends Model {

    private int id;

    private List<AddQuestionModel> questions;

    public FeedbackCreateModel(List<AddQuestionModel> questions) {
        this.questions = questions;
    }

    public FeedbackCreateModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AddQuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<AddQuestionModel> questions) {
        this.questions = questions;
    }

    @Override
    public boolean valid() {
        if (this.questions == null || this.questions.size() == 0) 
            return false;

        for (AddQuestionModel question :
                questions) {
            if (!question.valid())
                return false;
        }

        return true;
    }
}
