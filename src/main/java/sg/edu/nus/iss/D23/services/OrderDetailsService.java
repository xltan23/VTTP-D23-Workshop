package sg.edu.nus.iss.D23.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.D23.models.OrderDetails;
import sg.edu.nus.iss.D23.repositories.OrderDetailsRepository;

@Service
public class OrderDetailsService {
    
    @Autowired
    private OrderDetailsRepository orderDetailsRepo;

    public OrderDetails getOrderDetails(Integer orderId) {
        return orderDetailsRepo.getDiscountedOrderDetails(orderId);
    }
}
