package impl.sdi.business.classes.publico;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase Login que pertenece a la capa de persistencia y ejecuta un proceso de
 * negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class Login extends AbstractCommand {

	private String usuario;

	private String password;

	public Login(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		Usuario usuarioLogin = usuarioDao.comprobarLogin(usuario, password);
		return usuarioLogin;
	}

}
