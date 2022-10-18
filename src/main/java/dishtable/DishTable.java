package dishtable;

import java.sql.*;
import java.util.Calendar;

public class DishTable {
    private static final String HOST = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1121";
    private static final String INSERT_NEW = "INSERT INTO dish VALUES (?,?,?,?,?,?)";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DriverManager.getConnection(HOST, USER, PASSWORD);
            ps = connection.prepareStatement(INSERT_NEW);
            ps.setInt(1, 2);
            ps.setString(2, "fries");
            ps.setString(3, "potato");
            ps.setDouble(4, 0.2f);
            ps.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
            ps.setBoolean(6, true);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
                assert ps != null;
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
