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
<title>Session</title>
</head>
<body>
<p><c:out value=" "></c:out></p>
<c:if test="${!empty sessionScope.nom && !empty sessionScope.prenom}"><p><c:out value="Bonjour ${sessionScope.nom} ${sessionScope.prenom}"></c:out></p></c:if>
<fieldset name ="Cadre" id="cadre"> 
<legend><div id="fieldtitre">Session</div></legend>
<form method="post" action="session">
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
</body>
</html>
