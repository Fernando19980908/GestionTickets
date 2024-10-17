<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipos de Documentos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
    </head>
    <body>
        <h1>Tipos de Documentos</h1>

        <c:choose>
            <c:when test="${tipoDocumento != null}">
                <form action="tiposDocumentos" method="post">
                    <table>
                        <tr>
                            <td><input type="hidden" id="txtAccion" name="txtAccion" value="modificar"</td>
                            <td><input type="hidden" id="txtId" name="txtId" value="${tipoDocumento.id}"></td>
                        </tr>
                        <tr>
                            <td>Tipo Documento</td>
                            <td><input type="text" id="txtNombreDocumento" name="txtNombreDocumento" value="${tipoDocumento.tipoDocumento}"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" id="btnGuardar"  value="Guardar"></td>
                        </tr>
                    </table>
                </form>
            </c:when>
            <c:otherwise>
                <form action="tiposDocumentos" method="post">
                    <table>
                        <tr>
                            <td><input type="hidden" id="txtAccion" name="txtAccion" value="agregar"></td>
                            <td><input type="hidden" id="txtId" name="txtId"></td>
                        </tr>
                        <tr>
                            <td>Nombre Documento</td>
                            <td><input type="text" id="txtNombreDocumento" name="txtNombreDocumento"></td>
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

        <h1>Tipos De Documentos</h1>
        <c:if test="${fn:length(tiposDeDocumentos) > 0}">
            <table>
                <tr>
                    <th>N°</th>
                    <th>Nombre</th>
                    <th>Acción</th>
                </tr>
                <c:set var="contador" value="0"/>
                <c:forEach var="tipoDocumento" items="${tiposDeDocumentos}">
                    <c:set var="contador" value="${contador + 1}"/>
                    <tr>
                        <td>${contador}</td>
                        <td>${tipoDocumento.tipoDocumento}</td>
                        <td>
                            <form action="tiposDocumentos" method="post">
                                <input type="hidden" id="txtAccion" name="txtAccion" value="editar">
                                <input type="hidden" id="txtId" name="txtId" value="${tipoDocumento.id}">
                                <input type="submit" id="btnEditar" value="Editar">    
                            </form>
                            <form action="tiposDocumentos" method="post">
                                <input type="hidden" id="txtAccion" name="txtAccion" value="eliminar">
                                <input type="hidden" id="txtId" name="txtId" value="${tipoDocumento.id}">
                                <input type="submit" id="btnEliminar" value="Eliminar">    
                            </form>
                        </td>
                    </tr>
                </c:forEach>    
            </table>
        </c:if>
    <a href="dashboard.jsp" class="btn btn-primary">DASHBOARD</a></th>
    </body>
</html>
