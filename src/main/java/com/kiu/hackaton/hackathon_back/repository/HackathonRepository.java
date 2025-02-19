package com.kiu.hackaton.hackathon_back.repository;

import com.kiu.hackaton.hackathon_back.model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonRepository extends JpaRepository<Hackathon, Long> {
}
