package dvlopt.linux ;


import com.sun.jna.IntegerType ;
import com.sun.jna.Native      ;




public class SSizeT extends IntegerType {


    public static final int SIZE = Native.SIZE_T_SIZE ;




    public SSizeT() {
    
        this( 0 ) ;
    }


    public SSizeT( long size ) {
    
        super( SIZE  ,
               size  ,
               false ) ;
    }
}
