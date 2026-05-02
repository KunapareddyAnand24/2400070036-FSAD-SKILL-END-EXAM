package com.klef.fsad.exam;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Utility class — builds and holds a single SessionFactory for the app.
 * The SessionFactory is heavyweight; create it once per application lifecycle.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Load hibernate.cfg.xml from the classpath (src/main/resources)
            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();

            Metadata metadata =
                    new MetadataSources(registry)
                            .getMetadataBuilder()
                            .build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            System.err.println("SessionFactory creation FAILED: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    /** Returns the singleton SessionFactory. */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /** Call this on application shutdown to release JDBC connections. */
    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
            System.out.println("Hibernate SessionFactory closed.");
        }
    }
}
