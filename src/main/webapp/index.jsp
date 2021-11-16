<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>C4P</title>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<center>
<div class="container">
    <div class="row justify-content-center">
        <div class="form-group col-md-4 col-md-offset-5 align-center ">
            <body class="container text-center">
            <main class="form-signing">
            <h1>Base de datos Ciudadanos de 4 Patas! :D</h1>

            <button onclick="location.href='./form-user.jsp';">Create User</button>
            <button onclick="location.href='./form-username.jsp';">Create username</button>

            <h3>Libraries</h3>

            <table id="librariesTbl">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

            <h3>Authors</h3>

            <table id="authorsTbl">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th># Books</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

            <script>

                function printTable(elementId, servlet, columns, actions = []) {

                    var xhr = new XMLHttpRequest();
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4) {
                            var data = JSON.parse(xhr.responseText);

                            var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];

                            data.map(d => {

                                var newRow = tbodyRef.insertRow();

                                columns.map(c => {
                                    var cell = newRow.insertCell();
                                    var text = document.createTextNode(d[c]);
                                    cell.appendChild(text);
                                });

                                if (actions.includes('create-book')) {
                                    var cell = newRow.insertCell();
                                    var action = document.createElement('button');
                                    action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                                    var text = document.createTextNode('Create book');
                                    action.appendChild(text);
                                    cell.appendChild(action);
                                }

                                if (actions.includes('delete-username')) {
                                    var cell = newRow.insertCell();
                                    var action = document.createElement('button');
                                    action.setAttribute('onclick', 'location.href="./delete-username?authorId=' + d['authorId'] + '";');
                                    var text = document.createTextNode('Delete username');
                                    action.appendChild(text);
                                    cell.appendChild(action);
                                }

                            });

                        }
                    }
                    xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
                    xhr.send(null);

                }

                // Printing libraries
                printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name']);

                // Printing usernames
                printTable(elementId = 'authorsTbl', servlet = 'list-usernames', columns = ['authorId', 'name', 'numBooks'], actions = ['create-book', 'delete-username']);

            </script>
                <main class="form-signing">
            </body>
        </div>
    </div>

</div>
</center>

</html>