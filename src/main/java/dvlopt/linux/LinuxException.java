package dvlopt.linux ;


import com.sun.jna.Native;




public class LinuxException extends Exception {


    private int errno ;




    public LinuxException() {
    
        super() ;

        this.errno = Native.getLastError() ;
    }


    public LinuxException( String message ) {
    
        super( message ) ;

        this.errno = Native.getLastError() ;
    }




    public int getErrno() {

        return this.errno ;
    }
}
