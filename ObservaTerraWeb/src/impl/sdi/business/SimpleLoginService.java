package impl.sdi.business;

import impl.sdi.business.classes.CommandExecutor;
import impl.sdi.business.classes.publico.Login;

import com.sdi.business.LoginService;
import com.sdi.model.Usuario;

/**
 * Clase SimpleLoginService de implementación del interfaz de la fachada de
 * servicios
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class SimpleLoginService implements LoginService {

	@Override
	public Usuario comprobarLogin(String usuario, String password) {
		return (Usuario) CommandExecutor.execute(new Login(usuario, password));
	}

}