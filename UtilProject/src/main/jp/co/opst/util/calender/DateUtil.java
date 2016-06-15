package jp.co.opst.util.calender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import jp.co.opst.util.literal.IntegerUtil;

public class DateUtil {

	// yyyy/MM/ddにすると、一桁の月や日も例外の対象になった...
	// private static final String PATTERN = "yyyy/MM/dd";
	private static final String PATTERN = "u/M/d";

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN)
			.withResolverStyle(ResolverStyle.STRICT);

	public static boolean exists(String year, String month, String day) {
		if (IntegerUtil.isNotInteger(year) || IntegerUtil.isNotInteger(month) || IntegerUtil.isNotInteger(day)) {
			return false;
		}
		String dateStr = year + "/" + month + "/" + day;
		return exists(dateStr);
	}

	public static boolean exists(String dateStr) {
		try {
			formatter.parse(dateStr);
			return true;
		} catch (DateTimeParseException e) {
			System.out.println("parsed string -->" + e.getParsedString());
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * 日付の前後関係が正しいかどうか検証します<br>
	 * 日付として正しくない値が渡された場合は<code>false</code>を返します
	 *
	 * @param before
	 *            前の日付（yyyy/MM/dd形式）
	 * @param after
	 *            後の日付（yyyy/MM/dd形式）
	 * @return <code>true</code>:日付の前後関係は正しい
	 */
	public static boolean isValidCombi(String beforeStr, String afterStr) {
		try {
			LocalDate before = LocalDate.parse(beforeStr, formatter);
			LocalDate after = LocalDate.parse(afterStr, formatter);
			if (before.equals(after)) {
				return true;
			}
			return before.isBefore(after);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return false;
		}
	}
}

class Main {
	public static void main(String[] args) {

		String year = "1992";
		String month = "2";
		String day = "29";

		if (DateUtil.exists(year, month, day)) {
			System.out.println("日付です");
		} else {
			System.out.println("日付じゃありません");
		}
	}
}