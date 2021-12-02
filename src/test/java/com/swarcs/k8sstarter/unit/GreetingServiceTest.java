package com.swarcs.k8sstarter.unit;

import com.swarcs.k8sstarter.config.ApplicationTest;
import com.swarcs.k8sstarter.dto.GreetingMessage;
import com.swarcs.k8sstarter.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;

/**
 * The <code>GreetingServiceTest</code> class is a test container holding all the Junit tests related to
 * <code>GreetingService</code> class.
 *
 * @author Bosko Mijin.
 */
@Slf4j
@ApplicationTest
class GreetingServiceTest {

    /** The greeting service. */
    @Autowired
    private GreetingService greetingService;

    /**
     * The <code>should_Pass_ReturnGreeting</code> method is test related to GreetingService.getPreparedGreeting and
     * perform junit test for his base functionality.
     */
    @Test
    void should_Pass_ReturnGreeting() {
        CompletableFuture<GreetingMessage> message = greetingService.getPreparedGreeting("test");
        Assertions.assertEquals("Hi test!", message.join().getMessage());
    }

}
