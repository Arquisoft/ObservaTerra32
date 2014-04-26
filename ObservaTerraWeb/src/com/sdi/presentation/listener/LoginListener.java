package com.sdi.presentation.listener;

import java.util.Map;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Application Lifecycle Listener implementation class LoginListener
 * 
 */
public class LoginListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8835504852402509177L;

	/**
	 * Default constructor.
	 */
	public LoginListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		FacesContext fc = event.getFacesContext();
		String view = fc.getViewRoot().getViewId();
		// Check to see if they are on the login page.
		if (view.contains("index") || view.contains("asignaturas")
				|| view.contains("profesores") || view.contains("registro")) {
			// processing can continue
			return;
		}
		if (!IsValidAuth()) {
			NavigationHandler nh = fc.getApplication().getNavigationHandler();
			nh.handleNavigation(fc, null, "/index");
			return;
		}
		return;
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

	private boolean IsValidAuth() {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return (session.get("LOGGEDIN_USER") != null);
	}
}
