package jp.co.opst.util.data;


public class StringConvertUtil {

	
    public static void main(String[] args) {
        String columns = "GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_EXP, MAKER, REG_DATE, LST_UPDATE_TIME";
        printFieldFromCSVColumn(columns);
    }

    /**
     * CSV形式のカラム名からprivateなString型のフィールド名を作成し、コンソールに出力します。
     * @param csv
     */
    public static void printFieldFromCSVColumn(String csv) {

        String[] colmunArray = csv.split(",");

        for (String string : colmunArray) {
            string = string.trim();
            StringBuilder sb = new StringBuilder();
            sb.append("private ");
            sb.append("String ");
            sb.append(columnToCamel(string));
            sb.append(";");
            System.out.println(sb);
        }

    }

    /**
     * 大文字とアンダースコアで構成されているカラム名を、キャメルケースに変換します。
     * @param str
     * @return
     */
    private static String columnToCamel(String str) {
        str = str.toLowerCase();

        if (!str.contains("_")) {
            return str;
        }

        String[] wordArray = str.split("_");
        for (int i = 1; i < wordArray.length; i++) {
            if (wordArray[i] == null || wordArray[i].isEmpty()) {
                continue;
            }

            String word = wordArray[i];
            char firstChar = word.charAt(0);
            String formattedWord = Character.toUpperCase(firstChar) + word.substring(1);
            wordArray[i] = formattedWord;
        }

        StringBuilder sb = new StringBuilder();
        for (String string : wordArray) {
            sb.append(string);
        }

        return sb.toString();
    }

}
