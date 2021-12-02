package com.swarcs.k8sstarter.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * The <code>GreetingMessage</code> class is the data transfer object holding the values for the message.
 *
 * @author Bosko Mijin.
 */
@Getter
@Builder
public class GreetingMessage {

    /** The message. */
    private String message;
}
