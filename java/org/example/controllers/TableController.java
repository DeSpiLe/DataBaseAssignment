package org.example.controllers;

import org.example.models.Table;
import org.example.repositories.interfaces.ITableRepository;

import java.util.List;

public class TableController {
    private final ITableRepository repository;

    public TableController(ITableRepository repository) {
        this.repository = repository;
    }
// новый столик
    public String createTable(short capacity, boolean reserved) {
        Table table = new Table((short) 0, capacity, reserved);
        boolean created = repository.createTable(table);

        return (created ? "Table has been created" : "Table creation failed");
    }
// показать все столы
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
//
    public String reserveTable(short id, String firstName, String secondName, String phonenumber, boolean reserved) {
        boolean reserve = repository.reserveTable(id, firstName, secondName, phonenumber, reserved);
        return (reserve ? "Table has been reserved" : "Table reservation failed");
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

    public String cancelReservationByNameAndSurname(String firstName, String secondName) {
        boolean canceled = repository.cancelReservationByNameAndSurname(firstName, secondName);
        return (canceled ? "Reservation canceled successfully." : "Failed to cancel reservation. No reservation found for the provided name and surname.");
    }

    public String findReservationByNameAndSurname(String firstName, String secondName) {
        String reservationDetails = repository.findReservationByNameAndSurname(firstName, secondName);
        return (reservationDetails != null ? "Reservation details: " + reservationDetails : "No reservation found for the provided name and surname.");
    }


}
