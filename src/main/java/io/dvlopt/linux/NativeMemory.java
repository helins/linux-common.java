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



    private static native int memcmp( Pointer ptr1 ,
                                      Pointer ptr2 ,
                                      SizeT   n    ) ;


    private static native void memcpy( Pointer ptrOrigin ,
                                       Pointer ptrTarget ,
                                       SizeT   n         ) ;


    private static native void memset( Pointer ptr ,
                                       int     b   ,
                                       SizeT   n   ) ;




    public static void copy( Pointer ptrOrigin ,
                             Pointer ptrTarget ,
                             SizeT   n         ) {
    
        memcpy( ptrOrigin ,
                ptrTarget ,
                n         ) ;
    }




    public static void copy( Memory  ptrOrigin ,
                             Pointer ptrTarget ) {
    
        memcpy( ptrOrigin                     ,
                ptrTarget                     ,
                new SizeT( ptrOrigin.size() ) ) ;
    }




    public static boolean equal( Pointer ptr1 ,
                                 Pointer ptr2 ,
                                 SizeT   n    ) {
    
        return memcmp( ptr1 ,
                       ptr2 ,
                       n    ) == 0 ;
    }




    public static boolean equal( Memory  ptr1 ,
                                 Pointer ptr2 ) {
    
        return equal( ptr1                     ,
                      ptr2                     ,
                      new SizeT( ptr1.size() ) ) ;
    }



    public static boolean equal( Pointer ptr1 ,
                                 Memory  ptr2 ) {
    
        return equal( ptr1                     ,
                      ptr2                     ,
                      new SizeT( ptr2.size() ) ) ;
    }




    public static boolean equal( Memory ptr1 ,
                                 Memory ptr2 ) {
    
        return equal( ptr1          ,
                      (Pointer)ptr2 ) ;
    }




    public static void fill( Pointer ptr ,
                             int     b   ,
                             SizeT   n   ) {
    
        memset( ptr ,
                b   ,
                n   ) ;
    }




    public static void fill( Memory ptr ,
                             int    b   ) {
    
        fill( ptr                     ,
              b                       ,
              new SizeT( ptr.size() ) ) ;
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
               & 0xffffffffL          ; 
    }




    public static void setUnsignedInt( Pointer ptr    ,
                                       long    offset ,
                                       long    i      ) {
    
        ptr.setInt( offset ,
                    (int)i ) ;
    }
}
