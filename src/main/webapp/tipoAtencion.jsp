<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipos Atención</title>
    </head>
    <body>
        <div class="container">
            <h1>Registrar Tipo de Atención</h1>

            <c:choose>
                <c:when test="${tipoAtencion != null}">
                    <form action="tiposDeAtenciones" method="post">
                        <table>
                            <tr>
                                <td><input type="hidden" id="txtAccion" name="txtAccion" value="modificar"</td>
                                <td><input type="hidden" id="txtId" name="txtId" value="${tipoAtencion.id}"></td>
                            </tr>
                            <tr>
                                <td>Nombre</td>
                                <td><input type="text" id="txtNombreAtencion" name="txtNombreAtencion" value="${tipoAtencion.nombre}"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" id="btnGuardar"  value="Guardar"></td>
                            </tr>
                        </table>
                    </form>
                </c:when>
            </c:choose>
                            <hr>
        </div>
    </body>
    <a href="dashboard.jsp" class="btn btn-primary">DASHBOARD</a></th>
</html>
