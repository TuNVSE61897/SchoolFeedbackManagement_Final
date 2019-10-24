package com.sample.sfms.service.impl;

import com.sample.sfms.entity.*;
import com.sample.sfms.model.FeedbackDetailsModel;
import com.sample.sfms.model.ModifyFeedbackModel;
import com.sample.sfms.repository.*;
import com.sample.sfms.service.interf.ModifyFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MyPC on 23/02/2018.
 */
@Service("ModifyFeedbackService")
public class ModifyFeedbackServiceImpl implements ModifyFeedbackService {

    static Logger logger = Logger.getLogger(ModifyFeedbackServiceImpl.class.getName());

    @Autowired
    private FeedbackRepository feedbackRepo;

    @Autowired
    private MajorRepository majorRepo;

    private MajorCourseRepository majorCourseRepo;
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private ClazzRepository clazzRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private TypeRepository typeRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserFeedbackRepository userFeedbackRepo;

    @Autowired
    private StudentClazzRepository studentClazzRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserFilteringRepository userFilteringRepo;

    @Override
    public ResponseEntity<Feedback> getFeedback(int id) {
        Feedback fb = feedbackRepo.findOne(id);
        try {
            return new ResponseEntity<Feedback>(feedbackRepo.findOne(id), HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
<<<<<<< Updated upstream
//        String[] conductorIds = fb.getConductors().split("/"), viewerIds = fb.getViewers().split("/");
//        List<User> conductors = new ArrayList<>(), viewers = new ArrayList<>();
//        User tmp;
//        if (conductorIds != null) {
//            for (String conductorId : conductorIds) {
//                tmp = userRepo.findOne(Integer.parseInt(conductorId));
//                if (tmp != null) conductors.add(tmp);
//            }
//        }
//        if (viewerIds != null) {
//            for (String viewerId : viewerIds) {
//                tmp = userRepo.findOne(Integer.parseInt(viewerId));
//                if (tmp != null) viewers.add(tmp);
//            }
//        }
//        List<FeedbackDetailsModel> details = new ArrayList<>();
//        switch (fb.getTypeByTypeId().getDescription()) {
//            case "Major":
//                details.add(new FeedbackDetailsModel(conductors, viewers, fb.getMajorByMajorId(), null, null, null, fb.getTypeByTypeId()));
//                break;
//            case "Course":
//                details.add(new FeedbackDetailsModel(conductors, viewers, null, fb.getCourseByCourseId(), null, null, fb.getTypeByTypeId()));
//                break;
//            case "Clazz":
//                details.add(new FeedbackDetailsModel(conductors, viewers, null, null, fb.getClazzByClazzId(), null, fb.getTypeByTypeId()));
//                break;
//            case "Department":
//                details.add(new FeedbackDetailsModel(conductors, viewers, null, null, null, fb.getDepartmentByDepartmentId(), fb.getTypeByTypeId()));
//                break;
//            default:
//                break;
//        }
=======
    }

    @Override
    public ResponseEntity<List<Feedback>> savePublishFeadbacks(int feedbackId, List<Integer> targetIds) {
        try {
            List<Feedback> affected = new ArrayList<>();
            Feedback target = new Feedback(), template = feedbackRepo.findOne(feedbackId);
            if (template == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            for (int targetId : targetIds) {
                target = feedbackRepo.findOne(targetId);
                if (target != null) {
                    target = clone(template, target);
                    target.setIsPublished(true);
                    target.setIsTemplate(false);
                    affected.add(feedbackRepo.save(target));
                }
            }
            deleteFeedback(template);
            return new ResponseEntity<>(affected, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Feedback> saveTemplateFeadback(int feedbackId, List<Integer> targetIds) {
        try {
            List<Feedback> affected = new ArrayList<>();
            Feedback target = new Feedback(), template = feedbackRepo.findOne(feedbackId);
            if (template == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            for (int targetId : targetIds) {
                target = feedbackRepo.findOne(targetId);
                if (target != null) {
                    deleteFeedback(target);
                }
            }
            template.setIsTemplate(true);
            template.setIsPublished(false);
            template = feedbackRepo.save(template);
            return new ResponseEntity<>(template, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Feedback> updateSelectedTemplate(int feedbackId, List<Integer> targetIds) {
        try {
            Feedback feedback = feedbackRepo.findOne(feedbackId), target = new Feedback();
            feedback.setId(feedback.getFeedbackByReferenceId().getId());
            feedback.setFeedbackByReferenceId(null);
            for (int id : targetIds) {
                target = feedbackRepo.findOne(id);
                if (target != null) {
                    feedbackRepo.delete(target);
                }
            }
            Feedback template = feedback.getFeedbackByReferenceId();
            for (Question q : template.getQuestionsById()) {
                questionRepo.delete(q);
            }
            template = clone(feedback, template);
            template.setStartDate(null);
            template.setEndDate(null);
            template.setIsTemplate(true);
            template.setIsPublished(false);
            template.setSemesterBySemesterId(null);
            return new ResponseEntity<>(feedbackRepo.save(feedback), HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public Feedback clone(Feedback template, Feedback target) {
        target.setTypeByTypeId(template.getTypeByTypeId());
        target.setFeedbackDes(template.getFeedbackDes());
        target.setFeedbackName(template.getFeedbackName());
        target.setFeedbackByReferenceId(template.getFeedbackByReferenceId());
        target.setCreateDate(template.getCreateDate());
        target.setStartDate(template.getStartDate());
        target.setEndDate(template.getEndDate());
        target.setIsTemplate(template.getIsTemplate());
        target.setSemesterBySemesterId(template.getSemesterBySemesterId());
        Question question = new Question();
        Optionn optionn = new Optionn();
        for (Question q : template.getQuestionsById()) {
            question = new Question(q.getType(), q.getSuggestion(), q.getIsRequied(), q.getQuestionContent(),
                    q.getCriteriaByCriteriaId(), target);
            question = questionRepo.save(question);
            for (Optionn o : q.getOptionsById()) {
                optionn = new Optionn(o.getOptionnContent(), o.getPoint(), question);
                optionn = optionRepo.save(optionn);
            }
        }
        return target;
>>>>>>> Stashed changes
    }

    @Override
    public ResponseEntity<Feedback> createFeedbackFromTemplate(int id) {
        try {
            Feedback template = feedbackRepo.findOne(id);
            return new ResponseEntity<>(feedbackRepo.save(new Feedback(
                    template.getFeedbackDes(),
                    template.getFeedbackName(),
                    template.getFeedbackDes(),
                    template.getFeedbackName(),
                    template.getDepartmentByDepartmentId(),
                    template.getCourseByCourseId(),
                    template.getMajorByMajorId(),
                    template.getClazzByClazzId(),
                    template.getTypeByTypeId(),
                    template.getFeedbackByReferenceId()
            )), HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Feedback> createEmptyFeedback(String title, String description) {
        try {
            return new ResponseEntity<Feedback>(feedbackRepo.save(new Feedback(description, title)), HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Feedback>> saveNewFeadbacks(ModifyFeedbackModel model) {
        ResponseEntity<List<Feedback>> response;
        try {
            List<Feedback> affected = new ArrayList<>();
//            Feedback sharedTemplate = model.getFeedback(), tmp;
//            Type t;
//            String selectedusers;
//            for (FeedbackDetailsModel detail : model.getSelectedObjs()) {
//                t = detail.getType();
//                selectedusers = "";
//                tmp = sharedTemplate;
//                switch (t.getDescription()) {
//                    case "Major":
//                        tmp.setMajorByMajorId(majorRepo.findOne(detail.getMajor().getId()));
//                        break;
//                    case "Course":
//                        tmp.setCourseByCourseId(courseRepo.findOne(detail.getCourse().getId()));
//                        break;
//                    case "Clazz":
//                        tmp.setClazzByClazzId(clazzRepo.findOne(detail.getClazz().getId()));
//                        break;
//                    case "Department":
//                        tmp.setDepartmentByDepartmentId(departmentRepo.findOne(detail.getDepartment().getId()));
//                        break;
//                    default:
//                        break;
//                }
//                tmp.setTypeByTypeId(t);
//                for (User conductor : detail.getConductors()) {
//                    selectedusers += conductor.getId() + "/";
//                }
//                tmp.setConductors(selectedusers.substring(0, selectedusers.length() - 1));
//                selectedusers = "";
//                for (User viewer : detail.getReportviewers()) {
//                    selectedusers += viewer.getId() + "/";
//                }
//                tmp.setViewers(selectedusers.substring(0, selectedusers.length() - 1));
//                affected.add(feedbackRepo.save(tmp));
//            }
            response = new ResponseEntity<>(affected, HttpStatus.OK);
            return response;
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @Override
    public ResponseEntity<Feedback> updateTemplate(ModifyFeedbackModel model) {
        try {
            if (feedbackRepo.exists(model.getFeedback().getId())) {
//                model.getFeedback().setConductors("");
//                model.getFeedback().setViewers("");
                Feedback f = new Feedback();
                feedbackRepo.save(model.getFeedback());
                return new ResponseEntity<>(HttpStatus.OK);
            } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Feedback> deleteFeedback(int id) {
        try {
            feedbackRepo.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Feedback> addTarget(int typeId, int targetId) {
        Feedback response = new Feedback();
        try {
            Type t = typeRepo.findOne(typeId);
            switch (t.getDescription()) {
                case "Major":
                    response = feedbackRepo.save(new Feedback(null, null, majorRepo.findOne(targetId), null, t));
                    break;
                case "Course":
                    response = feedbackRepo.save(new Feedback(null, courseRepo.findOne(targetId), null, null, t));
                    break;
<<<<<<< Updated upstream
                case "Clazz":
=======
                case "Lớp":
                    if (!targetIds.isEmpty()) {
                        for (int id : targetIds) {
                            response = feedbackRepo.findOne(id);
                            if (response.getClazzByClazzId().getId() == targetId)
                                return new ResponseEntity<>(targetIds, HttpStatus.ALREADY_REPORTED);
                        }
                    }
>>>>>>> Stashed changes
                    response = feedbackRepo.save(new Feedback(null, null, null, clazzRepo.findOne(targetId), t));
                    break;
                case "Department":
                    response = feedbackRepo.save(new Feedback(departmentRepo.findOne(targetId), null, null, null, t));
                    break;
                default:
                    break;
            }
            autoGenerateConductorsAndViewers(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

<<<<<<< Updated upstream
=======
    public void deleteFeedback(Feedback response) {

        userFeedbackRepo.delete(response.getUserFeedbacksById());
//                            response.setUserFeedbacksById(null);
        feedbackRepo.delete(response.getFeedbacksById());
//                            response.setFeedbacksById(null);
        for (Question q : response.getQuestionsById()) {
            for (Optionn opt : q.getOptionsById()) {
                answerRepo.delete(opt.getAnswersById());
            }
            optionRepo.delete(q.getOptionsById());
        }
        questionRepo.delete(response.getQuestionsById());
//                            response.setQuestionsById(null);

        feedbackRepo.delete(response);

    }

    @Override
    public ResponseEntity<List<Integer>> removeTarget(int id, List<Integer> targetIds) {
        Feedback response = new Feedback();
        Type t;
        int removedId = 0;
        try {
            for (int targetId : targetIds) {
                response = feedbackRepo.findOne(targetId);
                t = response.getTypeByTypeId();
                switch (t.getDescription()) {
                    case "Chuyên ngành":
                        if (response.getMajorByMajorId().getId() == id)
                            userFeedbackRepo.delete(response.getUserFeedbacksById());
                        feedbackRepo.delete(response);
                        removedId = response.getId();
                        break;
                    case "Môn học":
                        if (response.getCourseByCourseId().getId() == id)
                            userFeedbackRepo.delete(response.getUserFeedbacksById());
                        feedbackRepo.delete(response);
                        removedId = response.getId();
                        break;
                    case "Lớp":
                        if (response.getClazzByClazzId().getId() == id) {
                            userFeedbackRepo.delete(response.getUserFeedbacksById());
//                            response.setUserFeedbacksById(null);
                            feedbackRepo.delete(response.getFeedbacksById());
//                            response.setFeedbacksById(null);
                            for (Question q : response.getQuestionsById()) {
                                for (Optionn opt : q.getOptionsById()) {
                                    answerRepo.delete(opt.getAnswersById());
                                }
                                optionRepo.delete(q.getOptionsById());
                            }
                            questionRepo.delete(response.getQuestionsById());
//                            response.setQuestionsById(null);
                            removedId = response.getId();
                            feedbackRepo.delete(response);
                        }
                        break;
                    case "Phòng ban":
                        if (response.getDepartmentByDepartmentId().getId() == id)
                            userFeedbackRepo.delete(response.getUserFeedbacksById());
                        feedbackRepo.delete(response);
                        removedId = response.getId();
                        break;
                    default:
                        return new ResponseEntity<>(targetIds, HttpStatus.BAD_REQUEST);
                }
            }
            if (removedId == 0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            targetIds.remove((Object) removedId);
            return new ResponseEntity<>(targetIds, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Feedback>> deleteFeedbacks(List<Integer> ids) {
        try {
            Feedback target;
            List<Feedback> affected = new ArrayList<>();
            if (!ids.isEmpty()) {
                for (int id : ids) {
                    target = feedbackRepo.findOne(id);
                    if (target != null) {
                        deleteFeedback(target);
                        affected.add(target);
                    }
                }
            }
            return new ResponseEntity<>(affected, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
>>>>>>> Stashed changes

    public void autoGenerateConductorsAndViewers(Feedback f) {
        List<User> conductors = new ArrayList<>(), viewers = new ArrayList<>();
        List<StudentClazz> studentClazzes = new ArrayList<>();
        List<MajorCourse> majorCourses;
        String specialDepartment = "IT/Y tế/Thư Viện";
        User tmp;
        switch (f.getTypeByTypeId().getDescription()) {
            case "Major":
                conductors = userFilteringRepo.findByMajorByMajorId(f.getMajorByMajorId());
                viewers = userFilteringRepo.findByRoleByRoleId_RoleNameAndMajorByMajorId("HeadOfAcademic", f.getMajorByMajorId());
                break;
            case "Course":
                Course course = f.getCourseByCourseId();
                //set default conductors
                List<Clazz> clazzesOfCourse = clazzRepo.findByCourseByCourseId(course);
                for (Clazz c : clazzesOfCourse) {
                    tmp = c.getUserByLecturerId();
                    if (!conductors.contains(tmp)) conductors.add(tmp);
                    studentClazzes.addAll(studentClazzRepo.findByClazzByClazzId(c));
                }
                for (StudentClazz sc : studentClazzes) {
                    tmp = sc.getUserByUserId();
                    if (!conductors.contains(tmp)) conductors.add(tmp);
                }
//                set default viewers
                majorCourses = majorCourseRepo.findByCourseByCourseId(course);
                viewers.addAll(userFilteringRepo.findByRoleByRoleIdAndMajorByMajorId_MajorCoursesByIdContains(
                        roleRepo.findByRoleName("HeadOfAcademic"), majorCourses
                ));
                viewers.addAll(userFilteringRepo.findByRoleByRoleIdAndMajorByMajorId_MajorCoursesByIdContains(
                        roleRepo.findByRoleName("Lecturer"), majorCourses
                ));
                break;
            case "Clazz":
                studentClazzes.addAll(studentClazzRepo.findByClazzByClazzId(f.getClazzByClazzId()));
                for (StudentClazz sc : studentClazzes) {
                    tmp = sc.getUserByUserId();
                    if (!conductors.contains(tmp)) conductors.add(tmp);
                }
                course = f.getClazzByClazzId().getCourseByCourseId();
                majorCourses = majorCourseRepo.findByCourseByCourseId(course);
                viewers.addAll(userFilteringRepo.findByRoleByRoleIdAndMajorByMajorId_MajorCoursesByIdContains(
                        roleRepo.findByRoleName("HeadOfAcademic"), majorCourses
                ));
                break;
            case "Department":
                if (specialDepartment.contains(f.getDepartmentByDepartmentId().getName())) {
                    conductors.addAll(userRepo.findAll());
                    for (User conductor : conductors) {
                        if (conductor.getDepartmentByDepartmentId().getName().equals("IT"))
                            conductors.remove(conductor);
                    }
                } else conductors.addAll(userRepo.findByRoleByRoleId_RoleName("Student"));
                viewers = userFilteringRepo.findByRoleByRoleId_RoleNameAndMajorByMajorId("HeadOfAcademic", f.getMajorByMajorId());
                break;
            default:
                break;
        }
        for (User u : conductors) {
            userFeedbackRepo.save(new UserFeedback(u.getId(), f.getId(), true, false, false));
        }
        UserFeedback uf;
        for (User u : viewers) {
            uf = userFeedbackRepo.findOne(new UserFeedbackPK(u.getId(), f.getId()));
            if (uf != null) {
                uf.setViewer(true);
            } else userFeedbackRepo.save(new UserFeedback(u.getId(), f.getId(), false, true, false));
        }
    }

    Feedback findTarget(int id, List<Integer> targetIds) {
        Feedback tmp; Type t;

        for (int i : targetIds) {
            tmp = feedbackRepo.findOne(i);
            t = tmp.getTypeByTypeId();
            switch (t.getDescription()) {
                case "Chuyên ngành":
                    break;
                case "Phòng ban":
                    break;
                case "Môn học":
                    break;
                case "Lớp":
                    if (tmp.getClazzByClazzId().getId() == id) {
                        return tmp;
                    }
                    break;
                default:
                    break ;
            }
        }

        return null;
    }

    @Override
<<<<<<< Updated upstream
    public FeedbackDetailsModel customizeConductors(FeedbackDetailsModel model, int[] conductorIds) {
        try {
            return null;
=======
    public ResponseEntity<UserFeedback> addConductor(int targetId, int userId, List<Integer> targetIds) {
        try {
            Feedback f = findTarget(targetId, targetIds);
            UserFeedback selected = userFeedbackRepo.findOne(new UserFeedbackPK(userId, f.getId()));
            if (selected != null) {
                selected.setConductor(true);
                return new ResponseEntity<>(userFeedbackRepo.save(selected), HttpStatus.OK);
            }
            User u = userRepo.findOne(userId);
//            Feedback f = feedbackRepo.findOne(targetId);
//            UserFeedback uf = userFeedbackRepo.save(new UserFeedback(u.getId(), f.getId(), true, false, false));
//            uf.setConductor(true);
//            return new ResponseEntity<>(userFeedbackRepo.save(uf), HttpStatus.OK);
            return new ResponseEntity<>(userFeedbackRepo.save(new UserFeedback(u.getId(), f.getId(), true, false, false)), HttpStatus.OK);
>>>>>>> Stashed changes
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return null;
        }
    }

    @Override
<<<<<<< Updated upstream
    public FeedbackDetailsModel customizeViewers(FeedbackDetailsModel model, int[] viewerIds) {
        return null;
=======
    public ResponseEntity removeConductor(int targetId, int userId, List<Integer> targetIds) {
        try {
            Feedback f = findTarget(targetId, targetIds);
            UserFeedback selected = userFeedbackRepo.findOne(new UserFeedbackPK(userId, f.getId()));
            if (selected.isViewer()) {
                selected.setConductor(false);
                return new ResponseEntity<>(userFeedbackRepo.save(selected), HttpStatus.OK);
            }
            userFeedbackRepo.delete(selected);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
>>>>>>> Stashed changes
    }

    @Override
    public ResponseEntity<ModifyFeedbackModel> setStart(Date start, Feedback feedback) {
        return null;
    }

    @Override
    public ResponseEntity<ModifyFeedbackModel> setEnd(Date end, Feedback feedback) {
        return null;
    }


    @Override
    public ResponseEntity<List<User>> loadConductors(int id, List<Integer> targetIds) {
        try {
            List<User> conductors = new ArrayList<>();
            Feedback tmp;
            Type t;
            for (int i : targetIds) {
                tmp = feedbackRepo.findOne(i);
                t = tmp.getTypeByTypeId();
                switch (t.getDescription()) {
                    case "Chuyên ngành":
                        break;
                    case "Phòng ban":
                        break;
                    case "Môn học":
                        break;
                    case "Lớp":
                        if (tmp.getClazzByClazzId().getId() == id) {
                            List<UserFeedback> ufs = (List) tmp.getUserFeedbacksById();
                            if (!(ufs.isEmpty() || ufs == null)) {
                                for (UserFeedback uf : ufs) {
                                    conductors.add(uf.getUserByUserId());
                                }
                            }
                        }
                        break;
                    default:
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }

            return new ResponseEntity<>(conductors, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<User>> loadViewers(int id) {
        List<User> viewers = new ArrayList<>();
        try {
            for (UserFeedback uf : feedbackRepo.findOne(id).getUserFeedbacksById()) {
                viewers.add(uf.getUserByUserId());
            }
            return new ResponseEntity<>(viewers, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<User>> loadTargets(int[] ids) {

//        try {
//            for (int i: ids) {
//
//            }
//            return new ResponseEntity<>(viewers, HttpStatus.OK);
//        } catch (UnexpectedRollbackException e) {
//            logger.log(Level.FINE, e.toString());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        return null;
    }

<<<<<<< Updated upstream
=======
    @Override
    public ResponseEntity<List<Clazz>> filterClazz(int majorKey, int courseKey, int semesterkey, int lecturerKey) {
        try {
            Major major = null;
            Semester semester = null;
            User lecturer = null;
            List<Course> courses = new ArrayList<>();
            if (courseKey == 0) {
                if (majorKey != 0) courses = (List<Course>) majorRepo.findOne(majorKey).getCoursesById();
            } else courses.add(courseRepo.findOne(courseKey));
            if (semesterkey != 0) semester = semesterRepo.findOne(semesterkey);
            if (lecturerKey != 0) lecturer = userRepo.findOne(lecturerKey);
            List<Clazz> clazzes = clazzRepo.findAll();
            for (Clazz c : clazzRepo.findAll()) {
                if (!courses.isEmpty()) {
                    if (!courses.contains(c.getCourseByCourseId())) clazzes.remove(c);
                }
                if (semester != null) {
                    if (c.getSemesterBySemesterId() != semester) clazzes.remove(c);
                }
                if (lecturer != null) {
                    if (c.getUserByLecturerId() != lecturer) clazzes.remove(c);
                }
            }
            return new ResponseEntity<>(clazzes, HttpStatus.OK);
//            List<Clazz> clazzes = clazzRepo.filteringver2(majorKey, courseKey, semesterKey, lecturerKey);
//            return new ResponseEntity<>(clazzes, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List filterSemester(String title) {
        return semesterRepo.findByTitleContains(title);
    }

    @Override
    public List<User> getAllStudents() {
        List<User> l = userRepo.findAll();
        List<User> result = userRepo.findAll();
        for(User u: l){
            if(!u.getRoleByRoleId().getRoleName().equals("Học sinh")) result.remove(u);
        }
        return result;
    }

    @Override
    public ResponseEntity<List<Department>> loadDepartmentTargets(List<Integer> ids) {
        try {
            List<Department> results = new ArrayList<>();
            Department d;
            for (int id : ids) {
                d = feedbackRepo.findOne(id).getDepartmentByDepartmentId();
                if (d != null) results.add(d);
            }
            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Major>> loadMajorTargets(List<Integer> ids) {
        try {
            List<Major> results = new ArrayList<>();
            Major m;
            for (int id : ids) {
                m = feedbackRepo.findOne(id).getMajorByMajorId();
                if (m != null) results.add(m);
            }
            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Course>> loadCourseTargets(List<Integer> ids) {
        try {
            List<Course> results = new ArrayList<>();
            Course c;
            for (int id : ids) {
                c = feedbackRepo.findOne(id).getCourseByCourseId();
                if (c != null) results.add(c);
            }
            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Clazz>> loadClazzTargets(List<Integer> ids) {
        try {
            List<Clazz> results = new ArrayList<>();
            Clazz c;
            for (int id : ids) {
                c = feedbackRepo.findOne(id).getClazzByClazzId();
                if (c != null) results.add(c);
            }
            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
>>>>>>> Stashed changes

}
