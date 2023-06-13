import java.io.FileWriter;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 2, 8 };
        int n = arr.length;

        try (FileWriter writer = new FileWriter("sort_log.txt")) {
            writer.write("Initial array: " + arrayToString(arr) + "\n");

            for (int i = 0; i < n - 1; i++) {
                writer.write("Iteration " + (i + 1) + ": " + arrayToString(arr) + "\n");

                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            writer.write("Final sorted array: " + arrayToString(arr) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
