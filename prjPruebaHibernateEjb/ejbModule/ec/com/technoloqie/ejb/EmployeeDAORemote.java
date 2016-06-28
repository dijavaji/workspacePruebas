package ec.com.technoloqie.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import ec.com.technoloqie.entidades.Employee;


@Remote
public interface EmployeeDAORemote {
	
	 //public void crearUsuario(String nombre, String direccion, String email);
    public void crearEmployee(Employee tipoUsuario);
    public Employee obtenerEmployeeNombre(String nombre);
    public void eliminarEmployee(Employee tipoUsuario);
    public Employee actualizarEmployee(Employee tipoUsuario);
    public Collection <Employee> listarEmployee();

}
