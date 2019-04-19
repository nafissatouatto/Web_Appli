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
<title>Cookies</title>
</head>
<body>
<c:out value="Bonjour ${prenom} bienvenue sur notre site web"></c:out>
<fieldset name ="Cadre" id="cadre"> 
<legend><div id="fieldtitre">Session</div></legend>
<form method="post" action="pagecookies">
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
