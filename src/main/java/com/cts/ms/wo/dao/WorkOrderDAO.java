package com.cts.ms.wo.dao;

import com.cts.ms.wo.vo.WorkOrder;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class WorkOrderDAO {

    public static final String TABLE_NAME = "WorkOrder";

    public List<WorkOrder> getOrders() {
         List<WorkOrder> workOrderList = new ArrayList();

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
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

    public List<WorkOrder> createWorkOrder(List<WorkOrder> workOrderList) {
        return workOrderList;
    }
}
