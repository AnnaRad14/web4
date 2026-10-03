package task3.dao;

import task3.db.DBConnection;
import task3.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public List<Car> getAllCars() {

        List<Car> cars =
                new ArrayList<>();

        String sql =
                "SELECT id, mark_id, model, price FROM cars";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Car car = new Car();

                car.setId(
                        resultSet.getInt("id")
                );

                car.setMarkId(
                        resultSet.getInt("mark_id")
                );

                car.setModel(
                        resultSet.getString("model")
                );

                car.setPrice(
                        resultSet.getInt("price")
                );

                cars.add(car);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return cars;
    }
}