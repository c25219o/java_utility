package jp.co.opst.util.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public final class ArrayUtil {

    /**
     *  int型の配列から、要素が0であるものを除いた配列を返します。<br>
     *  配列がnullあるいは空の場合にのみ、要素数1、初めの要素が0の配列を返します。
     * @param intArray 0を除く前の配列
     * @return 引数で受け取った配列から0を除いた
     */
    public static Integer[] removeZero(int[] intArray) {

        List<Integer> hitList = new ArrayList<>();

        for (int i : intArray) {
            if (i !=0) {
                hitList.add(i);
            }
        }
        return (Integer[])(hitList.toArray(new Integer[0]));
    }

}
