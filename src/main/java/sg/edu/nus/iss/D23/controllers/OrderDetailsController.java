package sg.edu.nus.iss.D23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.D23.models.OrderDetails;
import sg.edu.nus.iss.D23.services.OrderDetailsService;

@RestController
@RequestMapping(path = "/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsController {
    
    @Autowired
    private OrderDetailsService orderDetailsSvc;

    @GetMapping(path = "{orderId}")
    public ResponseEntity<String> getAllOrderDetails(@PathVariable Integer orderId) {
        OrderDetails orderDetails = orderDetailsSvc.getOrderDetails(orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderDetails.toJSON().toString()); 
    }
}
