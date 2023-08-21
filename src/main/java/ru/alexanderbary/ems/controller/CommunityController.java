package ru.alexanderbary.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexanderbary.ems.model.Community;
import ru.alexanderbary.ems.service.CommunityService;
import ru.alexanderbary.ems.util.ErrorResponse;
import ru.alexanderbary.ems.util.CommunityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping()
    public List<Community> getCommunities() {
        return communityService.findAll();
    }

    @GetMapping("/{id}")
    public Community getCommunity(@PathVariable("id") Long id) {
        return this.communityService.findOne(id);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(CommunityNotFoundException e) {
        ErrorResponse response = new ErrorResponse(
                "Community with this id wasn't found.",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public void create(@RequestBody Community community) {
        this.communityService.save(community);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id,
                         @RequestBody Community community) {
        this.communityService.update(id, community);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.communityService.delete(id);
    }

}
