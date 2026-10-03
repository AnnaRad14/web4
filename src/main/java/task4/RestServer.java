package task4;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class RestServer {

    public static void main(String[] args) {

        ResourceConfig config =
                new ResourceConfig();

        config.register(
                RestTranslator.class
        );

        JdkHttpServerFactory.createHttpServer(
                URI.create(
                        "http://localhost:8082/"
                ),
                config
        );

        System.out.println(
                "REST-сервіс запущено!"
        );

        System.out.println(
                "http://localhost:8082/translate/"
        );
    }
}