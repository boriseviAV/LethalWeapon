package logic.DAO;

import logic.connection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WeaponsAndCollectionsDAO {

    private static final String SQL_INSERT = "INSERT INTO weapons_and_collections(weapon_id, collection_id) VALUES(?, ?);";

    private static final String SQL_EXISTS = "SELECT weap_col_id FROM weapons_and_collections WHERE weapon_id = ? AND collection_id = ? LIMIT 1;";

    public void insert(int weaponId, int collectionId) {
        try {
            PreparedStatement exStat = MyConnection.getSimpleConnection().prepareStatement(SQL_EXISTS);
            exStat.setInt(1, weaponId);
            exStat.setInt(2, collectionId);
            ResultSet rs = exStat.executeQuery();

            if (!rs.next()) {
                PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(SQL_INSERT);
                preparedStatement.setInt(1, weaponId);
                preparedStatement.setInt(2, collectionId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
