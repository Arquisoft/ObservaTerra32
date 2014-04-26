package impl.sdi.business.classes.administrador;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase NuevaAsignatura que pertenece a la capa de persistencia y ejecuta un
 * proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class NuevaAsignatura extends AbstractCommand {

	private Asignatura asignatura;

	public NuevaAsignatura(Asignatura asignatura) {
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
		return asignaturaDao.nuevaAsignatura(asignatura);
	}

}
