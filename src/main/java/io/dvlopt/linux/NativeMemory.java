/*
 * Copyright 2018 Adam Helinski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.dvlopt.linux ;


import com.sun.jna.Memory    ;
import com.sun.jna.Native    ;
import com.sun.jna.Pointer   ;
import io.dvlopt.linux.SizeT ;


public class NativeMemory {


    static {
    
        Native.register( "c" ) ;
    }



    private static native void memcpy( Pointer ptr1 ,
                                       Pointer ptr2 ,
                                       SizeT   n    ) ;


    private static native void memset( Pointer ptr ,
                                       int     b   ,
                                       SizeT   n   ) ;




    public static void copy( Pointer ptr1 ,
                             Pointer ptr2 ,
                             SizeT   n     ) {
    
        memcpy( ptr1 ,
                ptr2 ,
                n    ) ;
    }




    public static void copy( Memory  ptr1 ,
                             Pointer ptr2 ) {
    
        memcpy( ptr1                     ,
                ptr2                     ,
                new SizeT( ptr1.size() ) ) ;
    }




    public static void fill( Pointer ptr ,
                             int     b   ,
                             SizeT   n   ) {
    
        memset( ptr ,
                b   ,
                n   ) ;
    }



    public static int getUnsignedByte( Pointer ptr    ,
                                       long    offset ) {
    
        return   ptr.getByte( offset )
               & 0x000000ff            ;
    }




    public static void setUnsignedByte( Pointer ptr    ,
                                        long    offset ,
                                        int     b      ) {
    
        ptr.setByte( offset  ,
                     (byte)b ) ;
    }




    public static int getUnsignedShort( Pointer ptr    ,
                                        long    offset ) {
    
        return   ptr.getShort( offset )
               & 0x0000ffff             ;
    }




    public static void setUnsignedShort( Pointer ptr    ,
                                         long    offset ,
                                         int     s      ) {
    
        ptr.setShort( offset    ,
                      (short) s ) ;
    }




    public static long getUnsignedInt( Pointer ptr    ,
                                       long    offset ) {
    
        return   ptr.getInt( offset )
               & 0xffffffL            ; 
    }




    public static void setUnsignedInt( Pointer ptr    ,
                                       long    offset ,
                                       long    i      ) {
    
        ptr.setInt( offset ,
                    (int)i ) ;
    }
}
