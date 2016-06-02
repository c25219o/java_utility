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
        return (list != null && list.size() == 1);
    }

    /**
     * リストがnullあるいは空であるかどうか確認します。
     * @param list
     * @return
     */
    public static boolean isEmptyOrNull(List<?> list) {
        return (list == null || list.isEmpty());
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

        if (integerList == null || integerList.size() == 0) {
            return 0;
        }

        int max = integerList.get(0);
        for (int i = 1; i < integerList.size(); i++) {
            int num = integerList.get(i);
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int minInt(List<Integer> integerList) {

        if (integerList == null || integerList.size() == 0) {
            return 0;
        }

        int min = integerList.get(0);
        for (int i = 1; i < integerList.size(); i++) {
            int num = integerList.get(i);
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

}
