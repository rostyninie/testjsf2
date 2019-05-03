/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testjsf2.testjsf2.Beans;

import com.testjsf2.testjsf2.ContextInit;
import com.testjsf2.testjsf2.Entities.Utilisateur;
import com.testjsf2.testjsf2.Services.UtilisateurService;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author viper
 */
public class LazyUtilisateurDataModel extends LazyDataModel<Utilisateur> {
    private List<Utilisateur>  dataSource=new ArrayList<>();
    private ApplicationContext  ctx=ContextInit.appContext;

    public LazyUtilisateurDataModel() {
        loadNewCars();
    }
    
    
    
    @Override
    public Utilisateur getRowData(String rowKey){
        for(Utilisateur user: dataSource){
            if(user.getIdUtilisateur().equals(rowKey)){
                return user;
            }
        }
        return null;
    }
    @Override
    public Object getRowKey(Utilisateur user){
       return user.getIdUtilisateur();
    }
    
    @Override
  public List<Utilisateur> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
    List<Utilisateur> data = new ArrayList<Utilisateur>();

    // filter
    for (Utilisateur user : dataSource) {
      boolean match = true;

      if (filters != null) {
        for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
          try {
            String filterProperty = it.next();
            Object filterValue = filters.get(filterProperty);
            BeanInfo info = Introspector.getBeanInfo(Utilisateur.class);
            String fieldValue = null;
            for (PropertyDescriptor p : info.getPropertyDescriptors()) {
              if (p.getName().equals(filterProperty)) {
                fieldValue = (String) p.getReadMethod().invoke(user, new Object[0]);
              }
            }
            // String fieldValue = String.valueOf(car.getClass().getField(filterProperty).get(car));
            if (filterValue == null || fieldValue.contains(filterValue.toString())) {
              match = true;
            }
            else {
              match = false;
              break;
            }
          }
          catch (Exception e) {
            match = false;
          }
        }
      }

      if (match) {
        data.add(user);
      }
    }

    // rowCount
    int dataSize = data.size();
    setRowCount(dataSize);

    // paginate
    if (dataSize > pageSize) {
      try {
        return data.subList(first, first + pageSize);
      }
      catch (IndexOutOfBoundsException e) {
        return data.subList(first, first + dataSize % pageSize);
      }
    }
    else {
      return data;
    }
  }
  
  protected void loadNewCars() {
    if (dataSource.isEmpty() ) {
      dataSource.clear();
     UtilisateurService utilisateurService=(UtilisateurService)ctx.getBean(UtilisateurService.class);
     dataSource=utilisateurService.getUtilisateurs();
    }
  }
}
