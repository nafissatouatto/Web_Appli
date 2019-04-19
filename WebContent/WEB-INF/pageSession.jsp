<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#cadre{
width:400px;
padding-top:30px;
margin-left:100px;
border-color:#FF1493;

}
label{text-decoration-color: Blue;}
form{
padding-top:30px;
}
#prenom{margin-left:20px;}
#nom{margin-left:36px;}
</style>
<title>PageSession</title>
</head>
<body>
    <c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>
<fieldset name ="Cadre" id="cadre"> 
<legend><div id="fieldtitre">Connexion</div></legend>
<form method="post" action="Pagesession">
<p>
<label>Nom:</label>

<input type="text" name="nom" id="nom"/><br></p>
<p>
<label>Prenom:</label>
<input type="text" name="prenom" id="prenom"/> 

<p>
   <input type="submit" Value="Connexion"/>
</form>
</fieldset> 

<ul><c:forEach var ="utilisateur" items="${utilisateurs}">
<li><c:out value="${utilisateur.prenom}"></c:out>
<c:out value=" ${utilisateur.nom}"></c:out>
</li>
</c:forEach>
</ul>
</body>