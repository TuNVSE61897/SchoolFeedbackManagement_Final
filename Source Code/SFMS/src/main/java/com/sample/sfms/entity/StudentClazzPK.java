package com.sample.sfms.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MyPC on 22/02/2018.
 */
public class StudentClazzPK implements Serializable {
    private int userId;
    private int clazzId;

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "clazz_id", nullable = false, insertable = false, updatable = false)
    @Id
    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentClazzPK that = (StudentClazzPK) o;

        if (userId != that.userId) return false;
        if (clazzId != that.clazzId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + clazzId;
        return result;
    }
}
