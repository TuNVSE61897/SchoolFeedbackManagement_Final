package com.sample.sfms.service.interf;

import com.sample.sfms.entity.*;

import java.util.List;

/**
 * Created by MyPC on 21/02/2018.
 */

public interface ClazzService {
    List<Clazz> filtering(String major, String course, String lecturer, String semester);
}
