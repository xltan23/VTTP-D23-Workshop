package sg.edu.nus.iss.D23.repositories;

public class Queries {
    public static final String SQL_SELECT_ORDER_DETAILS = """
            SELECT 
            o.id as order_id,
            o.customer_id as customer_id,
            DATE_FORMAT(o.order_date, \"%d/%m/%Y\") as order_date,
            sum(od.quantity * od.unit_price) as total_price,
            sum(od.quantity * od.unit_price * od.discount) as discount,
            sum(od.quantity * od.unit_price) - sum(od.quantity * od.unit_price * od.discount) as discounted_price,
            sum(od.quantity * p.standard_cost) as cost_price
            FROM
            orders o
            LEFT JOIN order_details od
            ON o.id = od.order_id
            LEFT JOIN products p
            ON od.product_id = p.id
            WHERE o.id = ?;
            """;
}
