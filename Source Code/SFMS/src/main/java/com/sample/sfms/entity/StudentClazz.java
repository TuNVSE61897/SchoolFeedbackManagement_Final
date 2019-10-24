package com.sample.sfms.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.view.UserView;

import javax.persistence.*;

/**
 * Created by MyPC on 22/02/2018.
 */
@Entity
@Table(name = "student_clazz", schema = "capstone", catalog = "")
@IdClass(StudentClazzPK.class)
public class StudentClazz {
    @JsonView({UserView.listUserView.class})
    private int userId;
    @JsonView({UserView.listUserView.class})
    private int clazzId;
    private User userByUserId;
    @JsonView({UserView.listUserView.class})
    private Clazz clazzByClazzId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "clazz_id", nullable = false)
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

        StudentClazz that = (StudentClazz) o;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "clazz_id", referencedColumnName = "id", nullable = false)
    public Clazz getClazzByClazzId() {
        return clazzByClazzId;
    }

    public void setClazzByClazzId(Clazz clazzByClazzId) {
        this.clazzByClazzId = clazzByClazzId;
    }
}
