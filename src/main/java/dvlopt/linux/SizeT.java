package dvlopt.linux ;


import com.sun.jna.IntegerType ;
import com.sun.jna.Native      ;




public class SizeT extends IntegerType {


    public static final int SIZE = Native.SIZE_T_SIZE ;




    public SizeT() {
    
        this( 0 ) ;
    }


    public SizeT( long size ) {
    
        super( SIZE ,
               size ,
               true ) ;
    }
}
