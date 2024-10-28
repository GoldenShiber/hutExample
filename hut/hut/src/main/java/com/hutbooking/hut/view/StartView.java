package com.hutbooking.hut.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;

@Route("")
public class StartView extends VerticalLayout {

    private final Button bookingButton;
    private final Button checkCurrentBookings;

    public StartView(){
        bookingButton = new Button("If you want to book, click here!");
        bookingButton.addClickListener(e -> bookingButton.getUI().ifPresent(ui -> ui.navigate("choose-customer")));
        checkCurrentBookings = new Button("Check here if you are an admin and want to check the bookings :)");
        checkCurrentBookings.addClickListener(e -> checkCurrentBookings.getUI().ifPresent(ui -> ui.navigate("bookings-list")));
        add(bookingButton);
        add(checkCurrentBookings);

    }

}
