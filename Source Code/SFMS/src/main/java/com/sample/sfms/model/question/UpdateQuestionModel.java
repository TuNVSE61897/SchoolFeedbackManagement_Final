package com.sample.sfms.model.question;

import com.sample.sfms.model.option.OptionCreateModel;
import com.sample.sfms.model.option.OptionUpdateModel;

public class UpdateQuestionModel extends AddQuestionModel {
    private int id;
    private OptionUpdateModel[] optionUpdateModels;

    public UpdateQuestionModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OptionUpdateModel[] getOptionUpdateModels() {
        return optionUpdateModels;
    }

    public void setOptionUpdateModels(OptionUpdateModel[] optionUpdateModels) {
        this.optionUpdateModels = optionUpdateModels;
    }

    @Override
    public OptionCreateModel[] getOptionCreateModel() {
        return this.getOptionUpdateModels();
    }
}
