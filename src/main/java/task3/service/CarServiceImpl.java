package task3.service;

import task3.Client1;
import task3.dao.CarDAO;
import task3.dao.ClientDAO;
import task3.model.Car;

import javax.jws.WebService;
import java.util.List;

@WebService(
        endpointInterface =
                "task3.service.CarService"
)
public class CarServiceImpl
        implements CarService {

    private final CarDAO carDAO =
            new CarDAO();

    private final ClientDAO clientDAO =
            new ClientDAO();

    @Override
    public List<Car> getCars() {

        return carDAO.getAllCars();
    }

    @Override
    public List<Client1> getClients() {

        return clientDAO.getAllClients();
    }
}