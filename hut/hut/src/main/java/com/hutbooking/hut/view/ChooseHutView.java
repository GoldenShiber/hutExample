package com.hutbooking.hut.view;

import com.hutbooking.hut.model.Booking;
import com.hutbooking.hut.model.Hut;
import com.hutbooking.hut.repository.BookingRepository;
import com.hutbooking.hut.repository.HutRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Route("choose-hut")
public class ChooseHutView extends VerticalLayout implements HasUrlParameter<String> {

    // Let customer choose hut based on information
    final Grid<Hut> grid;

    private final HutRepository hutRepository;

    private final BookingRepository bookingRepository;
    private final Button finishedButton;

    private final DatePicker startDate;
    private final DatePicker endDate;

    private Long customerId;

    TextField name = new TextField("Which Hut do you want?");

    @Autowired
    ChooseHutView(HutRepository hutRepository, BookingRepository bookingRepository){
        this.hutRepository = hutRepository;
        this.bookingRepository = bookingRepository;
        name.setRequired(true);
        finishedButton = new Button("Have you decided?");
        startDate = new DatePicker("When are you arriving?");
        endDate = new DatePicker("When are you leaving?");

        this.grid = new Grid<>(Hut.class);
        add( name, startDate, endDate, finishedButton);
        add(grid);
        listHuts();
        finishedButton.addClickListener(e -> onFinishedAction());

    }

    private void listHuts() {
        grid.setItems(hutRepository.findAll());
    }

    private void onFinishedAction(){
        if(name.getValue().isEmpty() || startDate.isEmpty() || endDate.isEmpty() || startDate.getValue().isAfter(endDate.getValue())){
            Notification.show("Fill in hut code, or choose a start date which is before the end date!");
        } else {
            bookingRepository.save(new Booking(Timestamp.valueOf(startDate.getValue().atStartOfDay()), Timestamp.valueOf(endDate.getValue().atStartOfDay()),
                    customerId, Long.parseLong(name.getValue())));
            finishedButton.getUI().ifPresent(ui -> ui.navigate("thank-you"));
        }
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        customerId = Long.parseLong(s);
    }
}
