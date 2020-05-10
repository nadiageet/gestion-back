package com.gestion.gestion.repository;

import com.gestion.gestion.entity.Us;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsRepository extends JpaRepository< Us, Long > {
}
