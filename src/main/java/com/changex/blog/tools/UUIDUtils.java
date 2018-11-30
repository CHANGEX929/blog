/**
 * 
 */
package com.changex.blog.tools;

import java.util.UUID;

/**
 * @author fengchu
 *
 */
public class UUIDUtils {
	public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
