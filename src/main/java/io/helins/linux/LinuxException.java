/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */




package io.helins.linux ;


import com.sun.jna.Native;




/**
 * Exception associated with an errno value for when an error occurs on the native side.
 */
public class LinuxException extends Exception {


    private int errno ;




    /**
     * Constructor automatically fetching errno.
     */
    public LinuxException() {
    
        super( messagePrefix() ) ;

        this.errno = Native.getLastError() ;
    }




    /**
     * Constructor automatically fetching errno and associating it with a message.
     *
     * @param message  String describing what happened.
     */
    public LinuxException( String message ) {

        super( messagePrefix() + " : " + message ) ;

        this.errno = Native.getLastError() ;
    }




    // Makes a prefix stating the current value of errno for the exception message.
    //
    private static String messagePrefix() {

        return "Errno " + Native.getLastError() ;
    }




    /**
     * Retrieves the value of errno when the error occured.
     *
     * @return  The value of errno.
     */
    public int getErrno() {

        return this.errno ;
    }
}
