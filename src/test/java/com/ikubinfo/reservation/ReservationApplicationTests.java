package com.ikubinfo.reservation;


import com.ikubinfo.reservation.repository.impl.ReservationRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class ReservationApplicationTests {


	@Test
	public void testDateConditionsHours(){
		ReservationRepoImpl reservationRepo = new ReservationRepoImpl();

		LocalDateTime date7 = LocalDateTime.of(2021,8,13,16,0);
		LocalDateTime date8 = LocalDateTime.of(2021,8,13,16,45);
		LocalDateTime date12 = LocalDateTime.of(2021,8,13,16,4);

		assertTrue(reservationRepo.isBetween(date12, date7,date8));


	}
	@Test
	public void testDateConditionsDay(){
		ReservationRepoImpl reservationRepo = new ReservationRepoImpl();

		LocalDateTime date3 = LocalDateTime.of(2021,8,11,16,35);
		LocalDateTime date4 = LocalDateTime.of(2021,8,13,16,35);
		LocalDateTime date10 = LocalDateTime.of(2021,8,12,16,35);

		assertTrue(reservationRepo.isBetween(date10, date3,date4));
	}
	@Test
	public void testDateConditionsMonth(){
		ReservationRepoImpl reservationRepo = new ReservationRepoImpl();

		LocalDateTime date1 = LocalDateTime.of(2021,3,11,16,35);
		LocalDateTime date2 = LocalDateTime.of(2021,5,11,16,35);
		LocalDateTime date9 = LocalDateTime.of(2021,4,11,16,35);

		assertTrue(reservationRepo.isBetween(date9, date1,date2));

	}
}
