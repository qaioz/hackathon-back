package com.kiu.hackaton.hackathon_back.service;

import com.kiu.hackaton.hackathon_back.dto.request.HackathonRequest;
import com.kiu.hackaton.hackathon_back.dto.response.HackathonResponse;
import com.kiu.hackaton.hackathon_back.model.Hackathon;
import com.kiu.hackaton.hackathon_back.repository.HackathonRepository;


import org.springframework.stereotype.Service;

@Service
public class HackathonService {

    private final HackathonRepository hackathonRepository;

    public HackathonService(HackathonRepository hackathonRepository) {
        this.hackathonRepository = hackathonRepository;
    }

    public HackathonResponse createHackathon(HackathonRequest hackathonRequest) {
        Hackathon hackathon = new Hackathon();
        hackathon.setTopic(hackathonRequest.getTopic());
        hackathon.setDescription(hackathonRequest.getDescription());
        hackathon.setMinTeamSize(hackathonRequest.getMinTeamSize());
        hackathon.setMaxTeamSize(hackathonRequest.getMaxTeamSize());

        Hackathon savedHackathon = hackathonRepository.save(hackathon);

        HackathonResponse response = new HackathonResponse();
        response.setId(savedHackathon.getId());
        response.setTopic(savedHackathon.getTopic());
        response.setDescription(savedHackathon.getDescription());
        response.setMinTeamSize(savedHackathon.getMinTeamSize());
        response.setMaxTeamSize(savedHackathon.getMaxTeamSize());

        return response;
    }

    public HackathonResponse getHackathonDetails(Long hackathonId) {
        Hackathon hackathon = hackathonRepository.findById(hackathonId)
                .orElseThrow(() -> new RuntimeException("Hackathon not found"));

        HackathonResponse response = new HackathonResponse();
        response.setId(hackathon.getId());
        response.setTopic(hackathon.getTopic());
        response.setDescription(hackathon.getDescription());
        response.setMinTeamSize(hackathon.getMinTeamSize());
        response.setMaxTeamSize(hackathon.getMaxTeamSize());

        return response;
    }
}
