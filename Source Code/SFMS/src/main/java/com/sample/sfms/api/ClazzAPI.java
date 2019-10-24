package com.sample.sfms.api;

import com.sample.sfms.entity.Clazz;
import com.sample.sfms.service.interf.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MyPC on 22/02/2018.
 */
@RestController
@RequestMapping("/api/clazzes")
public class ClazzAPI {
    @Autowired
    ClazzService clazzService;

    @GetMapping
    private List<Clazz> getListClazz(@RequestParam("major") String major,
                                     @RequestParam("course") String course,
                                     @RequestParam("semester") String semester,
                                     @RequestParam("lecturer") String lecturer)
    {
        return clazzService.filtering(major, course, semester, lecturer);
    }
}
