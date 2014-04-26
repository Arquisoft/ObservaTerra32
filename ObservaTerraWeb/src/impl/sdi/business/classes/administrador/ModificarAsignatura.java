package impl.sdi.business.classes.administrador;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase ModificarAsignatura que pertenece a la capa de persistencia y
 * ejecuta un proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class ModificarAsignatura extends AbstractCommand {

	private Asignatura asignatura;

	public ModificarAsignatura(Asignatura asignatura) {
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
		asignaturaDao.setBD(getBd());
		asignaturaDao.modificarAsignatura(asignatura);
		return true;
	}
}
