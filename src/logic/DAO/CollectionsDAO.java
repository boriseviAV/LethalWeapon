package logic.DAO;

import logic.models.Weapon;
import logic.models.WeaponCollection;
import logic.connection.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionsDAO {

    private static final String SQL_INSERT = "INSERT INTO weapon_collections(name, picture_url) VALUES(?, ?);";
    private static final String GET_BY_ID = "SELECT * FROM lethal_weapon.weapon_collections WHERE collection_id = ?;";
    private static final String GET_CHILDREN_BY_ID =
            "SELECT w.* " +
            "FROM (weapons w INNER JOIN weapons_and_collections w_and_col " +
            "     ON w.weapon_id = w_and_col.weapon_id) INNER JOIN weapon_collections w_col " +
            "     ON w_and_col.collection_id = w_col.collection_id " +
            "WHERE w_col.collection_id = ?;";
    private static final String GET_BY_WEAPON_ID =
            "SELECT w_col.* " +
                    "FROM (weapons w INNER JOIN weapons_and_collections w_and_col " +
                    "     ON w.weapon_id = w_and_col.weapon_id) INNER JOIN weapon_collections w_col " +
                    "     ON w_and_col.collection_id = w_col.collection_id " +
                    "WHERE w.weapon_id = ?;";

    public List<Weapon> getWeaponsByCollectionId(int id) {
        PreparedStatement preparedStatement;
        List<Weapon> result = new ArrayList<Weapon>();
        try {
            preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_CHILDREN_BY_ID);
            preparedStatement.setInt(1, id);
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

    public List<WeaponCollection> getAllCollections() {
        List<WeaponCollection> result = new ArrayList<WeaponCollection>();
        String query = "SELECT * FROM lethal_weapon.weapon_collections;";
        ResultSet rs = null;
        Statement statement = null;

        try {
            Connection connection = MyConnection.getSimpleConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                result.add(
                        new WeaponCollection(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3)
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

    public List<WeaponCollection> getCollectionsByWeaponId(int id) {
        PreparedStatement preparedStatement;
        List<WeaponCollection> result = new ArrayList<WeaponCollection>();
        try {
            preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_BY_WEAPON_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result.add(
                        new WeaponCollection(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3)
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insert(WeaponCollection weaponCollection) {
        int id = 0;
        try {
            PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, weaponCollection.getName());
            preparedStatement.setString(2, weaponCollection.getPictureURL());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                weaponCollection.setCollectionId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
