package com.apt5.amtool.exceptions;

public class ActivityIdExceptionResponse {

    private String activityIdentifier;

    public ActivityIdExceptionResponse(String activityIdentifier){
        this.activityIdentifier = activityIdentifier;
    }

    public String getActivityIdentifier() {
        return activityIdentifier;
    }

    public void setActivityIdentifier(String activityIdentifier) {
        this.activityIdentifier = activityIdentifier;
    }
}
