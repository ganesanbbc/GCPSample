package com.cts.ms.wo.service;

import com.cts.ms.wo.vo.WorkOrder;
import com.cts.ms.wo.dao.WorkOrderDAO;
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
