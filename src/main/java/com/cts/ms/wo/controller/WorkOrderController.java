package com.cts.ms.wo.controller;


import com.cts.ms.wo.ServiceEndPoint;
import com.cts.ms.wo.service.WorkOrderService;
import com.cts.ms.wo.vo.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @RequestMapping(path = ServiceEndPoint.GET_SERVICE, method = GET)
    public WorkOrder getWorkOrder() {
        return workOrderService.getWorkOrderById(0);
    }

    @RequestMapping(path = ServiceEndPoint.POST_ORDERS, method = POST)
    public ResponseEntity<List<WorkOrder>> createWorkOrders(@RequestBody List<WorkOrder> workOrderList) {
        if (workOrderList ==null || workOrderList.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        List<WorkOrder> proceededOrders = workOrderService.createOrders(workOrderList);
        return ResponseEntity.status(HttpStatus.OK).body(proceededOrders);
    }






}
