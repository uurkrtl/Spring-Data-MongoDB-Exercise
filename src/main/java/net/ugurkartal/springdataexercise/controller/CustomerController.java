package net.ugurkartal.springdataexercise.controller;

import lombok.AllArgsConstructor;
import net.ugurkartal.springdataexercise.dataaccess.CustomerRepository;
import net.ugurkartal.springdataexercise.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@RequestBody Customer customer) {
            return this.customerRepository.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteCustomer(@PathVariable String id) {
        this.customerRepository.deleteById(id);
    }
}