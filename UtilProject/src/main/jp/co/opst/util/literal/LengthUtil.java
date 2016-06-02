package jp.co.opst.util.literal;

/**
 * @author Yui
 * リテラルの長さに関するユーティリティクラス
 *
 */
public final class LengthUtil {

    private LengthUtil() {}

    /**
     * 指定した文字列がnullあるいは空でないか確認します。
     * @param str nullあるいは空でないことを確認したい文字列
     * @return <code>true</code>:<code>str</code>の長さは1以上
     */
    public static boolean isNotEmpty (String str) {
        return (str != null) && (!str.isEmpty()) ? true : false;
    }

//    /**
//     * 指定した整数がnullあるいは空でないか確認します。
//     * @param num nullあるいは空でないことを確認したい数値
//     * @return <code>true</code>:<code>num</code>の長さは1以上
//     */
//    public static boolean isNotEmpty (Integer num) {
//        return (num != null) && (!String.valueOf(num).isEmpty()) ? true : false;
//    }

    /**
     * 指定した文字列がnullあるいは空であるか確認します。
     * @param str 検査対象の文字列
     * @return <code>true</code>:<code>str</code>はnullあるいは空
     */
    public static boolean isEmpty (String str) {
        return (str == null) || (str.isEmpty()) ? true : false;
    }

//    /**
//     * 指定した整数がnullあるいは空であるか確認します。
//     * @param num 検査対象の整数
//     * @return <code>true</code>:<code>num</code>はnullあるいは空
//     */
//    public static boolean isEmpty (Integer num) {
//        return (num == null) || (String.valueOf(num).isEmpty()) ? true : false;
//    }

    /**
     * 文字列<code>str</code>の長さが<code>minLength</code>～<code>maxLength</code>に含まれているか確認します。
     * @param str 検査対象の文字列
     * @param minLength 文字列の長さ下限
     * @param maxLength 文字列の長さの上限
     * @return <code>true</code>:<code>str</code>の長さは<code>minLength</code>～<code>maxLength</code>に含まれている
     */
    public static boolean isLengthInside(String str, int minLength, int maxLength) {

        if (isEmpty(str) && minLength == 0) {
            return true;
        }

        if (minLength <= str.length() && str.length() <= maxLength) {
            return true;
        }

        return false;
    }

}