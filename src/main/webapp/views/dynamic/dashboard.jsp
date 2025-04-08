<%@page import="src.main.java.Models.*"%>
<%@page import="java.util.*"%>
<% ArrayList<HashMap<String,Object>> lignes=(ArrayList<HashMap<String,Object>>) request.getAttribute("data"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/static/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
    <div>
        <h2>DASHBOARD</h2>
        <table class="table table-hover">
            <tr>
                <th>Libelle</th>
                <th>Depenses</th>
                <th>Reste</th>
            </tr>
            <% for(HashMap<String,Object> ligne:lignes) {%>
                <tr>
                    <td><%=ligne.get("libelle")%></td>
                    <td><%=ligne.get("depenses")%></td>
                    <td><%=ligne.get("reste")%></td>
                </tr>
            <% } %>

        </table>
    </div>
    <a href="back_office">BackOffice</a>
</body>
</html>