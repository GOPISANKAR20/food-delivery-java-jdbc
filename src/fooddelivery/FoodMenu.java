package fooddelivery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FoodMenu {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM food_items");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("food_id") + " - " +
                    rs.getString("food_name") + " - ₹" +
                    rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}