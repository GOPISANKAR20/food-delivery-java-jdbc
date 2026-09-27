package fooddelivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful");
                System.out.println("Welcome " + rs.getString("name"));
            } else {
                System.out.println("Invalid email or password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}