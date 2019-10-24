package com.sample.sfms.model.answer;

public class ConductAnswer {
    private int optionnByOptionnId;
    private String answerContent;


    public ConductAnswer() {
    }

    public int getOptionnByOptionnId() {
        return optionnByOptionnId;
    }

    public void setOptionnByOptionnId(int optionnByOptionnId) {
        this.optionnByOptionnId = optionnByOptionnId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
}
