package com.cts.ms.wo.controller;


import com.cts.ms.wo.ServiceEndPoint;
import com.cts.ms.wo.service.WorkOrderService;
import com.cts.ms.wo.vo.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class WorkOrderController {


    @Autowired
    private WorkOrderService workOrderService;

    @RequestMapping(path = ServiceEndPoint.GET_SERVICES, method = GET)
    public List<WorkOrder> getWorkOrders() {
        return workOrderService.getWorkOrders();
    }

    @RequestMapping(path = "/", method = GET)
    public String getIndexPage() {
        return "Welcome";
    }




}
