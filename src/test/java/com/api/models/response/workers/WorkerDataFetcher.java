package com.api.models.response.workers;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;

public class WorkerDataFetcher {

    private final Jdbi jdbi;
    //private static final ThreadLocal<WorkerResponseRowMapper> rowMapperThreadLocal = ThreadLocal.withInitial(WorkerResponseRowMapper::new);
    public WorkerDataFetcher(Jdbi jdbi) {
        this.jdbi = jdbi;
    }
    public Optional<WorkerResponse> getWorkerById(int workerId) {
        return jdbi.withHandle(handle -> {
            WorkerResponse worker = (WorkerResponse) handle.createQuery(
                            "SELECT w.id, " +
                                    "w.aoid, " +
                                    "w.first_name, " +
                                    "w.last_name, " +
                                    "pa.address_id, " +
                                    "pa.building_name, " +
                                    "pa.city_name, " +
                                    "pa.country_code, " +
                                    "pa.postal_code, " +
                                    "pa.state, " +
                                    "pa.street_name, " +
                                    "pc.person_comm_id," +
                                    "pc.emails, " +
                                    "pc.landline, " +
                                    "pc.mobile " +
                                    "FROM worker w " +
                                    "LEFT JOIN person_address pa " +
                                    "ON w.fk_add_id=pa.address_id " +
                                    "LEFT JOIN person_communication pc " +
                                    "ON w.fk_add_id = pc.person_comm_id " +
                                    "WHERE w.id = :workerId")
                    .bind("workerId", workerId)
                    .map(new WorkerResponseRowMapper()) // This is thread-safe because of the thread-local handle
                    .findFirst()
                    .orElse(null);

            return Optional.ofNullable(worker);
        });
    }
    public List<WorkerResponse> getAllWorkers() {
        List<WorkerResponse> workerDataList=null;
        try (Handle handle = jdbi.open()) {
            workerDataList = handle.createQuery("SELECT w.id, " +
                            "w.aoid, " +
                            "w.first_name, " +
                            "w.last_name, " +
                            "pa.address_id, " +
                            "pa.building_name, " +
                            "pa.city_name, " +
                            "pa.country_code, " +
                            "pa.postal_code, " +
                            "pa.state, " +
                            "pa.street_name, " +
                            "pc.person_comm_id," +
                            "pc.emails, " +
                            "pc.landline, " +
                            "pc.mobile " +
                            "FROM worker w " +
                            "LEFT JOIN person_address pa " +
                            "ON w.fk_add_id=pa.address_id " +
                            "LEFT JOIN person_communication pc " +
                            "ON w.fk_add_id = pc.person_comm_id ")
                    .map(new WorkerResponseRowMapper())
                    .list();
            return workerDataList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workerDataList;
    }
}