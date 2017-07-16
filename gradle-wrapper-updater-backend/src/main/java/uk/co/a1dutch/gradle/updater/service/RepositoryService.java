package uk.co.a1dutch.gradle.updater.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoryService {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryService.class);

    private RestTemplate restTemplate;

    @Autowired
    public RepositoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<RepositoryDto> findAllRepositories() {
        List<RepositoryDto> repositories = new ArrayList<>();

        logger.info("finding user repositories");
        addRepositories(repositories, null);

        logger.info("finding user organisations");
        Organisation[] organisations = restTemplate.getForObject(endpoint("user/orgs"), Organisation[].class);

        logger.info("finding user organisations repositories");
        for (Organisation organisation : organisations) {
            logger.info("finding organisations repositories for {}", organisation.getName());
            addRepositories(repositories, organisation.getName());
        }

        return repositories;
    }

    private void addRepositories(List<RepositoryDto> repositories, String organisation) {
        String endooint = endpoint(organisation == null ? "user/repos" : "orgs/" + organisation + "/repos");
        for (Repository repository : restTemplate.getForObject(endooint, Repository[].class)) {
            RepositoryDto repositoryDto = RepositoryDto.builder()
                .id(repository.getId())
                .organisation(organisation)
                .name(repository.getName())
                .build();
            repositories.add(repositoryDto);
        }
    }

    private String endpoint(String endpoint) {
        return "https://api.github.com/" + endpoint;
    }

}
