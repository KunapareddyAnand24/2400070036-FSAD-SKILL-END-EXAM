package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;


public class ClientDemo {


    public static int insertHospital() {

        System.out.println("\n========================================");
        System.out.println("  OPERATION I : INSERT HOSPITAL RECORD");
        System.out.println("========================================");

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session        = factory.openSession();
        Transaction tx         = null;
        int generatedId        = -1;

        try {
            tx = session.beginTransaction();

            Hospital hospital = new Hospital(
                    "KLEF Super Specialty Hospital",
                    "A leading multi-specialty hospital offering advanced medical care " +
                    "with state-of-the-art technology and experienced professionals.",
                    LocalDate.of(2005, 6, 15),   
                    "Active",                    
                    "Vijayawada, Andhra Pradesh", 
                    "0866-2450100",               
                    "info@klefhospital.ac.in",    
                    500                           
            );

            generatedId = (int) session.save(hospital);

            tx.commit();

            System.out.println("\n[SUCCESS] Hospital record inserted successfully!");
            System.out.println("  Generated Hospital ID : " + generatedId);
            System.out.println("  Hospital Name         : " + hospital.getName());

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("[ERROR] Insert failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return generatedId;
    }


    public static void viewHospitalById(int hospitalId) {

        System.out.println("\n========================================");
        System.out.println("  OPERATION II : VIEW RECORD BY ID = " + hospitalId);
        System.out.println("========================================");

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session        = factory.openSession();

        try {

            Hospital hospital = session.get(Hospital.class, hospitalId);

            if (hospital != null) {
                System.out.println("\n[SUCCESS] Hospital record found:\n");
                System.out.println(hospital);
            } else {
                System.out.println("\n[INFO] No Hospital found with ID: " + hospitalId);
            }

        } catch (Exception e) {
            System.err.println("[ERROR] Retrieval failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("  KLEF FSAD EXAM — Hospital Hibernate Demo");
        System.out.println("  Database : fsadendexam");
        System.out.println("============================================");


        int newId = insertHospital();

        if (newId != -1) {
            viewHospitalById(newId);
        }

        HibernateUtil.shutdown();

        System.out.println("\n============================================");
        System.out.println("  Demo completed successfully.");
        System.out.println("============================================");
    }
}
