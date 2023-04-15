package com.GRH.service;

import com.GRH.dto.CandidatDto;
import com.GRH.mapper.CandidatMapper;
import com.GRH.model.Candidat;
import com.GRH.model.UserRole;
import com.GRH.repository.CandidatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidatService {
    private final CandidatRepo candidatRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public Candidat createCandidat(Candidat candidat){
        String newPassword = bCryptPasswordEncoder.encode("12345678");
        candidat.setRole(UserRole.CANDIDAT);
        candidat.setPassword(newPassword);
        candidat.setUsername(candidat.getEmail());
        Candidat candidatAdded = candidatRepo.save(candidat);
        return candidatAdded;
    }
}
