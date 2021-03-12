package com.ikubinfo.reservation;


import com.ikubinfo.reservation.repository.impl.ReservationRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReservationApplicationTests {


	@Test
	public void testDateConditions(){
		ReservationRepoImpl reservationRepo = new ReservationRepoImpl();

		LocalDateTime date1 = LocalDateTime.of(2021,3,11,16,35);
		LocalDateTime date2 = LocalDateTime.of(2021,5,11,16,35);
		LocalDateTime date9 = LocalDateTime.of(2021,4,11,16,35);

		LocalDateTime date3 = LocalDateTime.of(2021,8,11,16,35);
		LocalDateTime date4 = LocalDateTime.of(2021,8,13,16,35);
		LocalDateTime date10 = LocalDateTime.of(2021,8,12,16,35);

		LocalDateTime date5 = LocalDateTime.of(2021,8,13,12,35);
		LocalDateTime date6 = LocalDateTime.of(2021,8,13,16,35);
		LocalDateTime date11 = LocalDateTime.of(2021,8,13,14,35);

		LocalDateTime date7 = LocalDateTime.of(2021,8,13,16,0);
		LocalDateTime date8 = LocalDateTime.of(2021,8,13,16,45);
		LocalDateTime date12 = LocalDateTime.of(2021,8,13,16,4);

		//assertTrue(reservationRepo.isBetween(date12,date1,date2));

		LocalDateTime date13 = LocalDateTime.of(2021,8,13,12,35);
		LocalDateTime date14= LocalDateTime.of(2021,8,13,16,35);
		LocalDateTime date15 = LocalDateTime.of(2021,8,13,12,35);


		List<LocalDateTime> beginDates = new ArrayList<>();
		List<LocalDateTime> endDates = new ArrayList<>();
		List<LocalDateTime> betweenDates = new ArrayList<>();

		beginDates.add(date1);
		beginDates.add(date3);
		beginDates.add(date5);
		beginDates.add(date7);
		beginDates.add(date13);

		endDates.add(date2);
		endDates.add(date4);
		endDates.add(date6);
		endDates.add(date8);
		endDates.add(date14);

		betweenDates.add(date9);
		betweenDates.add(date10);
		betweenDates.add(date11);
		betweenDates.add(date12);
		betweenDates.add(date15);

		int i = 0;
		while (i<4){
			assertTrue(reservationRepo.isBetween(betweenDates.get(i),
							beginDates.get(i),endDates.get(i)));
			i++;
		}

		assertTrue(reservationRepo.areTheSame(betweenDates.get(4),beginDates.get(4)));

	}
}
