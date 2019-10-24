package com.sample.sfms.service.impl;

import com.sample.sfms.entity.*;
import com.sample.sfms.repository.*;
import com.sample.sfms.service.interf.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by MyPC on 21/02/2018.
 */
@Service("ClazzService")
public class ClazzServiceImpl implements ClazzService {
    static Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());

    @Autowired
    private ClazzRepository clazzRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private MajorCourseRepository majorCourseRepo;

    @Override
    public List<Clazz> filtering(String major, String course, String lecturer, String semester) {
        List<Clazz> result = new ArrayList<>();
        if (course.isEmpty()) {
            List<MajorCourse> majorCourses = majorCourseRepo.findByMajorByMajorId_NameContains(major);
            Course c;
            for (MajorCourse majorCourse : majorCourses) {
                c = courseRepo.findByMajorCoursesById(majorCourse);
                result.addAll(clazzRepo.filtering(
                        c.getName()+" - "+c.getCode()
                        , semester, lecturer));
            }
        }
        else {
            result = clazzRepo.filtering(course, semester, lecturer);
        }
        return result;
    }
}
