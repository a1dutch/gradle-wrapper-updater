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
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import uk.co.a1dutch.gradle.updater.controller.AuthenticationInterceptor;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ThreadLocal<String> authorisation() {
        return new ThreadLocal<>();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor(authorisation()));
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

    private AuthenticationInterceptor authenticationInterceptor(ThreadLocal<String> authorisation) {
        return new AuthenticationInterceptor(authorisation);
    }
}
