<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
        <link href="./resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="./resources/css/agency.css" rel="stylesheet">
        <link rel="stylesheet" href="./resources/css/normalize.css">
        <link rel="stylesheet" href="./resources/css/style.css">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>Nuovo evento</title>
        <script>
            var i = 1;
            function aggiungiArtista() {
                var add = document.getElementById("add");
                add.parentNode.removeChild(add);
                var re = document.getElementById("delete");
                re.parentNode.removeChild(re);
                var newdiv = document.createElement('div');
                newdiv.id = "div" + i;
                newdiv.innerHTML = "<input class=\"form-control\" placeholder=\"Artista " + (i + 1) + "\" id=\"artisti\" type=\"text\" name=\"artisti[]\">\n\
                                    <input class=\"col-md-6\" type=\"button\" id=\"add\" value=\"+\" onClick=\"aggiungiArtista();\">\n\
                                    <input class=\"col-md-6\" type=\"button\" id=\"delete\" value=\"-\" onClick=\"eliminaArtista();\">";
                document.getElementById("dynamicInput").appendChild(newdiv);
                i++;
            }
            function eliminaArtista() {
                if (i > 1) {
                    i--;
                    var olddiv = document.getElementById('div' + i);
                    olddiv.parentNode.removeChild(olddiv);
                    var id;
                    if(i==1) id = 'dynamicInput';
                    else {
                        id = 'div' + (i-1);
                    }
                    var newdiv = document.getElementById(id);
                    newdiv.innerHTML += "<input class=\"col-md-6\" type=\"button\" id=\"add\" value=\"+\" onClick=\"aggiungiArtista();\">\n\
                                        <input class=\"col-md-6\" type=\"button\" id=\"delete\" value=\"-\" onClick=\"eliminaArtista();\">";
                }
            }
        </script>
    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-fixed-top  block-nav">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand page-scroll" href="./">Events Net</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden">
                            <a href="./"></a>
                        </li>
                        <li>
                            <a class="page-scroll" href="./">Home</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="./about">About</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="./event">Events</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="./contact">Contact</a>
                        </li>
                        <%
                            if (session.getAttribute("nick") == null) {
                                out.print("<li><a class=\"page-scroll\" href=\"./loginForm?form=login\">Login</a></li>");
                            } else {
                                out.print("<li><a class=\"page-scroll\" href=\"./logout\">Logout</a></li>");
                            }
                        %>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>


        <!-- Contact Section -->
        <section id="contact">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading">Nuovo evento</h2>
                        <h3 class="section-subheading text-muted">Registra qui il tuo nuovo evento.</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <form action="./registraEvento" name="sentMessage" id="contactForm" novalidate>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="titolo" class="form-control" placeholder="Titolo evento" id="titolo" required data-validation-required-message="Scrivi qui il titolo.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="luogo" class="form-control" placeholder="Luogo evento" id="luogo" required data-validation-required-message="Scrivi qui il luogo dell'evento.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="data" class="form-control" placeholder="Data evento" id="data" required data-validation-required-message="Data dell'evento.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="categoria" class="form-control" placeholder="Categoria" id="categoria" required data-validation-required-message="Specifica la categoria dell'evento.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div id="dynamicInput">
                                            <input class="form-control" placeholder="Artista 1" id="artisti" type="text" name="artisti[]">
                                            <input class="col-md-6" type="button" id="add" value="+" onClick="aggiungiArtista();">
                                            <input class="col-md-6" type="button" id="delete" value="-" onClick="eliminaArtista();">
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-lg-12 text-center">
                                    <div id="success"></div>
                                    <button type="submit" class="btn btn-xl">Registra evento</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <span class="copyright">Copyright &copy; Your Website 2014</span>
                    </div>
                    <div class="col-md-4">
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-4">
                        <ul class="list-inline quicklinks">
                            <li><a href="#">Privacy Policy</a>
                            </li>
                            <li><a href="#">Terms of Use</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="./resources/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="./resources/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="./resources/js/classie.js"></script>
        <script src="./resources/js/cbpAnimatedHeader.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="./resources/js/jqBootstrapValidation.js"></script>
        <script src="./resources/js/contact_me.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="./resources/js/agency.js"></script>

    </body>

</html>

