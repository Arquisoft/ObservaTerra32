package impl.sdi.business.classes;

import impl.sdi.persistence.BaseDeDatos;

/**
 * Clase abstracta del patrón Command
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public abstract class AbstractCommand implements Command {

	private BaseDeDatos bd;

	public AbstractCommand() {
		super();
	}

	public void setBD(BaseDeDatos bd) {
		this.bd = bd;
	}
	
	public BaseDeDatos getBd() {
		return bd;
	}

}