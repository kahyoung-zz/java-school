package com.example.example.TestExample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Basic Test class
 *
 * JUnit4 (Java 5+ support)
 *
 * Generated via IntelliJ
 */
public class TestUtilTest {
    private TestUtil testUtil = new TestUtil();

    @Test
    public void sum() throws Exception {
        // If any values are null, method should return null
        assertNull(testUtil.sum(1, null));
        assertNull(testUtil.sum(null, 2));
        assertNull(testUtil.sum(null, null));

        // Values should just sum, as normal
        assertEquals(testUtil.sum(1, 2), Double.valueOf(3.0));
        assertEquals(testUtil.sum(4, 2), Double.valueOf(6.0));

        // Make sure the inverse is true
        assertNotEquals(testUtil.sum(4, 4), 6.0);
    }

    @Test
    public void multiply() throws Exception {
        // If any values are null, method should return null
        assertNull(testUtil.multiply(1, null));
        assertNull(testUtil.multiply(null, 2));
        assertNull(testUtil.multiply(null, null));

        // Values should just multiply, as normal
        assertEquals(testUtil.multiply(1, 2), Double.valueOf(2.0));
        assertEquals(testUtil.multiply(4, 2), Double.valueOf(8.0));

        // Make sure the inverse is true
        assertNotEquals(testUtil.sum(4, 4), 6.0);
    }

}