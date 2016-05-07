<!DOCTYPE html>
<html>

<head>
	<title>next-events | Home</title>
	<link rel="stylesheet" type="text/css" href="css/index-style.css">
	<!--MaterializeCSS-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>

	<script type="text/javascript">
		
		  $(document).ready(function(){
		    $('.collapsible').collapsible({
		      accordion : false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
		    });
		  });

	</script>
</head>

<body>

    <div>
    	<div class="navbar-fixed">
		    <nav class="orange">
		      <div class="nav-wrapper container">
		        <a href="#!" class="brand-logo navlogo">NEXTEVENTS</a>
		        <ul class="right hide-on-med-and-down">
		          <li class="active"><a href="#">Events</a></li>
		          <li><a href="#">Contacts</a></li>
		          <li><a href="./login"><i class="material-icons">input</i></a></li>
		        </ul>
		      </div>
		    </nav>
		</div>
 	</div>

 	<div class=" cover">
 		<div>
 			<p>Which is the next event?<br/>Comment with us</p>
 		</div>
 	</div>

 	<div class="white">
	 	<div class="container nextCards">
	 	<div class="row">
	 	<div class="col s12">
	 		<div class="divTitle">
	 			<h5>NEXT EVENTS</h5>
	 		</div>
	 		<br/>
	 		<ul class="collapsible popout" data-collapsible="expandable">
			    <li class="grey lighten-4">
			      <div class="collapsible-header"><i class="material-icons">today</i>First</div>
			      <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
			    </li>
			</ul>
	 	</div>
	 	</div>
	 	</div>
 	</div>

 	<br/><br/>

 	<div class="grey lighten-3">
 	<br/><br/>
 		<div class="container">
 			<div class="col s12 divTitle">
	 			<h5>PAST EVENTS</h5>
	 		</div>
	 		<br/>
			<div class="row">
				<div class="col s3">
					<div class="card ">
		            <div class="card-image ">
		              <img src="img/event.jpg">
		              <span class="card-title">Event name </span>
		            </div>
		            <div class="card-content blue-grey lighten-5">
		              <p>Event description ... </p>
		            </div>
		            <div class="card-action blue-grey lighten-5">
		              <a href="#">Go to the event</a>
		            </div>
		        </div>
			</div>
 		</div>

 		<br/><br/>
 	</div>
</body>
</html>