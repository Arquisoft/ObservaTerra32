package impl.sdi.business.classes.publico;

import impl.sdi.business.classes.AbstractCommand;

import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;
import com.sdi.persistence.AsignaturaDao;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase BuscarAsignatura que pertenece a la capa de persistencia y ejecuta un
 * proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class BuscarAsignatura extends AbstractCommand {

	private Asignatura asignatura;

	public BuscarAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public Object execute() throws BusinessException {
		AsignaturaDao asignaturaDao = Factories.persistence
				.createAsignaturaDao();
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		asignaturaDao.setBD(getBd());
		usuarioDao.setBD(getBd());
		List<Asignatura> asignaturas = asignaturaDao
				.buscarAsignaturas(asignatura);
		for (Asignatura asignatura : asignaturas) {
			List<Usuario> profesores = usuarioDao
					.buscarProfesoresPorAsignatura(asignatura.getIdAsignatura());
			asignatura.setProfesores(profesores);
		}
		return asignaturas;
	}

}
