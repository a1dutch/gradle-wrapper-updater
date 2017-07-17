package uk.co.a1dutch.gradle.updater.configuration;

import java.io.IOException;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ThreadLocal<String> authorisation() {
        return new ThreadLocal<>();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Arrays.asList(authorisationRequestInterceptor()));
        return restTemplate;
    }

    private ClientHttpRequestInterceptor authorisationRequestInterceptor() {
        return new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
                HttpHeaders headers = request.getHeaders();
                headers.add("Authorization", authorisation().get());
                return execution.execute(request, body);
            }
        };
    }

}
