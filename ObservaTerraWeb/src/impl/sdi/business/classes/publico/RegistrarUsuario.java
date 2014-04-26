package impl.sdi.business.classes.publico;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase RegistrarUsuario que pertenece a la capa de persistencia y ejecuta un
 * proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class RegistrarUsuario extends AbstractCommand {

	private Usuario usuario;

	private String confirmarPassword;

	public RegistrarUsuario(Usuario usuario, String confirmarPassword) {
		this.usuario = usuario;
		this.confirmarPassword = confirmarPassword;
	}

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		if (!usuario.getPassword().equals(confirmarPassword)) {
			return false;
		}
		Usuario usuarioActual = usuarioDao.buscarPorUsuario(usuario
				.getUsuario());
		if (usuarioActual != null) {
			return false;
		}
		usuarioDao.insertar(usuario);
		return true;
	}

}
