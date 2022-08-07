package com.ks.fbs.repository;

import com.ks.fbs.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long> {

    Optional<Sector> findBySectorName(String sectorname);
    Optional<Sector> findById(int id);
}
