package jp.co.opst.util.variable;

import static org.junit.Assert.*;

import org.junit.Test;

public class LengthUtilTest {



    @Test
    public void testIsNotEmptyString() {
        String nullStr = null;
        String emptyStr = "";
        String filledStr = "abc";

        assertFalse(LengthUtil.isNotEmpty(nullStr));
        assertFalse(LengthUtil.isNotEmpty(emptyStr));
        assertTrue(LengthUtil.isNotEmpty(filledStr));
    }

//    @Test
//    public void testIsNotEmptyInteger() {
//        Integer nullInt = null;
//        Integer zeroInt = 0;
//        Integer hundredInt = 100;
//
//        assertFalse(LengthUtil.isNotEmpty(nullInt));
//        assertTrue(LengthUtil.isNotEmpty(zeroInt));
//        assertTrue(LengthUtil.isNotEmpty(hundredInt));
//    }

    @Test
    public void testIsEmptyString() {
        String nullStr = null;
        String emptyStr = "";
        String filledStr = "abc";

        assertTrue(LengthUtil.isEmpty(nullStr));
        assertTrue(LengthUtil.isEmpty(emptyStr));
        assertFalse(LengthUtil.isEmpty(filledStr));
    }

//    @Test
//    public void testIsEmptyInteger() {
//        Integer nullInt = null;
//        Integer zeroInt = 0;
//        Integer hundredInt = 100;
//
//        assertTrue(LengthUtil.isEmpty(nullInt));
//        assertFalse(LengthUtil.isEmpty(zeroInt));
//        assertFalse(LengthUtil.isEmpty(hundredInt));
//    }

    @Test
    public void testIsLengthInside() {
        String str1 = "abcde";
        assertTrue(LengthUtil.isLengthInside(str1, 5, 5));
        assertTrue(LengthUtil.isLengthInside(str1, 4, 5));
        assertTrue(LengthUtil.isLengthInside(str1, 5, 6));
        assertTrue(LengthUtil.isLengthInside(str1, 4, 6));
        assertFalse(LengthUtil.isLengthInside(str1, 6, 7));
        assertFalse(LengthUtil.isLengthInside(str1, 3, 4));

        String str2 = "";
        assertTrue(LengthUtil.isLengthInside(str2, 0, 0));
        assertTrue(LengthUtil.isLengthInside(str2, 0, 1));
        assertFalse(LengthUtil.isLengthInside(str2, 1, 1));
        assertFalse(LengthUtil.isLengthInside(str2, 1, 3));
    }

}
