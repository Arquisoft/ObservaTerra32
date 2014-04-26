package impl.sdi.business.classes.profesor;

import impl.sdi.business.classes.AbstractCommand;

import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;
import com.sdi.persistence.AsignaturaDao;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase ListarCalificarAlumnos que pertenece a la capa de persistencia y
 * ejecuta un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class ListarCalificarAlumnos extends AbstractCommand {

	private int idUsuario;

	public ListarCalificarAlumnos(int idUsuario) {
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
		AsignaturaDao asignaturaDao = Factories.persistence
				.createAsignaturaDao();
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		asignaturaDao.setBD(getBd());
		usuarioDao.setBD(getBd());
		List<Asignatura> asignaturas = asignaturaDao
				.asignaturasImparte(idUsuario);
		for (Asignatura asignatura : asignaturas) {
			List<Usuario> alumnos = usuarioDao.alumnosMatriculados(asignatura
					.getIdAsignatura());
			asignatura.setAlumnos(alumnos);
		}
		return asignaturas;
	}

}
