package impl.sdi.persistence;

import com.sdi.persistence.AsignaturaDao;
import com.sdi.persistence.PersistenceFactory;
import com.sdi.persistence.UsuarioDao;

/**
 * Implementación de la factoria que devuelve implementación de la capa de
 * persistencia con Jdbc
 * 
 * @author alb
 * 
 */
public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public AsignaturaDao createAsignaturaDao() {
		return new AsignaturaJdbcDao();
	}

	@Override
	public UsuarioDao createUsuarioDao() {
		return new UsuarioJdbcDao();
	}

}
