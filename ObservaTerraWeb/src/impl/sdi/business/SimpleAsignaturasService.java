package impl.sdi.business;

import impl.sdi.business.classes.CommandExecutor;
import impl.sdi.business.classes.administrador.EliminarAsignatura;
import impl.sdi.business.classes.administrador.ModificarAsignatura;
import impl.sdi.business.classes.administrador.NuevaAsignatura;
import impl.sdi.business.classes.publico.BuscarAsignatura;
import impl.sdi.business.classes.publico.ListarAsignaturasConProfesores;

import java.util.List;

import com.sdi.business.AsignaturasService;
import com.sdi.model.Asignatura;

/**
 * Clase SimpleAsignaturasService de implementación del interfaz de la fachada
 * de servicios
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class SimpleAsignaturasService implements AsignaturasService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> listarAsignaturasConProfesores() {
		return (List<Asignatura>) CommandExecutor
				.execute(new ListarAsignaturasConProfesores());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> buscarAsignaturas(Asignatura asignatura) {
		return (List<Asignatura>) CommandExecutor.execute(new BuscarAsignatura(
				asignatura));
	}

	@Override
	public boolean modificarAsignatura(Asignatura asignatura) {
		return (boolean) CommandExecutor.execute(new ModificarAsignatura(
				asignatura));
	}

	@Override
	public boolean eliminarAsignatura(Asignatura asignatura) {
		return (boolean) CommandExecutor.execute(new EliminarAsignatura(
				asignatura));
	}

	@Override
	public boolean nuevaAsignatura(Asignatura asignatura) {
		return (boolean) CommandExecutor
				.execute(new NuevaAsignatura(asignatura));
	}

}
