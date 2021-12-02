package com.swarcs.k8sstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The <code>K8sStarterApplication</code> class is Spring Boot main application class. Serves as both the runtime
 * application entry point and the central Java configuration class.
 *
 * @author Bosko Mijin
 */
@EnableAsync
@SpringBootApplication
public class K8sStarterApplication {

    /**
     * The <code>main</code> method - entry point of the application.
     *
     * @param args - The arguments which are provided to the appilcation.
     */
    public static void main(String... args) {
        SpringApplication.run(K8sStarterApplication.class, args);
    }
}
