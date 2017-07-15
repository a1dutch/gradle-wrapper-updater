package uk.co.a1dutch.gradle.updater.controller;

@SuppressWarnings("serial")
public class AuthenticationRequiredException extends RuntimeException {
    public AuthenticationRequiredException() {
        super("Authentication required");
    }
}
