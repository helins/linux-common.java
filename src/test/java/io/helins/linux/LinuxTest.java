/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */




package io.helins.linux ;


import static org.junit.jupiter.api.Assertions.* ;


import org.junit.jupiter.api.DisplayName ;
import org.junit.jupiter.api.Test        ;
import io.helins.linux.Linux             ;




public class LinuxTest {


    @Test
    @DisplayName( "Setting and getting errno." )
    void errno() {
    
        for ( int value : new int[] { 0, 42, Integer.MAX_VALUE, Integer.MIN_VALUE } ) {

            Linux.setErrno( value ) ;

            assertEquals( Linux.getErrno()                 ,
                          value                            ,
                          "Errno should be set correctly." ) ;
        }
    }
}
