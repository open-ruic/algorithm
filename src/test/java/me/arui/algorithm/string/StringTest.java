package me.arui.algorithm.string;

import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {

    @Test
    public void testEquals() throws IOException {
        String value = "aa";
        String value1 = "aa";
        String value2 = new String("aa");
        String value3 = new String("aa");
        String value4 = "aa".intern();
        String value5 = value2.intern();
        assertTrue(value == value1);
        assertFalse(value == value2);
        assertFalse(value2 == value3);
        assertTrue(value2.equals(value4));
        assertTrue(value == value4);
        assertTrue(value == value5);
        System.in.read();
    }

}
