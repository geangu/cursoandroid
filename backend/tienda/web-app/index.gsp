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
		<div class="large-6 large-centered columns panel">
			<form action="buscar" method="get">
				<input type="text" name="elemento" value="" placeholder="Busque sus productos aqui">
				<input class="button right" type="submit" value="->">
			</form>
		</div>
	<div>

	<div class="row footer">
		<div class="large-4 columns panel">
			AQUI UNA COSA
		</div>
		<div class="large-4 columns panel">
			AQUI UNA COSA
		</div>
		<div class="large-4 columns panel">
			AQUI UNA COSA
		</div>
	</div>
	

	<script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
</body>
</html>