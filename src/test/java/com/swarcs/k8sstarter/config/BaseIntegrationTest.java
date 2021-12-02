package com.swarcs.k8sstarter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.web.servlet.MockMvc;

/**
 * The <code>BaseIntegrationTest</code> class is an abstract base integration test which holds all the configuration
 * required for integration tests.
 *
 * @author Bosko Mijin
 */
@ApplicationTest
@EnableAsync
@AutoConfigureMockMvc
public abstract class BaseIntegrationTest {

    /** The mapper. */
    @Autowired
    protected ObjectMapper mapper;

    /** The mock mvc. */
    @Autowired
    protected MockMvc mockMvc;

}