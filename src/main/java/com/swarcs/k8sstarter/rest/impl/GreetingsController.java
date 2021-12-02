package com.swarcs.k8sstarter.rest.impl;

import com.swarcs.k8sstarter.dto.GreetingMessage;
import com.swarcs.k8sstarter.rest.GreetingsApi;
import com.swarcs.k8sstarter.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * The <code>GreetingsController</code> class is a rest controller responsible only for handling communication for the
 * greetings.
 *
 * @author Bosko Mijin
 */
@RestController
@RequiredArgsConstructor
public class GreetingsController implements GreetingsApi {

    /** The greeting service. */
    private final GreetingService greetingService;

    /**
     * The <code>greetingResponder</code> method returns the greeting according to the provided value.
     *
     * @param name - The name of the user which has to be greeted.
     * @return CompletableFuture - The prepared message which wrapped into the completable future which has to be consumed.
     */
    @Override
    public CompletableFuture<GreetingMessage> getGreetings(String name) {
        return greetingService.getPreparedGreeting(name);
    }
}
