package com.kiu.hackaton.hackathon_back.controller;

import com.kiu.hackaton.hackathon_back.model.TestEntity;
import com.kiu.hackaton.hackathon_back.service.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class TestEntityController {

    @Autowired
    private TestEntityService testEntityService;

    @PostMapping
    public ResponseEntity<TestEntity> createTestEntity(@RequestBody TestEntity testEntity) {
        TestEntity createdTestEntity = testEntityService.createTestEntity(testEntity);
        return new ResponseEntity<>(createdTestEntity, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TestEntity>> getAllTestEntities() {
        List<TestEntity> testEntities = testEntityService.getAllTestEntities();
        return new ResponseEntity<>(testEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestEntity> getTestEntityById(@PathVariable Long id) {
        Optional<TestEntity> testEntity = testEntityService.getTestEntityById(id);
        return testEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
