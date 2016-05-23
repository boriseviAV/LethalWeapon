package logic.DAO;

import logic.connection.MyConnection;
import logic.models.Weapon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SearchDAO {
    private static final String GET_BY_STRING = "SELECT * FROM lethal_weapon.weapons WHERE model_name LIKE ?;";

    public List<Weapon> getResults(String phrase) {

        List<Weapon> result = new ArrayList<Weapon>();

        try {
            PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_BY_STRING);

            preparedStatement.setString(1, "%" + phrase + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result.add(
                        new Weapon(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getInt(7),
                                rs.getBoolean(8),
                                rs.getString(9),
                                rs.getInt(10),
                                rs.getString(11)
                        )
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
