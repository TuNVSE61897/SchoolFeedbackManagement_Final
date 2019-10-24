package com.sample.sfms.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.sfms.entity.Criteria;
import com.sample.sfms.service.interf.CriteriaService;
import com.sample.sfms.view.CriteriaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by MyPC on 23/03/2018.
 */
@RestController
@RequestMapping("/api/criteria")
public class CriteriaAPI {
    @Autowired
    private CriteriaService criteriaService;

    @JsonView(CriteriaView.basicCriteriaView.class)
    @GetMapping("/list")
    public ResponseEntity getAll(){return criteriaService.getAll();}

    @JsonView(CriteriaView.basicCriteriaView.class)
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Criteria c){return criteriaService.create(c);}

    @JsonView(CriteriaView.basicCriteriaView.class)
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Criteria c){return criteriaService.update(c);}

    @JsonView(CriteriaView.basicCriteriaView.class)
    @PutMapping("/active")
    public ResponseEntity active(@RequestBody Criteria c){return criteriaService.active(c.getId());}

    @JsonView(CriteriaView.basicCriteriaView.class)
    @PutMapping("/deactive")
    public ResponseEntity deactive(@RequestBody Criteria c){return criteriaService.deactive(c.getId());}

    @JsonView(CriteriaView.basicCriteriaView.class)
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Criteria c){return criteriaService.delete(c.getId());}
}
