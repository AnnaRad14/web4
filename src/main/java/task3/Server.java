package task3;

import task3.service.CarServiceImpl;

import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String[] args) {

        String address =
                "http://localhost:8080/carservice";

        Endpoint.publish(
                address,
                new CarServiceImpl()
        );

        System.out.println(
                "SOAP-сервіс запущено!"
        );

        System.out.println(
                "WSDL:"
        );

        System.out.println(
                address + "?wsdl"
        );
    }
}