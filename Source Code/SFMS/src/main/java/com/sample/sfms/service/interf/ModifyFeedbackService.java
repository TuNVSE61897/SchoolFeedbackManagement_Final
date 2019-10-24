package com.sample.sfms.service.interf;

import com.sample.sfms.entity.*;
import com.sample.sfms.model.FeedbackDetailsModel;
import com.sample.sfms.model.ModifyFeedbackModel;
import org.springframework.http.ResponseEntity;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by MyPC on 23/02/2018.
 */
public interface ModifyFeedbackService {

    public ResponseEntity<Feedback> getFeedback(int id);

    public ResponseEntity<Feedback> createEmptyFeedback(String title, String description);

    public ResponseEntity<Feedback> createFeedbackFromTemplate(int id);

    public ResponseEntity<List<Feedback>> saveNewFeadbacks(ModifyFeedbackModel model);

    public ResponseEntity<Feedback> updateTemplate(ModifyFeedbackModel model);

    public ResponseEntity<Feedback> deleteFeedback(int id);

    public ResponseEntity<Feedback> addTarget(int typeId, int targetId);

    public FeedbackDetailsModel customizeConductors(FeedbackDetailsModel model, int[] conductorIds);

    public FeedbackDetailsModel customizeViewers(FeedbackDetailsModel model, int[] viewerIds);

    public ResponseEntity<ModifyFeedbackModel> setStart(Date start, Feedback feedback);

    public ResponseEntity<ModifyFeedbackModel> setEnd(Date end, Feedback feedback);

<<<<<<< Updated upstream
    public ResponseEntity<List<User>> loadConductors(int id);//id of feedback contains target

    public ResponseEntity<List<User>> loadViewers(int id);//id of feedback contains target
=======
    public ResponseEntity<UserFeedback> addConductor(int targetId, int userId, List<Integer> targetIds);

    public ResponseEntity removeConductor(int targetId, int userId, List<Integer> targetIds);

    public ResponseEntity<UserFeedback> addViewer(int targetId, int userId);

    public ResponseEntity<UserFeedback> removeViewer(int targetId, int userId);

    public ResponseEntity saveFeedback(Feedback feedback);

    public ResponseEntity updateSemester(int semesterId, int feedbackId);

    public ResponseEntity updateType(int typeId, int feedbackId);

    public ResponseEntity setStart(Date start, int feedbbackId);

    public ResponseEntity setEnd(Date end, int feedbackId);

    public ResponseEntity loadConductors(int id, List<Integer> targetIds);//id of feedback contains target

    public ResponseEntity loadViewers(int id);//id of feedback contains target

    public ResponseEntity loadDepartmentTargets(List<Integer> targetIds);//ids of feedbacks contain targets

    public ResponseEntity loadMajorTargets(List<Integer> targetIds);//ids of feedbacks contain targets

    public ResponseEntity loadCourseTargets(List<Integer> targetIds);//ids of feedbacks contain targets

    public ResponseEntity loadClazzTargets(List<Integer> targetIds);//ids of feedbacks contain targets

    public ResponseEntity loadTargets(List<Integer> targetIds);//ids of feedbacks contain targets

    public ResponseEntity loadAllTypes();

    public ResponseEntity loadAllSemesters();

    public ResponseEntity<List<Major>> filterMajors(String majorKey);

    public ResponseEntity<List<Course>> filterCourses(String courseKey);

    public ResponseEntity<List<Department>> filterDepartments();

    public ResponseEntity<List<User>> filterLecturers(String majorKey, String nameKey);

    public ResponseEntity<List<Clazz>> filterClazz(String majorKey, String courseKey, String semesterkey, String lecturerKey);

    public ResponseEntity<List<Clazz>> filterClazz(int majorKey, int courseKey, int semesterkey, int lecturerKey);

    public List filterSemester(String title);

    List<User> getAllStudents();
>>>>>>> Stashed changes

    public ResponseEntity<List<User>> loadTargets(int[] id);//ids of feedbacks contain targets
}