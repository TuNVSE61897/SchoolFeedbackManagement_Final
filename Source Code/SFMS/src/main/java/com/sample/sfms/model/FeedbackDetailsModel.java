package com.sample.sfms.model;

import com.sample.sfms.entity.*;

import java.util.List;

/**
 * Created by MyPC on 23/02/2018.
 */
public class FeedbackDetailsModel {
    private List<User> conductors;
    private List<User> reportviewers;
    private Major major;
    private Course course;
    private Clazz clazz;
    private Department department;
    private Type type;

    public FeedbackDetailsModel() {
    }

    public FeedbackDetailsModel(List<User> conductors, List<User> reportviewers, Major major, Course course, Clazz clazz, Department department, Type type) {
        this.conductors = conductors;
        this.reportviewers = reportviewers;
        this.major = major;
        this.course = course;
        this.clazz = clazz;
        this.department = department;
        this.type = type;
    }

    public List<User> getConductors() {
        return conductors;
    }

    public void setConductors(List<User> conductors) {
        this.conductors = conductors;
    }

    public List<User> getReportviewers() {
        return reportviewers;
    }

    public void setReportviewers(List<User> reportviewers) {
        this.reportviewers = reportviewers;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}