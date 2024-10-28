package com.hutbooking.hut.view;

import com.hutbooking.hut.model.Booking;
import com.hutbooking.hut.repository.BookingRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("bookings-list")
public class BookingsView extends VerticalLayout {

    private final BookingRepository bookingRepository;

    final Grid<Booking> grid;

    @Autowired
    public BookingsView(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
        this.grid = new Grid<>(Booking.class);
        listBookings();
        add(grid);
        listBookings();
    }

    private void listBookings() {
        grid.setItems(bookingRepository.findAll());
    }
}
