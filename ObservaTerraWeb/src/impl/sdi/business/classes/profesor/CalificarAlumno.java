package impl.sdi.business.classes.profesor;

import impl.sdi.business.classes.AbstractCommand;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase CalificarAlumno que pertenece a la capa de persistencia y ejecuta un
 * proceso de negocio.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class CalificarAlumno extends AbstractCommand {

	private double nota;

	private int idAsignatura;

	private int idUsuario;

	public CalificarAlumno(double nota, int idAsignatura, int idUsuario) {
		this.nota = nota;
		this.idAsignatura = idAsignatura;
		this.idUsuario = idUsuario;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
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
		usuarioDao.calificarAlumno(nota, idAsignatura, idUsuario);
		return null;
	}

}
