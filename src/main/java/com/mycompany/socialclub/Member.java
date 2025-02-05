/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialclub;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTES
 */
public class Member {
    private static final int Treg = 1000000;
    private static final int Tvip = 5000000;

    private String name;
    private String id;
    private int availableFunds; 
    private String subscription; 
    private int pendingInvoices;
    protected HashSet<String> namesOfAssociates;
    private ArrayList<Member> userList;

    public Member() {
        this.userList = new ArrayList<>();
        this.namesOfAssociates = new HashSet<>();
        this.pendingInvoices = 0;
        this.availableFunds = 0;
    }

    public Member(String name, String id) {
        this.namesOfAssociates = new HashSet<>();
        this.name = name;
        this.id = id;
        this.pendingInvoices = 0;
        this.availableFunds = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAvailableFunds() {
        return availableFunds; 
    }

    public void setAvailableFunds(int availableFunds) {
        this.availableFunds = availableFunds; 
    }

    public String getSubscription() {
        return subscription; 
    }

    public void setSubscription(String subscription) { 
        this.subscription = subscription; 
    }

    public int getPendingInvoices() {
        return pendingInvoices; 
    }

    public void setPendingInvoices(int pendingInvoices) { 
        this.pendingInvoices = pendingInvoices; 
    }

    public void enterNameAndId(Scanner sc) {
        System.out.println("Enter the user's name:");
        String name = sc.nextLine();
        System.out.println("Enter the user's ID:");
        String id = sc.nextLine();

        for (Member member : userList) {
            if (member.getId().equals(id)) {
                System.out.println("The ID already exists, please enter another.");
                return;
            }
        }

        Member newUser = new Member(name, id);
        userList.add(newUser);
        System.out.println("User added: " + name);
    }

    public void showUsers() {
        System.out.println("List of Users:");
        for (Member member : userList) {
            System.out.println("Name: " + member.getName() + ", ID: " + member.getId());
            System.out.println("Subscription: " + this.subscription);
            System.out.println("Funds: " + this.availableFunds);
        }
    }

    public void availableFunds(Scanner sc) {
        System.out.println("ENTER SUBSCRIPTION AMOUNT: ");
        this.availableFunds = sc.nextInt();

        if (this.availableFunds < 50000) {
            System.out.println("--NO FUNDS--");
            return;
        }

        if (this.availableFunds < 100000) {
            this.subscription = "REGULAR";
            System.out.println("--REGULAR--");
            handleFunds(sc, Treg);
        } else if (this.availableFunds < Tvip) {
            this.subscription = "VIP";
            System.out.println("--VIP--");
            handleFunds(sc, Tvip);
        } else {
            System.out.println("--UNRECOGNIZED AMOUNT--");
        }
    }

    private void handleFunds(Scanner sc, int limit) {
        System.out.println("Would you like to add new funds? (yes/no)");
        String response = sc.next();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter your new funds (up to " + limit + "):");
            int newFunds = sc.nextInt();

            if (this.availableFunds + newFunds > limit) {
                System.out.println("Your funds exceed the allowed limit.");
            } else {
                this.availableFunds += newFunds;
                System.out.println("Funds added successfully. Total funds: " + this.availableFunds);
            }
        } else {
            System.out.println("OK, thank you....");
        }
    }

    public void pendingInvoices() {
        if (pendingInvoices == 0) {
            System.out.println("--YOUR ACCOUNT HAS NO PENDING INVOICES--");
        } else {
            System.out.println("Pending invoices: " + pendingInvoices);
        }
    }
}
