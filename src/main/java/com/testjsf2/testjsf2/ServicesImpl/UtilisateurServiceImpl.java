package com.testjsf2.testjsf2.ServicesImpl;



import com.testjsf2.testjsf2.Entities.Utilisateur;
import com.testjsf2.testjsf2.Repositories.UtilisateurDao;
import com.testjsf2.testjsf2.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

  //@Autowired
  //  @ManagedProperty(value = "#{UtilisateurDaoImpl}")
    
  UtilisateurDao utilisateurDao;
@Autowired
    public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
  

  @Override
  public List<Utilisateur> getUtilisateurs() {
    return utilisateurDao.list();
  }

  @Override
  public boolean saveOrUpdateUtilisateur(Utilisateur utilisateur) {
    return utilisateurDao.saveOrUpdate(utilisateur);
  }

  @Override
  public boolean deleteUtilisateur(Utilisateur utilisateur) {
    return utilisateurDao.delete(utilisateur);
  }

  @Override
  public Utilisateur getUtilisateur(Long id) {
    return utilisateurDao.getById(id);
  }
}
