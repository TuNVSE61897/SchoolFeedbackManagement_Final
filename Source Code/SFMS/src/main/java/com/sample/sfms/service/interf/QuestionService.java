package com.sample.sfms.service.interf;

import com.sample.sfms.model.question.AddQuestionModel;
import com.sample.sfms.model.question.RemoveQuestionModel;
import com.sample.sfms.model.question.UpdateQuestionModel;

/**
 * Created by MyPC on 21/02/2018.
 */

public interface QuestionService {

    /**
     * Add 1 question
     * @param model
     * @return Id của question vừa được tạo dưới db
     */
    int addQuestion(AddQuestionModel model) throws Exception;

    void updateQuestion(UpdateQuestionModel model) throws Exception;

    void removeQuestion(RemoveQuestionModel model) throws Exception;

}
