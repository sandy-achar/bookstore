package com.challengers.util;

import java.util.UUID;

/**
 * Created by Malika(mxp134930) on 11/6/2015.
 */
public class UniqueIdGenerator {

    public static long generateId(){
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }
}
