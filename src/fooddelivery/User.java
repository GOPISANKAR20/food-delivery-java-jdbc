package fooddelivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class User {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();

            System.out.println("User registered successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}