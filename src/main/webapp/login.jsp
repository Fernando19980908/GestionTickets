<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <script src="https://kit.fontawesome.com/8622076d3d.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/8622076d3d.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styleLogin.css">
    </head>
    
<body class="contenidoLogin" style="background-image: url('background-login.jpg');">
    <main class="contenedor">
        <div class="containerLogin">
            <div class="nameApp">
                <h2>Gestión de Tickets</h2>
            </div>
            <form method="post" action="dashboard">
                <div class="inputContainer containerUser">
                    <input required="required" name="correo" id="user" class="inputField" placeholder="Usuario" type="text" required>
                    <label class="usernameLabel" for="user">Usuario</label>
                    <svg viewBox="0 0 448 512" class="userIcon">
                        <path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"></path>
                    </svg>
                </div>
                <div class="inputContainer containerPass">                    
                    <input required="required" name="password" id="password" class="inputField" placeholder="Contraseña" type="password" required>
                    <label class="usernameLabel" for="password">Contraseña</label>
                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512" class="userIcon"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                        <path d="M144 144v48H304V144c0-44.2-35.8-80-80-80s-80 35.8-80 80zM80 192V144C80 64.5 144.5 0 224 0s144 64.5 144 144v48h16c35.3 0 64 28.7 64 64V448c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V256c0-35.3 28.7-64 64-64H80z" />
                    </svg>
                </div>
                <div class="containerBtn">
                    <input name="btningresar" type="submit" class="button-78" value="Iniciar Sesión">
                </div>
            </form>
        </div>
    </main>
</body>

</html>
