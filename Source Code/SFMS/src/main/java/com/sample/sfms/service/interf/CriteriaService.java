package com.sample.sfms.service.interf;

import com.sample.sfms.entity.Criteria;
import org.springframework.http.ResponseEntity;

/**
 * Created by MyPC on 22/03/2018.
 */
public interface CriteriaService {
    ResponseEntity getOne(int id);

    ResponseEntity getAll();

    ResponseEntity create(Criteria c);

    ResponseEntity update(Criteria c);

    ResponseEntity active(int id);

    ResponseEntity deactive(int id);

    ResponseEntity delete(int id);

    public ResponseEntity loadAllTypes();
}
