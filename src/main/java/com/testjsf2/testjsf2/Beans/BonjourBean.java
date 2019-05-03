/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testjsf2.testjsf2.Beans;


//import com.users.testuser.testjsf.entities.Configurations;
import com.testjsf2.testjsf2.ContextInit;
import com.testjsf2.testjsf2.Entities.Utilisateur;
import com.testjsf2.testjsf2.Services.UtilisateurService;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author viper
 */
@ManagedBean(name = "bonjourBean")
@Scope
public class BonjourBean extends HttpServlet{
   // @ManagedProperty(value = "#{UtilisateurServiceImpl}")
    private static final String CONTEXT="app_context";
   @Autowired
   private UtilisateurService userService;
   
   private ApplicationContext ctx=(ApplicationContext)ContextInit.appContext;
     private UtilisateurService user=(UtilisateurService) this.ctx.getBean(UtilisateurService.class);
    public void setUserService(UtilisateurService userService) {
        this.userService = userService;
    }
    
    
    
    private String nom="rosty";
    /**
     * Creates a new instance of BonjourBean
     */
    public BonjourBean() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getemailFirstUser(){
       // return userService.getUtilisateurs().get(0).getEmail();
         //ApplicationContext ctx=new AnnotationConfigApplicationContext(Configurations.class);
       // SessionFactory sessionFactory=(SessionFactory) ctx.getBean("sessionFactory");
       // System.out.println( "Hello World!" );
       
    //UtilisateurService user=(UtilisateurService) ctx.getBean(UtilisateurService.class);
  // int e = user.getNbUsers();
       // System.out.println( e );
     //  user.setNom("rosty");
      
      Utilisateur user1= this.user.getUtilisateurs().get(0);
       return user1.getEmail();
    }
    
    
    
    
}
