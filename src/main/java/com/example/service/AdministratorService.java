package com.example.service;

import com.example.repository.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministrationRepository administrationRepository;
}
