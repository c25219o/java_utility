package jp.co.opst.util.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.co.opst.util.literal.IntegerUtil;

public final class ArrayUtil {

	/**
	 * int型の配列から、要素が0であるものを除いた配列を返します。<br>
	 * 配列がnullあるいは空の場合にのみ、要素数1、初めの要素が0の配列を返します。
	 * 
	 * @param intArray
	 *            0を除く前の配列
	 * @return 引数で受け取った配列から0を除いた
	 */
	public static Integer[] removeZero(int[] intArray) {

		List<Integer> hitList = new ArrayList<>();

		for (int i : intArray) {
			if (i != 0) {
				hitList.add(i);
			}
		}
		return (hitList.toArray(new Integer[0]));
	}

	public static String isValidConbination(String[] code, Map<String, String> params) {

		// まずはチェックが入っているのに数値が入力されていないエラー
		for (String eachCode : code) {
			// チェックを入れたはずのものが入ってない
			if (!params.containsKey(eachCode)) {
				return "数値を入力してください";
			}
			// チェックを入れたパラメータに入っている値が数値でない
			if (IntegerUtil.isNotInteger(params.get(eachCode))) {
				return "数値を入力してください";
			}
		}

		// 次に、数値を入力したパラメータの横にチェックが入っていなかった場合
		for (Entry<String, String> entry : params.entrySet()) {
			if (IntegerUtil.isInteger(entry.getValue())) {
				if (!ArrayUtil.contains(code, entry.getKey())) {
					return "数値を入力したパラメータにはチェックをつけてください";
				}
			}
		}

		return null;
	}

	private static boolean contains(String[] strArray, String str) {
		// TODO nullチェック
		for (String each : strArray) {
			if (each == str || each.equals(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 文字列の配列を整数の配列に変換します。<br>
	 * 数値に変換できない値が含まれていた場合は、nullを返します。
	 *
	 * @param strArray
	 *            整数の配列に変換したい文字列配列
	 * @return 変換後の整数配列
	 */
	public static int[] arrayStrToInt(String[] strArray) {
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			try {
				intArray[i] = Integer.parseInt(strArray[i]);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return intArray;
	}

}
