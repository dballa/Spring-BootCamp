package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.EmployeeService;
import model.Reservation;
import model.ShopService;
import model.User;
import repository.BarberShopRepository;
import util.BarberShopManagementException;

	@Service
	public class BarberShopServiceImpl implements BarberShopService {

		private BarberShopRepository barberShopRepository;

		public BarberShopServiceImpl(BarberShopRepository barberShopRepository) {
			super();
			this.barberShopRepository = barberShopRepository;
		}

		@Override
		public User addUser(User user) {

			if (barberShopRepository.existsUser(user.getUsername())) {
				throw new BarberShopManagementException("An user with this username exists");

			} else {
				return barberShopRepository.save(user);
			}

		}

		@Override
		public ShopService addService(ShopService shopService) {
			
			if (barberShopRepository.existService(shopService)) {
				throw new BarberShopManagementException("This Service already exists");

			} else {
				return barberShopRepository.add(shopService);
			}
		}
		
		@Override
		public List<Reservation> manageReservationList(User user, Reservation newReservation) {
			// if in this day, in this time, this employee is free add the reservation, else return the list of free employees
			// or when it is the next free time of the requested employee
			//return barberShopRepository.manageReservationList(shopService);
			
			return null;
		}

		@Override
		public List<Reservation> getAll(EmployeeService employeeService) {
			return barberShopRepository.getAll(employeeService);
		}

	}
