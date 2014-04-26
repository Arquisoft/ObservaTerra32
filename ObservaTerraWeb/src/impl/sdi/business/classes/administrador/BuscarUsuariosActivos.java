package impl.sdi.business.classes.administrador;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase BuscarUsuariosActivos que pertenece a la capa de persistencia y ejecuta
 * un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class BuscarUsuariosActivos extends AbstractCommand {

	private String busqueda;

	public BuscarUsuariosActivos(String busqueda) {
		this.busqueda = busqueda;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		return usuarioDao.buscarUsuariosActivos(busqueda);
	}

}
