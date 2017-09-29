package org.ipps.sisslr.controllers;


import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.ipps.sisslr.models.License;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/example")
public class ExampleController {


//    public static void initialization()
//    {
//        System.out.println("initialization");
//        try
//        {
//            Configuration myConfiguration = new
//                    Configuration();
//
//            myConfiguration
//                    .addClass(org.ipps.sisslr.models.Street.class)
//            .addClass(org.ipps.sisslr.models.AdministrativeTerritories.class);
//
//
//            // Load the *.hbm.xml files as set in the
//            // config, and set the dialect.
//            new SchemaUpdate(myConfiguration)
//                    .execute(true, true);
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

    public List getLicense(){
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = getSession();

            session = sessionFactory.openSession();
            List list= session.createCriteria(License.class).list();
            return list;
        }
        catch (Exception e){
            System.out.println(e);
        }
        //Test
        //asdasdasdasdasdas
        finally {
            session.close();
            sessionFactory.close();

        }
        return null;
    }



    public Object parseRequest(HttpServletRequest request){
        SessionFactory sessionFactory = null;
        Session session = null;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            sessionFactory = getSession();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            License license = (License) session.get(License.class, id);
            tx.commit();
            return license;
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public  void deleteLicense( License license, HttpServletResponse response){

        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = getSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(license);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public  void addLicense( License license, HttpServletResponse response){

        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = getSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(license);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public  void updateLicense( License license, HttpServletResponse response){
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = getSession();
            session = sessionFactory.openSession();
            session.beginTransaction();

            System.out.println(license.toString());
        //    session.save(user);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            System.out.println(license.toString());
            session.update(license);


            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public  void updateLicense(String data, HttpServletResponse response) throws IOException {

        response.getWriter().write(data);
    }

    @RequestMapping(value = "/JSON", method = RequestMethod.GET)
    public  void getJSON(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = getSession();

            session = sessionFactory.openSession();
            List list= session.createCriteria(License.class).list();
            Gson g = new Gson();
            response.getWriter().write(g.toJson(list));
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }

    static SessionFactory getSession(){
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
