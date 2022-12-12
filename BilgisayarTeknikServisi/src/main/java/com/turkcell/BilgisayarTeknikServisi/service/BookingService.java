package com.turkcell.BilgisayarTeknikServisi.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.BilgisayarTeknikServisi.model.Booking;
import com.turkcell.BilgisayarTeknikServisi.repository.BookingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService {

	private BookingRepository bookingRepository;
	private EntityManager entityManager;

	public void refresh(Booking booking) {
		entityManager.refresh(booking);
	}

	public Booking createBooking(Booking booking) {
		LocalDate someDate = createBookingDate(booking.getService().getDuration());
		booking.setBookingDate(someDate);
		booking = bookingRepository.saveAndFlush(booking);
		entityManager.clear();
		booking = bookingRepository.findById(booking.getId()).get();
		return booking;
	}

	public Booking getById(Long id) {
		return bookingRepository.findById(id).orElse(null);
	}

	public void deleteById(Long id) {
		bookingRepository.deleteById(id);
	}

	public List<Booking> getAllByOrderByBookingDateDesc() {
		return bookingRepository.findAllByOrderByBookingDateDesc();
	}

	public List<Booking> getAllByOrderByBookingDateAsc() {
		return bookingRepository.findAllByOrderByBookingDateAsc();
	}

	public List<Booking> findNameLike(String name) {
		return bookingRepository.findByUserNameLike(name);
	}

	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	private LocalDate createBookingDate(int serviceDuration) {
		LocalDate bookingDate = LocalDate.now();
		int dailyWorkHours = 0;
		do {
			dailyWorkHours = serviceDuration;
			List<Booking> bookings = bookingRepository.searchByBookingDate(bookingDate);
			for (Booking booking : bookings) {
				dailyWorkHours += booking.getService().getDuration();
			}
		} while (dailyWorkHours > 10);
		return bookingDate;
	}

	public Booking updateIsDone(Long id) {
		Booking booking = bookingRepository.findById(id).get();
		booking.setDone(true);
		return bookingRepository.save(booking);
	}

}
