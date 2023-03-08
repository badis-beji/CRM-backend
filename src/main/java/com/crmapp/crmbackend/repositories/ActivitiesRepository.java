package com.crmapp.crmbackend.repositories;

import com.crmapp.crmbackend.entities.ActivitiesEntity;
import com.crmapp.crmbackend.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitiesRepository extends CrudRepository<ActivitiesEntity,Long> {
    List<ActivitiesEntity> findByParticipantsContaining(Contact contact);
}
