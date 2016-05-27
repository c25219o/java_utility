package jp.co.opst.util.list;

import java.util.List;

public class ListUtil {

    /**
     * リストがただひとつの要素を持っているかどうか確認します。
     * @param list 検査対象のList
     * @return <code>true</code>:リストはただひとつの要素を持つ
     */
    public static boolean hasOnlyOneElement(List<?> list) {
        return (list != null && list.size() == 1) ? true : false;
    }

}
