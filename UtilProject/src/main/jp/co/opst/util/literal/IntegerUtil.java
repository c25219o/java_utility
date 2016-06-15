package jp.co.opst.util.literal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerUtil {

	public static boolean isInteger(Object object) {
        if (object == null) {
            return false;
        }

		String str = object.toString();
		if (str.contains(" ")) {
			return false;
        }

		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(str);
		return (m.find());
	}

	public static boolean isJapanZipCode(String str) {
		return LengthUtil.isEmpty(str) ? false : str.matches("^[0-9]{3}-[0-9]{4}$");
	}

	public static boolean isJapanTel(String str) {
		return LengthUtil.isEmpty(str) ? false : str.matches("^[0-9]+-[0-9]+-[0-9]+$");
	}

	public static boolean isNotInteger(Object object) {
		return !isInteger(object);
    }

}
