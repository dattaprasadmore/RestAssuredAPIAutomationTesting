package com.api.models.response.workers;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerResponseRowMapper implements RowMapper {
    @Override
    public WorkerResponse map(ResultSet rs, StatementContext ctx) throws SQLException {

        WorkerResponse worker = new WorkerResponse();
        worker.setId(rs.getInt("id"));
        worker.setFirstName(rs.getString("first_name"));
        worker.setLastName(rs.getString("last_name"));
        worker.setAoid(rs.getString("aoid"));

        WorkerResponse.PersonAddress address = new WorkerResponse.PersonAddress();
        address.setAddressId(rs.getInt("address_id"));
        address.setBuildingName(rs.getString("building_name"));
        address.setStreetName(rs.getString("street_name"));
        address.setCityName(rs.getString("city_name"));
        address.setState(rs.getString("state"));
        address.setCountryCode(rs.getString("country_code"));
        address.setPostalCode(rs.getString("postal_code"));
        worker.setPersonAddress(address);

        WorkerResponse.PersonCommunication communication = new WorkerResponse.PersonCommunication();
        communication.setPersonCommId(rs.getInt("person_comm_id"));
        communication.setEmails(rs.getString("emails"));
        communication.setLandline(rs.getString("landline"));
        communication.setMobile(rs.getString("mobile"));
        worker.setPersonCommunication(communication);

        return worker;
    }
}