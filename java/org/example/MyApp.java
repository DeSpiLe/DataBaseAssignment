package org.example;

import org.example.controllers.TableController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApp {
    private final TableController controller;
    private final Scanner scanner;
    private final String ADMIN_PASSWORD = "0000";

    public MyApp(TableController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning = true;
        boolean isAdmin = false;
        while (isRunning) {
            System.out.println("Welcome to Application For Reserving Tables :)");
            System.out.println("Select user type:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter user type (0-2): ");
                int userType = scanner.nextInt();
                switch (userType) {
                    case 0:
                        isRunning = false;
                        break;
                    case 1:
                        System.out.println("Enter admin password: ");
                        String adminPassword = scanner.next();
                        if (adminPassword.equals(ADMIN_PASSWORD)) {
                            isAdmin = true;
                            adminMenu();
                        } else {
                            System.out.println("Incorrect password. Try again.");
                        }
                        break;
                    case 2:
                        userMenu();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer: " + e);
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");
        }
    }

    private void adminMenu() {
        boolean isAdminMenuRunning = true;
        while (isAdminMenuRunning) {
            System.out.println("Admin Menu:");
            System.out.println("1. Get all tables");
            System.out.println("2. Add table");
            System.out.println("3. Set status for table");
            System.out.println("4. Delete table");
            System.out.println("5. View reserved tables");
            System.out.println("0. Back to main menu");
            System.out.println();
            try {
                System.out.println("Enter option (0-4): ");
                int adminOption = scanner.nextInt();
                switch (adminOption) {
                    case 0:
                        isAdminMenuRunning = false;
                        break;
                    case 1:
                        getAllTablesMenu();
                        break;
                    case 2:
                        createTableMenu();
                        break;
                    case 3:
                        setStatus();
                        break;
                    case 4:
                        deleteTableById();
                        break;
                    case 5:
                        viewReservedTables();
                        break;
                    case 13:
                        restart();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer: " + e);
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");
        }
    }


    private void restart() {
        controller.resetDatabase();
        System.out.println("Database reset successful.");
    }

    private void userMenu() {
        boolean isUserMenuRunning = true;
        while (isUserMenuRunning) {
            System.out.println("User Menu:");
            System.out.println("1. View available tables");
            System.out.println("2. Reserve a table");
            System.out.println("3. Cancel table reservation");
            System.out.println("4. Find reservation by name and surname");
            System.out.println("0. Back to main menu");
            System.out.println();
            try {
                System.out.println("Enter option (0-4): ");
                int userOption = scanner.nextInt();
                switch (userOption) {
                    case 0:
                        isUserMenuRunning = false;
                        break;
                    case 1:
                        viewAvailableTables();
                        break;
                    case 2:
                        reserveTable();
                        break;
                    case 3:
                        cancelReservationByNameAndSurname();
                        break;
                    case 4:
                        findReservationByNameAndSurname();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer: " + e);
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");
        }
    }

    private void cancelReservationByNameAndSurname() {
        System.out.println("Please enter your name:");
        String name = scanner.next();
        System.out.println("Please enter your surname:");
        String surname = scanner.next();
        String response = controller.cancelReservationByNameAndSurname(name, surname);
        System.out.println(response);
    }

    private void findReservationByNameAndSurname() {
        System.out.println("Please enter your name:");
        String name = scanner.next();
        System.out.println("Please enter your surname:");
        String surname = scanner.next();
        String response = controller.findReservationByNameAndSurname(name, surname);
        System.out.println(response);
    }

    private void setStatus(){
        System.out.println("Please enter the id");
        short id = scanner.nextShort();
        System.out.println("Please enter the status");
        String status = scanner.next();
        String response = controller.setStatus(id, status);
        System.out.println(response);
    }

    private void getAllTablesMenu() {
        String response = controller.getAllTables();
        System.out.println(response);
    }

    private void createTableMenu() {
        System.out.println("How many people can be behind a table");
        short capacity = scanner.nextShort();
        boolean reserved = false;
        String response = controller.createTable(capacity, reserved);
        System.out.println(response);
    }

    private void deleteTableById() {
        System.out.println("Please enter number(id) of table");
        short id = scanner.nextShort();
        String response = controller.deleteTable(id);
        System.out.println(response);
        scanner.nextLine();
    }

    private void viewAvailableTables() {
        String response = controller.getAvailableTables();
        System.out.println(response);
    }

    private void reserveTable() {
        System.out.println("Please enter number(id) of the table you want to reserve:");
        short id = scanner.nextShort();
        System.out.println("Please enter your name");
        String name = scanner.next();
        System.out.println("Please enter your surname");
        String surname = scanner.next();
        System.out.println("Please enter your phone number");
        String phonenumber = scanner.next();
        boolean reserved = true;
        String response = controller.reserveTable(id, name, surname, phonenumber, reserved);
        System.out.println(response);
    }

    private void viewReservedTables() {
        String response = controller.viewReservedTables();
        System.out.println(response);
    }

}
