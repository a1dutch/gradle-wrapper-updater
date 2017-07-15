package uk.co.a1dutch.gradle.updater.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.a1dutch.gradle.updater.service.Repository;
import uk.co.a1dutch.gradle.updater.service.RepositoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(RepositoriesController.class)
public class RepositoriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RepositoryService repositoriesService;

    @Test
    public void list_repositories() throws Exception {
        when(repositoriesService.findAllRepositories())
            .thenReturn(Arrays.asList(Repository.builder().id(1).name("test").build(),
                Repository.builder().id(2).name("tester").build()));

        mockMvc.perform(get("/api/repositories")
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).header("Authorization", "token"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("[0].id", is(1)))
            .andExpect(jsonPath("[0].name", is("test")))
            .andExpect(jsonPath("[1].id", is(2)))
            .andExpect(jsonPath("[1].name", is("tester")));
    }
}
