package com.sample.sfms.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MyPC on 22/02/2018.
 */
public class MajorCoursePK implements Serializable {
    private int majorId;
    private int courseId;

    @Column(name = "major_id", nullable = false, insertable = false, updatable = false)
    @Id
    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    @Column(name = "course_id", nullable = false, insertable = false, updatable = false)
    @Id
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MajorCoursePK that = (MajorCoursePK) o;

        if (majorId != that.majorId) return false;
        if (courseId != that.courseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = majorId;
        result = 31 * result + courseId;
        return result;
    }
}
