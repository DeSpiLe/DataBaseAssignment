package org.example.repositories.interfaces;

import org.example.models.Table;

import java.util.List;

public interface ITableRepository {
 boolean createTable(Table table);

 Table getTable(short id);

 List<Table> getAllTables();

 boolean reserveTable(short id, String firstName, String secondName, String phoneNumber, boolean reserved);

 boolean editInfo(short id, String firstName, String secondName, short capacity, String phoneNumber);

 boolean deleteTable(short id);

 List<Table> getReservedTables();

 List<Table> getAvailableTables();

 boolean setStatus(short id, String status);

 boolean clearTables();

 boolean resetAutoIncrement();

 boolean cancelReservationByNameAndSurname(String firstName, String secondName);

 String findReservationByNameAndSurname(String firstName, String secondName);
}
