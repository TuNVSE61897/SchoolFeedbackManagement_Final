package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Optionn;
import com.sample.sfms.model.option.OptionCreateModel;
import com.sample.sfms.model.option.OptionUpdateModel;
import com.sample.sfms.repository.OptionnRepository;
import com.sample.sfms.service.interf.OptionnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("optionnService")
public class OptionnServiceImpl implements OptionnService {

    static Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());

    @Autowired
    private OptionnRepository optionnRepository;

    @Override
    public int add(OptionCreateModel model) throws Exception {

        try {
            Optionn option = new Optionn();
            option.setOptionnContent(model.getOptionContent());
            option.setPoint(model.getPoint());
            option.setQuestionByQuestionId(model.getQuestion());
            optionnRepository.save(option);
            return option.getId();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void update(OptionUpdateModel model) throws Exception {
        try {
            Optionn option = this.optionnRepository.findOne(model.getId());
            if (option != null) {
                option.setPoint(model.getPoint());
                option.setOptionnContent(model.getOptionContent());
                this.optionnRepository.save(option);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void remove(int id) throws Exception {
        try {
            Optionn option = this.optionnRepository.findOne(id);
            if (option != null) {
                this.optionnRepository.delete(id);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
