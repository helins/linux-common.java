package io.dvlopt.linux ;


import com.sun.jna.Native ;



/**
 * Class containing static methods related to Linux.
 */
public class Linux {


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
