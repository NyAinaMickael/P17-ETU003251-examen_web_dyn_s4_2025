<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/static/css/bootstrap.min.css">
    <title>Ligne Credit</title>
</head>
<body>
    <div>
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="#">Ligne credit</a></li>
            <li role="presentation"><a href="form_ligne_depense">Ligne depense</a></li>
        </ul>
        <h2>Page de ligne de credit</h2>
        <form action="ligne_credit" method="post" class="container">
            <div class="form-group">
                <p>Libelle</p>
                <input type="text" name="libelle" class="form-control">
            </div>
            <div class="form-group">
                <p>Montant</p>
                <input type="number" name="montant" class="form-control">
            </div>
            <br>
            <input type="submit" class="btn btn-primary" value="VALIDER">
        </form>
    </div>
</body>
</html>