<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create user</title>
    </head>
    <center>
    <body>

        <form action="./create-user">
            <h1>Base de datos Ciudadanos de 4 Patas! :D</h1>
            <div>
                Username: <input type="text" id="name" name="name" required>
            </div>
            <div>
                Password:  <input type="password" id="password" name="password" required>
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div>
                <label for="role">Choose role:</label>
                <select name="role" id="role">
                    <option value="official">Official</option>
                    <option value="owner">Owner</option>
                    <option value="vet">Vet</option>
                </select>
            </div>
            <input type="submit" value="Create User">
        </form>
    </body>
    </center>
</html>
