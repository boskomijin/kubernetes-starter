package com.swarcs.k8sstarter.service;

import com.swarcs.k8sstarter.dto.GreetingMessage;

import java.util.concurrent.CompletableFuture;

/**
 * The <code>GreetingService</code> interface defines all required actions for obtaining greeting message.
 *
 * @author Bosko Mijin.
 */
public interface GreetingService {

    /**
     * The <code>getPreparedGreeting</code> method defines the greeting obtaining process.
     *
     * @return CompletableFuture - The greeting message prepared for further actions, wrapped into the completable future.
     */
    CompletableFuture<GreetingMessage> getPreparedGreeting(String name);
}
