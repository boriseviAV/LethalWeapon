package logic.DAO;

import logic.connection.MyConnection;
import logic.models.Weapon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeaponsDAO {

    private static final String SQL_INSERT = "INSERT INTO weapons(model_name, holding_way, country," +
            " weapon_range, caliber, ammo_number, optics, stuff, picture_url, category_id) VALUES(" +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String GET_BY_ID = "SELECT * FROM lethal_weapon.weapons WHERE weapon_id = ?;";
    private static final String GET_BY_CATEGORY_ID = "SELECT * FROM lethal_weapon.weapons WHERE category_id = ?;";

    public List<Weapon> getAllWeapons() {
        List<Weapon> result = new ArrayList<Weapon>();
        String query = "SELECT * FROM lethal_weapon.weapons;";
        ResultSet rs = null;
        Statement statement = null;

        try {
            Connection connection = MyConnection.getSimpleConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

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

    public List<Weapon> getWeaponsByCategoryId(int id) {
        PreparedStatement preparedStatement;
        List<Weapon> result = new ArrayList<Weapon>();
        try {
            preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_BY_CATEGORY_ID);
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
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Weapon getWeaponById(int id) {
        PreparedStatement preparedStatement;
        Weapon weapon = null;
        try {
            preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                weapon = new Weapon(
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
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weapon;
    }

    public int insert(Weapon weapon) {
        int id = 0;
        try {
            PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, weapon.getModelName());
            preparedStatement.setString(2, weapon.getHoldingWay());
            preparedStatement.setString(3, weapon.getCountry());
            preparedStatement.setString(4, weapon.getRange());
            preparedStatement.setString(5, weapon.getCaliber());
            preparedStatement.setInt(6, weapon.getAmmoNumber());
            preparedStatement.setBoolean(7, weapon.isOptics());
            preparedStatement.setString(8, weapon.getStuff());
            preparedStatement.setString(9, weapon.getPictureURL());
            preparedStatement.setInt(10, weapon.getCategoryId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                weapon.setWeaponId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

}
