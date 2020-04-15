package com.apt5.amtool.web;


import com.apt5.amtool.domain.Activity;
import com.apt5.amtool.services.ActivityService;
import com.apt5.amtool.services.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ValidationErrorService validationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewActivity(@Valid  @RequestBody Activity activity, BindingResult result){

        ResponseEntity<?> errorMap = validationErrorService.ValidationErrorServiceMethod(result);
        if (errorMap != null){
            return errorMap;
        }

        activityService.saveOrUpdateActivity(activity);
        return new ResponseEntity<Activity>(activity, HttpStatus.CREATED);
    }
}
