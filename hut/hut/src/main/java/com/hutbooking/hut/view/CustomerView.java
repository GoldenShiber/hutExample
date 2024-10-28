package com.hutbooking.hut.view;


import com.hutbooking.hut.model.Customer;
import com.hutbooking.hut.repository.CustomerRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("customer-list")
public class CustomerView extends VerticalLayout {

    private final CustomerRepository repo;
    final Grid<Customer> grid;
    public CustomerView(CustomerRepository repo){
        this.repo = repo;
        this.grid = new Grid<>(Customer.class);
        add(grid);
        listCustomers();
    }

    private void listCustomers() {
        grid.setItems(repo.findAll());
    }
}
