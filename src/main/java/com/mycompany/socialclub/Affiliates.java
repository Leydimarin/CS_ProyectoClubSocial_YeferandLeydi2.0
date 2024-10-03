/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialclub;
import java.util.HashSet;
import java.util.Scanner;
/**
 *
 * @author ESTUDIANTES
 */
public class Affiliates extends Member {
    private String lastName;
    private HashSet<String> namesOfAssociates;


    public Affiliates(String lastName, HashSet<String> namesOfAssociates) {
        this.lastName = lastName;
        this.namesOfAssociates = namesOfAssociates;
    }

    public Affiliates(String lastName, HashSet<String> namesOfAssociates, String name, String id) {
        super(name, id);
        this.lastName = lastName;
        this.namesOfAssociates = namesOfAssociates;
    }
  
    
    public Affiliates() {
        super(" ", " "); 
        this.lastName = "";
        this.namesOfAssociates = new HashSet<>(); 
    }
    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public void listOfPeople(Scanner sc) {
        System.out.println("Enter the names of the associates (max. 10):");
        while (namesOfAssociates.size() < 10) {
            System.out.println("Enter a name (or type 'exit' to finish):");
            String nickname = sc.nextLine();
            if (nickname.equalsIgnoreCase("exit")) {
                break; 
            }
            if (namesOfAssociates.contains(nickname)) {
                System.out.println("The name is already registered. Please enter another.");
            } else {
                namesOfAssociates.add(nickname);  
            }
        }
        System.out.println("Registered users: " + namesOfAssociates);
    }
    public void showInfoAffiliates() {
        System.out.println("===== Affiliates Info =====");
        System.out.println("Registered Associates: " + (namesOfAssociates.isEmpty() ? "No associates registered" : namesOfAssociates));
    }
}
