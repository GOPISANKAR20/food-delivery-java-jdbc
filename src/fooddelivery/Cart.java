package fooddelivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Cart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter food ID: ");
        int foodId = sc.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM food_items WHERE food_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, foodId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String foodName = rs.getString("food_name");
                double price = rs.getDouble("price");

                double total = price * quantity;

                System.out.println("Food: " + foodName);
                System.out.println("Price: ₹" + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Total: ₹" + total);

            } else {
                System.out.println("Food item not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}