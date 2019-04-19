<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#cadre{
width:550px;
padding-top:30px;
margin-left:100px;
border-color:#808000;
}

form{
padding-top:30px;



}
#description{margin-left:40px;}
#Charger{margin-left:5px;}
</style>
<title>Chargement</title>
</head>
<body>
<c:if  test="${!empty description }"><c:out value="le fichier ${description } a été charger avec succès"></c:out></c:if>
<fieldset name ="Cadre" id="cadre"> 
<legend><div id="fieldtitre"> Chargement</div></legend>
<form method="post" action="Load" enctype="multipart/form-data">
<p>
<label>Description:</label>

<input type="text" name="description" id="description"/><br></p>
<p>
<label>Fichier à envoyer:</label>
<input type="file" name="fichier" id="fichier"/> 

<c:choose>
<c:when test="${!empty fichier }">
<label> <c:out value="Chargement de ${description }"></c:out>.</label> <br>
</c:when>
<c:when test="${empty fichier}">
<label> <c:out value=" Aucun fichier charger"></c:out>.</label> <br>
</c:when>

</c:choose>

<p>
   <input type="submit" Value="Envoyer"/>
</form>
</fieldset> 
</body>
</html>
