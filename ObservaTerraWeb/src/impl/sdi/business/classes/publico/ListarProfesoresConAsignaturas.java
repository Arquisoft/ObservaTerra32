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
 * Clase ListarProfesoresConAsignaturas que pertenece a la capa de persistencia
 * y ejecuta un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class ListarProfesoresConAsignaturas extends AbstractCommand {

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		AsignaturaDao asignaturaDao = Factories.persistence
				.createAsignaturaDao();
		usuarioDao.setBD(getBd());
		asignaturaDao.setBD(getBd());
		List<Usuario> usuarios = usuarioDao.buscarTodos();
		for (Usuario usuario : usuarios) {
			List<Asignatura> asignaturas = asignaturaDao
					.buscarAsignaturasPorProfesor(usuario.getIdUsuario());
			usuario.setAsignaturas(asignaturas);
		}
		return usuarios;
	}

}
