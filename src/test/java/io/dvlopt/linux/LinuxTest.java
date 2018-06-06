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


package io.dvlopt.linux.gpio ;


import static org.junit.jupiter.api.Assertions.* ;


import org.junit.jupiter.api.DisplayName ;
import org.junit.jupiter.api.Test        ;
import io.dvlopt.linux.Linux             ;




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
