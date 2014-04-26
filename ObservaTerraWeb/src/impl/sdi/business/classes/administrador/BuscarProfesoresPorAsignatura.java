package impl.sdi.business.classes.administrador;

import impl.sdi.business.classes.AbstractCommand;

import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase BuscarProfesoresPorAsignatura que pertenece a la capa de persistencia y
 * ejecuta un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class BuscarProfesoresPorAsignatura extends AbstractCommand {

	@Override
	public Object execute() throws BusinessException {
		UsuarioDao usuarioDao = Factories.persistence.createUsuarioDao();
		usuarioDao.setBD(getBd());
		List<Usuario> profesores = usuarioDao.buscarTodos();
		return profesores;
	}

}
