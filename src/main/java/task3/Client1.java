package task3;

import task3.model.Car;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;

public class Client1 {

    public static void main(String[] args)
            throws Exception {

        URL url =
                new URL(
                        "http://localhost:8080/carservice?wsdl"
                );

        QName serviceName =
                new QName(
                        "http://service.task3/",
                        "CarServiceImplService"
                );

        Service service =
                Service.create(
                        url,
                        serviceName
                );

        QName portName =
                new QName(
                        "http://service.task3/",
                        "CarServiceImplPort"
                );

        task3.service.CarService carService =
                service.getPort(
                        portName,
                        task3.service.CarService.class
                );

        System.out.println(
                "=== CARS ==="
        );

        List<Car> cars =
                carService.getCars();

        for (Car car : cars) {

            System.out.println(car);
        }

        System.out.println();

        System.out.println(
                "=== CLIENTS ==="
        );

        List<Client1> clients =
                carService.getClients();

        for (Client1 client : clients) {

            System.out.println(client);
        }
    }
}