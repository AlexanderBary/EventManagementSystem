package ru.alexanderbary.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alexanderbary.ems.repository.CommunityRepository;
import ru.alexanderbary.ems.model.Community;

import java.util.List;

@RestController
@RequestMapping("/community/controller")
public class CommunityController {

    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityController(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @GetMapping()
    public List<Community> getAll(Model model) {
        return this.communityRepository.getAll();
    }

    @GetMapping("/{id}")
    public Community getById(@PathVariable Long id) {
        return this.communityRepository.getById(id);
    }

    @PostMapping()
    public void create(@RequestBody Community community) {
        this.communityRepository.add(community);
    }



    @DeleteMapping()
    public String delete() {
        return null;
    }
}
