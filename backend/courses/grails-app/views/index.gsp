<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="css/foundation.css" />

	<style type="text/css">
		.top-separate {
			margin-top: 5em;
		}

		.left-separate{
			border-left: 2em solid rgba(0,0,0,0);	
		}

		.btn-round{
			border-radius: 50%;
			width: 60px;
			height: 60px;
			font-size: 2em !important;
			font-weight: bolder;
			margin-top: -0.4em;
		}

		.input-finder {
			height: 3em !important;
		}

		.img {
			display: block;
			height: 150px;
			width: 150px;
			margin-left: 10%;
		}

		.text-center{
			display: block;
			text-align: center;
		}

	</style>

</head>
<body>
	
	<div class="row">
		<div class="large-12 medium-12 small-12 columns">
			<img src="img/logo.png" height="200" width="200">	
		</div>
	</div>

	<div class="row top-separate">
		
		<div class="large-10 large-centered columns">
			
			<div class="row">
		
				<div class="large-8 medium-8 small-8 columns">
					<input class="input-finder" type="text" name="token" placeholder="Android, Photoshop, Illustrator, etc..."/>
				</div>
				
				<div class="large-4 medium-4 small-4 columns">
					<button class="tiny btn-round"> > </button>
				</div>

			</div>

		</div>

	</div>


	<div class="row top-separate left-separate">
		<div class="large-3 columns">

			<div class="row">
				<div class="large-10 large-centered columns">
					<img class="img" src="img/curso1.png" alt="curso01" width="200" height="200">
				</div>
			</div>
			<div class="row">
				<div class="large-10 large-centered columns">
					<span class="text-center">titulo curso</span>
				</div>
			</div>

		</div>
		<div class="large-3 columns">
			<div class="row">
				<div class="large-10 large-centered columns">
					<img class="img" src="img/curso2.png" alt="curso01" width="200" height="200">
				</div>
			</div>
			<div class="row">
				<div class="large-10 large-centered columns">
					<span class="text-center">titulo curso</span>
				</div>
			</div>
		</div>
		<div class="large-3 columns">
			<div class="row">
				<div class="large-10 large-centered columns">
					<img class="img" src="img/curso3.jpg" alt="curso01" width="200" height="200">
				</div>
			</div>
			<div class="row">
				<div class="large-10 large-centered columns">
					<span class="text-center">titulo curso</span>
				</div>
			</div>
		</div>
		<div class="large-3 columns">
			<div class="row">
				<div class="large-10 large-centered columns">
					<br/>
					<img class="img" src="img/curso4.png" alt="curso01" width="200" height="200">
				</div>
			</div>
			<div class="row">
				<div class="large-10 large-centered columns">
					<span class="text-center">titulo curso</span>
				</div>
			</div>
		</div>
	</div>

	<script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
</body>
</html>