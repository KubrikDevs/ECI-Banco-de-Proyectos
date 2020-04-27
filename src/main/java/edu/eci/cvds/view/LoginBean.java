package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.services.ExcepcionBancoDeProyectos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authz.annotation.RequiresGuest;


import java.io.IOException;
import edu.eci.cvds.authentication.SessionLogger;


@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@SessionScoped


public class LoginBean extends BasePageBean{

    /**
	 * 
	 **/
    private static final long serialVersionUID = 3594009161252782831L;
	
    private String email;
    private String password;
    private boolean rememberMe;
    
    @Inject
    private SessionLogger logger;

    public LoginBean(){
        rememberMe = false;
    }
    public Subject getCurrentUser(){
    	Subject currentUser = SecurityUtils.getSubject();
		return currentUser;
    }
    
  
    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    @RequiresGuest
    public void login(String email,String password) throws ExcepcionBancoDeProyectos{
        try {
            logger.login(email, password,rememberMe);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/iniciativas.xhtml");
        } catch (ExcepcionBancoDeProyectos excepcionBancoDeProyectos) {
            LoginBean.setErrorMessage(excepcionBancoDeProyectos);
        }catch (IOException e) {
        	LoginBean.setErrorMessage(e);
        }catch(Exception e) {
        	LoginBean.setErrorMessage(e);
        }


    }

    public void devolver(){
        if (isLogged()){
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
            }catch(IOException e){
                setErrorMessage(e);
            }
        }
    }
    public boolean isLogged(){
        
        return logger.isLogged();
    }
    
    public void logout() throws IOException {
        System.out.println("aquitoy");
    	if (isLogged()) {
    		FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
    		SecurityUtils.getSubject().logout();
    	}
    }
    
    protected static void setErrorMessage(Exception e) {
		String message = e.getMessage();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

    

}