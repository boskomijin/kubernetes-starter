package com.swarcs.k8sstarter.integration;

import com.swarcs.k8sstarter.config.BaseIntegrationTest;
import com.swarcs.k8sstarter.dto.GreetingMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The <code>GreetingApiIntegrationTest</code> class is a test case where are performed integration tests related to the
 * "greetings" endpoint.
 *
 * @author Bosko Mijin
 */
@SpringBootTest
class GreetingApiIntegrationTest extends BaseIntegrationTest {

    /** The "greetings" endpoint constant. */
    private static final String GREETINGS_ENDPOINT = "/greetings";

    /**
     * The <code>should_Pass_ReturnGreeting_When_NameIsProvided</code> method tests the "greetings" endpoint.
     *
     * @throws Exception - The exception which may occur in mocking mvc result.
     */
    @Test
    void should_Pass_ReturnGreeting_When_NameIsProvided() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(GREETINGS_ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .param("name", "test"))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        GreetingMessage greetingMessage = (GreetingMessage) mvcResult.getAsyncResult();
        Assertions.assertEquals("Hi test!", greetingMessage.getMessage());
    }

    /**
     * The <code>should_Pass_ReturnDefaultGreeting_When_NameIsNotProvided</code> method tests the "greetings" endpoint.
     *
     * @throws Exception - The exception which may occur in mocking mvc result.
     */
    @Test
    void should_Pass_ReturnDefaultGreeting_When_NameIsNotProvided() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.get(GREETINGS_ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        GreetingMessage greetingMessage = (GreetingMessage) mvcResult.getAsyncResult();
        Assertions.assertEquals("Hi Jack!", greetingMessage.getMessage());
    }
}
