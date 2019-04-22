import com.gupao.orm.entity.Member;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class JDBCTest {
    public static void main(String[] args) {
        Member condition = new Member();
        condition.setName("TOM");
        condition.setAge(18);
        List<?> result = select(condition);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static List<?> select(Member condition){
        List<Object> result = new ArrayList<>();
        Class<?> entityClass = condition.getClass();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String password = "***";//自己的云服务器，保密
            String url = "***";//自己的云服务器，保密
            conn = DriverManager.getConnection(url, "root", password);

            Map<String, String> columnMapper = new HashMap<>();
            Map<String, String> fieldMapper = new HashMap<>();
            Field[] fields = entityClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (field.isAnnotationPresent(Column.class)){
                    Column column = field.getAnnotation(Column.class);
                    String columnName = column.name();
                    columnMapper.put(columnName, fieldName);
                    fieldMapper.put(fieldName, columnName);
                } else {
                    columnMapper.put(fieldName, fieldName);
                    fieldMapper.put(fieldName, fieldName);
                }
            }

            Table table = entityClass.getAnnotation(Table.class);
            String sql = "select * from " + table.name();
            StringBuffer where = new StringBuffer(" where 1=1 ");
            for (Field field : fields) {
                Object value = field.get(condition);
                if (value != null){
                    if (String.class == field.getType()){
                        where.append(" and " + fieldMapper.get(field.getName()) + " = '" + value + "'");
                    } else {
                        where.append(" and " + fieldMapper.get(field.getName()) + " = '" + value + "'");
                    }
                }
            }

            sql = sql + where.toString();
            System.out.println(sql);
            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();
            int columnCounts = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object instance = entityClass.newInstance();
                for (int i = 1; i < columnCounts; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Field field = entityClass.getDeclaredField(columnMapper.get(columnName));
                    field.setAccessible(true);
                    field.set(instance, rs.getObject(columnName));
                }
                result.add(instance);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
