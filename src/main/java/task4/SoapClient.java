package task4;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class SoapClient {

    public static void main(String[] args)
            throws Exception {

        URL url =
                new URL(
                        "http://localhost:8081/translator?wsdl"
                );

        QName serviceName =
                new QName(
                        "http://task4/",
                        "TranslatorImplService"
                );

        Service service =
                Service.create(
                        url,
                        serviceName
                );

        QName portName =
                new QName(
                        "http://task4/",
                        "TranslatorImplPort"
                );

        Translator translator =
                service.getPort(
                        portName,
                        Translator.class
                );

        System.out.println(
                "=== SOAP ПЕРЕКЛАДАЧ ==="
        );

        System.out.println(
                "привіт -> " +
                        translator.translate("привіт")
        );

        System.out.println(
                "машина -> " +
                        translator.translate("машина")
        );

        System.out.println(
                "комп'ютер -> " +
                        translator.translate("комп'ютер")
        );

        System.out.println(
                "дякую -> " +
                        translator.translate("дякую")
        );

        System.out.println(
                "яблуко -> " +
                        translator.translate("яблуко")
        );
    }
}