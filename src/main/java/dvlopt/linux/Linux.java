package dvlopt.linux ;


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
     * @return the current value of errno.
     */
    public static int errno() {
    
        return Native.getLastError() ;
    }
}
