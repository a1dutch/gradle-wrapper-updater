package uk.co.a1dutch.gradle.updater.service;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Repository> findAllRepositories() {
        List<Repository> repositories = new ArrayList<>();
        logger.info("finding user repositories");
        repositories
            .addAll(Arrays.asList(restTemplate.getForObject(endpoint("user/repos"), Repository[].class)));

        logger.info("finding user organisations");
        Organisation[] organisations = restTemplate.getForObject(endpoint("user/orgs"), Organisation[].class);

        logger.info("finding user organisations repositories");
        for (Organisation organisation : organisations) {
            String endpoint = endpoint("orgs/" + organisation.getName() + "/repos");

            logger.info("finding organisations repositories for {}", organisation.getName());

            repositories
                .addAll(Arrays.asList(restTemplate.getForObject(endpoint, Repository[].class)));
        }

        return repositories;
    }

    private String endpoint(String endpoint) {
        return "https://api.github.com/" + endpoint;
    }

}
