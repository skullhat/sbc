import javax.swing.JFrame;

import java.sql.*;

public class App extends JFrame {

    public static void main(String[] args) throws Exception {
        User user = null;
        String pickup_station = "Sudan";

        final String DB_URL = "jdbc:mysql://localhost/sbc?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...
            // sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES
            // ( ?,?, ?, ?, ?, ? )";
            String sql = "DELETE FROM trips WHERE pickup_station = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, pickup_station);

            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
