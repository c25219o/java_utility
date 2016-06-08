package jp.co.opst.util.calender;

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