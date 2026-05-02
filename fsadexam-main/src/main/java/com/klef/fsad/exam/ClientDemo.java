package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Vehicle.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== VEHICLE MENU =====");
            System.out.println("1. Insert Vehicle");
            System.out.println("2. View Vehicle by ID");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            // 🔹 INSERT
            if (choice == 1) {

                session.beginTransaction();

                System.out.print("Enter Name: ");
                String name = sc.next();

                System.out.print("Enter Type: ");
                String type = sc.next();

                System.out.print("Enter Description: ");
                String desc = sc.next();

                System.out.print("Enter Status: ");
                String status = sc.next();

                Vehicle v = new Vehicle(name, type, desc, new Date(), status);
                session.persist(v);

                session.getTransaction().commit();
                System.out.println("✅ Vehicle Inserted!");

            }

            // 🔹 VIEW
            else if (choice == 2) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                Vehicle v = session.get(Vehicle.class, id);

                if (v != null) {
                    System.out.println("ID: " + v.getId());
                    System.out.println("Name: " + v.getName());
                    System.out.println("Type: " + v.getType());
                    System.out.println("Description: " + v.getDescription());
                    System.out.println("Date: " + v.getManufactureDate());
                    System.out.println("Status: " + v.getStatus());
                } else {
                    System.out.println("❌ Vehicle Not Found!");
                }
            }

            // 🔹 UPDATE
            else if (choice == 3) {

                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();

                session.beginTransaction();

                Vehicle v = session.get(Vehicle.class, id);

                if (v != null) {
                    System.out.print("Enter New Name: ");
                    v.setName(sc.next());

                    System.out.print("Enter New Type: ");
                    v.setType(sc.next());

                    System.out.print("Enter New Description: ");
                    v.setDescription(sc.next());

                    System.out.print("Enter New Status: ");
                    v.setStatus(sc.next());

                    session.merge(v);

                    System.out.println("✅ Vehicle Updated!");
                } else {
                    System.out.println("❌ Vehicle Not Found!");
                }

                session.getTransaction().commit();
            }

            // 🔹 DELETE
            else if (choice == 4) {

                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();

                session.beginTransaction();

                Vehicle v = session.get(Vehicle.class, id);

                if (v != null) {
                    session.remove(v);
                    System.out.println("✅ Vehicle Deleted!");
                } else {
                    System.out.println("❌ Vehicle Not Found!");
                }

                session.getTransaction().commit();
            }
            
         // 🔹 EXIT
            else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("❌ Invalid Choice!");
            }
        }

        session.close();
        factory.close();
        sc.close();
    }
}