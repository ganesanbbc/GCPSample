package com.cts.ms.wo.controller;

import com.cts.ms.wo.service.WorkOrderService;
import com.cts.ms.wo.vo.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UIController extends WebMvcConfigurerAdapter {


    public static final String INDEX_PAGE = "index";
    public static final String ROOT = "/index";

    Logger logger = Logger.getLogger("UIController");


    @Autowired
    WorkOrderService service;


    @GetMapping(ROOT)
    public String loadIndexPage(Model model) {
        List<WorkOrder> orders = service.getWorkOrders();
//        List<WorkOrder> orders = getStaticWorkOrders();
        model.addAttribute("orders", orders);
        return INDEX_PAGE;
    }


    @RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.POST)
    public void processForm(@PathVariable Long id) {
        logger.warning("WorkOrderID"+id);
        service.updateOrder(id);
    }


    private List<WorkOrder> getStaticWorkOrders() {
        List<WorkOrder> orders = new ArrayList();

        orders.add(new WorkOrder(1, "CustomerName", "cts", "details", "10/10/2017", "open"));
        orders.add(new WorkOrder(2, "CustomerName", "cts", "details", "10/10/2017", "open"));
        orders.add(new WorkOrder(3, "CustomerName", "cts", "details", "10/10/2017", "open"));
        return orders;
    }

}
