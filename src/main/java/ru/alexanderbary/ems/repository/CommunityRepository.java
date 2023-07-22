package ru.alexanderbary.ems.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexanderbary.ems.model.Community;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CommunityRepository {

    private List<Community> COMMUNITIES = Stream.of(
            new Community(1L, "communityName0"),
            new Community(2L, "communityName1"),
            new Community(3L, "communityName2")
            ).collect(Collectors.toList());

    public List<Community> getAll() {
        return this.COMMUNITIES;
    }

    public Community getById(Long id) {
        return this.COMMUNITIES.stream()
                .filter(community -> community.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void add(Community community) {
        this.COMMUNITIES.add(new Community(
                community.getId(),
                community.getName()
            )
        );
    }

    public void deleteById(Long id) {
        this.COMMUNITIES.removeIf(community -> community.getId().equals(id));
    }

/*    public Community update(Community community) {
        this.COMMUNITIES.stream()
                .filter(c -> c.equals(community))
                .findFirst().replace(community)
                .orElse(null);
    }*/



}
