package com.bst.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.bst.model.Usuario;
import com.bst.restcontroller.EndpointsRest;


public  class XlsView extends AbstractXlsView {
	protected EndpointsRest serviciosRest = new EndpointsRest();
    @Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // cambiar nombre de archivo
        response.setHeader("Content-Disposition", "attachment; filename=\"asistentes.xls\"");

        // crear una pagina excel
        Sheet sheet = workbook.createSheet("Lista de Asistentes");


        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Nombre");
        header.createCell(1).setCellValue("E-Mail");
        header.createCell(2).setCellValue("Telefono");
        header.createCell(3).setCellValue("Fecha-Nacimiento");
        header.createCell(4).setCellValue("Tipo Usuario");
        header.createCell(5).setCellValue("Centro Operativo");
        header.createCell(6).setCellValue("Empresa");
        header.createCell(7).setCellValue("Codigo");

        int count_row = 1;
        Map mapa = serviciosRest.getlistausuarios();
    	List<Usuario> lista = (List) mapa.get("usuarios");
        for (Usuario usuario : lista) {
            Row customerRow = sheet.createRow(count_row++);

            customerRow.createCell(0).setCellValue(usuario.getNombre());
            customerRow.createCell(1).setCellValue(usuario.getEmail());
            customerRow.createCell(2).setCellValue(usuario.getTelefono());
            customerRow.createCell(3).setCellValue(usuario.getFechaNacimiento());
            customerRow.createCell(4).setCellValue(usuario.getCategoria().getDetalle());
            customerRow.createCell(5).setCellValue(usuario.getCentro().getCentroOpeativo());
            customerRow.createCell(6).setCellValue(usuario.getEmpresa());
            customerRow.createCell(7).setCellValue(usuario.getCodigo());
        }
    }

}
