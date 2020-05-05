<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Pais" %>
<!DOCTYPE html">
<html lang="pt-br">
	<head>
	 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Visualizar Pais</title>
		
		<link href="css/bootstrap.min.css" rel="stylesheet">
    	<link href="css/style.css" rel="stylesheet">	
	</head>
	
	<body>
		<% Pais pais = (Pais) request.getAttribute("pais"); %>
		<!-- Barra superior com os menus de navegação -->

		<!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Visualizar pais #<%= pais.getId() %></h3>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        <%= pais.getNome() %>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Populacao</strong>
                    </p>
                    <p>
                        <%= pais.getPopulacao() %>
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Área</strong>
                    </p>
                    <p>
                        <%= pais.getArea() %> m²
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.html" class="btn btn-info">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
	</body>
	
</html>