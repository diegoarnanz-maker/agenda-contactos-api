package com.agenda.agendalistapi.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.agendalistapi.entity.Contact;
import com.agenda.agendalistapi.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public List<Contact> findAllList() {
        return contactRepository.findAll();
    }

    public Contact findByIdContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact createNewContact(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now()); // Set the current date and time when the contact is created
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id,Contact form) {

        //Consulta a la base datos para obtener el contacto a actualizar
        Contact contactFromDb = contactRepository.findById(id).orElse(null);
        if (contactFromDb != null) {
            contactFromDb.setName(form.getName());
            contactFromDb.setEmail(form.getEmail());
            return contactRepository.save(contactFromDb);
        }
        return null;
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}
