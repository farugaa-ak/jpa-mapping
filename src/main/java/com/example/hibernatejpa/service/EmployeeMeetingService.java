package com.example.hibernatejpa.service;

import com.example.hibernatejpa.repository.EmployeeRepository;
import com.example.hibernatejpa.repository.MeetingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional // require to avoid LazyInitializationException
@Service
public class EmployeeMeetingService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeMeetingService.class);

    private final MeetingRepository meetingRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeMeetingService(MeetingRepository meetingRepository, EmployeeRepository employeeRepository) {
        this.meetingRepository = meetingRepository;
        this.employeeRepository = employeeRepository;
    }

    public void logAllMeetings() {
        meetingRepository.findAll().forEach(meeting -> {
            log.info("meeting={}", meeting);
        });
    }

    public void logAllEmployees() {
        employeeRepository.findAll().forEach(employee -> {
            log.info("employee={}", employee);
        });
    }

}
