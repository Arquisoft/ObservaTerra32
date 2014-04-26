package com.sdi.presentation;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sdi.business.LoginService;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;

@ManagedBean(name = "login")
@SessionScoped
public class BeanLogin implements Serializable {

	private static final long serialVersionUID = 6L;

	private String usuario = "";

	private String password = "";

	private String error = null;

	public String getError() {
		return error;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	private Usuario u;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BeanLogin() {
		System.out.println("BeanLogin - No existia");
	}

	/**
	 * permite loguearse
	 */
	public String login() {
		LoginService login = Factories.services.createLoginService();
		u = login.comprobarLogin(usuario, password);
		if (u != null) {
			putUserInSession(u);
			if (u.getTipo().equals("administrador")) {
				return "usuarioAdministrador";
			} else if (u.getTipo().equals("profesor")) {
				return "usuarioProfesor";
			} else
				return "usuarioAlumno";
		}
		error = "error_login";
		return "FRACASO";
	}

	private void putUserInSession(Usuario u) {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		session.put("LOGGEDIN_USER", u);
	}

}