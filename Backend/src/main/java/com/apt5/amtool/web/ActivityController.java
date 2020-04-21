package com.apt5.amtool.web;


import com.apt5.amtool.domain.Activity;
import com.apt5.amtool.services.ActivityService;
import com.apt5.amtool.services.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/activity")
@CrossOrigin
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable String id){
        Activity activity = activityService.findActivityByIdentifier(id);
        return new ResponseEntity<Object>(activity, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Activity> getAllActivities(){
        return activityService.findAllActivities();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable String id){
        activityService.deleteActivityById(id.toUpperCase());

        return new ResponseEntity<String>("Project with id " + id + " successfully deleted", HttpStatus.OK);
    }

}
