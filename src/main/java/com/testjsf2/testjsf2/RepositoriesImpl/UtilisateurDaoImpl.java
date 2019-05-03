package com.testjsf2.testjsf2.RepositoriesImpl;




import com.testjsf2.testjsf2.Entities.Utilisateur;
import com.testjsf2.testjsf2.Repositories.UtilisateurDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {

 // 
 private SessionFactory session;
@Autowired
    public void setSession(SessionFactory session) {
        this.session = session;
    }
 
 
  @Override
  public List<Utilisateur> list() {
    StringBuffer query= new StringBuffer();
    query.append("SELECT u FROM Utilisateur u");
    return session.getCurrentSession().createQuery(query.toString()).list();
  }

  @Override
  public boolean delete(Utilisateur utilisateur) {
    try{
      session.getCurrentSession().delete(utilisateur);
      return  true;
    }catch (Exception ex){
      ex.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean saveOrUpdate(Utilisateur utilisateur) {
    try{
      session.getCurrentSession().saveOrUpdate(utilisateur);
      return  true;
    }catch (Exception ex){
      ex.printStackTrace();
      return false;
    }
  }

  @Override
  public Utilisateur getById(Long id) {
    //Criteria criteria=session.getCurrentSession().createCriteria(Utilisateur.class);
   // Criterion idEq= Expression.eq("id", id);
   // criteria.add(idEq);

    StringBuffer query= new StringBuffer();
    query.append("select u from Utilisateur u where u.id = :id");
    return (Utilisateur) session.getCurrentSession().createQuery(query.toString()).setParameter("id",id).list().get(0);
  }
}
