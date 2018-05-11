package io.dvlopt.linux ;


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
    
        super() ;

        this.errno = Native.getLastError() ;
    }


    /**
     * Constructor automatically fetching errno and associating it with a message.
     *
     * @param message  String describing what happened.
     */
    public LinuxException( String message ) {
    
        super( message ) ;

        this.errno = Native.getLastError() ;
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
