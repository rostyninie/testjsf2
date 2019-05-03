package com.testjsf2.testjsf2.Services;



import com.testjsf2.testjsf2.Entities.Utilisateur;
import java.util.List;

public interface UtilisateurService {
  public List<Utilisateur> getUtilisateurs();

  public boolean saveOrUpdateUtilisateur(Utilisateur utilisateur);

  public boolean deleteUtilisateur(Utilisateur utilisateur);

  public  Utilisateur getUtilisateur(Long id);

}
