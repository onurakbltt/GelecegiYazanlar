package com.turkcell.BilgisayarTeknikServisi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.BilgisayarTeknikServisi.model.Booking;
import com.turkcell.BilgisayarTeknikServisi.service.BookingService;
import com.turkcell.BilgisayarTeknikServisi.service.ServiceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "booking")
@AllArgsConstructor
public class BookingController {

	private BookingService bookingService;
	private ServiceService serviceService;

	@PostMapping(path = "/save")
	public Booking save(@RequestBody Booking booking) {
		// {"service":{"id": 1}, "user" : {"id": 2}, "note" : "deneme3" } json
		booking.setService(serviceService.findById(booking.getService().getId()));
		return bookingService.createBooking(booking);
	}

	@GetMapping(path = "/getById/{id}")
	public Booking getById(@PathVariable(name = "id") Long id) {
		return bookingService.getById(id);
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
		bookingService.deleteById(id);
		return ResponseEntity.ok("Başarı ile silindi");
	}

	@PutMapping(path = "/update/{id}")
	public Booking update(@PathVariable(name = "id") Long id) {
		return bookingService.updateIsDone(id);
	}

	@GetMapping(path = "/getAll")
	public List<Booking> getAll() {
		return bookingService.getAll();
	}

	@GetMapping(path = "/getAllByOrderByBookingDateAsc")
	public List<Booking> getAllByOrderByBookingDateAsc() {
		return bookingService.getAllByOrderByBookingDateAsc();
	}

	@GetMapping(path = "/getAllByOrderByBookingDateDesc")
	public List<Booking> getAllByOrderByBookingDateDesc() {
		return bookingService.getAllByOrderByBookingDateDesc();
	}

	@GetMapping(path = "/searchByName")
	public List<Booking> searchByName(@RequestParam(name = "name") String name) {
		return bookingService.findNameLike(name);
	}

}
