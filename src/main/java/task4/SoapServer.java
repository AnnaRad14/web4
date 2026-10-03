package task4;

import javax.xml.ws.Endpoint;

public class SoapServer {

    public static void main(String[] args) {

        String address =
                "http://localhost:8081/translator";

        Endpoint.publish(
                address,
                new TranslatorImpl()
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