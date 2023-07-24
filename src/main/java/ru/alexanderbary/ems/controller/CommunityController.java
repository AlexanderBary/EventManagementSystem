package ru.alexanderbary.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alexanderbary.ems.dao.CommunityDao;
import ru.alexanderbary.ems.model.Community;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/community/controller")
public class CommunityController {

    private final CommunityDao communityDao;

    @Autowired
    public CommunityController(CommunityDao communityRepository) {
        this.communityDao = communityRepository;
    }

    @GetMapping()
    public List<Community> getAll(Model model) {
        return this.communityDao.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Community> getById(@PathVariable Long id) {
        return communityDao.getById(id);
    }

    @PostMapping()
    public void create(@RequestBody Community community) {
        this.communityDao.save(community);
    }

    @DeleteMapping()
    public String delete() {
        return null;
    }
}
