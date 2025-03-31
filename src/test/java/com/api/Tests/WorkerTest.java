package com.api.Tests;

import com.api.Base.BaseTest;
import com.api.Base.WorkerService;
import com.api.models.requests.workers.WorkerPayload;
import com.api.models.response.workers.WorkerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.reporting.Setup;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Listeners(Setup.class)
public class WorkerTest extends BaseTest {
    @Test
    public void getWorketTest() {
        Response response = WorkerService.getWorker(5);
        String contentType = response.contentType();
        WorkerResponse workerResponse = response.as(WorkerResponse.class);
        String firstName = workerResponse.getFirstName();
        System.out.println(firstName);
    }

    @Test
    public void getAllWorkers() throws IOException {
        Response response = WorkerService.getAllWorkers();
        String sBody = response.getBody().asString();

        ObjectMapper objectMappermapper = new ObjectMapper();
        WorkerResponse[] allWorkers = objectMappermapper.readValue(sBody, WorkerResponse[].class);

        List<WorkerResponse> workerList = Arrays.asList(allWorkers);

        for (WorkerResponse worker : workerList) {
            System.out.println(worker.getId());
            System.out.println(worker.getFirstName());
        }
        JsonPath jsonPath = new JsonPath(sBody);
        List<String> countryList = jsonPath.getList("personAddress.countryCode");
        System.out.println(countryList);
    }
    @Test
    public void createWorker(){
        Response response = WorkerService.createWorker(WorkerPayload.getCreateWorkerPayloadFromPojo());
        ResponseBody Body = response.getBody();
        Assertions.assertThat(response.statusCode()).isEqualTo(201);
    }
}