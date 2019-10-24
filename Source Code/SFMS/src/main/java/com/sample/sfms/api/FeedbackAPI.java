package com.sample.sfms.api;

import com.sample.sfms.api.responseModel.Response;
import com.sample.sfms.entity.Answer;
import com.sample.sfms.entity.Feedback;
import com.sample.sfms.model.feedback.FeedbackCreateModel;
import com.sample.sfms.model.question.AddQuestionModel;
import com.sample.sfms.service.interf.FeedbackService;
import com.sample.sfms.service.interf.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Binh Nguyen on 21-Feb-18.
 */

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackAPI {

    //test new branch
    //test
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    private List<Feedback> getListTemplate(){
        return feedbackService.getListTemplate(true);
    }

    @GetMapping("/{id}")
    private Feedback getTemplateContent(@PathVariable("id") int id){
        return feedbackService.findFeedbackById(id);
    }

    @RequestMapping(value = "/save-question", method = RequestMethod.POST)
    @Transactional
    public Response saveQuestion(@RequestBody FeedbackCreateModel model) {
        if(model.valid()) {
            try {
                //int feedbackId = feedbackService.save(model);
                int feedbackId = model.getId();

                for (AddQuestionModel question :
                        model.getQuestions()) {
                    question.setFeedbackId(feedbackId);
                    questionService.addQuestion(question);
                }
                return new Response(true, "overview-feedback");
            } catch (Exception ex) {
                return new Response(false, ex.getMessage());
            }

        }
        return new Response(false, "Xin kiểm tra lại feedback đã hợp lệ chưa");
    }
<<<<<<< Updated upstream
=======

    @RequestMapping(value = "/modify-question", method = RequestMethod.POST)
    @Transactional
    public Response modifyQuestion(@RequestBody FeedbackUpdateModel model) {
        if(model.valid()) {
            try {
                //int feedbackId = feedbackService.save(model);
                int feedbackId = model.getId();
                List<Question> listExistedQuestion = questionService.findByFeedbackId(feedbackId);
                System.out.print("listExistedQuestion: " + listExistedQuestion.size());
                List<Integer> listModifyQuestionID = new ArrayList<>();
                for (UpdateQuestionModel question : model.getQuestions()) {
                    if (question.getQuestionId() >= 0) {
                        question.setFeedbackId(feedbackId);
                        questionService.updateQuestion(question);
                        listModifyQuestionID.add(question.getQuestionId());
                    } else {
                        AddQuestionModel addQuestion = new AddQuestionModel();
                        addQuestion.setFeedbackId(feedbackId);
                        addQuestion.setType(question.getType());
                        addQuestion.setSuggestion(question.getSuggestion());
                        addQuestion.setCriteriaId(question.getCriteriaId());
                        addQuestion.setQuestionContent(question.getQuestionContent());
                        addQuestion.setRequired(question.isRequired());
                        addQuestion.setRequireOther(question.isRequireOther());
                        OptionCreateModel[] options = new OptionCreateModel[question.getOptionUpdateModels().length];
                        int i = 0;
                        for (OptionUpdateModel option : question.getOptionUpdateModels()) {
                            OptionCreateModel addOption = new OptionCreateModel();
                            addOption.setOptionContent(option.getOptionContent());
                            addOption.setPoint(option.getPoint());
                          //  addOption.setQuestionId(option.getQuestionId());
                            addOption.setQuestion(option.getQuestion());
                            options[i] = addOption;
                            i++;
                        }
                        addQuestion.setOptionCreateModel(options);
                        int questionID = questionService.addQuestion(addQuestion);
                        listModifyQuestionID.add(questionID);
                    }
                }

                for (Question question : listExistedQuestion) {
                    if (!listModifyQuestionID.contains(question.getId()))     {
                        questionService.removeQuestion(question.getId());
                    }
                }

                return new Response(true, feedbackId + "");
            } catch (Exception ex) {
                return new Response(false, ex.getMessage());
            }

        }
        return new Response(false,"Xin kiểm tra lại feedback đã hợp lệ chưa");
    }


    @JsonView(FeedbackView.alertUserFeedbackView.class)
    @GetMapping("/undone-by-authorized-user")
    public ResponseEntity getListNotConductedFeedbackByAuthorizedUser() {
        return feedbackService.getNotConductedFeedbacksByUserId();
    }

    @JsonView(FeedbackView.alertUserFeedbackView.class)
    @GetMapping("/conduct")
    public ResponseEntity getListFeedbackOfAuthorizedUser() {
        return feedbackService.getNotConductedFeedbacksByUserId();
    }

    @JsonView(FeedbackView.conductFeedbackView.class)
    @GetMapping("/conduct/{id}")
    public Feedback conductFeedback(@PathVariable("id") int id) {
        return feedbackService.findFeedbackToConduct(id);
    }

>>>>>>> Stashed changes
}
