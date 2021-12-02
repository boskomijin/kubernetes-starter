package com.swarcs.k8sstarter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The <code>K8sStarterApplicationTest</code> class contains all the JUnit tests for the entry point of application.
 *
 * @author Bosko Mijin
 */
@SpringBootTest
class K8sStarterApplicationTest {

    /**
     * Testing if application loads with some array of arguments. This test ensures that the application is able to run
     * correctly.
     */
    @Test
    void applicationContextTest() {
        K8sStarterApplication.main("--server.port=10084");
    }

    /**
     * Testing if application loads context. This test ensures that the application is able to load context correctly.
     */
    @Test
    void contextLoads() {
        // There is no need to add any action, its just a context checker.
    }
}
