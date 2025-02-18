package com.kiu.hackaton.hackathon_back.repository;

import com.kiu.hackaton.hackathon_back.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
}
