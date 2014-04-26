package impl.sdi.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdi.model.Asignatura;

/**
 * Implementación de la interfaz de fachada al servicio de persistencia para
 * Asignaturas.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class AsignaturaJdbc {

	private BaseDeDatos bd;

	public AsignaturaJdbc(BaseDeDatos bd) {
		this.bd = bd;
	}

	public List<Asignatura> buscarAsignaturas(Asignatura asignatura) {
		Connection con = bd.getCon();
		PreparedStatement psAsig = null;
		ResultSet rsAsig = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();

		// Obtenemos la conexión a la base de datos.
		try {
			psAsig = con
					.prepareStatement("SELECT * FROM ASIGNATURA WHERE "
							+ "UPPER(NOMBRE) LIKE UPPER(?)");
			String nombreCompleto = "%" + asignatura.getNombre() + "%";
			psAsig.setString(1, nombreCompleto);
			rsAsig = psAsig.executeQuery();
			while (rsAsig.next()) {
				Asignatura asignaturaBusqueda = new Asignatura();
				asignaturaBusqueda.setNombre(rsAsig.getString("NOMBRE"));
				asignaturaBusqueda.setCurso(rsAsig.getInt("CURSO"));
				asignaturaBusqueda.setNumeroCreditos(rsAsig
						.getInt("NUMEROCREDITOS"));
				asignaturaBusqueda.setIdAsignatura(rsAsig
						.getInt("ID_ASIGNATURA"));
				asignaturas.add(asignaturaBusqueda);
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

	public List<Asignatura> buscarTodas() {
		Connection con = bd.getCon();
		PreparedStatement psAsig = null;
		ResultSet rsAsig = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();

		// Obtenemos la conexión a la base de datos.
		try {
			psAsig = con.prepareStatement("SELECT * FROM ASIGNATURA");
			rsAsig = psAsig.executeQuery();
			while (rsAsig.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(rsAsig.getString("NOMBRE"));
				asignatura.setCurso(rsAsig.getInt("CURSO"));
				asignatura.setNumeroCreditos(rsAsig.getInt("NUMEROCREDITOS"));
				asignatura.setIdAsignatura(rsAsig.getInt("ID_ASIGNATURA"));
				asignaturas.add(asignatura);
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

	public List<Asignatura> buscarAsignaturasPorProfesor(int idUsuario) {
		Connection con = bd.getCon();
		PreparedStatement psAsig = null;
		ResultSet rsAsig = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		try {
			psAsig = con
					.prepareStatement("SELECT DISTINCT a.NOMBRE AS NOMBRE FROM "
							+ "ASIGNATURA AS A JOIN IMPARTE AS I ON "
							+ "A.ID_ASIGNATURA = I.ID_ASIGNATURA WHERE "
							+ "I.ID_USUARIO = ?");
			psAsig.setLong(1, idUsuario);
			rsAsig = psAsig.executeQuery();
			while (rsAsig.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(rsAsig.getString("NOMBRE"));
				asignaturas.add(asignatura);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psAsig != null) {
				try {
					psAsig.close();
				} catch (SQLException e) {
				}
			}
			if (rsAsig != null) {
				try {
					rsAsig.close();
				} catch (SQLException e) {
				}
			}
		}

		return asignaturas;
	}

	public boolean modificarAsignatura(Asignatura asignatura) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE ASIGNATURA SET NOMBRE=?, CURSO=?, "
					+ "NUMEROCREDITOS=? WHERE ID_ASIGNATURA=?");
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getCurso());
			ps.setInt(3, asignatura.getNumeroCreditos());
			ps.setInt(4, asignatura.getIdAsignatura());
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

	public boolean eliminarAsignatura(Asignatura asignatura) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("DELETE FROM ASIGNATURA WHERE "
					+ "ID_ASIGNATURA=?");
			ps.setInt(1, asignatura.getIdAsignatura());
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

	public boolean exitsProfesores(Asignatura asignatura) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM IMPARTE WHERE "
					+ "ID_ASIGNATURA=?");
			ps.setInt(1, asignatura.getIdAsignatura());
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getLong(1) != 0;
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
		return false;
	}

	public boolean exitsAlumnos(Asignatura asignatura) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT COUNT(*) FROM MATRICULA WHERE "
					+ "ID_ASIGNATURA=?");
			ps.setInt(1, asignatura.getIdAsignatura());
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getLong(1) != 0;
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
		return false;
	}

	public boolean nuevaAsignatura(Asignatura asignatura) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("INSERT INTO ASIGNATURA "
					+ "VALUES(NULL,?,?,?)");
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getCurso());
			ps.setInt(3, asignatura.getNumeroCreditos());
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

	public boolean confirmarAsignacion(int idUsuario, int idAsignatura) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO IMPARTE VALUES(?,?)");
			ps.setInt(1, idUsuario);
			ps.setInt(2, idAsignatura);

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

	public List<Asignatura> asignaturasImparte(int idUsuario) {
		Connection con = bd.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();

		try {
			ps = con.prepareStatement("SELECT DISTINCT ASIGNATURA.* FROM "
					+ "ASIGNATURA JOIN IMPARTE ON "
					+ "ASIGNATURA.ID_ASIGNATURA = IMPARTE.ID_ASIGNATURA WHERE "
					+ "IMPARTE.ID_USUARIO = ?");
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();
			while (rs.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setCurso(rs.getInt("curso"));
				asignatura.setNumeroCreditos(rs.getInt("numeroCreditos"));
				asignatura.setIdAsignatura(rs.getInt("id_asignatura"));
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

}
