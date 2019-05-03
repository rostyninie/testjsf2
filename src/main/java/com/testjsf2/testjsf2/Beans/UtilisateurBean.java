/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testjsf2.testjsf2.Beans;

import com.testjsf2.testjsf2.ContextInit;
import com.testjsf2.testjsf2.Entities.Utilisateur;
import com.testjsf2.testjsf2.Services.UtilisateurService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author viper
 */
@ManagedBean(name = "utilisateurBean")
@ViewScoped
public class UtilisateurBean implements Serializable{
   private ApplicationContext  ctx=ContextInit.appContext;
   private UtilisateurService utilisateurService;
   private Utilisateur utilisateur;
   private Utilisateur utilisateur1;
   private List<Utilisateur> listeFiltre;

    public UtilisateurBean() {
        utilisateurService=(UtilisateurService)ctx.getBean(UtilisateurService.class);
        this.utilisateur=new  Utilisateur();
        this.utilisateur1=new  Utilisateur();
    }

   
   
   
    public UtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
   
   public List<Utilisateur> utilisateurList(){
    
       return getUtilisateurService().getUtilisateurs();
   }
   
   public void adduser(){
    boolean save=   getUtilisateurService().saveOrUpdateUtilisateur(getUtilisateur());
       FacesMessage message=null;
    if(save){
        setUtilisateur(new Utilisateur());
        
        message=new FacesMessage("Utilisateur enregistré avec succès");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        PrimeFaces.current().ajax().update("tb_users");
        PrimeFaces.current().ajax().update("formulaire");
    }else{
       message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","UErreur lors de l'enregistrement"); 
    }
     FacesContext fc=  FacesContext.getCurrentInstance();
     fc.addMessage(null, message);
   }
   
   /**
    * listener de la selection d'un utilisateur
    * @return 
    */
   public void UserOnRowSelect(SelectEvent event){
        FacesMessage message=null;
        setUtilisateur((Utilisateur)event.getObject());
        message=new FacesMessage("Utilisateur sélectionée "+((Utilisateur)event.getObject()).getNom());
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc=  FacesContext.getCurrentInstance();
     fc.addMessage(null, message);
   }
   
   /**
    * Utilisateur action event
    * @return 
    */
    public void UserActionEvent(){
        FacesMessage message=null;
       // this.utilisateur=(Utilisateur)event.getObject();
        message=new FacesMessage("Utilisateur sélectionée ");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc=  FacesContext.getCurrentInstance();
     fc.addMessage(null, message);
     PrimeFaces.current().scrollTo("formulaire");
   }
    
    /**
     * Supprimer un utilisateur
     * @return 
     */
    public void deleteUSer(){
          FacesMessage message=null;
          if(getUtilisateur().getIdUtilisateur()!=null){
        if(getUtilisateurService().deleteUtilisateur(getUtilisateur())){
            setUtilisateur(new Utilisateur());
            PrimeFaces.current().ajax().update("tb_users");
            PrimeFaces.current().ajax().update("formulaire");
            message=new FacesMessage("Utilisateur supprimé");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
           
        }else{
          message=new FacesMessage("Erreur lors de la suppression de l'utilisateur");  
        }
          }else{
               message=new FacesMessage("veillez sélectionner l'utilisateur à supprimer!!!");
               message.setSeverity(FacesMessage.SEVERITY_WARN);
          }
         FacesContext fc=  FacesContext.getCurrentInstance();
         fc.addMessage(null, message);
    }
    
    /** 
     * reset form
     * @return 
     */
    public void resetForm(){
        setUtilisateur(new Utilisateur());
        
    }

   
    public Utilisateur getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(Utilisateur utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

    public List<Utilisateur> getListeFiltre() {
        return listeFiltre;
    }

    public void setListeFiltre(List<Utilisateur> lsisteFiltre) {
        this.listeFiltre = listeFiltre;
    }
   
   
   
}
