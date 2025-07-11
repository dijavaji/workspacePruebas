package ec.com.technoloqie.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

public abstract class AbstractManejador<T> {
	private Class<T> entityClass;
	private static Logger logger = Logger.getLogger(AbstractManejador.class);

    public AbstractManejador(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) throws EJBException{
    	try{
    		getEntityManager().persist(entity);
    		//getEntityManager().flush();
    	}catch(EJBException e){
			logger.info(">>>> create: " + e.getMessage() + " - Entidad: " + entity.toString());
    	}
    }

    public void edit(T entity) throws EJBException{
    	try{
    		getEntityManager().merge(entity);
    		//getEntityManager().flush();
    	}catch(EJBException e){
			logger.info(">>>> edit: " + e.getMessage() + " - Entidad: " + entity.toString());
    	}
    }

    public void remove(T entity) throws EJBException {
    	try{
    		T managed = getEntityManager().merge(entity);
    		getEntityManager().remove(managed);
    	}catch(EJBException e){
			logger.info(">>>> remove: " + e.getMessage() + " - Entidad: " + entity.toString());
    	}
    }

    public T find(Object id) throws EJBException {
    	try{    	
    		return getEntityManager().find(entityClass, id);
    	}catch(EJBException e){
			logger.info(">>>> find: " + e.getMessage() + " - entityClass: " + entityClass.getName() +
					" - id: " + id.toString());
			return null;
    	}    		
    }

    public List<T> findAll() throws EJBException {
    	try{    	
    		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    		cq.select(cq.from(entityClass));
    		return getEntityManager().createQuery(cq).getResultList();
    	}catch(EJBException e){
			logger.info(">>>> findAll: " + e.getMessage() + " - entityClass: " + entityClass.getName());
			return null;
    	}      		
    }

    public List<T> findRange(int[] range) throws EJBException {
    	try{     	
	        CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
	        cq.select(cq.from(entityClass));
	        TypedQuery<T> q = getEntityManager().createQuery(cq);
	        q.setMaxResults(range[1] - range[0] + 1);
	        q.setFirstResult(range[0]);
	        return q.getResultList();
    	}catch(EJBException e){
			logger.info(">>>> findRange: " + e.getMessage() + " - entityClass: " + entityClass.getName() + 
					" - range: " + Arrays.toString(range));
			return null;
    	}	        
    }

    public int count() throws EJBException {
    	try{    	
	        CriteriaQuery<Long> cq = getEntityManager().getCriteriaBuilder().createQuery(Long.class);
	        Root<T> rt = cq.from(entityClass);
	        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
	        Query q = getEntityManager().createQuery(cq);
	        return ((Long) q.getSingleResult()).intValue();
    	}catch(EJBException e){
			logger.info(">>>> count: " + e.getMessage() + " - entityClass: " + entityClass.getName());
			return -1;
    	}		        
    }
}
