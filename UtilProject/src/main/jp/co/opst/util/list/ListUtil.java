package jp.co.opst.util.list;

import java.util.List;

public final class ListUtil {

    /**
     * リストがただひとつの要素を持っているかどうか確認します。
     *
     * @param list
     *            検査対象のList
     * @return <code>true</code>:リストはただひとつの要素を持つ
     */
    public static boolean hasOnlyOneElement(List<?> list) {
        return (list != null && list.size() == 1) ? true : false;
    }

    /**
     * リストがnullあるいは空であるかどうか確認します。
     * @param list
     * @return
     */
    public static boolean isEmptyOrNull(List<?> list) {
        return (list == null || list.isEmpty()) ? true : false;
    }

    /**
     * リストの中身が全てnullであるかどうか確認します。リストが空あるいはnullのときはtrueを返します。
     * @param list
     * @return
     */
    public static boolean hasOnlyNull(List<?> list) {

        if (isEmptyOrNull(list)) {
            return true;
        }

        for (Object element : list) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Integerのリストから最大値のを取得します。リストがnullあるいは空のときは、0を返します。
     *
     * @param integerList
     *            整数(Integer)のリスト
     * @return リストの全要素の最大値
     */
    public static int maxInt(List<Integer> integerList) {

        int max = 0;

        if (integerList == null || integerList.size() == 0) {
            return max;
        }

        max = integerList.get(0);

        for (int num : integerList) {

            // 初期値が0のため、
            if (num < 0) {
                if (max == 0) {
                    max = num;
                }

            } else if (num > max) {
                max = num;
            }
        }
        return max;

    }

    public static int minInt(List<Integer> integerList) {

        int min = 0;

        if (integerList == null || integerList.size() == 0) {
            return min;
        }

        for (int num : integerList) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

}
