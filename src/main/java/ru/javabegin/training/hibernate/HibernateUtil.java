package ru.javabegin.training.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// название класса может быть любым
public class HibernateUtil {

    private static SessionFactory sessionFactory; // настройка и работа с сессиями (фабрика сессий)

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder() // получение реестра сервисов
                .configure() // настройки из hibernate.cfg.xml
                .build();
        try {
            // MetadataSources - для работы с метаданными маппинга объектов
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
