package com.api.Tests;

import com.api.Base.BaseTest;
import com.api.Base.WorkerService;
import com.api.models.response.workers.WorkerDataFetcher;
import com.api.models.response.workers.WorkerResponse;
import io.restassured.response.Response;
import org.jdbi.v3.core.Jdbi;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.utils.DBUtils;

import java.util.List;

public class DBTest extends BaseTest {
    @Test
    public static void ValidatWorkers() {
            DBUtils dbUtils = new DBUtils();
            Jdbi jdbi = dbUtils.openConnection();

            Response response = WorkerService.getAllWorkers();
            List<WorkerResponse> apiWorkers = response.jsonPath().getList(".", WorkerResponse.class);

            WorkerDataFetcher fetcher = new WorkerDataFetcher(jdbi);
            List<WorkerResponse> databaseWorkers = fetcher.getAllWorkers();

            for(int i=0; i<apiWorkers.size(); i++){
                WorkerResponse apiWorker = apiWorkers.get(i);
                WorkerResponse databaseWorker = databaseWorkers.get(i);
                Assert.assertEquals(apiWorker, databaseWorker, "NOT Matched");
                System.out.println("*********************************************************************************");
                System.out.println(apiWorker.getId() + " MATCHED Successfully");
            }
    }
}