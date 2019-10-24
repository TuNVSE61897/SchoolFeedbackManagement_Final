package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Major;
import com.sample.sfms.repository.MajorRepository;
import com.sample.sfms.service.interf.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorRepository majorRepository;

    @Override
    public List<Major> getAllMajor() {
        return majorRepository.findAll();
    }
}
