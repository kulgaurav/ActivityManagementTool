package com.apt5.amtool.services;


import com.apt5.amtool.domain.Activity;
import com.apt5.amtool.exceptions.ActivityIdException;
import com.apt5.amtool.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository  activityRepository;

    public Activity saveOrUpdateActivity(Activity activity){
        try{
            activity.setActivityIdentifier(activity.getActivityIdentifier().toUpperCase());
            return activityRepository.save(activity);
        }
        catch (Exception e){
            throw new ActivityIdException("Activity ID " +  activity.getActivityIdentifier().toUpperCase());
        }

    }
}
