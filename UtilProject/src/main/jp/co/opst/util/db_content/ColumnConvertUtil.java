package jp.co.opst.util.db_content;


/**
 *
 * 文字列変換ユーティリティクラス
 * mainメソッドあるいは他プロジェクトより使用したいメソッドを呼び出してください。
 * 各メソッドの用途はメソッドのJavadocをご参照ください。
 *
 * @author Yui
 *
 */
public class ColumnConvertUtil {


    /**
     * convert呼び出し用mainメソッド
     * @param args コマンドライン引数(カラム名)
     */
    public static void main(String[] args) {
//        String columns = "GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_EXP, MAKER, REG_DATE, LST_UPDATE_TIME";
        String columns = args[0];
        printFieldFromCSVColumn(columns);
    }

    /**
     * CSV形式のカラム名からprivateなString型のフィールド名を作成し、コンソールに出力します。
     * @param csv csv形式のカラム一覧(カラム間のスペースは自動的に削除されます。)
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
     * @param column DBのカラム名(大文字＋アンダースコア)
     * @return カラム名をキャメルケースに直した文字列
     */
    private static String columnToCamel(String column) {
        column = column.toLowerCase();

        if (!column.contains("_")) {
            return column;
        }

        String[] wordArray = column.split("_");
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
