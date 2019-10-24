package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Criteria;
import com.sample.sfms.entity.Type;
import com.sample.sfms.repository.CriteriaRepository;
import com.sample.sfms.repository.TypeRepository;
import com.sample.sfms.service.interf.CriteriaService;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by MyPC on 23/03/2018.
 */
@Service("CriteriaService")
public class CriteriaServiceImpl implements CriteriaService{

    static Logger logger = Logger.getLogger(CriteriaServiceImpl.class.getName());
    @Autowired
    private CriteriaRepository criteriaRepo;

    @Autowired
    TypeRepository typeRepo;

    @Override
    public ResponseEntity getOne(int id) {
        try {
            return new ResponseEntity<>(criteriaRepo.findOne(id),HttpStatus.OK);
        }catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(criteriaRepo.findAll(),HttpStatus.OK);
        }catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity create(Criteria c) {
        try {
            c.setTypeByTypeId(typeRepo.findOne(c.getTypeByTypeId().getId()));
            if(criteriaRepo.exists(org.springframework.data.domain.Example.of(c)))return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
            return new ResponseEntity<>(criteriaRepo.save(c),HttpStatus.OK);
        }catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity update(Criteria c) {
        try {
            Criteria criteria = criteriaRepo.findOne(c.getId());
            if(criteria==null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            c.setTypeByTypeId(typeRepo.findOne(c.getTypeByTypeId().getId()));
            return new ResponseEntity<>(criteriaRepo.save(c),HttpStatus.OK);
        }catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity active(int id) {
        try {
            Criteria c = criteriaRepo.findOne(id);
            if(c==null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            c.setStatus(false);
            return new ResponseEntity<>(criteriaRepo.save(c),HttpStatus.OK);
        }catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deactive(int id) {
        try {
            Criteria c = criteriaRepo.findOne(id);
            if(c==null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            c.setStatus(true);
            return new ResponseEntity<>(criteriaRepo.save(c),HttpStatus.OK);
        }catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity delete(int id) {
        try {
            criteriaRepo.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Type>> loadAllTypes() {
        try {
            return new ResponseEntity<>(typeRepo.findAll(), HttpStatus.OK);
        } catch (UnexpectedRollbackException e) {
            logger.log(Level.FINE, e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
