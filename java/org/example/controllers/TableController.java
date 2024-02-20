package org.example.controllers;

import org.example.models.Table;
import org.example.repositories.interfaces.ITableRepository;

import java.util.List;

public class TableController {
    private final ITableRepository repository;

    public TableController(ITableRepository repository) {
        this.repository = repository;
    }

    public String createTable(String firstName, String secondName, short capacity, String reserved, String phoneNumber) {
        boolean reserve = reserved.equalsIgnoreCase("yes");
        Table table = new Table((short) 0, firstName, secondName, capacity, reserve, phoneNumber, "Normal");
        boolean created = repository.createTable(table);

        return (created ? "Table has been created" : "Table creation failed");
    }


    public String getTable(short id) {
        Table table = repository.getTable(id);
        return (table == null ? "404 Table was not found" : table.toString());
    }

    public String getAllTables() {
        try {
            List<Table> tables = repository.getAllTables();

            StringBuilder response = new StringBuilder();
            for (Table table : tables) {
                response.append(table.toString()).append("\n");
            }
            return response.toString();
        } catch (RuntimeException e) {
            return "Error getting all tables: " + e.getMessage();
        }
    }

    public String reserveTable(short id) {
        boolean reserved = repository.reserveTable(id);
        return (reserved ? "Table has been reserved" : "Table reservation failed");
    }

    public String editTableInfo(short id, String firstName, String secondName, short capacity, String phoneNumber) {
        boolean edited = repository.editInfo(id, firstName, secondName, capacity, phoneNumber);
        return (edited ? "Table information has been updated" : "Failed to update table information");
    }

    public String deleteTable(short id) {
        boolean deleted = repository.deleteTable(id);
        return (deleted ? "Table has been deleted" : "Table deletion failed");
    }

    public String viewReservedTables() {
        try {
            List<Table> reservedTables = repository.getReservedTables();

            StringBuilder response = new StringBuilder("Reserved Tables:\n");
            for (Table table : reservedTables) {
                response.append(table.toString()).append("\n");
            }
            return response.toString();
        } catch (RuntimeException e) {
            return "Error getting reserved tables: " + e.getMessage();
        }
    }

    public String getAvailableTables() {
        try {
            List<Table> tables = repository.getAvailableTables();

            StringBuilder response = new StringBuilder("Available Tables:\n");
            for (Table table : tables) {
                response.append(table.toString()).append("\n");
            }
            return response.toString();
        } catch (RuntimeException e) {
            return "Error getting available tables: " + e.getMessage();
        }
    }

    public String setStatus(short id, String status) {
        boolean result = repository.setStatus(id, status);
        return (result ? "Table status has been updated" : "Failed to update table status");
    }

    public void resetDatabase() {
        try {
            // Очистить таблицу
            boolean cleared = repository.clearTables();
            // Сбросить счетчик автоинкремента
            boolean reset = repository.resetAutoIncrement();
            if (cleared && reset) {
                System.out.println("Database reset successful.");
            }
        } catch (Exception e) {
            System.out.println("Database reset failed: " + e.getMessage());
        }
    }
}
