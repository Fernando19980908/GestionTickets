package com.mycompany.gestiontickets.controller;


import com.mycompany.gestiontickets.dao.especialidadesDAO;
import com.mycompany.gestiontickets.dao.tipoDocumentoDAO;
import com.mycompany.gestiontickets.model.especialidades;
import com.mycompany.gestiontickets.model.tipoDocumento;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TipoDocumentoController", urlPatterns = {"/tiposDocumentos"})
public class TipoDocumentoController extends HttpServlet{
    private tipoDocumentoDAO tipoDocumentoDAO1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        tipoDocumentoDAO1 = new tipoDocumentoDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<tipoDocumento> tipoDocumento_ = tipoDocumentoDAO1.selectAllTiposDocumento();
        request.setAttribute("tipoDocumento",null);
        request.setAttribute("tiposDeDocumentos",tipoDocumento_);
        
        request.getRequestDispatcher("tiposDocumentos.jsp").forward(request, response);
    }    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("txtAccion");
        if(accion.equals("agregar")) {
            String nombre = request.getParameter("txtNombreDocumento");
            tipoDocumentoDAO1.insertTipoDocumento(new tipoDocumento(0,nombre));
        }
        else if(accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            tipoDocumento tipoDocumento1 = tipoDocumentoDAO1.selectByTipoDocumento(id);
            request.setAttribute("tipoDocumento",tipoDocumento1);
            request.getRequestDispatcher("tiposDocumentos.jsp").forward(request, response);            
        }
        else if(accion.equals("modificar")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtNombreDocumento");
            
            tipoDocumentoDAO1.updateTipoDocumento(new tipoDocumento(id,nombre));
        }
        else {
            int id = Integer.parseInt(request.getParameter("txtId"));
            tipoDocumentoDAO1.deletePersona(new tipoDocumento(id));            
        }
        
        response.sendRedirect("tiposDocumentos");
    }    
}
