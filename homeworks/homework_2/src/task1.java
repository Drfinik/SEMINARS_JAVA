import java.util.HashMap;
import java.util.Map;

public class task1 {
    public static void task_1(String[] args) {
        String filter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        StringBuilder whereClause = new StringBuilder();
        Map<String, String> params = new HashMap<>();
        params.put("name", "name");
        params.put("country", "country");
        params.put("city", "city");
        params.put("age", "age");

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String paramName = entry.getKey();
            String columnName = entry.getValue();
            if (filter.contains("\"" + paramName + "\":")) {
                String value = filter.split("\"" + paramName + "\":\"")[1].split("\"")[0];
                if (!value.equals("null")) {
                    if (whereClause.length() > 0) {
                        whereClause.append(" AND ");
                    }
                    whereClause.append(columnName).append(" = '").append(value).append("'");
                }
            }
        }

        String sql = "SELECT * FROM students";
        if (whereClause.length() > 0) {
            sql += " WHERE " + whereClause.toString();
        }

        System.out.println(sql);
    }
}
