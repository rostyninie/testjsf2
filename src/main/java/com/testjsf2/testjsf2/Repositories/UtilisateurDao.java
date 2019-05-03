package com.testjsf2.testjsf2.Repositories;


import com.testjsf2.testjsf2.Entities.Utilisateur;
import java.util.List;

public interface UtilisateurDao {
  public List<Utilisateur> list();
  public boolean delete(Utilisateur utilisateur);
  public boolean saveOrUpdate(Utilisateur utilisateur);
  public Utilisateur getById(Long id);
}
