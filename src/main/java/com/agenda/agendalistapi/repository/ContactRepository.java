package com.agenda.agendalistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.agendalistapi.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
