import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {

    private static String[][] fileToStringArray(String str) {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(str))) {
            int ch;
            while ((ch = br.read()) != -1) {
                sb.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = sb.toString().split("\\s");

        String[][] temp = new String[arr.length][6];

        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher match;

        for (int i = 0; i < arr.length; i++) {
            match = pattern.matcher(arr[i]);
            int j = 0;
            while (match.find()) {
                temp[i][j] = match.group();
                j++;
            }
        }
        return temp;
    }

    private static String studentInf(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(String.format("студент %s получил %s по предмету %s\n", arr[i][1], arr[i][3], arr[i][5]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String[][] arr = fileToStringArray("homeworks\\homework_2\\src\\students.json");

        System.out.println(studentInf(arr));
    }
}
