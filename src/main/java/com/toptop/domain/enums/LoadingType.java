package com.toptop.domain.enums;

public enum LoadingType {

    /**
     * Loading, unloading with crane.
     */
    CRANE,

    /**
     * Loading, unloading by a forklift on the sides of the trailer.
     */
    LATERAL_LOADING,

    /**
     * Loading, unloading by a loader from behind.
     */
    BACK_LOADING,

    /**
     * Loading, unloading of bulk cargoes without packing.
     */
    IN_BULK,

    /**
     * Loading, unloading of goods without the use of machines.
     */
    MANUAL
}
