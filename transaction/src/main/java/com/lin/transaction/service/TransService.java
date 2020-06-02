package com.lin.transaction.service;

import com.lin.transaction.hibernate.Contact;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Properties;

@Service
public class TransService {
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }



    @Transactional(rollbackFor = {Exception.class})
    public void testInsert(Contact contact) throws Exception{
        Session session=sessionFactory.openSession();
        session.save(contact);
//        throw new NullPointerException("haha");

    }


    public void printOut() {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            // Fetching saved data
            List<Contact> contactList = session.createQuery("from Contact").list();

            for (Contact contact : contactList) {
                System.out.println("Id: " + contact.getId() + " | Name:" + contact.getName() + " | Email:" + contact.getEmail());
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TransService transService= new TransService();
        // Configure the session factory
        configureSessionFactory();
        Contact c = new Contact(4, "guanjun", "songlin@email.com");
//        transService.testInsert(c);
        transService.printOut();


    }




    public void doSomething(){
        doSomething3();
    }

    @Transactional
    public void doSomething2(){
        doSomething3();
    }

    @Transactional
    public void doSomething3() {
        TransactionStatus status=null;
        try {
            status = TransactionAspectSupport.currentTransactionStatus();
        } catch (NoTransactionException e) {
            System.err.println(e);
        }
        System.out.println(status!=null? "active transaction": "no transaction");

    }
}
