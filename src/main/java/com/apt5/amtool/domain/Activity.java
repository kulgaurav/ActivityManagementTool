package com.apt5.amtool.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Activity name is must!")
    private String activityName;

    @NotBlank(message = "Activity identifier is must!")
    @Size(min = 4, max = 5, message = "Please give 4 to 5 characters for Activity identifier.")
    @Column(updatable = false, unique = true) // This gets checked at DB layer, so can't really get caught in BindingResult errors.
    private String activityIdentifier;

    @NotBlank(message = "Activity description is must")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updatedAt;

    public Activity() {
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityIdentifier() {
        return activityIdentifier;
    }

    public void setActivityIdentifier(String activityIdentifier) {
        this.activityIdentifier = activityIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
