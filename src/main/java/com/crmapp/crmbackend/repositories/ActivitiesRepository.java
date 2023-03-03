package com.crmapp.crmbackend.repositories;

import com.crmapp.crmbackend.entities.ActivitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends CrudRepository<ActivitiesEntity,Long> {
}
