package logic.DAO;

import logic.connection.MyConnection;
import logic.models.Weapon;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by VORON on 02.05.2016.
 */
public class WeaponDAO {

    private static final String SQL_INSERT = "INSERT INTO weapons(weapon_id, model_name, holding_way, country," +
            " range, caliber, ammo_number, holder_kind, optics, weaponscol, stuff, collection_id, picture_url) VALUES(" +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    public static void insert(Weapon weapon){
        try {
            PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(SQL_INSERT);

            preparedStatement.setInt(1, weapon.getWeapon_id());
            preparedStatement.setString(2, weapon.getModel_name());
            preparedStatement.setString(3, weapon.getHolding_way());
            preparedStatement.setString(4, weapon.getCountry());
            preparedStatement.setString(5, weapon.getRange());
            preparedStatement.setString(6, weapon.getCaliber());
            preparedStatement.setInt(7, weapon.getAmmo_number());
            preparedStatement.setString(8, weapon.getHolder_kind());
            preparedStatement.setBoolean(9,weapon.isOptics());
            preparedStatement.setString(10, weapon.getStuff());
            preparedStatement.setInt(11, weapon.getCollection_id());
            preparedStatement.setString(12, weapon.getPicture_url());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
