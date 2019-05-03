/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testjsf2.testjsf2;


import com.testjsf2.testjsf2.Entities.Utilisateur;
import com.testjsf2.testjsf2.Services.UtilisateurService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import com.users.testuser.testjsf.entities.Configurations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author vipervice
 */
public class testEx {
   // @Autowired
    //UtilisateurService utilisateurService;
//    static Session session;
//    @Autowired
//    public  void setFactory(SessionFactory factory){
//        session=factory.openSession();
//    }
   public static void main(String ...args){
       System.out.println("Salop");
//         StringBuffer query= new StringBuffer();
//    query.append("SELECT u FROM Utilisateur u");
//        List<Utilisateur> utilisateur=session.createQuery(query.toString()).list();
//        System.out.println(utilisateur.size());
      // WebApplicationContext context=ContextLoader.getCurrentWebApplicationContext();
       ApplicationContext ctx=new AnnotationConfigApplicationContext(Configurations.class);
       // SessionFactory sessionFactory=(SessionFactory) ctx.getBean("sessionFactory");
       // System.out.println( "Hello World!" );
       
//    Utilisateurs user=(Utilisateurs) ctx.getBean(Utilisateurs.class);
//  // int e = user.getNbUsers();
//       // System.out.println( e );
//       user.setNom("rosty");
//        System.out.println(user.getNom());
//      // return user.getNom();
 UtilisateurService user=(UtilisateurService) ctx.getBean(UtilisateurService.class);
  // int e = user.getNbUsers();
       // System.out.println( e );
     //  user.setNom("rosty");
      Utilisateur user1= user.getUtilisateurs().get(0);
      System.out.println(user1.getEmail());
   } 
}
