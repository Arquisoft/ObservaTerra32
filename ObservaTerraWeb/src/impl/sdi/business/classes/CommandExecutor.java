package impl.sdi.business.classes;

import impl.sdi.persistence.BaseDeDatos;

import com.sdi.business.exception.BusinessException;

/**
 * Clase CommandExecutor donde se hace la conexión y desconecxión a la base de
 * datos
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class CommandExecutor {

	public static Object execute(Command command) throws BusinessException {

		BaseDeDatos bd = null;
		try {
			bd = new BaseDeDatos();
			command.setBD(bd);
			return command.execute();
		} finally {
			if (bd != null) {
				bd.desconectarBD();
			}
		}
	}
}
