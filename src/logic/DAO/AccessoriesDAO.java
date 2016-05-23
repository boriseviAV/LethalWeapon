package logic.DAO;

import logic.connection.MyConnection;
import logic.models.Accessory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccessoriesDAO {
    private static final String SQL_INSERT = "INSERT INTO accessories(name, description, picture_url) VALUES(?, ?, ?);";
    private static final String GET_BY_ID = "SELECT * FROM lethal_weapon.accessories WHERE accessory_id = ?;";

    public List<Accessory> getAllAccessories() {
        List<Accessory> result = new ArrayList<Accessory>();
        String query = "SELECT * FROM lethal_weapon.accessories;";
        ResultSet rs = null;
        Statement statement = null;

        try {
            Connection connection = MyConnection.getSimpleConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                result.add(
                        new Accessory(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4)
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

    public void deleteAll() {
        String query = "DELETE FROM lethal_weapon.accessories;";
        Statement statement = null;

        try {
            Connection connection = MyConnection.getSimpleConnection();
            statement = connection.createStatement();
            statement.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Accessory getAccessoryById(int id) {
        PreparedStatement preparedStatement;
        Accessory accessory = null;
        try {
            preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                accessory = new Accessory(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accessory;
    }

    public int insert(Accessory accessory) {
        int id = 0;
        try {
            Connection connection = MyConnection.getSimpleConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET NAMES 'utf8'");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, accessory.getName());
            preparedStatement.setString(2, accessory.getDescription());
            preparedStatement.setString(3, accessory.getPictureURL());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                accessory.setAccessoryId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
