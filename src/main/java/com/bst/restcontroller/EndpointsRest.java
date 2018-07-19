package com.bst.restcontroller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bst.model.*;
import com.bst.model.ingresoevento.AvisoIngreso;
import com.bst.model.ingresoevento.PantallaIngreso;
import com.bst.service.NotificationService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import com.bst.dao.AgendaDao;
import com.bst.dao.CentroOperativoDao;
import com.bst.dao.ExpositoresDao;
import com.bst.dao.GaleriaDao;
import com.bst.dao.PonentesDao;
import com.bst.dao.SponsorsDao;
import com.bst.dao.UsuarioDao;

@RestController
public class EndpointsRest {

    @Autowired
    private NotificationService notificationService;

	 @Autowired
	 private UsuarioDao usuarioDao;
	 
	 @Autowired
	 private ExpositoresDao expositoresDao;
	 
	 @Autowired
	 private CentroOperativoDao centroOperativoDao;
	 
	 @Autowired
	 private PonentesDao ponentesDao;
	 
	 @Autowired
	 private SponsorsDao sponsorsDao;
	 
	 @Autowired
	 private AgendaDao agendaDao;
	 
	 @Autowired
	 private GaleriaDao galeriaDao;

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
		Usuario usuario = usuarioDao.logeoapp(email, codigo);
	    Map mapa = new HashMap<>();
	    mapa.put("Categoria", usuario);
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
	public Map getUsuario(@RequestParam String idUsuario) throws JSONException{
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
			@RequestParam(value="paginainternet") String paginainternet,
			@RequestParam(value="logo") String logo
			) throws JSONException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		expositoresDao = context.getBean(ExpositoresDao.class);
	    Map mapa = new HashMap<>();
	    expositoresDao.updateExpositor(idExpositor,nombre,facebook,google,twitter,paginainternet,logo);
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
			@RequestParam(value="semblanza")String semblanza,
			@RequestParam(value="foto")String foto
			) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ponentesDao = context.getBean(PonentesDao.class);
	    Map mapa = new HashMap<>();
	    ponentesDao.updatePonente(idPonente,nombre,puesto,semblanza,foto);
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
	public Map addPonente(@RequestParam(value="nombre") String nombre, @RequestParam(value="puesto") String puesto,@RequestParam(value="semblanza")  String semblanza,@RequestParam(value="foto") String b) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ponentesDao = context.getBean(PonentesDao.class);
		 Map mapa = new HashMap<>();
		 ponentesDao.addPonente(nombre,puesto,semblanza,b);
		    mapa.put("expositor", "200");
		    context.close();
		    return mapa;    
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/RESTgetListasponsors")
	public Map getListasponsors() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		sponsorsDao = context.getBean(SponsorsDao.class);
		 Map mapa = new HashMap<>();
		 List sponsors = sponsorsDao.getSponsors();
		 mapa.put("sponsors", sponsors);
		 context.close();
		 return mapa;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTaddSponsor")
	public Map addSponsor(@RequestParam(value="nombre") String nombre, 
			@RequestParam(value="facebook") String facebook, 
			@RequestParam(value="google") String google, 
			@RequestParam(value="twitter") String twitter, 
			@RequestParam(value="paginainternet") String paginainternet,
			@RequestParam(value="logo")String b)throws JSONException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		sponsorsDao = context.getBean(SponsorsDao.class);
		 Map mapa = new HashMap<>();
		 sponsorsDao.addSponsors(nombre, facebook, google, twitter, paginainternet, b);
		    mapa.put("expositor", "200");
		    context.close();
		    return mapa;    
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTupdateSponsor")
	public Map updateSponsor(@RequestParam(value="idSponsors") String idSponsors,
			@RequestParam(value="nombre") String nombre,
			@RequestParam(value="facebook") String facebook,
			@RequestParam(value="google") String google,
			@RequestParam(value="twitter") String twitter,
			@RequestParam(value="paginainternet") String paginainternet,
			@RequestParam(value="logo") String logo
			) throws JSONException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		sponsorsDao = context.getBean(SponsorsDao.class);
	    Map mapa = new HashMap<>();
	    sponsorsDao.updateSponsors(idSponsors, nombre, facebook, google, twitter, paginainternet, logo);
	    mapa.put("expositor", "200");
	    context.close();
	    return mapa;    	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTdeleteSponsor")
	public Map deleteSponsor(@RequestParam(value="idSponsors") String idSponsors) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		sponsorsDao = context.getBean(SponsorsDao.class);
		 Map mapa = new HashMap<>();
		 sponsorsDao.deleteSponsors(idSponsors);
		    mapa.put("expositor", "200");
		    context.close();
		    return mapa;    
		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/RESTgetSponsor")
	public Map getSponsorId(@RequestParam(value="idSponsor") String idSponsor) throws JSONException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		sponsorsDao = context.getBean(SponsorsDao.class);
	    Map mapa = new HashMap<>();
	    Sponsors sponsor = sponsorsDao.getSponsorsId(idSponsor);
	    mapa.put("sponsor", sponsor);
	    context.close();
	    return mapa;    	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/RESTgetAgenda")
	public Map getAgenda(@RequestParam(value="idDia") String idDia) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		agendaDao = context.getBean(AgendaDao.class);
		 Map mapa = new HashMap<>();
		 List agenda = agendaDao.getAgenda(idDia);
		 mapa.put("agenda", agenda);
		 context.close();
		 return mapa;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/RESTgetAgendaCompleta")
	public Map getAgendaCompleta() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		agendaDao = context.getBean(AgendaDao.class);
		 Map mapa = new HashMap<>();
		 List agenda = agendaDao.getAgendaCompleta();
		 mapa.put("agenda", agenda);
		 context.close();
		 return mapa;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/RESTaddEvento")
	public Map addEvento(@RequestParam(value="titulo") String titulo,
			@RequestParam(value="fechainicio") String fechainicio,@RequestParam(value="horainicio") String horainicio,
			@RequestParam(value="fechafin") String fechafin,@RequestParam(value="horafin") String horafin,
			@RequestParam(value="ponentes",required=false) String[] ponentes) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		agendaDao = context.getBean(AgendaDao.class);
		 Map mapa = new HashMap<>();
		 agendaDao.addAgenda(titulo,fechainicio,horainicio,fechafin,horafin,ponentes);
		 mapa.put("agenda", "200");
		 context.close();
		 return mapa;
	}

	@RequestMapping("/RESTgetEvento")
	public Map getEvento(String id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		agendaDao = context.getBean(AgendaDao.class);
		 Map mapa = new HashMap<>();
		 Agenda agenda = agendaDao.getEvento(id);
		 mapa.put("agenda", agenda);
		 context.close();
		 return mapa;
	}

	@RequestMapping("/RESTdeleteEvento")
	public void deleteEvento(String id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		agendaDao = context.getBean(AgendaDao.class);
		agendaDao.deleteEvento(id);
	}

	@RequestMapping("/RESTupdateAgenda")
	public void updateAgenda(@RequestParam(value="titulo") String titulo,
			@RequestParam(value="fechainicio") String fechainicio,@RequestParam(value="horainicio") String horainicio,
			@RequestParam(value="fechafin") String fechafin,@RequestParam(value="horafin") String horafin,
			@RequestParam(value="ponentes",required=false) String[] ponentes,@RequestParam(value="id") String id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		agendaDao = context.getBean(AgendaDao.class);
		 Map mapa = new HashMap<>();
		 agendaDao.updateAgenda(titulo,fechainicio,horainicio,fechafin,horafin,ponentes,id);
		 mapa.put("agenda", "200");
		 context.close();
	}

	@RequestMapping("/RESTgetGaleria")
	public Map getGaleria() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		galeriaDao = context.getBean(GaleriaDao.class);
		 Map mapa = new HashMap<>();
		 List<Galeria> galeria = galeriaDao.getGaleria();
		 mapa.put("galeria", galeria);
		 context.close();
		 return mapa;
	}

	@RequestMapping("/RESTaddGaleria")
	public Map addGaleria(@RequestParam(value="foto") String foto) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		galeriaDao = context.getBean(GaleriaDao.class);
		 Map mapa = new HashMap<>();
		 galeriaDao.addFoto(foto);
		    mapa.put("foto", "200");
		    context.close(); 
		    return mapa;
		
	}
	@RequestMapping("/RESTdeleteFoto")
	public void deleteFoto(@RequestParam(value="id") String id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		galeriaDao = context.getBean(GaleriaDao.class);
		galeriaDao.deleteFoto(id);
	}




    /**
     * POST  /some-action  -> do an action.
     *
     * After the action is performed will be notified UserA.
     */
    @RequestMapping(value = "/RESTIngresaEventoUsuario", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> someAction(@RequestBody AvisoIngreso avisoIngreso) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        usuarioDao = context.getBean(UsuarioDao.class);
        Usuario usuario = usuarioDao.getUsuario(avisoIngreso.getIdUsuario());
        notificationService.notify(
                new PantallaIngreso(usuario.getNombre()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
