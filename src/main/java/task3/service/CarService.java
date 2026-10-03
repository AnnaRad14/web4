package task3.service;

import task3.Client1;
import task3.model.Car;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CarService {

    @WebMethod
    List<Car> getCars();

    @WebMethod
    List<Client1> getClients();
}