package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.EmployeeService;
import model.Reservation;
import model.ShopService;
import model.User;

@Repository
public class BarberShopRepositoryImpl implements BarberShopRepository{

	private List<User> users = new ArrayList<User>();
	private List<ShopService> shopServices = new ArrayList<ShopService>();
	
	@Override
	public List<Reservation> getAll(EmployeeService employeeService){
		
		//return shopService;
		return null;
	}



	@Override
	public User save(User user) {
		users.add(user);
		return user;
	}

	@Override
	public ShopService add(ShopService shopService) {
		shopServices.add(shopService);
		return shopService;
	}

	@Override
	public boolean existService(ShopService shopService) {

		return (shopServices.contains(shopService));
	}



	  @Override
	    public boolean existsUser(String username) {
	        for (User user : users){
	            if (user.getUsername().compareTo(username)==0){
	                return true;
	            }
	        }
	        return false;
	    }

}
