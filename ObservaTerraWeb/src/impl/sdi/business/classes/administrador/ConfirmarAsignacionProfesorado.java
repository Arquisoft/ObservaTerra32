package impl.sdi.business.classes.administrador;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase ConfirmarAsignacionProfesorado que pertenece a la capa de persistencia
 * y ejecuta un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class ConfirmarAsignacionProfesorado extends AbstractCommand {

	private int idUsuario;

	private int idAsignatura;

	public ConfirmarAsignacionProfesorado(int idUsuario, int idAsignatura) {
		this.idUsuario = idUsuario;
		this.idAsignatura = idAsignatura;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		usuarioDao.confirmarAsignacionProfesorado(idUsuario, idAsignatura);
		return true;
	}

}
