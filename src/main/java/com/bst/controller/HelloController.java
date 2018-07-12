package com.bst.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bst.model.Agenda;
import com.bst.model.Expositores;
import com.bst.model.Ponentes;
import com.bst.model.Sponsors;
import com.bst.model.Usuario;
import com.bst.restcontroller.EndpointsRest;


@Controller
public class HelloController {


    @RequestMapping("/")
	public String index() {
		   return "index";
	}
    
    @RequestMapping("/home")
   	public String home() {
   		   return "index";
   	}
	
	protected EndpointsRest serviciosRest = new EndpointsRest();
	
	@RequestMapping("/login")
	public String login() {
		   return "login";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/logeo")
	public String trylogin(HttpServletRequest request) {
		String email = request.getParameter("txtemail");
    	String codigo = request.getParameter("txtcodigo");
		Map categoria = serviciosRest.login(email, codigo);
		int cat = Integer.valueOf(categoria.get("Categoria").toString());
		if(cat!=0) {
			if(cat!=3) {
			return "menu";}else {
				return "menuadmin";
			}
		}
		return "login";
	}
	    
    @SuppressWarnings("rawtypes")
	@GetMapping("/registro")
    public String  registro(Map<String, Object> model) {
    	Map mapa = serviciosRest.getCentrosOperativos();
    	List lista = (List) mapa.get("Centros Operativos");
    	model.put("lista",lista);	
        return "registro";
    }
    
    @PostMapping("/addregistro")
    public String  pushRegisro(HttpServletRequest request) {
    	String nombre = request.getParameter("txtnombre");
    	String email = request.getParameter("txtmail");
    	String contrasena = request.getParameter("txtcodigo");
    	String telefono = request.getParameter("txtcelular");
    	String fechaNacimientoTemp = request.getParameter("txtnacimiento");
    	String idCentroOperativoTemp = request.getParameter("centrooperativo");
    	String idCategoriaTemp = request.getParameter("txtcategoria");
    	String empresa = request.getParameter("txtEmpresa");
    	Date fechaNacimiento = Date.valueOf(fechaNacimientoTemp);
    	int idCentroOperativo = Integer.valueOf(idCentroOperativoTemp);
    	int idCategoria = Integer.valueOf(idCategoriaTemp);
    	//metervalidacion de existente
    	if(idCategoria==1) {
    	serviciosRest.registrar(nombre, email, contrasena, telefono, fechaNacimiento, idCentroOperativo, idCategoria);  	
    	}else {
    		serviciosRest.registrarClientes(nombre, email, contrasena, telefono, fechaNacimiento, empresa, idCategoria);
    	}
    	return "menu";
    }
    
    @SuppressWarnings("rawtypes")
	@GetMapping("/usuariosadmin")
    public String  usuariosadmin(Model model) {
    	Map mapa = serviciosRest.getlistausuarios();
    	List lista = (List) mapa.get("usuarios");
    	model.addAttribute("lista",lista);	
        return "usuariosadmin";
    }
    
    @SuppressWarnings("rawtypes")
   	@GetMapping("/editarUsuario")
       public String  editarUsuario(Model model,HttpServletRequest request) {
    	String idUsuario = request.getParameter("idUsuario");
       	Map mapa = serviciosRest.getUsuario(idUsuario);
       	Usuario usuario = (Usuario) mapa.get("usuario");
       	Map maps = serviciosRest.getCentrosOperativos();
       	List listacentro = (List) maps.get("Centros Operativos");
       	model.addAttribute("usuario",usuario);
       	model.addAttribute("lista", listacentro);
        return "editarusuario";
       }
    
    @SuppressWarnings("rawtypes")
   	@GetMapping("/updateUsuario")
       public String  updateUsuario(Model model,HttpServletRequest request) {
    	String nombre = request.getParameter("txtnombre");
    	String email= request.getParameter("txtemail");
    	String telefono= request.getParameter("txttelefono");
    	String fechaNacimientoTemp= request.getParameter("txtfecha");
    	String centro= request.getParameter("centrooperativo");
    	int categoria= Integer.valueOf(request.getParameter("categoria"));
    	int status= Integer.valueOf(request.getParameter("status"));
    	String Empresa= request.getParameter("txtempresa");
    	String idUsuario = request.getParameter("idusuario");
    	Date fechaNacimiento = Date.valueOf(fechaNacimientoTemp);
       	serviciosRest.updateUsuario(nombre,email,telefono,fechaNacimiento,centro,categoria,status,Empresa,idUsuario);
    	int codigo = Integer.valueOf(request.getParameter("txtcodigo"));
    	LlamadasController llamada = new LlamadasController();
    	try {
			llamada.sendMensajeRegistro(nombre, telefono, codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       	return "menuadmin";
       }

    @GetMapping("/listaexpositores")
   	public String listaexpositores(Model model) {
    	Map mapa = serviciosRest.getListaexpositores();
    	List lista = (List) mapa.get("expositores");
    	model.addAttribute("lista", lista);
    	return "listaexpositores";
   	}
    
    @GetMapping("/expositoresadmin")
   	public String gestionexpositores(Model model) {
    	Map mapa = serviciosRest.getListaexpositores();
    	List lista = (List) mapa.get("expositores");
    	model.addAttribute("lista", lista);
    	return "gestionexpositores";
   	}
    
    @GetMapping("/editarExpositor")
   	public String editarExpositor(Model model,HttpServletRequest request) {
    	String idUsuario = request.getParameter("idExpositor");
    	Map mapa = serviciosRest.getExpositorId(idUsuario);
    	Expositores expositor = (Expositores) mapa.get("expositor");
    	model.addAttribute("expositor", expositor);
    	return "editarexpositor";
   	}
    
    @PostMapping("/updateExpositor")
   	public String updateExpositor(Model model,HttpServletRequest request) {
    	String idExpositor = request.getParameter("idexpositor");
    	String nombre = request.getParameter("txtnombre");
    	String facebook = request.getParameter("txtfacebook");
    	String google = request.getParameter("txtgoogle");
    	String twitter = request.getParameter("txttwitter");
    	String paginainternet = request.getParameter("txtpaginainternet");
    	String cambio = request.getParameter("txtcambio");
    	String bslogo = request.getParameter("bslogo");
    	String bslogolimpia=bslogo;
    	if(cambio.equals("1")){bslogolimpia=bslogo.substring(22);}
    	serviciosRest.updateExpositor(idExpositor,nombre,facebook,google,twitter,paginainternet,bslogolimpia);
    	return "menuadmin";
   	}
    
    @GetMapping("/agregarExpositor")
   	public String agregarExpositor(Model model) {
    	return "agregarexpositor";
   	}
    
    @PostMapping("/addExpositor")
   	public String addExpositor(Model model,HttpServletRequest request) {
    	String nombre = request.getParameter("txtnombre");
    	String facebook = request.getParameter("txtfacebook");
    	String google = request.getParameter("txtgoogle");
    	String twitter = request.getParameter("txttwitter");
    	String paginainternet = request.getParameter("txtpaginainternet");
    	String bslogo = request.getParameter("bslogo");
    	String bslogolimpia=bslogo.substring(22);
    	serviciosRest.addExpositor(nombre,facebook,google,twitter,paginainternet,bslogolimpia);
    	return "menuadmin";
   	}
    
    @GetMapping("/deleteExpositor")
   	public String deleteExpositor(Model model,HttpServletRequest request) {
    	String idExpositor = request.getParameter("idexpositord");
    	serviciosRest.deleteExpositor(idExpositor);
    	return "menuadmin";
   	}
    
    @GetMapping("/listaponentes")
   	public String listaponentes(Model model) {
    	Map mapa = serviciosRest.getListaponentes();
    	List lista = (List) mapa.get("ponentes");
    	model.addAttribute("lista", lista);
    	return "ponentesusuario";
   	}
     
    @GetMapping("/logout")
   	public String logout(Model model) {
    	return "login";
   	}
    @GetMapping("/revisarPonente")
   	public String revisarPonente(Model model,HttpServletRequest request) {
    	String idPonente = request.getParameter("idPonente");
    	Map mapa = serviciosRest.getPonenteId(idPonente);
    	Ponentes ponente = (Ponentes) mapa.get("ponente");
    	model.addAttribute("ponente", ponente);
    	return "ponentedetalle";
   	}
    
    @GetMapping("/ponentesadmin")
   	public String gestionponentes(Model model) {
    	Map mapa = serviciosRest.getListaponentes();
    	List lista = (List) mapa.get("ponentes");
    	model.addAttribute("lista", lista);
    	return "gestionponentes";
   	}
    
    @GetMapping("/editarPonente")
   	public String editarPonente(Model model,HttpServletRequest request) {
    	String idPonente = request.getParameter("idPonente");
    	Map mapa = serviciosRest.getPonenteId(idPonente);
    	Ponentes ponente = (Ponentes) mapa.get("ponente");
    	model.addAttribute("ponente", ponente);
    	return "editarPonente";
   	}
    
    @PostMapping("/updatePonente")
   	public String updatePonente(Model model,HttpServletRequest request) {
    	String idPonente = request.getParameter("idponente");
    	String nombre = request.getParameter("txtnombre");
    	String puesto = request.getParameter("txtpuesto");
    	String semblanza = request.getParameter("txtsemblanza");
    	String cambio = request.getParameter("txtcambio");
    	String bslogo = request.getParameter("bslogo");
    	String bslogolimpia=bslogo;
    	if(cambio.equals("1")){bslogolimpia=bslogo.substring(22);}
    	serviciosRest.updatePonente(idPonente,nombre,puesto,semblanza,bslogolimpia);
    	return "menuadmin";
   	}
    
    @GetMapping("/deletePonente")
   	public String deletePonente(Model model,HttpServletRequest request) {
    	String idPonente = request.getParameter("idponented");
    	serviciosRest.deletePonente(idPonente);
    	return "menuadmin";
   	}
    
    @GetMapping("/agregarPonente")
   	public String agregarPonente(Model model) {
    	return "agregarPonentes";
   	}
    
    @PostMapping("/addPonente")
   	public String addPonente(Model model,HttpServletRequest request) throws UnsupportedEncodingException {
    	 
    	String bslogo = request.getParameter("bslogo");
    	String bslogolimpia=bslogo.substring(22);
    	String nombre = request.getParameter("txtnombre");
    	String puesto = request.getParameter("txtpuesto");
    	String semblanza = request.getParameter("txtsemblanza");
    	serviciosRest.addPonente(nombre,puesto,semblanza,bslogolimpia);
    	return "menuadmin";
   	}
    
    @GetMapping("/hello")
   	public String hello(Model model) {
    	return "hello";
   	}
    
    @GetMapping("/test")
   	public String test(Model model) {
    	LlamadasController llamar = new LlamadasController();
    	try {
			llamar.sendGet();
			llamar.sendPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	return "hello";
   	}
    
    @GetMapping("/notificaciones")
   	public String listanotificaciones(Model model,HttpServletRequest request) {
    	return "notificaciones";
   	}
    
    @GetMapping("/agenda")
   	public String agenda(Model model,HttpServletRequest request) {
    	Map mapa1 = serviciosRest.getAgenda("28");
    	List lista1 = (List) mapa1.get("agenda");
    	model.addAttribute("lista1", lista1);
    	Map mapa2 = serviciosRest.getAgenda("29");
    	List agenda2 = (List) mapa2.get("agenda");
    	model.addAttribute("lista2", agenda2);
    	return "agenda";
   	}
    
    @GetMapping("/atras")
   	public String menuusuario(Model model,HttpServletRequest request) {
    	return "menu";
   	}

    @GetMapping("/sponsors")
   	public String listasponsors(Model model) {
    	Map mapa = serviciosRest.getListasponsors();
    	List lista = (List) mapa.get("sponsors");
    	model.addAttribute("lista", lista);
    	return "listasponsors";
   	}
    
    @GetMapping("/sponsorsadmin")
   	public String listasponsorsadmin(Model model) {
    	Map mapa = serviciosRest.getListasponsors();
    	List lista = (List) mapa.get("sponsors");
    	model.addAttribute("lista", lista);
    	return "listasponsorsadmin";
   	}

    @GetMapping("/anadirSponsor")
   	public String anadirSponsor(Model model) {
    	return "agregarSponsor";
   	}
    
    @PostMapping("/addSponsor")
   	public String addSponsor(Model model,HttpServletRequest request) {
    	try {
			request.setCharacterEncoding("ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String nombre = request.getParameter("txtnombre");
    	String facebook = request.getParameter("txtfacebook");
    	String google = request.getParameter("txtgoogle");
    	String twitter = request.getParameter("txttwitter");
    	String paginainternet = request.getParameter("txtpaginainternet");
    	String bslogo = request.getParameter("bslogo");
    	String bslogolimpia=bslogo.substring(22);
    	serviciosRest.addSponsor(nombre,facebook,google,twitter,paginainternet,bslogolimpia);
    	return "menuadmin";
   	}
    
    @GetMapping("/deleteSponsor")
   	public String deleteSponsor(Model model,HttpServletRequest request) {
    	String idSponsor = request.getParameter("idsponsord");
    	serviciosRest.deleteSponsor(idSponsor);
    	return "menuadmin";
   	}
    
    
    @GetMapping("/editarsponsor")
   	public String editarSponsor(Model model,HttpServletRequest request) {
    	String idUsuario = request.getParameter("idsponsorr");
    	Map mapa = serviciosRest.getSponsorId(idUsuario);
    	Sponsors sponsor = (Sponsors) mapa.get("sponsor");
    	model.addAttribute("sponsor", sponsor);
    	return "editarsponsor";
   	}
    
    @PostMapping("/updateSponsor")
   	public String updateSponsor(Model model,HttpServletRequest request) {
    	String idSponsors = request.getParameter("idSponsor");
    	String nombre = request.getParameter("txtnombre");
    	String facebook = request.getParameter("txtfacebook");
    	String google = request.getParameter("txtgoogle");
    	String twitter = request.getParameter("txttwitter");
    	String paginainternet = request.getParameter("txtpaginainternet");
    	String cambio = request.getParameter("txtcambio");
    	String bslogo = request.getParameter("bslogo");
    	String bslogolimpia=bslogo;
    	if(cambio.equals("1")){bslogolimpia=bslogo.substring(22);}
    	serviciosRest.updateSponsor(idSponsors, nombre, facebook, google, twitter, paginainternet, bslogolimpia);
    	return "menuadmin";
   	}

    @GetMapping("/conferenciasadmin")
   	public String conferenciasadmin(Model model,HttpServletRequest request) {
    	Map mapa1 = serviciosRest.getAgenda("28");
    	List lista1 = (List) mapa1.get("agenda");
    	model.addAttribute("lista1", lista1);
    	Map mapa2 = serviciosRest.getAgenda("29");
    	List agenda2 = (List) mapa2.get("agenda");
    	model.addAttribute("lista2", agenda2);
    	return "agendaadmin";
   	}
    
    @GetMapping("/agregaragenda")
   	public String agregarconferencia(Model model,HttpServletRequest request) {
    	Map mapa = serviciosRest.getListaponentes();
    	List lista = (List) mapa.get("ponentes");
    	model.addAttribute("lista", lista);
    	return "agregaragenda";
   	}
    
    @GetMapping("/addAgenda")
   	public String addAgenda(Model model,HttpServletRequest request) {
    	String titulo = request.getParameter("txttitulo");
    	String horafin = request.getParameter("horafin");
    	String fechafin = request.getParameter("fechafin");
    	String horainicio = request.getParameter("horainicio");
    	String fechainicio = request.getParameter("fechainicio");
    	String[] ponentes = request.getParameterValues("ponentes");
    	serviciosRest.addEvento(titulo,fechainicio,horainicio,fechafin,horafin,ponentes);
    	return "menuadmin";
   	}
    
    @GetMapping("/editarAgenda")
   	public String editarAgenda(Model model,HttpServletRequest request) {
    	String id = request.getParameter("idEvento");
    	Map mapa = serviciosRest.getEvento(id);
    	Agenda agenda = (Agenda) mapa.get("agenda");
    	model.addAttribute("agenda", agenda);
    	Map mapa2 = serviciosRest.getListaponentes();
    	List lista = (List) mapa2.get("ponentes");
    	model.addAttribute("lista", lista);
    	return "editarEvento";
   	}
    
    @GetMapping("/updateAgenda")
   	public String updateAgenda(Model model,HttpServletRequest request) {
    	String titulo = request.getParameter("txttitulo");
    	String horafin = request.getParameter("horafin");
    	String fechafin = request.getParameter("fechafin");
    	String horainicio = request.getParameter("horainicio");
    	String fechainicio = request.getParameter("fechainicio");
    	String[] ponentes = request.getParameterValues("ponentes");
    	String id = request.getParameter("txtid");
    	serviciosRest.updateAgenda(titulo,fechainicio,horainicio,fechafin,horafin,ponentes,id);
    	return "menuadmin";
   	}
    
    
    @GetMapping("/deleteEvento")
   	public String deleteEvento(Model model,HttpServletRequest request) {
    	String id = request.getParameter("txtid");
    	serviciosRest.deleteEvento(id);
    	return "menuadmin";
   	}
    
    
    @GetMapping("/galeriaadmin")
   	public String galeriaadmin(Model model,HttpServletRequest request) {
    	Map mapa = serviciosRest.getGaleria();
    	List galeria = (List) mapa.get("galeria");
    	model.addAttribute("fotos", galeria);
    	return "galeriaadmin";
   	}
    
    @GetMapping("/agregarFoto")
   	public String anadirFoto(Model model,HttpServletRequest request) {
    	return "agregarFoto";
   	}
    
    @PostMapping("/addFoto")
   	public String addFoto(Model model,HttpServletRequest request) {
    	String bslogo = request.getParameter("bslogo");
    	String bslogolimpia=bslogo.substring(22);
    	serviciosRest.addGaleria(bslogolimpia);
    	return "menuadmin";
   	}
    
    @GetMapping("/galeria")
   	public String galeria(Model model,HttpServletRequest request) {
    	Map mapa = serviciosRest.getGaleria();
    	List galeria = (List) mapa.get("galeria");
    	model.addAttribute("fotos", galeria);
    	return "galeria";
   	}
    
    @GetMapping("/eliminarFoto")
   	public String eliminarFoto(Model model,HttpServletRequest request) {
    	String id = request.getParameter("idfoto");
    	serviciosRest.deleteFoto(id);
    	Map mapa = serviciosRest.getGaleria();
    	List galeria = (List) mapa.get("galeria");
    	model.addAttribute("fotos", galeria);
    	return "galeriaadmin";
   	}
    
    
}