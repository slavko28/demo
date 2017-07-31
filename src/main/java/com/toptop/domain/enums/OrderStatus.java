package com.toptop.domain.enums;

public enum OrderStatus {

    /**
     * всі вхідні замовлення
     */
    INCOMING,

    /**
     * попереднє опрацювання (пошук транспорту)
     */
    PREPARING,

    /**
     * готові до виконання
     */
    READY_TO_PROCESS,

    /**
     *  в процесі виконання
     */
    PROCESSING,

    /**
     * виконані
     */
    DONE,

    /**
     * анульовані
     */
    CANCELED,

    /**
     * закриті
     */
    CLOSED
}
