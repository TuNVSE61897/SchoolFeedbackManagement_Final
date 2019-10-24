package com.sample.sfms.api.responseModel;

public class AddQuestionResponseModel extends Response{

    private int questionId;

    public AddQuestionResponseModel(boolean succeed, int questionId) {
        super(succeed);
        this.questionId = questionId;
    }


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
