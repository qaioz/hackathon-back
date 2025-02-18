package com.kiu.hackaton.hackathon_back.service;

import com.kiu.hackaton.hackathon_back.model.TestEntity;
import com.kiu.hackaton.hackathon_back.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestEntityService {

    @Autowired
    private TestEntityRepository testEntityRepository;

    public TestEntity createTestEntity(TestEntity testEntity) {
        return testEntityRepository.save(testEntity);
    }

    public List<TestEntity> getAllTestEntities() {
        return testEntityRepository.findAll();
    }

    public Optional<TestEntity> getTestEntityById(Long id) {
        return testEntityRepository.findById(id);
    }
}
