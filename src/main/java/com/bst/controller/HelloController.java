package com.bst.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bst.model.Expositores;
import com.bst.model.Ponentes;
import com.bst.model.Usuario;
import com.bst.restcontroller.EndpointsRest;


@Controller
public class HelloController {


    @RequestMapping("/")
	public String index() {
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
    
    @GetMapping("/updateExpositor")
   	public String updateExpositor(Model model,HttpServletRequest request) {
    	String idExpositor = request.getParameter("idexpositor");
    	String nombre = request.getParameter("txtnombre");
    	String facebook = request.getParameter("txtfacebook");
    	String google = request.getParameter("txtgoogle");
    	String twitter = request.getParameter("txttwitter");
    	String paginainternet = request.getParameter("txtpaginainternet");
    	serviciosRest.updateExpositor(idExpositor,nombre,facebook,google,twitter,paginainternet);
    	return "menuadmin";
   	}
    
    @GetMapping("/agregarExpositor")
   	public String agregarExpositor(Model model) {
    	return "agregarexpositor";
   	}
    
    @GetMapping("/addExpositor")
   	public String addExpositor(Model model,HttpServletRequest request) {
    	String nombre = request.getParameter("txtnombre");
    	String facebook = request.getParameter("txtfacebook");
    	String google = request.getParameter("txtgoogle");
    	String twitter = request.getParameter("txttwitter");
    	String paginainternet = request.getParameter("txtpaginainternet");
    	serviciosRest.addExpositor(nombre,facebook,google,twitter,paginainternet);
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
    	return "listaponentes";
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
    
    @GetMapping("/updatePonente")
   	public String updatePonente(Model model,HttpServletRequest request) {
    	String idPonente = request.getParameter("idponente");
    	String nombre = request.getParameter("txtnombre");
    	String puesto = request.getParameter("txtpuesto");
    	String semblanza = request.getParameter("txtsemblanza");
    	serviciosRest.updatePonente(idPonente,nombre,puesto,semblanza);
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
    

    @GetMapping("/addPonente")
   	public String addPonente(Model model,HttpServletRequest request) {
    	String nombre = request.getParameter("txtnombre");
    	String puesto = request.getParameter("txtpuesto");
    	String semblanza = request.getParameter("txtsemblanza");
    	serviciosRest.addPonente(nombre,puesto,semblanza);
    	return "menuadmin";
   	}
    
}