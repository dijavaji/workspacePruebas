package ec.com.technoloqie.ejb.sentiment.analysis.persistence.dao;

import java.util.Collection;

public interface GenericDAO<T> {
	
	 //public T findById(Long id);

	 //public  Collection<T> findAll();

	 //public Collection findAll(Pagination paginacion);

	 //public long countAll();

	 public void persist(T producto);

	 public void remove(T producto);

	 //public void removeAll();

}
