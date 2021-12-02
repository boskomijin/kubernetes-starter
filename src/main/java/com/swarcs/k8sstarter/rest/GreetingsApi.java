package com.swarcs.k8sstarter.rest;

import com.swarcs.k8sstarter.dto.GreetingMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.concurrent.CompletableFuture;

/**
 * The <code>GreetingsApi</code> interface defines all the functionalities related to the exposed api, such as open api
 * definitions, mappings, statuses as well as method definition which has to be implemented in the related controller.
 *
 * @author Bosko Mijin
 */
@Tag(
        name = "Greetings API",
        description = "This API is used for obtaining greeting messages."
)
public interface GreetingsApi {

    /**
     * The <code>greetingResponder</code> definitions for the exposed endpoint which returns the greeting according to
     * the provided value.
     *
     * @param name - The name of the user which has to be greeted.
     * @return CompletableFuture - The prepared message which wrapped into the completable future which has to be consumed.
     */
    @Operation(summary = "Get Greeting")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Data"),
        @ApiResponse(responseCode = "400", description = "Bad request.", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @RequestMapping(
            value = "/greetings",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    CompletableFuture<GreetingMessage> getGreetings(
        @Parameter(description = "The name of the person which has to be greeted.")
        @RequestParam(value = "name", required = true, defaultValue = "Jack") String name);
}
