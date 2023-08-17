package ru.alexanderbary.ems.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexanderbary.ems.model.Community;
import ru.alexanderbary.ems.repository.CommunityRepository;
import ru.alexanderbary.ems.util.CommunityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CommunityService {
    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    public List<Community> findAll() {
        return communityRepository.findAll();
    }

    public Community findOne(Long id) {
        Optional<Community> foundCommunity = communityRepository.findById(id);
        return foundCommunity.orElseThrow(CommunityNotFoundException::new);
    }

    @Transactional
    public void save(Community community) {
        communityRepository.save(community);
    }

    @Transactional
    public void update(Long id, Community community) {
        community.setId(id);
        communityRepository.save(community);
    }

    @Transactional
    public void delete(Long id) {
        communityRepository.deleteById(id);
    }

}
