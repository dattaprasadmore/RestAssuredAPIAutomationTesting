package com.api.Routs;

public class WorkerRouts {
    private static final String API = "/api";
    private static final String HR = "/hr";
    private static final String VERSION = "/v2";
    private static final String WORKERS = "/workers";
    private static final String PAGINATION_AND_SORT = "/pageAndSortingWorkers";

    public static String worker(){return API + HR + VERSION + WORKERS;}
    public static String workers(){
        return API + HR + VERSION + WORKERS + "/all";
    }
    public static String addWorker(){return API + HR + VERSION + WORKERS + "/add";}
}