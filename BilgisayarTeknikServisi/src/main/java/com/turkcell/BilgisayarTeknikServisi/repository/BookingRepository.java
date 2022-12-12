package com.turkcell.BilgisayarTeknikServisi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.BilgisayarTeknikServisi.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	public List<Booking> findAllByOrderByBookingDateAsc();

	public List<Booking> searchByBookingDate(LocalDate bookingDate);

	public List<Booking> findAllByOrderByBookingDateDesc();

	public List<Booking> findByUserNameLike(String name);

}
