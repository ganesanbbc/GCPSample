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
    public void thatRespondListOfAvailableResourceWhenRequestingAllAvailableService(){
        String some_service = "some_service";
        Mockito.when(orderDao.getOrders()).thenReturn(new WorkOrder(some_service));

        WorkOrder actualWorkOrderName = service.getWorkOrders();
        assertThat(actualWorkOrderName.getName(), is(some_service));

    }
}