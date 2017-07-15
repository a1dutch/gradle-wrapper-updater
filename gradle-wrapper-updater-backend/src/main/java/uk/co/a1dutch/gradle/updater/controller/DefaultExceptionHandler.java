package uk.co.a1dutch.gradle.updater.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Map<String, Object> handleUncaught(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticationRequiredException.class)
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> handleValidation(AuthenticationRequiredException e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        return map;
    }

}
