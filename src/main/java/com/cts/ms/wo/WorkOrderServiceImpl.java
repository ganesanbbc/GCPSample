package com.cts.ms.wo;

import org.springframework.stereotype.Service;


@Service
public class WorkOrderServiceImpl implements WorkOrderService {
    @Override
    public WorkOrder getWorkOrders() {
        return new WorkOrder("demo");
    }
}
