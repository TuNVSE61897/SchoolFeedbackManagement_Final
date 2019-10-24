package com.sample.sfms.service.interf;

import com.sample.sfms.entity.Clazz;

import java.util.List;

/**
 * Created by MyPC on 21/02/2018.
 */

public interface ReportService {
    List<Object> loadListReport (String type);
}
