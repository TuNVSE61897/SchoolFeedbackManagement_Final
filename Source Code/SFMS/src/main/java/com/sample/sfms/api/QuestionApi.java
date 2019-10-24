package com.sample.sfms.api;

import com.sample.sfms.api.responseModel.AddQuestionResponseModel;
import com.sample.sfms.api.responseModel.Response;
import com.sample.sfms.model.question.AddQuestionModel;
import com.sample.sfms.model.question.RemoveQuestionModel;
import com.sample.sfms.model.question.UpdateQuestionModel;
import com.sample.sfms.service.interf.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/question")
public class QuestionApi {

    @Autowired
    private QuestionService questionService;

    /**
     * Add 1 question
    * @return Response message
    * */
    @RequestMapping(value = "/add-question", method = RequestMethod.POST)
    public Response addQuestion(@RequestBody AddQuestionModel model) {
        try {
            int questionId = this.questionService.addQuestion(model);
            return new AddQuestionResponseModel(true, questionId);
        } catch (Exception ex) {
            return new Response(false, ex.getMessage());
        }

    }

    /**
     * Add nhiều question
     * @param model một array cái addQuestionModel
     * @return Response message
     */
    @RequestMapping(value = "/add-multiple-question", method = RequestMethod.POST)
    public Response addMultipleQuestions(@RequestBody AddQuestionModel[] model) {
        try {

            for (AddQuestionModel m : model) {
                this.questionService.addQuestion(m);
            }
            return new Response(true, "Successful");
        } catch (Exception ex) {
            return new Response(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/update-question", method = RequestMethod.POST)
    public Response updateQuestion(@RequestBody UpdateQuestionModel model) {
        try {
            this.questionService.updateQuestion(model);
            return new Response(true, "Successful");
        } catch (Exception ex) {
            return new Response(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/remove-question", method = RequestMethod.POST)
    public Response removeQuestion(@RequestBody RemoveQuestionModel model) {
        try {
            this.questionService.removeQuestion(model);
            return new Response(true, "Successful");
        } catch (Exception ex) {
            return new Response(false, ex.getMessage());
        }
    }
}
