package org.example.repositories.interfaces;

import org.example.models.Table;

import java.util.List;

public interface ITableRepository {
 boolean createTable(Table table);
 Table getTable(short id);
 List<Table> getAllTables();
 boolean reserveTable(short id, String firstName, String secondName, String phonenumber, boolean reserved);
 boolean editInfo(short id, String firstName, String secondName, short capacity, String phoneNumber);
 boolean deleteTable(short id);
 List<Table> getReservedTables(); // Новый метод для получения зарезервированных столов
 List<Table> getAvailableTables(); // Новый метод для получения доступных столов
 boolean setStatus(short id, String status);
 boolean clearTables();
 boolean resetAutoIncrement();
}
