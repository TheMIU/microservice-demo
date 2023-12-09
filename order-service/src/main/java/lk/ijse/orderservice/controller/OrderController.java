package lk.ijse.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping
    public String get() {
        return "Orders get method invoked";
    }

    ///////////////////////////////////

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("to-customer")
    public String test() {
        return restTemplate.getForObject("http://localhost:8081/app/customer", String.class);

        // post request ,,,
        // return restTemplate.postForObject("http://localhost:8082/app/order/save", User, ResponseUtil);
    }

    ////////////////////////
    @PostMapping("/save")
    public Customer getCustomer(@RequestBody Customer customer) {
        System.out.println("invoked");
        customer.setName("John");
        return customer;
    }
}