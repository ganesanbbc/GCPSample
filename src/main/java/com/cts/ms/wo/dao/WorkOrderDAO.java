package com.cts.ms.wo.dao;

import com.cts.ms.wo.vo.WorkOrder;
import org.springframework.stereotype.Repository;

@Repository
public class WorkOrderDAO {
    public WorkOrder getOrders() {
        return new WorkOrder("demo");
    }
}
