package com.swarcs.k8sstarter.service;

import com.swarcs.k8sstarter.dto.GreetingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * The <code>GreetingServiceImpl</code> class implements all the defined actions for obtaining greeting message.
 *
 * @author Bosko Mijin.
 */
@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService {

    /** The greeting message. */
    @Value("${greeting:Hi}")
    private String preparedGreeting;

    /**
     * The <code>getPreparedGreeting</code> method implements the greeting obtaining process by wrapping the greeting
     * message and name into the completable future.
     *
     * @return CompletableFuture - The greeting message prepared for further actions.
     */
    @Async
    @Override
    public CompletableFuture<GreetingMessage> getPreparedGreeting(String name) {
        return CompletableFuture.completedFuture(
                GreetingMessage.builder()
                        .message(String.format("%s %s!", preparedGreeting, name))
                        .build());
    }
}
