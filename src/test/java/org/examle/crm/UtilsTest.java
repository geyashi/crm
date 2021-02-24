package org.examle.crm;

import org.example.crm.utils.UUIDUtil;
import org.junit.Test;

/**
 * @author qww
 * @Date 2021-02-24 12:02
 */
public class UtilsTest {

    @Test
    public void testUUIDUtil() {
        String s = UUIDUtil.getUUID();
        System.out.println(s);
        System.out.println(s.length());
    }
}
