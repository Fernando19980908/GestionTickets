<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Especialidades</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
    </head>
    <body>
        <h1>Registrar Especialidades de Atención</h1>

        <c:choose>
            <c:when test="${especialidad != null}">
                <form action="especialidades" method="post">
                    <table>
                        <tr>
                            <td><input type="hidden" id="txtAccion" name="txtAccion" value="modificar"</td>
                            <td><input type="hidden" id="txtId" name="txtId" value="${especialidad.id}"></td>
                        </tr>
                        <tr>
                            <td>Nombre Especialidad</td>
                            <td><input type="text" id="txtNombreAtencion" name="txtNombreAtencion" value="${especialidad.tipoEspecialidad}"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" id="btnGuardar"  value="Guardar"></td>
                        </tr>
                    </table>
                </form>
            </c:when>
            <c:otherwise>
                <form action="especialidades" method="post">
                    <table>
                        <tr>
                            <td><input type="hidden" id="txtAccion" name="txtAccion" value="agregar"></td>
                            <td><input type="hidden" id="txtId" name="txtId"></td>
                        </tr>
                        <tr>
                            <td>Nombre Especialidad</td>
                            <td><input type="text" id="txtNombreAtencion" name="txtNombreAtencion"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" id="btnGuardar" value="Guardar"></td>
                        </tr>
                    </table>
                </form>
                
            </c:otherwise>
        </c:choose>

        <hr>

        <h1>Especialidades</h1>
        <c:if test="${fn:length(especialidades) > 0}">
            <table>
                <tr>
                    <th>N°</th>
                    <th>Nombre</th>
                    <th>Acción</th>
                </tr>
                <c:set var="contador" value="0"/>
                <c:forEach var="especialidad" items="${especialidades}">
                    <c:set var="contador" value="${contador + 1}"/>
                    <tr>
                        <td>${contador}</td>
                        <td>${especialidad.tipoEspecialidad}</td>
                        <td>
                            <form action="especialidades" method="post">
                                <input type="hidden" id="txtAccion" name="txtAccion" value="editar">
                                <input type="hidden" id="txtId" name="txtId" value="${especialidad.id}">
                                <input type="submit" id="btnEditar" value="Editar">    
                            </form>
                            <form action="especialidades" method="post">
                                <input type="hidden" id="txtAccion" name="txtAccion" value="eliminar">
                                <input type="hidden" id="txtId" name="txtId" value="${especialidad.id}">
                                <input type="submit" id="btnEliminar" value="Eliminar">    
                            </form>
                        </td>
                    </tr>
                </c:forEach>    
            </table>
        </c:if>
    </body>
    <a href="dashboard.jsp" class="btn btn-primary">DASHBOARD</a></th>
</html>

