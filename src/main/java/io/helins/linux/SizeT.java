/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */




package io.helins.linux ;


import com.sun.jna.IntegerType ;
import com.sun.jna.Native      ;




/**
 * Class representing the native <code>size_t</code> type which is architecture-specific.
 * <p>
 * It is an unsigned integer typically representing the length of something.
 */
public class SizeT extends IntegerType {


    /**
     * In bytes, the size of <code>size_t</code>.
     */
    public static final int SIZE = Native.SIZE_T_SIZE ;




    /**
     * Constructor defaulting to 0.
     */
    public SizeT() {
    
        this( 0 ) ;
    }




    /**
     * Constructor with a value.
     *
     * @param value  The original value, cannot be larger than <code>size_t</code>.
     */
    public SizeT( long value ) {
    
        super( SIZE  ,
               value ,
               true  ) ;
    }
}
