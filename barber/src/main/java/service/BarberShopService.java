package service;

import java.util.List;

import model.EmployeeService;
import model.Reservation;
import model.ShopService;
import model.User;

public interface BarberShopService {
	
	User addUser(User user);
	
	ShopService addService(ShopService shopService);
	
	List<Reservation> manageReservationList(User user, Reservation reservation);

	List<Reservation> getAll(EmployeeService employeeService);

}
