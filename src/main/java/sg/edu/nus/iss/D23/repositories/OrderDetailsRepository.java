package sg.edu.nus.iss.D23.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.D23.models.OrderDetails;

import static sg.edu.nus.iss.D23.repositories.Queries.*;

@Repository
public class OrderDetailsRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDetails getDiscountedOrderDetails(Integer orderId) {
        final List<OrderDetails> orderDetailsList = new LinkedList<>();
        SqlRowSet srs = jdbcTemplate.queryForRowSet(SQL_SELECT_ORDER_DETAILS, orderId);
        while(srs.next()) {
            orderDetailsList.add(OrderDetails.create(srs));
        }
        return orderDetailsList.get(0);
    }
}
