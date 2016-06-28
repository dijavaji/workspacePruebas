package ec.com.technoloqie.ejb;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ec.com.technoloqie.commons.util.HibernateUtil;
import ec.com.technoloqie.entidades.Employee;

/**
 * Session Bean implementation class EmployeeDAO
 */
@Stateless
@LocalBean
public class EmployeeDAO implements EmployeeDAORemote {
	 //Session session = factory.openSession();
	 
	@Override
	public void crearEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
		     session.beginTransaction();
		     //Employee employee = new Employee(fname, lname, salary);
		     session.save(employee); 
		}catch (HibernateException e) {
		     e.printStackTrace(); 
		}finally {
			 session.getTransaction().commit(); 
		}
		
	}

	@Override
	public Employee obtenerEmployeeNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEmployee(Employee tipoUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee actualizarEmployee(Employee employee) {
		Session sessionHibernate;
		try {
			if(employee != null){
				sessionHibernate = HibernateUtil.getSessionFactory().openSession();
	 	        sessionHibernate.clear();
	 	        sessionHibernate.update(employee);
	 	        sessionHibernate.flush();
			}
 	    } catch(Exception ex) {
    		//EtiquetadoLogger.LOG.error("No se ha podido actualizar el tipo de documento. {}"+ex); 
 	       	//throw new EtiquetadoException("No se ha podido actualizar el tipo documento. {}", ex.getMessage());
 	    }
		return employee;
	}

	@Override
	public Collection<Employee> listarEmployee() {
		Collection employees = null;
		Session sessionHibernate;
		try{
			sessionHibernate = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = sessionHibernate.createCriteria(Employee.class, "tipoDocumento");
			employees = criteria.list();
			sessionHibernate.clear();
		}catch(Exception e){
			
		}
		return employees;
	}


}
