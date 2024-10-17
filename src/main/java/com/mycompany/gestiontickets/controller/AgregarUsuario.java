package com.mycompany.gestiontickets.controller;

import com.mycompany.gestiontickets.dao.personaDAO;
import com.mycompany.gestiontickets.dao.usuarioDAO;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AgregarUsuario", urlPatterns = {"/agregarUsuario"})
public class AgregarUsuario extends HttpServlet{
    private personaDAO personaDAO1;
    private usuarioDAO usuarioDAO1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        personaDAO1 = new personaDAO();
        usuarioDAO1 = new usuarioDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*List<especialidades> especialidades_ = especialidadesDAO1.selectAllEspecialidades();
        request.setAttribute("especialidad",null);
        request.setAttribute("especialidades",especialidades_);*/
        
        request.getRequestDispatcher("agregarUsuario.jsp").forward(request, response);
    }    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("txtAccion");
        /*if(accion.equals("agregar")) {
            String nombre = request.getParameter("txtNombreAtencion");   
            System.out.println(nombre); 
            especialidadesDAO1.insertEspecialidad(new especialidades(0,nombre));
        }
        else if(accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            especialidades especialidad = especialidadesDAO1.selectByIdEspecialidades(id);
            request.setAttribute("especialidad",especialidad);
            request.getRequestDispatcher("especialidades.jsp").forward(request, response);            
        }
        else if(accion.equals("modificar")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtNombreAtencion");
            
            especialidadesDAO1.updateEspecialidad(new especialidades(id,nombre));
        }
        else {
            int id = Integer.parseInt(request.getParameter("txtId"));
            especialidadesDAO1.deleteEspecialidad(new especialidades(id));            
        }*/
        
        response.sendRedirect("agregarUsuario");
    }
    
}
