package com.cts.ms.wo.controller;

import com.cts.ms.wo.service.WorkOrderService;
import com.cts.ms.wo.vo.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UIController extends WebMvcConfigurerAdapter {


    public static final String INDEX_PAGE = "index";
    public static final String ROOT = "/";


    @Autowired
    WorkOrderService service;


    @GetMapping(ROOT)
    public String loadIndexPage(Model model) {
//        List<WorkOrder> orders = service.getWorkOrders();
        List<WorkOrder> orders = getStaticWorkOrders();

        model.addAttribute("orders", orders);
        return INDEX_PAGE;
    }

    private List<WorkOrder> getStaticWorkOrders() {
        List<WorkOrder> orders = new ArrayList();

        orders.add(new WorkOrder("name1"));
        orders.add(new WorkOrder("name2"));
        return orders;
    }

}
