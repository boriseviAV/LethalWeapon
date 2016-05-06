package logic.DAO;

import logic.models.WeaponCollection;
import logic.connection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CollectionDAO {

    private final String SQL_INSERT = "INSERT INTO weapon_collections(collection_id, weapon_id, name, picture_url) VALUES(?, ?, ?, ?)";

    public void insert(WeaponCollection weaponCollection){
        try {
            PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(SQL_INSERT);

            preparedStatement.setInt(1, weaponCollection.getCollection_id());
            preparedStatement.setInt(2, weaponCollection.getWeapon_id());
            preparedStatement.setString(3, weaponCollection.getName());
            preparedStatement.setString(4, weaponCollection.getPicture_url());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
