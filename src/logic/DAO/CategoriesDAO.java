package logic.DAO;

import logic.connection.MyConnection;
import logic.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO {
    private static final String SQL_INSERT = "INSERT INTO categories(name, picture_url) VALUES(?, ?);";
    private static final String GET_BY_ID = "SELECT * FROM lethal_weapon.categories WHERE category_id = ?;";

    public List<Category> getAllCategories() {
        List<Category> result = new ArrayList<Category>();
        String query = "SELECT * FROM lethal_weapon.categories;";
        ResultSet rs = null;
        Statement statement = null;

        try {
            Connection connection = MyConnection.getSimpleConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                result.add(
                        new Category(
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

    public void deleteAll() {
        String query1 = "DELETE FROM weapons;";
        String query2 = "DELETE FROM categories;";
        Statement statement = null;

        try {
            Connection connection = MyConnection.getSimpleConnection();
            statement = connection.createStatement();
            statement.execute(query1);
            statement.execute(query2);
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

    public Category getCategoryById(int id) {
        PreparedStatement preparedStatement;
        Category category = null;
        try {
            preparedStatement = MyConnection.getSimpleConnection().prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                category = new Category(
                        rs.getString(1),
                        rs.getString(2)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public int insert(Category category) {
        int id = 0;
        try {
            PreparedStatement preparedStatement = MyConnection.getSimpleConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getPictureURL());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                category.setCategoryId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
