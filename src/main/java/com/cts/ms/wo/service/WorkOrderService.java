package com.cts.ms.wo.service;

import com.cts.ms.wo.vo.WorkOrder;

import java.util.List;

public interface WorkOrderService {
    List<WorkOrder> getWorkOrders();

    WorkOrder getWorkOrderById(int i);

    List<WorkOrder> createOrders(List<WorkOrder> workOrders);

    void updateOrder(Long workOrder);
}
