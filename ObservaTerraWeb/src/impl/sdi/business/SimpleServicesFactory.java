package impl.sdi.business;

import com.sdi.business.AsignaturasService;
import com.sdi.business.LoginService;
import com.sdi.business.ServicesFactory;
import com.sdi.business.UsuariosService;

/**
 * Clase SimpleServicesFactory de implementación del interfaz de la fachada de
 * servicios
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public AsignaturasService createAsignaturasService() {
		return new SimpleAsignaturasService();
	}

	@Override
	public LoginService createLoginService() {
		return new SimpleLoginService();
	}

	@Override
	public UsuariosService createUsuariosService() {
		return new SimpleUsuariosService();
	}

}
