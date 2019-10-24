package com.sample.sfms.api;

<<<<<<< Updated upstream
import com.sample.sfms.entity.Feedback;
import com.sample.sfms.entity.Role;
import com.sample.sfms.model.ModifyFeedbackModel;
import com.sample.sfms.service.interf.ModifyFeedbackService;
=======
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.json.UTF8JsonGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.sfms.entity.*;
//import com.sample.sfms.entity.Role;
//import com.sample.sfms.entity.Semester;
//import com.sample.sfms.model.ModifyFeedbackModel;
import com.sample.sfms.model.FilteringModel;
import com.sample.sfms.model.Target;
import com.sample.sfms.service.interf.ModifyFeedbackService;
import com.sample.sfms.view.*;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by MyPC on 24/02/2018.
 */
@RestController
@SessionAttributes("MFModel")//modify feedback model
@RequestMapping("/api/modify-feedback-targets")
class ModifyFeedbackObjsAPI {
    @Autowired
    ModifyFeedbackService modifyService;


}
@RestController
@SessionAttributes("MFModel")
@RequestMapping("/api/modify-feedback")
class  ModifyFeedbackAPI{
    @Autowired
    ModifyFeedbackService modifyService;

    @GetMapping("/create/{id}")
    private ResponseEntity<Feedback> getFeedback(@PathVariable("id") int id){
        return modifyService.getFeedback(id);
    }

    @PostMapping
    private ResponseEntity<Feedback> createFeedback(HttpSession session, @RequestParam("title")String title, @RequestParam("description")String description){
        ResponseEntity<Feedback> response = modifyService.createEmptyFeedback(title, description);
        session.setAttribute("id", response.getBody().getId());
        return response;
    }
    @JsonView(UserView.listUserView.class)
    @GetMapping("/list/conductors/{id}")
    private ResponseEntity listConductors(@PathVariable("id") int id, HttpSession session) {
        return modifyService.loadConductors(id, (List<Integer>)session.getAttribute("targetIds"));
    }

    @JsonView(UserView.listUserView.class)
    @GetMapping("/list/students")
    private Iterable<User> getAllStudents(){
        return modifyService.getAllStudents();
    }

    @PostMapping("/create/{id}")
    private ResponseEntity<Feedback> createFeedback(@PathVariable("id") int id, HttpSession session){
        ResponseEntity<Feedback> response = modifyService.createFeedbackFromTemplate(id);
        session.setAttribute("id", response.getBody().getId());
        return response;
    }

    @PutMapping
    private ResponseEntity<Feedback> updateTemplate(@RequestParam("MFModel") ModifyFeedbackModel MFModel){
        return modifyService.updateTemplate(MFModel);
    }

    @DeleteMapping
    private ResponseEntity<Feedback> deleteFeedback(@RequestParam("deletedId") int id){
        return modifyService.deleteFeedback(id);
    }

//    @DeleteMapping
//    private ResponseEntity<ModifyFeedbackModel> cancel


<<<<<<< Updated upstream
//    @PutMapping
//    private ResponseEntity<ModifyFeedbackModel> saveFeedbackModel (@RequestParam)

=======
    @PostMapping("/add/conductor/{id}")
    private ResponseEntity addConductor(@PathVariable("id") int targetId, @RequestBody User conductor, HttpSession session) {
        return modifyService.addConductor(targetId, conductor.getId(), (List<Integer>) session.getAttribute("targetIds"));
    }

    @DeleteMapping("/remove/conductor/{id}")
    private ResponseEntity removeConductor(@PathVariable("id") int id, @RequestBody User conductor, HttpSession session) {
        return modifyService.removeConductor(id, conductor.getId(),(List<Integer>) session.getAttribute("targetIds"));
    }


//    @PostMapping("/add-conductor")
//    private ResponseEntity<Integer> addCourseTarget(@RequestParam("semesterId") int typeId, HttpSession session) {
//        modifyService.deleteFeedbacks((List<Integer>)session.getAttribute("targetIds"));
//        return new ResponseEntity<Type>(
//                modifyService.updateType(typeId,
//                        (int) session.getAttribute("id")).getBody().getTypeByTypeId(),
//                HttpStatus.OK);
//    }

    @PutMapping("/save/option/{opt}")
    @JsonView({FeedbackView.overview.class})
    private ResponseEntity saveFeedback(@PathVariable("opt") int opt, HttpSession session) {
        ResponseEntity response;
        switch (opt) {
            case 1:
                response = modifyService.savePublishFeadbacks((int) session.getAttribute("id"),
                        (List<Integer>) session.getAttribute("targetIds"));
                session.setAttribute("targetIds", null);
                return response;
            case 2:
                response =  modifyService.saveTemplateFeadback((int) session.getAttribute("id"),
                        (List<Integer>) session.getAttribute("targetIds"));
                session.setAttribute("targetIds", null);
                return response;
            case 3:
                response =  modifyService.updateSelectedTemplate((int) session.getAttribute("id"),
                        (List<Integer>) session.getAttribute("targetIds"));
                session.setAttribute("targetIds", null);
                return response;
            default:
                response = new ResponseEntity(HttpStatus.BAD_REQUEST);
                session.setAttribute("targetIds", null);
                return response;
        }
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Feedback> deleteFeedback(@RequestBody Feedback feedback) {
        return modifyService.deleteFeedback(feedback.getId());
    }

    @DeleteMapping("/cancel")
    private ResponseEntity canceProcess(HttpSession session) {
        return modifyService.cancelProcess((int) session.getAttribute("id"), (List<Integer>) session.getAttribute("targetIds"));
    }

    String ObjToJson(Object o) throws JsonProcessingException {
        return om.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
>>>>>>> Stashed changes
}
