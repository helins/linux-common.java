package dvlopt.linux ;


import com.sun.jna.Native ;




public class Linux {


    public static int errno() {
    
        return Native.getLastError() ;
    }
}
