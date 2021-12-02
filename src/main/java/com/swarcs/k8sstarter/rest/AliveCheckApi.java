package com.swarcs.k8sstarter.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The <code>AliveCheckApi</code> interface defines the functionality related to a liveness probe.
 *
 * @author Bosko Mijin
 */
@Tag(
        name = "Aliveness API",
        description = "This API is used for checking if the service is alive."
)
public interface AliveCheckApi {

    /**
     * The <code>alive</code> method is just a responder to a liveness probe (instead of actuator, because of possible
     * cascading failures.
     */
    @Operation(summary = "Check is the service alive.")

    @ApiResponse(responseCode = "200")
    @RequestMapping(
            value = "/alive",
            method = {RequestMethod.HEAD, RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Void> alive();
}
