package com.cts.ms.wo.dao;

import com.cts.ms.wo.vo.WorkOrder;
import com.google.cloud.datastore.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class WorkOrderDAO {

    public static final String TABLE_NAME = "WorkOrder";

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    private final KeyFactory keyFactory = datastore.newKeyFactory().setKind(TABLE_NAME);


    public List<WorkOrder> getOrders() {
        List<WorkOrder> workOrderList = new ArrayList();


        Query<Entity> query =
                Query.newEntityQueryBuilder().setKind(TABLE_NAME).build();

        Iterator<Entity> result = datastore.run(query);

        while (result.hasNext()) {
            Entity task = result.next();
            String name = task.getString("name");
            workOrderList.add(new WorkOrder(name));
        }

        return workOrderList;
    }

    public WorkOrder getOrderById(int i) {
        return new WorkOrder("");
    }

    public List<WorkOrder> createWorkOrder(List<WorkOrder> workOrderList) throws DatastoreException {

        for (WorkOrder workOrder : workOrderList) {
            Key key = datastore.allocateId(keyFactory.newKey());
            Entity task = Entity.newBuilder(key)
                    .set("name", workOrder.getName())
                    .set("customerid", workOrder.getCustomerid())
                    .set("details", workOrder.getDetails())
                    .set("start_date", workOrder.getStart_date())
                    .build();
            datastore.put(task);

        }


        return workOrderList;
    }
}
