package it.develhope.shoppyz.Controller;


import it.develhope.shoppyz.order.Order;
import it.develhope.shoppyz.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Shoppyz/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createorder/{accountid}/{isgift}")
    public Order saveOrder(@PathVariable Long accountid,
                           @PathVariable byte isgift) {
        orderService.createOrder(accountid, isgift);
        return orderService.getOrderByAccountId(accountid);
    }
}
