package com.agenda.agendalistapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.agenda.agendalistapi.entity.Contact;
import com.agenda.agendalistapi.services.ContactService;

@CrossOrigin
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> list() {
        return contactService.findAllList();
    }

    @GetMapping("{id}")
    public Contact get( @PathVariable Long id) {
        return contactService.findByIdContact(id);
    }

    @ResponseStatus(HttpStatus.CREATED) // Return 201 status code
    @PostMapping()
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createNewContact(contact);
    }

    @PutMapping("{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact form) {
        return contactService.updateContact(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // Return 204 status code (no content)
    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

}
