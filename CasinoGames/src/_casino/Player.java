package _casino;

import java.io.*;
import java.util.Scanner;

public class Player {
    private String name;
    private double balance;

    public Player(String name, double startingBalance) {
        this.name = name;
        this.balance = startingBalance;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void addMoney(double amount) {
        balance += amount;
    }
    public boolean subtractMoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else
            return false;
    }

    public void saveBalance() {
        try (FileWriter fw = new FileWriter("balance.txt")) {
            fw.write(Double.toString(balance));
        }catch (IOException e) {
            System.out.println("Error writing balance: " + e.getMessage());
        }
    }
    public void loadBalance() {
        File file = new File("balance.txt");
        if (file.exists()) {
            try (Scanner sc = new Scanner(file)) {
                balance = sc.nextDouble();
                System.out.println("Loaded Balance: " + balance);
            } catch (IOException e) {
                System.out.println("Error writing balance: " + e.getMessage());
            }
        }
    }
}


