package uk.co.a1dutch.gradle.updater.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.a1dutch.gradle.updater.service.RepositoryDto;
import uk.co.a1dutch.gradle.updater.service.RepositoryService;

@RestController
public class RepositoriesController {

    @Autowired
    private RepositoryService repositoriesService;

    @GetMapping(name = "/api/repositories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RepositoryDto>> repositories() {
        return ResponseEntity.ok(repositoriesService.findAllRepositories());
    }

}
