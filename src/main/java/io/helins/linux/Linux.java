/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */




package io.helins.linux ;


import com.sun.jna.Native ;




/**
 * Class containing static methods related to Linux.
 */
public class Linux {


    // Privatize constructor.
    //
    private Linux() {}




    /**
     * Get the value of <code>errno</code>, a global int often set by native functions when
     * a failure occurs.
     *
     * @return  The current value of errno.
     */
    public static int getErrno() {
    
        return Native.getLastError() ;
    }




    /**
     * Set the value of <code>errno</code>.
     *
     * @param value The new value of errno.
     *
     * @see getErrno
     */
    public static void setErrno( int value ) {

        Native.setLastError( value ) ;
    }
}
