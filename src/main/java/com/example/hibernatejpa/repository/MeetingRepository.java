package com.example.hibernatejpa.repository;

import com.example.hibernatejpa.model.manytomany.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}
