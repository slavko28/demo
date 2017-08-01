package com.toptop.domain.enums;

public enum OrderStatus {

    /**
     * All incoming orders from customers.
     */
    INCOMING,

    /**
     * Preliminary processing (transport searching... ).
     */
    PREPARING,

    /**
     * Ready to processing.
     */
    READY_TO_PROCESS,

    /**
     * Processing.
     */
    PROCESSING,

    /**
     * Order done.
     */
    DONE,

    /**
     * Order canceled by customer.
     */
    CANCELED,

    /**
     * Order done and account is paid.
     */
    CLOSED
}
