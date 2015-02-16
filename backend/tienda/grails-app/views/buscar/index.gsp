<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<title>Tienda</title>
	<link rel="stylesheet" href="css/foundation.css" />

	<style type="text/css">
		
		.titulo-header {
			height: 8em;
			background-color:#2CD6FF; 
		}

		.contenido {
			margin-top: 3em;
		}

		.footer{
			margin-top: 8em !important;
		}

	</style>

</head>
<body>

	<div class="row titulo-header">
		<div class="large-12 columns">
			<h1>MI TIENDA.com</h1>
		</div>
	</div>

	<div class="row contenido">

		<g:each in="${items}" var="item">
			<div class="large-3 columns panel">
				<img src="" width="100" height="100" alt="imagen">
				<span>${item.name}</span>
				<span>${item.price}</span>
			</div>
		</g:each>

	<div>

	
	

	<script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
</body>
</html>