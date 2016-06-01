package jp.co.opst.util.list;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListUtilTest {

    @Test
    public void testHasOnlyOneElement() {

        List<String> arrayList1 = null;
        // List = null;
        assertFalse(ListUtil.hasOnlyOneElement(arrayList1));

        // List size = 0
        arrayList1 = new ArrayList<>();
        assertFalse(ListUtil.hasOnlyOneElement(arrayList1));

        arrayList1.add("abc");
        // List size = 1
        assertTrue(ListUtil.hasOnlyOneElement(arrayList1));

        arrayList1.add("abc");
        // List size = 2
        assertFalse(ListUtil.hasOnlyOneElement(arrayList1));

    }

    @Test
    public void testIsEmptyOrNull() {
        List<String> testList = null;
        assertTrue(ListUtil.isEmptyOrNull(testList));

        testList = new ArrayList<>();
        assertTrue(ListUtil.isEmptyOrNull(testList));

        testList .add("test");
        assertFalse(ListUtil.isEmptyOrNull(testList));
    }

    @Test
    public void testHasOnlyNull() {

        List<String> testList = null;
        assertTrue(ListUtil.hasOnlyNull(testList));

        testList = new ArrayList<>();
        assertTrue(ListUtil.hasOnlyNull(testList));

        testList.add(null);
        testList.add(null);
        testList.add(null);
        testList.add(null);
        assertTrue(ListUtil.hasOnlyNull(testList));

        testList .add("test");
        assertFalse(ListUtil.hasOnlyNull(testList));
    }

    @Test
    public void testMaxInt() {
        List<Integer> intList = null;

        // nullの場合の戻り値は0
        assertEquals(0, ListUtil.maxInt(intList));

        intList = new ArrayList<>();
        // 空の場合の戻り値は0
        assertEquals(0, ListUtil.maxInt(intList));

        // リストの中身が全てnullの場合の戻り値は0
        intList.add(null);
        intList.add(null);
        intList.add(null);
        assertEquals(0, ListUtil.maxInt(intList));

        // 中身をすべて削除
        intList.clear();

        // リストに整数を追加
        intList.add(30);
        assertEquals(30, ListUtil.maxInt(intList));

        intList.add(20);
        intList.add(50);
        intList.add(40);
        assertEquals(50, ListUtil.maxInt(intList));

        // 中身をすべて削除
        intList.clear();
    }

}
