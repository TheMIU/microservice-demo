package lk.ijse.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String get() {
        return "Customer get method invoked";
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        System.out.println("customer save invoke");
        System.out.println("send to orders API end point");
        return restTemplate.postForObject("http://localhost:8082/app/order/save", customer, Customer.class);
    }
}
