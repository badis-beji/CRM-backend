package com.crmapp.crmbackend.services;

import com.crmapp.crmbackend.entities.Contact;
import com.crmapp.crmbackend.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;


    public List<Contact> getAllContacts(){
    return contactRepository.findAll();
}


    public void addContact( Contact contact) {
        contactRepository.save(contact);


    }
    public Contact getContactById(Long id) throws Exception{
        return contactRepository.findById(id)
                .orElseThrow(() -> new Exception("Contact not found with id " + id));
    }



    public void updateContact (Contact updatedcontact, Long id){
        Optional<Contact> presentcontact = contactRepository.findById(id);
        if (presentcontact.isPresent()){
            Contact contact = presentcontact.get();
            contact.setEmail(updatedcontact.getEmail());
            contact.setFirstName(updatedcontact.getFirstName());
            contact.setLastName(updatedcontact.getLastName());
            contact.setJobTitle(updatedcontact.getJobTitle());
            contact.setCompany(updatedcontact.getCompany());
            contact.setPhone(updatedcontact.getPhone());
            contact.setContactOwner(updatedcontact.getContactOwner());
            contactRepository.save(contact);

        }
    }



    public void deleteContact(Long id){
        contactRepository.deleteById(id);
    }

}
