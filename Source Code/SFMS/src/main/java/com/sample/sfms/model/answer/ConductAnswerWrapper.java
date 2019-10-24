package com.sample.sfms.model.answer;


import java.util.ArrayList;
import java.util.List;

public class ConductAnswerWrapper {
    private List<ConductAnswer> answers;

    public ConductAnswerWrapper() {
        answers = new ArrayList<>();
    }

    public List<ConductAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ConductAnswer> answers) {
        this.answers = answers;
    }
}
