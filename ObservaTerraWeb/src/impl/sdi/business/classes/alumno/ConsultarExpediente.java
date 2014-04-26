package impl.sdi.business.classes.alumno;

import impl.sdi.business.classes.AbstractCommand;

import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase ConsultarExpediente que pertenece a la capa de persistencia y ejecuta
 * un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class ConsultarExpediente extends AbstractCommand {

	private int idUsuario;

	public ConsultarExpediente(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		List<Asignatura> asignaturas = usuarioDao
				.consultarExpediente(idUsuario);
		return asignaturas;
	}

}
