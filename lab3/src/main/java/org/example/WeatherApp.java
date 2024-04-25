package org.example;

import java.sql.*;
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {
        try {
            // З'єднання з базою даних
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/laboratory_work_3","postgres", "bvk250303");

            // Створення запиту для взяття інформації про погоду
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter country:");
            String country = scanner.nextLine();

            System.out.println("Enter date (YYYY-MM-DD AA:BB:CC):");
            String last_update_str = scanner.nextLine();
            Timestamp last_update = Timestamp.valueOf(last_update_str);

            // Якщо потрібні додаткові параметри, введіть їх тут

            String query = "SELECT * FROM weather_data WHERE country = ? AND last_update = ?";
            //String query = "SELECT * FROM weather WHERE country = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, country);
            pstmt.setTimestamp(2, last_update);

            // Виконання запиту та вивід результатів
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String temperature = rs.getString("temperature_celsius");
                System.out.println("temperature_celsius:"+temperature);
                String cloud = rs.getString("cloud");
                System.out.println("cloud:"+cloud);
                String humidity = rs.getString("humidity");
                System.out.println("humidity:"+humidity);
                String wind_direction = rs.getString("wind_direction");
                System.out.println("wind_direction:"+wind_direction);
                String wind_kph = rs.getString("wind_kph");
                System.out.println("wind_kph:"+wind_kph);
            }

            // Закриття з'єднання та ресурсів
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

