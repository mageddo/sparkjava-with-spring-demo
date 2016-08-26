package com.mageddo.bank.api;

import org.springframework.stereotype.Service;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 8/26/16 11:06 AM
 */

@Service
public class HelloWorldService {


    public Object hello() {
        return "Hello World";
    }
}
