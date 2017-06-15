package com.cts.ms.wo;

import org.springframework.stereotype.Repository;

@Repository
public class WorkOrderDAO {
    public WorkOrder getOrders() {
        return new WorkOrder("demo");
    }
}
