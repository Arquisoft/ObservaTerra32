package impl.sdi.business.classes;

import impl.sdi.persistence.BaseDeDatos;

import com.sdi.business.exception.BusinessException;

/**
 * Interfaz del patrón Command
 * 
 * @author Fernando Vigil-Escalera Caicoya
 */
public interface Command {

	public Object execute() throws BusinessException;

	public void setBD(BaseDeDatos bd);
}
