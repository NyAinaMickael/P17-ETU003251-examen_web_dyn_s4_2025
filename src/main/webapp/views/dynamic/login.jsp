<%@page import="src.main.java.Models.*"%>
<%@page import="java.util.*"%>
<% 
    String message="";
    if(request.getParameter("err")!=null)
    {
        message="Login ou mot de passe incorrect"; 
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/static/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
    <div class="container">
        <form action="back_office" method="post" class="container">
            <div class="form-group">
                <p>Login</p>
                <input type="text" name="nom" value="jean" class="form-control">
            </div>
            <div class="form-group">
                <p>Mot de passe</p>
                <input type="password" name="mdp" value="jean" class="form-control">
            </div>
            <div class="form-group">
            <% if(!message.equals("")){%>
                <p class="text-danger"><%=message%></p>
            <% }%>
            </div>
            <br>
            <input type="submit" class="btn btn-primary" value="Log in">
        </form>
    </div>
</body>
</html>