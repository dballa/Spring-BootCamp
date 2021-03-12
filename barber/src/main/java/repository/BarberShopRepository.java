package repository;

import java.util.List;

import model.EmployeeService;
import model.Reservation;
import model.ShopService;
import model.User;

public interface BarberShopRepository {

	List<Reservation> getAll(EmployeeService employeeService);

	User save(User user);

	boolean existService(ShopService shopService);

	ShopService add(ShopService shopService);

	boolean existsUser(String username);

	//List<Reservation> manageReservationList(ShopService shopService);


}
