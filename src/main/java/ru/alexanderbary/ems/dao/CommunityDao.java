package ru.alexanderbary.ems.dao;

import org.springframework.stereotype.Repository;
import ru.alexanderbary.ems.model.Community;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CommunityDao implements Dao<Community> {

    private List<Community> COMMUNITIES = Stream.of(
            new Community(1L, "communityName0"),
            new Community(2L, "communityName1"),
            new Community(3L, "communityName2")
            ).collect(Collectors.toList());

    @Override
    public List<Community> getAll() {
        return this.COMMUNITIES;
    }

    @Override
    public Optional<Community> getById(Long id) {
        return Optional.ofNullable(this.COMMUNITIES.get(id.intValue()));
    }

    @Override
    public void save(Community community) {
        this.COMMUNITIES.add(new Community(
                community.getId(),
                community.getName()
        ));
    }

    @Override
    public void delete(Community community) {
        this.COMMUNITIES.remove(community);
    }

    @Override
    public void update(Community community) {
    }

}
