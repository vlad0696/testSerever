package org.ipps.sisslr.controllers;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.*;
import java.util.List;


public class LicenseController {

    private static SessionFactory getSession(){
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public  static  int pageCount;

    static public   List<Object[]> serviceList;

    public List getLicense(int pageNumber){
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = getSession();
            session = sessionFactory.openSession();
            List obj= session.createSQLQuery("SELECT count(*) FROM sisslr.license WHERE sisslr.license.dateend > now()").list();
            pageCount = Integer.parseInt(obj.get(0).toString());
            List<Object[]> licenseList = session.createSQLQuery("SELECT * FROM sisslr.get_license_list(:page);")
                    .setInteger("page",pageNumber).list();

//            serviceList =   session.createSQLQuery("SELECT license.id, licenseservices.name FROM sisslr.license\n" +
//                    "  INNER JOIN sisslr.licenseservicescross ON sisslr.license.id = sisslr.licenseservicescross.license_id\n" +
//                    "  INNER JOIN sisslr.licenseservices ON sisslr.licenseservices.id= sisslr.licenseservicescross.licenseservices_id\n" +
//                    "WHERE sisslr.licenseservicescross.enddatetime > now() and  (sisslr.licenseservicescross.license_id BETWEEN :licenseIdStart AND :licenseIdEnd) " +
//                    "ORDER BY license.id;")
//                    .setParameter("licenseIdStart", 16369)
//                    .setParameter("licenseIdEnd", 16388)
//                    .list();


            return licenseList;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
    }
        finally {
            assert session != null;
            session.close();
            sessionFactory.close();

        }
        return null;
    }


}
