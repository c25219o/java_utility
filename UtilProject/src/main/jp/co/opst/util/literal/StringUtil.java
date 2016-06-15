package jp.co.opst.util.literal;

public class StringUtil {

	public static boolean isSame(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return str1 == str2;
		}
		return str1.equals(str2);
	}
}
