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
import com.bst.dao.UsuarioDao;
import com.bst.model.Usuario;

@RestController
public class EndpointsRest {

	 @Autowired
	 private UsuarioDao usuarioDao;
	 
	 @Autowired
	 private CentroOperativoDao centroOperativoDao;
	
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
	public Map registrar(
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
	    Map mapa = new HashMap<>();
	    mapa.put("Usuario", "hola mundo");
	    context.close();
	    return mapa;    
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
}
