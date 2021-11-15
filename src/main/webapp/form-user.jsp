<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create user</title>
    </head>
    <body>

        <form action="./create-user">
            <h1>Base de datos Ciudadanos de 4 Patas! :D</h1>
            <div>
                Username: <input type="text" id="name" name="name">
            </div>
            <div>
                Password: <input type="password" id="password" name="password">
            </div>
            <div>
                Email: <input type="text" id="email" name="email">
            </div>
            <div>
                Role: <input type="text" id="role" name="role">
            </div>
            <input type="submit" value="Create User">
        </form>
    </body>
</html>
