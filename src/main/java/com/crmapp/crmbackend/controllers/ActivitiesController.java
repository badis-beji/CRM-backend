package com.crmapp.crmbackend.controllers;

import com.crmapp.crmbackend.entities.Contact;
import com.crmapp.crmbackend.services.ActivitiesService;
import com.crmapp.crmbackend.entities.ActivitiesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class ActivitiesController {
    @Autowired
    ActivitiesService activitiesService;

    @GetMapping("/activities")
    public List<ActivitiesEntity> getActivities() {
        return activitiesService.getActivities();
    }
    @RequestMapping("/activities/{id}")
    public Optional<ActivitiesEntity> getActivity(@PathVariable Long id) {
        return activitiesService.getActivity(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/activities")
        public void addActivity(@RequestBody ActivitiesEntity activitiesEntity) {
        activitiesService.addActivity(activitiesEntity);}
    @RequestMapping(method = RequestMethod.PUT, value = "/activities/{id}")
        public void updateActivity(@PathVariable Long id,@RequestBody ActivitiesEntity activitiesEntity) {
        activitiesService.updateActivity(activitiesEntity, id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/activities/{id}")
        public void deleteActivity(@PathVariable Long id) {
        activitiesService.deleteActivity(id);
    }
    @GetMapping("/by-contact")
        public List<ActivitiesEntity> getActivitiesByContact(@RequestParam Long contactId) {
        Contact contact = new Contact();
        contact.setId(contactId);
        return activitiesService.getActivitiesByContact(contact);
    }
}
