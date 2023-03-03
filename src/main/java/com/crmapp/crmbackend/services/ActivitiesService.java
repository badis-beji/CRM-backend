package com.crmapp.crmbackend.services;

import com.crmapp.crmbackend.repositories.ActivitiesRepository;
import com.crmapp.crmbackend.entities.ActivitiesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesService {
    @Autowired
    private ActivitiesRepository activitiesRepository;

    public List<ActivitiesEntity> getActivities() {
        List<ActivitiesEntity> activitiesEntities = new ArrayList<>();
        activitiesRepository.findAll()
                .forEach(activitiesEntities::add);
        return activitiesEntities;

    }

    public void addActivity(ActivitiesEntity activitiesEntity) {

        activitiesRepository.save(activitiesEntity);
    }

    public Optional<ActivitiesEntity> getActivity(Long id) {
        return activitiesRepository.findById(id);
    }

public void updateActivity(ActivitiesEntity updatedActivity, Long id) {
    Optional<ActivitiesEntity> existingActivity = activitiesRepository.findById(id);

    if(existingActivity.isPresent()) {
        ActivitiesEntity activity = existingActivity.get();
        activity.setDate(updatedActivity.getDate());
        activity.setType(updatedActivity.getType());
        activity.setSubject(updatedActivity.getSubject());
        activity.setNote(updatedActivity.getNote());
        activity.setDocument(updatedActivity.getDocument());

        activitiesRepository.save(activity);
    }
}
    public void deleteActivity(Long id) {
        activitiesRepository.deleteById(id);
    }
}
