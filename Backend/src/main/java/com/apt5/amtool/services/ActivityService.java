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
            throw new ActivityIdException("Activity ID " +  activity.getActivityIdentifier().toUpperCase() + " already present.");
        }

    }

    public Activity findActivityByIdentifier(String identifier){
        Activity activity = activityRepository.findByActivityIdentifier(identifier.toUpperCase());

        if(activity == null){
            throw new ActivityIdException("Activity ID " +  identifier + " does not exist.");
        }

        return activity;
    }

    public Iterable<Activity> findAllActivities(){
        return activityRepository.findAll();
    }

    public void deleteActivityById(String id){
        Activity activity = activityRepository.findByActivityIdentifier(id);

        if(activity == null){
            throw new ActivityIdException(" No activity with id " + id);
        }

        activityRepository.delete(activity);
    }
}
