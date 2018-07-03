package com.bst.restcontroller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bst.dao.CentroOperativoDao;
import com.bst.dao.ExpositoresDao;
import com.bst.dao.PonentesDao;
import com.bst.dao.UsuarioDao;
import com.bst.model.Expositores;
import com.bst.model.Ponentes;
import com.bst.model.Usuario;

@RestController
public class EndpointsRest {

	 @Autowired
	 private UsuarioDao usuarioDao;
	 
	 @Autowired
	 private ExpositoresDao expositoresDao;
	 
	 @Autowired
	 private CentroOperativoDao centroOperativoDao;
	 
	 @Autowired
	 private PonentesDao ponentesDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTlogin")
	public Map login(@RequestParam(value="email") String email,@RequestParam(value="codigo") String codigo) throws JSONException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		usuarioDao = context.getBean(UsuarioDao.class);
		int categoria = usuarioDao.logeo(email, codigo);
	    Map mapa = new HashMap<>();
	    mapa.put("Categoria", categoria);
	    context.close();
	    return mapa;    
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTloginapp")
	public Map loginapp(@RequestParam(value="email") String email,@RequestParam(value="codigo") String codigo) throws JSONException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		usuarioDao = context.getBean(UsuarioDao.class);
		int categoria = usuarioDao.logeoapp(email, codigo);
	    Map mapa = new HashMap<>();
	    mapa.put("Categoria", categoria);
	    context.close();
	    return mapa;    
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/RESTcentrosoperativos")
	public Map getCentrosOperativos() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		centroOperativoDao = context.getBean(CentroOperativoDao.class);
		 Map mapa = new HashMap<>();
		 List centros = centroOperativoDao.getCentroOperativos();
		 mapa.put("Centros Operativos", centros);
		 context.close();
		 return mapa;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/RESTgetlistausuarios")
	public Map getlistausuarios() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		usuarioDao = context.getBean(UsuarioDao.class);
		 Map mapa = new HashMap<>();
		 List usuarios = usuarioDao.getUsuarios();
		 mapa.put("usuarios", usuarios);
		 context.close();
		 return mapa;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTanadirUsuario")
	public void registrar(
			@RequestParam(value="nombre") String nombre,
			@RequestParam(value="email") String email,
			@RequestParam(value="contrasena") String contrasena,
			@RequestParam(value="telefono") String telefono,
			@RequestParam(value="fechaNacimiento") Date fechaNacimiento,		
			@RequestParam(value="idCentroOperativo") int idCentroOperativo,		
			@RequestParam(value="idCategoria") int idCategoria
			
			) throws JSONException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		usuarioDao = context.getBean(UsuarioDao.class);
		usuarioDao.registrar(nombre, email, contrasena, telefono, fechaNacimiento, idCentroOperativo, idCategoria);
	    context.close();
  
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTanadirCliente")
	public void registrarClientes(
			@RequestParam(value="nombre") String nombre,
			@RequestParam(value="email") String email,
			@RequestParam(value="contrasena") String contrasena,
			@RequestParam(value="telefono") String telefono,
			@RequestParam(value="fechaNacimiento") Date fechaNacimiento,		
			@RequestParam(value="empresa") String empresa,		
			@RequestParam(value="idCategoria") int idCategoria
			
			) throws JSONException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		usuarioDao = context.getBean(UsuarioDao.class);
		usuarioDao.registrarCliente(nombre, email, contrasena, telefono, fechaNacimiento, empresa, idCategoria);
	    context.close(); 
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTgetUsuario")
	public Map getUsuario(@RequestParam(value="idusuario") String idUsuario) throws JSONException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		usuarioDao = context.getBean(UsuarioDao.class);
	    Map mapa = new HashMap<>();
	    Usuario usuario = usuarioDao.getUsuario(idUsuario);
	    mapa.put("usuario", usuario);
	    context.close();
	    return mapa;    	
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTupdateUsuario")
	public void updateUsuario(@RequestParam(value="nombre") String nombre, 
			@RequestParam(value="email") String email,@RequestParam(value="telefono") String telefono,
			@RequestParam(value="fechaNacimiento") Date fechaNacimiento,@RequestParam(value="centro") String centro,
			@RequestParam(value="categoria") int categoria, @RequestParam(value="status") int status, 
			@RequestParam(value="empresa") String empresa,@RequestParam(value="idUsuario") String idUsuario) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		usuarioDao = context.getBean(UsuarioDao.class);
		usuarioDao.editarUsuario(nombre,email,telefono,fechaNacimiento,centro,categoria,status,empresa,idUsuario);
		 context.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/RESTgetlistaexpositores")
	public Map getListaexpositores() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		expositoresDao = context.getBean(ExpositoresDao.class);
		 Map mapa = new HashMap<>();
		 List ponentes = expositoresDao.getExpositores();
		 mapa.put("expositores", ponentes);
		 context.close();
		 return mapa;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTgetExpositor")
	public Map getExpositorId(@RequestParam(value="idExpositor") String idExpositor) throws JSONException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		expositoresDao = context.getBean(ExpositoresDao.class);
	    Map mapa = new HashMap<>();
	    Expositores expositor = expositoresDao.getExpositorId(idExpositor);
	    mapa.put("expositor", expositor);
	    context.close();
	    return mapa;    	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTupdateExpositor")
	public Map updateExpositor(@RequestParam(value="idExpositor") String idExpositor,
			@RequestParam(value="nombre") String nombre,
			@RequestParam(value="facebook") String facebook,
			@RequestParam(value="google") String google,
			@RequestParam(value="twitter") String twitter,
			@RequestParam(value="paginainternet") String paginainternet
			) throws JSONException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		expositoresDao = context.getBean(ExpositoresDao.class);
	    Map mapa = new HashMap<>();
	    expositoresDao.updateExpositor(idExpositor,nombre,facebook,google,twitter,paginainternet);
	    mapa.put("expositor", "200");
	    context.close();
	    return mapa;    	
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTaddExpositor")
	public Map addExpositor(@RequestParam(value="nombre") String nombre, 
			@RequestParam(value="facebook") String facebook, 
			@RequestParam(value="google") String google, 
			@RequestParam(value="twitter") String twitter, 
			@RequestParam(value="paginainternet") String paginainternet,
			@RequestParam(value="logo")String b)throws JSONException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		expositoresDao = context.getBean(ExpositoresDao.class);
		 Map mapa = new HashMap<>();
		 expositoresDao.addExpositor(nombre,facebook,google,twitter,paginainternet,b);
		    mapa.put("expositor", "200");
		    context.close();
		    return mapa;    
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTdeleteExpositor")
	public Map deleteExpositor(@RequestParam(value="idExpositor") String idExpositor) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		expositoresDao = context.getBean(ExpositoresDao.class);
		 Map mapa = new HashMap<>();
		 expositoresDao.deleteExpositor(idExpositor);
		    mapa.put("expositor", "200");
		    context.close();
		    return mapa;    
		
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTgetListaponentes")
	public Map getListaponentes() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ponentesDao = context.getBean(PonentesDao.class);
		Map mapa = new HashMap<>();
		 List ponentes = ponentesDao.getListaPonentes();
		 mapa.put("ponentes", ponentes);
		 context.close();
		 return mapa;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTgetPonenteId")
	public Map getPonenteId(@RequestParam(value="idPonente")String idPonente) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ponentesDao = context.getBean(PonentesDao.class);
	    Map mapa = new HashMap<>();
	    Ponentes ponente = ponentesDao.getPonenteId(idPonente);
	    mapa.put("ponente", ponente);
	    context.close();
	    return mapa;    	
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTupdatePonente")
	public Map updatePonente(@RequestParam(value="idPonente") String idPonente, 
			@RequestParam(value="nombre") String nombre, 
			@RequestParam(value="puesto") String puesto, 
			@RequestParam(value="semblanza")String semblanza) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ponentesDao = context.getBean(PonentesDao.class);
	    Map mapa = new HashMap<>();
	    ponentesDao.updatePonente(idPonente,nombre,puesto,semblanza);
	    mapa.put("ponente", "200");
	    context.close();
	    return mapa;    
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTdeletePonente")
	public Map deletePonente(@RequestParam(value="idPonente") String idPonente) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ponentesDao = context.getBean(PonentesDao.class);
		 Map mapa = new HashMap<>();
		 ponentesDao.deletePonentes(idPonente);
		 mapa.put("ponente", "200");
		 context.close();
		 return mapa;    
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTaddPonente")
	public Map addPonente(String nombre, String puesto, String semblanza,String b) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ponentesDao = context.getBean(PonentesDao.class);
		 Map mapa = new HashMap<>();
		 ponentesDao.addPonente(nombre,puesto,semblanza,b);
		    mapa.put("expositor", "200");
		    context.close();
		    return mapa;    
		
	}
}
