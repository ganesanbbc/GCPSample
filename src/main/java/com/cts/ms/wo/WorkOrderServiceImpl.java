package com.cts.ms.wo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WorkOrderServiceImpl implements WorkOrderService {


    @Autowired
    WorkOrderDAO workOrderDAO;

    @Override
    public WorkOrder getWorkOrders() {
        return workOrderDAO.getOrders();
    }
}
