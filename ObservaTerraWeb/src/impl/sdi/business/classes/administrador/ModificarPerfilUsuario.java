package impl.sdi.business.classes.administrador;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase ModificarPerfilUsuario que pertenece a la capa de persistencia y
 * ejecuta un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class ModificarPerfilUsuario extends AbstractCommand {

	private Usuario usuario;

	private String nuevaPassword;

	private String nuevaPasswordConfirmar;

	public ModificarPerfilUsuario(Usuario usuario, String nuevaPassword,
			String nuevaPasswordConfirmar) {
		this.usuario = usuario;
		this.nuevaPassword = nuevaPassword;
		this.nuevaPasswordConfirmar = nuevaPasswordConfirmar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNuevaPassword() {
		return nuevaPassword;
	}

	public void setNuevaPassword(String nuevaPassword) {
		this.nuevaPassword = nuevaPassword;
	}

	public String getNuevaPasswordConfirmar() {
		return nuevaPasswordConfirmar;
	}

	public void setNuevaPasswordConfirmar(String nuevaPasswordConfirmar) {
		this.nuevaPasswordConfirmar = nuevaPasswordConfirmar;
	}

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		if (!nuevaPassword.equals(nuevaPasswordConfirmar)) {
			return false;
		}
		usuarioDao.modificarPerfil(usuario, nuevaPassword,
				nuevaPasswordConfirmar);
		return true;
	}

}
