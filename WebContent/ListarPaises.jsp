<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Pais</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!--  Modal  -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Pais</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este Pais ?</div>
				<div class="modal-footer">
					<form action="Controller.do" method="post">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary" name="command"
							value="ExcluirPais">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.Modal -->
	<!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp" />

	<!--  Container Principal -->
	<div id="main" class="container">
		<form action="Controller.do" method="post">
			<div id="top" class="row">
				<div class="col-md-3">
					<h3>Paises</h3>
				</div>
				<div class="col-md-6">
					<div class="input-group h2">
						<input name="busca" class="form-control" id="search" type="text"
							placeholder="Pesquisar Paises (deixe em branco para ver todos)">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="submit" name="command"
								value="ListarPaisesBuscar">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
				<div class="col-md-3">
					<a href="CriarPais.jsp" class="btn btn-primary pull-right h2">
						Novo Pais </a>
				</div>
			</div>
			<!-- /#top -->
		</form>

		<hr />

		<c:if test="${not empty lista}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<th>ID</th>
							<th>Nome</th>
							<th>População</th>
							<th>Área</th>
							<th class="actions">Ações</th>
						</thead>
						<tbody>
							<c:forEach var="pais" items="${lista}">
								<tr>
									<td>${pais.id}</td>
									<td>${pais.nome}</td>
									<td>${pais.populacao}</td>
									<td>${pais.area}</td>
									<td class="actions"><a class="btn btn-success btn-xs"
										href="Controller.do?command=VisualizarPais&id=${pais.id}">
											Visualizar</a> <a class="btn btn-warning btn-xs"
										href="Controller.do?command=EditarPais&id=${pais.id}">
											Editar</a>
										<button id="${pais.id}" type="button"
											class="btn btn-danger btn-xs" data-toggle="modal"
											data-target="#delete-modal" data-pais="${pais.id}">
											Excluir</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
			<!-- /#list -->

			<div id="buttom" class="row">
				<div class="col-md-12">
					<!-- paginação ainda não foi implementada -->
					<ul class="pagination">
						<li class="disable"><a> &lt; Anterior</a></li>

						<li class="disable"><a> 1 </a></li>

						<li class="disable"><a href="#">2</a></li>

						<li class="disable"><a href="#">3</a></li>

						<li class="next"><a href="#" rel="next"> Próximo &gt; </a></li>
					</ul>
					<!--  /.pagination -->
				</div>
			</div>
		</c:if>
		<!-- /#buttom -->
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget); //botao que disparou a modal
			var recipient = button.data('pais');
			$("#id_excluir").val(recipient);
		});
	</script>
</body>
</html>