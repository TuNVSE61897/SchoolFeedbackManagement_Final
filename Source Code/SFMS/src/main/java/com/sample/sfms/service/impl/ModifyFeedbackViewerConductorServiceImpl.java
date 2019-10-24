package com.sample.sfms.service.impl;

import com.sample.sfms.entity.*;
import com.sample.sfms.model.FeedbackDetailsModel;
import com.sample.sfms.repository.*;
import com.sample.sfms.service.interf.ModifyFeedbackViewConductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by MyPC on 23/02/2018.
 */
@Service("ModifyFeedbackViewConductService")
public class ModifyFeedbackViewerConductorServiceImpl implements ModifyFeedbackViewConductService {

    @Autowired
    private FeedbackRepository feedbackRepo;

    @Autowired
    private MajorRepository majorRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private ClazzRepository clazzRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private TypeRepository typeRepo;

    @Autowired
    private UserFilteringRepository userfilterRepo;

    @Autowired
    private StudentClazzRepository studentClazzRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public FeedbackDetailsModel addConductors(FeedbackDetailsModel model, int[] conductorIds) {
        int[] unexist = new int[0];
        int j = 0;
        try {
            List<User> conductors = model.getConductors();
            for (int i = 0; i < conductorIds.length ; i++){
                if(userRepo.findOne(conductorIds[i]) != null){
                    conductors.add(userRepo.findOne(conductorIds[i]));
                } else {
                    unexist[j] = conductorIds[i];
                    j++;
                }
            }
            model.setReportviewers(conductors);
        } catch (Exception e){
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public FeedbackDetailsModel addViewers(FeedbackDetailsModel model, int[] viewerIds) {
        try {
            List<User> viewers = model.getReportviewers();
            for (int i = 0; i < viewerIds.length ; i++){
                if(userRepo.findOne(viewerIds[i]) != null){
                    viewers.add(userRepo.findOne(viewerIds[i]));
                } else {
                    int unexist = viewerIds[i];
                }
            }
            model.setReportviewers(viewers);
        } catch (Exception e){
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public FeedbackDetailsModel removeConductors(FeedbackDetailsModel model, int[] conductorIds) {
        int[] unexist = new int[0];
        int j = 0;
        try {
            List<User> conductors = model.getConductors();
            for (int i = 0; i < conductorIds.length ; i++){
                if(userRepo.findOne(conductorIds[i]) != null){
                    conductors.remove(userRepo.findOne(conductorIds[i]));
                } else {
                    unexist[j] = conductorIds[i];
                    j++;
                }
            }
            model.setReportviewers(conductors);
        } catch (Exception e){
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public FeedbackDetailsModel removeViewers(FeedbackDetailsModel model, int[] viewerIds) {
        try {
            List<User> viewers = model.getReportviewers();
            for (int i = 0; i < viewerIds.length ; i++){
                if(userRepo.findOne(viewerIds[i]) != null){
                    viewers.add(userRepo.findOne(viewerIds[i]));
                } else {
                    int unexist = viewerIds[i];
                }
            }
            model.setReportviewers(viewers);
        } catch (Exception e){
            e.printStackTrace();
        }
        return model;
    }
}