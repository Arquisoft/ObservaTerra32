package impl.sdi.persistence;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.persistence.AsignaturaDao;

public class AsignaturaJdbcDao implements AsignaturaDao {

	private BaseDeDatos bd;

	@Override
	public void setBD(BaseDeDatos bd) {
		this.bd = bd;
	}

	@Override
	public List<Asignatura> buscarTodas() {
		return new AsignaturaJdbc(bd).buscarTodas();
	}

	@Override
	public List<Asignatura> buscarAsignaturasPorProfesor(int idUsuario) {
		return new AsignaturaJdbc(bd).buscarAsignaturasPorProfesor(idUsuario);
	}

	@Override
	public List<Asignatura> buscarAsignaturas(Asignatura asignatura) {
		return new AsignaturaJdbc(bd).buscarAsignaturas(asignatura);
	}

	@Override
	public boolean modificarAsignatura(Asignatura asignatura) {
		return new AsignaturaJdbc(bd).modificarAsignatura(asignatura);
	}

	@Override
	public boolean eliminarAsignatura(Asignatura asignatura) {
		return new AsignaturaJdbc(bd).eliminarAsignatura(asignatura);
	}

	@Override
	public boolean exitsProfesores(Asignatura asignatura) {
		return new AsignaturaJdbc(bd).exitsProfesores(asignatura);
	}

	@Override
	public boolean exitsAlumnos(Asignatura asignatura) {
		return new AsignaturaJdbc(bd).exitsAlumnos(asignatura);
	}

	@Override
	public boolean nuevaAsignatura(Asignatura asignatura) {
		return new AsignaturaJdbc(bd).nuevaAsignatura(asignatura);
	}

	@Override
	public List<Asignatura> asignaturasImparte(int idUsuario) {
		return new AsignaturaJdbc(bd).asignaturasImparte(idUsuario);
	}

}
