package com.cts.ms.wo;

import com.cts.ms.wo.dao.WorkOrderDAO;
import com.cts.ms.wo.service.WorkOrderServiceImpl;
import com.cts.ms.wo.vo.WorkOrder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WorkOrderServiceTest {


    @InjectMocks
    private WorkOrderServiceImpl service;

    @Mock
    private WorkOrderDAO orderDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void thatRespondListOfAvailableResourceWhenRequestingAllAvailableService() {
        int expectedSize = givenReadAllOrder();
        List<WorkOrder> actualWorkOrderName = whenGetAllOrders();
        assertThat(actualWorkOrderName.size(), is(expectedSize));
    }

    private List<WorkOrder> whenGetAllOrders() {
        return service.getWorkOrders();
    }

    private int givenReadAllOrder() {
        List<WorkOrder> workOrderList = new ArrayList();
        workOrderList.add(new WorkOrder("SOME_SERVICE_NAME"));
        Mockito.when(orderDao.getOrders()).thenReturn(workOrderList);
        return workOrderList.size();
    }


}