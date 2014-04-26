package impl.sdi.business.classes.administrador;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase ActivarUsuario que pertenece a la capa de persistencia y ejecuta un
 * proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class ActivarUsuario extends AbstractCommand {

	private Usuario usuario;

	public ActivarUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		return usuarioDao.activarUsuario(usuario);
	}

}
