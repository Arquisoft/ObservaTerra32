package impl.sdi.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

/**
 * Implementación de la interfaz de fachada al servicio de persistencia para
 * Usuarios.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class UsuariosJdbc {

	private BaseDeDatos bd;

	public UsuariosJdbc(BaseDeDatos bd) {
		this.bd = bd;
	}

	public List<Usuario> buscarProfesoresPorAsignatura(int idAsignatura) {
		Connection con = bd.getCon();
		PreparedStatement psProf = null;
		ResultSet rsProf = null;
		List<Usuario> profesores = new ArrayList<Usuario>();
		try {
			psProf = con
					.prepareStatement("SELECT DISTINCT U.NOMBRE AS NOMBRE FROM "
							+ "USUARIO AS U JOIN IMPARTE AS I ON "
							+ "U.ID_USUARIO = I.ID_USUARIO WHERE TIPO='profesor' "
							+ "AND I.ID_ASIGNATURA = ?");
			psProf.setLong(1, idAsignatura);
			rsProf = psProf.executeQuery();
			while (rsProf.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(rsProf.getString("NOMBRE"));
				profesores.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psProf != null) {
				try {
					psProf.close();
				} catch (SQLException e) {
				}
			}
			if (rsProf != null) {
				try {
					rsProf.close();
				} catch (SQLException e) {
				}
			}
		}

		return profesores;
	}

	public List<Usuario> buscarTodos() {
		Connection con = bd.getCon();
		PreparedStatement psProf = null;
		ResultSet rsProf = null;
		List<Usuario> profesores = new ArrayList<Usuario>();

		// Obtenemos la conexión a la base de datos.
		try {
			psProf = con.prepareStatement("SELECT * FROM USUARIO WHERE "
					+ "TIPO='profesor'");
			rsProf = psProf.executeQuery();
			while (rsProf.next()) {
				Usuario profesor = new Usuario();
				profesor.setNombre(rsProf.getString("NOMBRE"));
				profesor.setApellidos(rsProf.getString("APELLIDOS"));
				profesor.setEmail(rsProf.getString("EMAIL"));
				profesor.setIdUsuario(rsProf.getInt("ID_USUARIO"));
				profesores.add(profesor);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psProf != null) {
				try {
					psProf.close();
				} catch (SQLException e) {
				}
			}
			if (rsProf != null) {
				try {
					rsProf.close();
				} catch (SQLException e) {
				}
			}
		}
		return profesores;
	}

	public List<Usuario> buscarProfesores(String busqueda) {
		Connection con = bd.getCon();
		PreparedStatement psProf = null;
		ResultSet rsProf = null;
		List<Usuario> profesores = new ArrayList<Usuario>();
		String busquedaTodo = "%" + busqueda + "%";

		// Obtenemos la conexión a la base de datos.
		try {
			psProf = con.prepareStatement("SELECT * FROM USUARIO WHERE "
					+ "TIPO='profesor'  AND (UPPER(NOMBRE) LIKE "
					+ "UPPER(?) OR UPPER(APELLIDOS) LIKE UPPER(?))");
			psProf.setString(1, busquedaTodo);
			psProf.setString(2, busquedaTodo);
			rsProf = psProf.executeQuery();
			while (rsProf.next()) {
				Usuario profesor = new Usuario();
				profesor.setNombre(rsProf.getString("NOMBRE"));
				profesor.setApellidos(rsProf.getString("APELLIDOS"));
				profesor.setEmail(rsProf.getString("EMAIL"));
				profesores.add(profesor);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psProf != null) {
				try {
					psProf.close();
				} catch (SQLException e) {
				}
			}
			if (rsProf != null) {
				try {
					rsProf.close();
				} catch (SQLException e) {
				}
			}
		}
		return profesores;
	}

	public boolean insertar(Usuario usuario) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO USUARIO "
					+ "VALUES(NULL,?,?,?,?,?,?,?)");
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellidos());
			ps.setString(4, usuario.getEmail());
			ps.setString(5, usuario.getPassword());
			ps.setString(6, usuario.getTipo());
			ps.setInt(7, 0);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}

		}
		return false;
	}

	public Usuario buscarPorUsuario(String usuario) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuarioBusqueda = null;

		// Obtenemos la conexión a la base de datos.
		try {
			ps = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO=?");
			ps.setString(1, usuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				usuarioBusqueda = new Usuario();
				usuarioBusqueda.setUsuario(rs.getString("USUARIO"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}
		return usuarioBusqueda;
	}

	public Usuario comprobarLogin(String usuario, String password) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario u = null;

		try {
			ps = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO=? "
					+ "AND PASSWORD=? AND CUENTA_ACTIVADA=1");
			ps.setString(1, usuario);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				u = new Usuario();
				u.setUsuario(rs.getString("usuario"));
				u.setNombre(rs.getString("nombre"));
				u.setApellidos(rs.getString("apellidos"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setTipo(rs.getString("tipo"));
				u.setIdUsuario(rs.getInt("id_usuario"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}
		return u;
	}

	public boolean modificarPerfil(Usuario usuario, String nuevaPassword,
			String nuevaPasswordConfirmar) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE USUARIO SET NOMBRE=?, APELLIDOS=?, "
					+ "EMAIL=?, PASSWORD=? WHERE USUARIO=?");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellidos());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, nuevaPassword);
			ps.setString(5, usuario.getUsuario());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return false;
	}

	public List<Usuario> buscarUsuariosActivos(String busqueda) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Usuario> usuariosActivados = new ArrayList<Usuario>();
		String busquedaTodo = "%" + busqueda + "%";

		// Obtenemos la conexión a la base de datos.
		try {
			ps = con.prepareStatement("SELECT * FROM USUARIO WHERE "
					+ "CUENTA_ACTIVADA=1 AND (TIPO='profesor' OR "
					+ "TIPO='alumno') AND (UPPER(NOMBRE) LIKE UPPER(?) OR "
					+ "UPPER(APELLIDOS) LIKE UPPER(?))");
			ps.setString(1, busquedaTodo);
			ps.setString(2, busquedaTodo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellidos(rs.getString("APELLIDOS"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setTipo(rs.getString("TIPO"));
				usuariosActivados.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}
		return usuariosActivados;
	}

	public List<Usuario> buscarUsuariosInactivos(String busqueda) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Usuario> usuariosDesactivados = new ArrayList<Usuario>();
		String busquedaTodo = "%" + busqueda + "%";

		// Obtenemos la conexión a la base de datos.
		try {
			ps = con.prepareStatement("SELECT * FROM USUARIO WHERE "
					+ "CUENTA_ACTIVADA=0 AND (TIPO='profesor' OR "
					+ "TIPO='alumno') AND (UPPER(NOMBRE) LIKE UPPER(?) OR "
					+ "UPPER(APELLIDOS) LIKE UPPER(?))");
			ps.setString(1, busquedaTodo);
			ps.setString(2, busquedaTodo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellidos(rs.getString("APELLIDOS"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setTipo(rs.getString("TIPO"));
				usuariosDesactivados.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}
		return usuariosDesactivados;
	}

	public List<Usuario> listarUsuariosActivos() {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Usuario> usuariosActivados = new ArrayList<Usuario>();

		try {
			ps = con.prepareStatement("SELECT * FROM USUARIO WHERE "
					+ "CUENTA_ACTIVADA=1 AND (TIPO='profesor' OR "
					+ "TIPO='alumno')");
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellidos(rs.getString("APELLIDOS"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setTipo(rs.getString("TIPO"));
				usuariosActivados.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return usuariosActivados;
	}

	public List<Usuario> listarUsuariosInActivos() {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Usuario> usuariosDesactivados = new ArrayList<Usuario>();

		try {
			ps = con.prepareStatement("SELECT * FROM USUARIO WHERE "
					+ "CUENTA_ACTIVADA=0 AND (TIPO='profesor' OR "
					+ "TIPO='alumno')");
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellidos(rs.getString("APELLIDOS"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setTipo(rs.getString("TIPO"));
				usuariosDesactivados.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return usuariosDesactivados;
	}

	public boolean activarUsuario(Usuario usuario) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE USUARIO SET CUENTA_ACTIVADA=1 "
					+ "WHERE USUARIO=?");
			ps.setString(1, usuario.getUsuario());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return false;
	}

	public boolean desactivarUsuario(Usuario usuario) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE USUARIO SET CUENTA_ACTIVADA=0 "
					+ "WHERE USUARIO=?");
			ps.setString(1, usuario.getUsuario());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return false;
	}

	public boolean confirmarAsignacionProfesorado(int idUsuario,
			int idAsignatura) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO IMPARTE VALUES(?,?)");
			ps.setInt(1, idAsignatura);
			ps.setInt(2, idUsuario);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return false;
	}

	public boolean confirmarAsignacionAlumnado(int idUsuario, int idAsignatura){
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO MATRICULA "
					+ "VALUES(NULL,?,?,NULL)");
			ps.setInt(1, idAsignatura);
			ps.setInt(2, idUsuario);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
		return false;
	}

	public List<Asignatura> consultarExpediente(int idUsuario) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		try {
			ps = con.prepareStatement("SELECT * FROM asignatura AS a JOIN "
					+ "matricula AS m ON a.id_asignatura = m.id_asignatura "
					+ "AND m.id_usuario = ?");
			ps.setLong(1, idUsuario);
			rs = ps.executeQuery();
			while (rs.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(rs.getString("NOMBRE"));
				asignatura.setCurso(rs.getInt("CURSO"));
				asignatura.setNumeroCreditos(rs.getInt("NUMEROCREDITOS"));
				asignatura.setNota(rs.getDouble("NOTA"));
				asignaturas.add(asignatura);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}

		return asignaturas;
	}

	public List<Asignatura> listarCalificarAlumnos(int idUsuario) {
		Connection con = bd.getCon();
		PreparedStatement psAsig = null;
		ResultSet rsAsig = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();

		// Obtenemos la conexión a la base de datos.
		try {
			psAsig = con
					.prepareStatement("SELECT DISTINCT ASIGNATURA.* FROM "
							+ "ASIGNATURA JOIN IMPARTE ON "
							+ "ASIGNATURA.ID_ASIGNATURA = IMPARTE.ID_ASIGNATURA "
							+ "WHERE IMPARTE.ID_USUARIO = ?");
			psAsig.setInt(1, idUsuario);
			rsAsig = psAsig.executeQuery();
			while (rsAsig.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(rsAsig.getString("nombre"));
				asignatura.setCurso(rsAsig.getInt("curso"));
				asignatura.setNumeroCreditos(rsAsig.getInt("numeroCreditos"));
				asignatura.setIdAsignatura(rsAsig.getInt("id_asignatura"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rsAsig != null) {
				try {
					rsAsig.close();
				} catch (SQLException e) {
				}
			}
			if (psAsig != null) {
				try {
					psAsig.close();
				} catch (SQLException e) {
				}
			}
		}
		return asignaturas;
	}

	public List<Usuario> alumnosMatriculados(int idAsignatura) {
		Connection con = bd.getCon();
		PreparedStatement psAlum = null;
		ResultSet rsAlum = null;

		// Obtenemos la conexión a la base de datos.
		try {
			psAlum = con
					.prepareStatement("SELECT * FROM USUARIO JOIN MATRICULA ON "
							+ "USUARIO.ID_USUARIO = MATRICULA.ID_USUARIO WHERE "
							+ "TIPO='alumno' AND MATRICULA.ID_ASIGNATURA = ?");
			psAlum.setInt(1, idAsignatura);
			rsAlum = psAlum.executeQuery();
			List<Usuario> alumnos = new ArrayList<Usuario>();
			while (rsAlum.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(rsAlum.getString("nombre"));
				usuario.setApellidos(rsAlum.getString("apellidos"));
				usuario.setIdUsuario(rsAlum.getInt("id_usuario"));
				usuario.setNota((Double) rsAlum.getObject("nota"));
				alumnos.add(usuario);
			}
			return alumnos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psAlum != null) {
				try {
					psAlum.close();
				} catch (SQLException e) {
				}
			}
			if (rsAlum != null) {
				try {
					rsAlum.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public void calificarAlumno(double nota, int idAsignatura, int idUsuario) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE MATRICULA SET nota = ? WHERE "
					+ "id_asignatura = ? AND id_usuario = ?");
			ps.setDouble(1, nota);
			ps.setInt(2, idAsignatura);
			ps.setInt(3, idUsuario);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Usuario> buscarTodosAlumnos() {
		Connection con = bd.getCon();
		PreparedStatement psProf = null;
		ResultSet rsProf = null;
		List<Usuario> alumnos = new ArrayList<Usuario>();

		// Obtenemos la conexión a la base de datos.
		try {
			psProf = con
					.prepareStatement("SELECT * FROM USUARIO WHERE "
							+ "TIPO='alumno'");
			rsProf = psProf.executeQuery();
			while (rsProf.next()) {
				Usuario alumno = new Usuario();
				alumno.setNombre(rsProf.getString("NOMBRE"));
				alumno.setApellidos(rsProf.getString("APELLIDOS"));
				alumno.setEmail(rsProf.getString("EMAIL"));
				alumno.setIdUsuario(rsProf.getInt("ID_USUARIO"));

				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psProf != null) {
				try {
					psProf.close();
				} catch (SQLException e) {
				}
			}
			if (rsProf != null) {
				try {
					rsProf.close();
				} catch (SQLException e) {
				}
			}
		}
		return alumnos;
	}

	public List<Usuario> buscarAlumnosPorAsignatura(int idAsignatura) {
		Connection con = bd.getCon();
		PreparedStatement psAlum = null;
		ResultSet rsAlum = null;
		List<Usuario> alumnos = new ArrayList<Usuario>();
		try {
			psAlum = con
					.prepareStatement("SELECT DISTINCT U.NOMBRE AS NOMBRE FROM "
							+ "USUARIO AS U JOIN MATRICULA AS I ON "
							+ "U.ID_USUARIO = I.ID_USUARIO WHERE TIPO='alumno' "
							+ "AND I.ID_ASIGNATURA = ?");
			psAlum.setLong(1, idAsignatura);
			rsAlum = psAlum.executeQuery();
			while (rsAlum.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(rsAlum.getString("NOMBRE"));
				alumnos.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psAlum != null) {
				try {
					psAlum.close();
				} catch (SQLException e) {
				}
			}
			if (rsAlum != null) {
				try {
					rsAlum.close();
				} catch (SQLException e) {
				}
			}
		}

		return alumnos;
	}

}
