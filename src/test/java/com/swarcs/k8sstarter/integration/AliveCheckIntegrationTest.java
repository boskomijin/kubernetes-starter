package com.swarcs.k8sstarter.integration;

import com.swarcs.k8sstarter.config.BaseIntegrationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The <code>AliveCheckIntegrationTest</code> class is a test case where are performed integration checks related to the
 * alive endpoint.
 *
 * @author Bosko Mijin
 */
@Slf4j
class AliveCheckIntegrationTest extends BaseIntegrationTest {

    /** The service alive endpoint constant. */
    private static final String SERVICE_ALIVE_ENDPOINT = "/alive";

    /**
     * The <code>should_Pass_ReturnServiceAlive_When_ServiceIsUp</code> method tests the alive endpoint.
     *
     * @throws Exception - The exception which may occur in mocking mvc result.
     */
    @Test
    void should_Pass_ReturnServiceAlive_When_ServiceIsUp() throws Exception {
        log.info("--> should_Pass_ReturnServiceAlive_When_ServiceIsUp");
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.head(SERVICE_ALIVE_ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        Assertions.assertTrue(json.isBlank());
        log.info(String.format("Status is: %s", mvcResult.getResponse().getStatus()));
        log.info(String.format("Response body is%s empty", mvcResult.getResponse().getContentAsString().isBlank() ? "" : " not"));
        log.info("<-- should_Pass_ReturnServiceAlive_When_ServiceIsUp");
    }
}
