<%@page import="src.main.java.Models.*"%>
<%@page import="java.util.*"%>
<% List<LigneCredit> lignesCredit=(List<LigneCredit>) request.getAttribute("lignes_credit"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/static/css/bootstrap.min.css">
    <title>Ligne Depense</title>
</head>
<body>
    <div>
        <ul class="nav nav-tabs">
            <li role="presentation" ><a href="form_ligne_credit">Ligne credit</a></li>
            <li role="presentation" class="active"><a href="form_ligne_depense">Ligne depense</a></li>
        </ul>
        <h2>Page de ligne de depense</h2>
        <form action="ligne_depense" method="post" class="container">
            <div class="form-group">
                <p>Ligne de credit</p>
                <select name="id_ligne_credit" id="id_ligne_credit" class="form-control">
                    <option value="">Selectionner une ligne de credit</option>
                    <% for(LigneCredit ligneCredit:lignesCredit){ %>
                        <option value="<%=ligneCredit.getId()%>"><%=ligneCredit.getLibelle()%></option>
                    <% } %>
                    
                </select>
            </div>
            <div class="form-group">
                <p>Montant</p>
                <input type="number" name="montant" class="form-control">
                <% if(request.getParameter("err")!=null){ %>
                    <p class="text-danger">Votre insertion est hors budget</p>
                <% } %>
            </div>
            <br>
            <input type="submit" class="btn btn-primary" value="VALIDER">
        </form>
    </div>
</body>
</html>