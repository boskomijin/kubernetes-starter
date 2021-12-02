package com.swarcs.k8sstarter.rest.impl;

import com.swarcs.k8sstarter.rest.AliveCheckApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The <code>AliveCheckController</code> class is a rest controller responsible only for responding on liveness probe.
 *
 * @author Bosko Mijin
 */
@RestController
public class AliveCheckController implements AliveCheckApi {

    /**
     * The <code>alive</code> method is just a responder to a liveness probe (instead of actuator, because of possible
     * cascading failures.
     */
    @Override
    public ResponseEntity<Void> alive() {
        return ResponseEntity.ok().build();
    }
}
