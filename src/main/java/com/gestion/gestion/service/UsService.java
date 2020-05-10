package com.gestion.gestion.service;

import com.gestion.gestion.entity.Us;
import com.gestion.gestion.repository.UsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsService {

    private UsRepository usRepository;

    public UsService(UsRepository usRepository) {
        this.usRepository = usRepository;
    }

    @Transactional
    public Us create(Us us) {
     return usRepository.save(us);
    }

    @Transactional
    public Page< Us> findAll(Pageable pageable) {
        return usRepository.findAll(pageable);
    }
}
