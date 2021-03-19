/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */




package io.helins.linux ;


import static org.junit.jupiter.api.Assertions.* ;


import com.sun.jna.Memory                ;
import org.junit.jupiter.api.DisplayName ;
import org.junit.jupiter.api.Test        ;
import io.helins.linux.NativeMemory      ;




public class NativeMemoryTest {


    @Test
    @DisplayName( "Comparing memory for equality." )
    void equal() {
    
        Memory mem1 = new Memory( 64000 ) ;
        Memory mem2 = new Memory( 64000 ) ;

        mem1.setByte( 63999       ,
                      (byte)42    ) ;

        mem2.setByte( 63999       ,
                      (byte)43    ) ;

        assertFalse( NativeMemory.equal( mem1 ,
                                         mem2 )                       ,
                     "Two pointers are different by at least 1 byte." ) ;

        NativeMemory.copy( mem1 ,
                           mem2 ) ;

        assertTrue( NativeMemory.equal( mem1 ,
                                        mem2 )         ,
                    "Copied pointers should be equal." ) ;
    }




    @Test
    @DisplayName( "Copying memory." )
    void copy() {

        Memory mem1 = new Memory( 64000 ) ;
        Memory mem2 = new Memory( 64000 ) ;

        NativeMemory.copy( mem1 ,
                           mem2 ) ;

        assertTrue( NativeMemory.equal( mem1 ,
                                        mem2 )                            ,
                    "Copying is successful if copied pointer are equald." ) ;
    }




    @Test
    @DisplayName( "Filling memory." )
    void fill() {
    
        int b = 142 ;

        Memory mem = new Memory( 64000 ) ;

        NativeMemory.fill( mem ,
                           b   ) ;

        for ( int i = 0 ;
              i < 64000 ; 
              i += 1    ) {
              
            if ( NativeMemory.getUnsignedByte( mem ,
                                               i   ) != b ) {

                fail( "Unsigned byte value differs from what has been filled." ) ;            
            }
        }
    }




    @Test
    @DisplayName( "Setting and getting unsigned integers" )
    void unsignedIntegers() {
    
        Memory mem = new Memory( 4 ) ;

        int ubyte = Byte.MAX_VALUE + 1 ;

        NativeMemory.setUnsignedByte( mem   ,
                                      0     ,
                                      ubyte ) ;

        assertEquals( ubyte                                                 ,
                      NativeMemory.getUnsignedByte( mem ,
                                                    0   )                   ,
                      "Unsigned byte value differs from what has been set." ) ;

        int ushort = Short.MAX_VALUE + 1 ;

        NativeMemory.setUnsignedShort( mem    ,
                                       0      ,
                                       ushort ) ;

        assertEquals( ushort                                                 ,
                      NativeMemory.getUnsignedShort( mem ,
                                                     0   )                   ,
                      "Unsigned short value differs from what has been set." ) ;

        long uint = Integer.MAX_VALUE + 1L ;

        NativeMemory.setUnsignedInt( mem  ,
                                     0    ,
                                     uint ) ;

        assertEquals( uint                                                 ,
                      NativeMemory.getUnsignedInt( mem ,
                                                   0   )                   ,
                      "Unsigned int value differs from what has been set." ) ;
    }
}
