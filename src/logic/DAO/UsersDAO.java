package logic.DAO;

import logic.connection.MyConnection;
import logic.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    private static final String SQL_INSERT = "INSERT INTO users(login, password_hash, email, role) VALUES(?, ?, ?, ?);";
    private static final String GET_BY_LOGIN = "SELECT * FROM users WHERE login = ?;";

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<User>();
        String query = "SELECT * FROM users;";
        ResultSet rs = null;
        Statement statement = null;

        try {
            Connection connection = MyConnection.getSimpleConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                result.add(
                        new User(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5)
                        )
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (statement != null)
                    statement.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public User getUserByLogin(String login) {
        PreparedStatement preparedStatement;
        User user = null;
        try {
            preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int insert(User user) {
        int id = 0;
        try {
            if (getUserByLogin(user.getLogin()) == null) {

                PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPasswordHash());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getRole());

                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                    user.setUserId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
