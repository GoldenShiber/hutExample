package com.hutbooking.hut.view;

import com.hutbooking.hut.model.Customer;
import com.hutbooking.hut.repository.CustomerRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("choose-customer")
public class ChooseCustomerView extends VerticalLayout {
    private final Customer customer;

    private final CustomerRepository customerRepository;

    /* Fields to edit properties in Customer entity */
    TextField name = new TextField("First name");
    TextField phoneNumber = new TextField("Email");
    // Enter customer information
    private final Button finishedButton;


    @Autowired
    public ChooseCustomerView(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
        finishedButton = new Button("Press to continue!");
        name.setRequired(true);
        phoneNumber.setRequired(true);
        customer = new Customer(name.getValue(), phoneNumber.getValue());
        add(name, phoneNumber);
        add(finishedButton);
        finishedButton.addClickListener(e -> onCustomerFinished());

    }

    private void onCustomerFinished(){
        if(name.getValue().isEmpty() || phoneNumber.getValue().isEmpty()){
            Notification.show("Please fill in name and phone number!");
        } else {
            customerRepository.save(customer);
            finishedButton.getUI().ifPresent(ui -> ui.navigate("choose-hut/" + customer.getId()));
        }

    }


}
