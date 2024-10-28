package com.hutbooking.hut.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("thank-you")
public class ThankYou extends VerticalLayout {

    private final Button homeButton;

    ThankYou(){
        homeButton = new Button("Home");
        Text text = new Text("Thank you, you have successfully booked a hut, confirmation is coming on the email!");
        add(text, homeButton);
        homeButton.addClickListener(e -> homeButton.getUI().ifPresent(ui -> ui.navigate("")));
    }
}
