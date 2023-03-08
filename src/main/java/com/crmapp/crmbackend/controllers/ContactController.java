package com.crmapp.crmbackend.controllers;

import com.crmapp.crmbackend.entities.Contact;
import com.crmapp.crmbackend.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contact")
public class ContactController {
     @Autowired
     private ContactService contactService;


    @GetMapping()
    public List<Contact> getContacts(){
       return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) throws Exception{
        return contactService.getContactById(id);
    }
    @PostMapping()
    public void addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
    }
    @PutMapping("/{id}")
    public void updateContact(@PathVariable Long id, @RequestBody Contact contact){
         contactService.updateContact(contact,id);
    }
    @DeleteMapping("/{id}")
    public  void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }

}
