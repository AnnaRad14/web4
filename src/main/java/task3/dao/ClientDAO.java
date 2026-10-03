package task3.dao;

import task3.db.DBConnection;
import task3.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public List<Client> getAllClients() {

        List<Client> clients =
                new ArrayList<>();

        String sql =
                "SELECT id, name, age, phone FROM clients";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Client client =
                        new Client();

                client.setId(
                        resultSet.getInt("id")
                );

                client.setName(
                        resultSet.getString("name")
                );

                client.setAge(
                        resultSet.getInt("age")
                );

                client.setPhone(
                        resultSet.getString("phone")
                );

                clients.add(client);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return clients;
    }
}
