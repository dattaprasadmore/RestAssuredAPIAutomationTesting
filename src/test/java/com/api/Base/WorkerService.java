package com.api.Base;

import com.api.Routs.WorkerRouts;
import io.restassured.response.Response;
import com.api.models.requests.workers.WorkerRequest;
import com.api.restUtils.RestUtils;
import java.util.HashMap;

public class WorkerService{
    public static Response getAllWorkers(){
        String service = WorkerRouts.workers();
        return RestUtils.performGet(service);
    }
    public static Response getWorker(long id){
        String service = WorkerRouts.worker();
        return RestUtils.performGet(service + "/" + id);
    }
    public static Response createWorker(WorkerRequest workerPayload){
        String service = WorkerRouts.addWorker();
        //return RestUtils.performPost(service,createWorkerPayload,  new HashMap<>());
        return RestUtils.performPost(service, workerPayload,  new HashMap<>());
    }
}