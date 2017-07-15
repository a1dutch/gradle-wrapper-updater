package uk.co.a1dutch.gradle.updater.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private RepositoryService repositoriesService;

    @Before
    public void setup() throws Exception {
        repositoriesService = new RepositoryService(restTemplate);
    }

    @Test
    public void find_all() throws Exception {
        when(restTemplate.getForObject(Mockito.eq("https://api.github.com/user/repos"), Mockito.any()))
            .thenReturn(new Repository[0]);
        when(restTemplate.getForObject(Mockito.eq("https://api.github.com/user/orgs"), Mockito.any()))
            .thenReturn(new Organisation[] { Organisation.builder().id(1).name("test").build() });
        when(restTemplate.getForObject(Mockito.eq("https://api.github.com/orgs/test/repos"), Mockito.any()))
            .thenReturn(new Repository[0]);

        repositoriesService.findAllRepositories();

        verify(restTemplate).getForObject("https://api.github.com/user/repos", Repository[].class);
        verify(restTemplate).getForObject("https://api.github.com/user/orgs", Organisation[].class);
        verify(restTemplate).getForObject("https://api.github.com/orgs/test/repos", Repository[].class);
    }
}
