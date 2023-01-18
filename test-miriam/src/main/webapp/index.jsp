<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>TEST</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body ng-app="myApp" >

<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
<script src="<c:url value='/static/js/app/app.js' />"></script>
	<script src="<c:url value='/static/js/service/usuario_service.js' />"></script>
  	<script src="<c:url value='/static/js/controller/usuario_controller.js' />"></script>
  
  	
	<div ng-controller="UsuarioController as ctrl">
	<sec:authentication var="user" property="principal" />
	  
	
	<!-- Modal Finanzas-->
			<div class="modal fade" id="myModalCatalogoFinanzas" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content bg-dark text-white">
					<div class="modal-header">
						<h4 class="modal-title">Datos Usuario</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
					<form ng-submit="ctrl.addUser(ctrl.usuario)" name="myFormCon" class="form-horizontal">
<%-- 					<form name="myForm" class="form-horizontal""> --%>
                     
                      <div class="row">
							<div class="form-group col-md-12">
								
								<div class="input-group mb-3 input-group-sm">
								     <div class="input-group-prepend">
								       <span class="input-group-text">Nombre</span>					       
								    </div>
								    <input type="text" ng-model="ctrl.usuario.nombre" id="idName" class="form-control input-sm" placeholder="Nombre" required ng-minlength="3"/>
								 </div>
							</div>
							<div class="form-group col-md-12">
								
								<div class="input-group mb-3 input-group-sm">
								     <div class="input-group-prepend">
								       <span class="input-group-text">RFC</span>					       
								    </div>
								    <input type="text" ng-model="ctrl.usuario.rfc" id="RFC" class="form-control input-sm" placeholder="RFC" required ng-minlength="3"/>
								 </div>
							</div>
							<div class="form-group col-md-12">
								
								<div class="input-group mb-3 input-group-sm">
								     <div class="input-group-prepend">
								       <span class="input-group-text">Email</span>					       
								    </div>
								    <input type="email" ng-model="ctrl.usuario.email" id="emailid" class="form-control input-sm" placeholder="email" required />
								 </div>
							</div>
							<div class="form-group col-md-12">
								
								<div class="input-group mb-3 input-group-sm">
								     <div class="input-group-prepend">
								       <span class="input-group-text">Observaciones</span>					       
								    </div>
								    <input type="text" ng-model="ctrl.usuario.observaciones" id="Obsr" class="form-control input-sm" placeholder="observaciones" required ng-minlength="3"/>
								 </div>
							</div>
						</div> 
						    
					<div class="modal-footer">
						<div class="form-actions floatRight">
                           <input type="submit" value="Guardar" class="btn btn-primary btn-sm"
                             >
                        </div>
						<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
					</div>
                  </form>
					
					
					</div>
					
				</div>
			</div>
		</div>		
		
  
<div class="container">

      <div class="formcontainer" >
      <button type="button"  class="btn btn-info btn-sm" data-toggle="modal"
					data-target="#myModalCatalogoFinanzas"
					ng-disabled=false 
					ng-show=true>Agregar Usuario</button>
					
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<span class="lead">Lista de Usuarios</span>
					</div>
				</div>
				<div class="table-responsive-sm">
					<div class="row">
                          <div class="col align-self-center">
                             <p><input class="form-control"  type="text" ng-model="text" placeholder="Buscar"></p>
						   </div>                            
              		</div>
					<table class="table table-sm table-hover table-dark table-responsive">
						<thead>
							<tr>
								<th>id</th>
								<th>nombre</th>
								<th>rfc</th>
								<th>email</th>
								<th>observaciones</th>
								
							</tr>
						</thead>
						<tbody>
							<tr  ng-repeat="u in ctrl.catalogo |orderBy : 'tipoconcepto.nombre'| filter : text" ">
								<td><span ng-bind="u.idusuario"></span></td>
								<td><span ng-bind="u.nombre"></span></td>
								<td><span ng-bind="u.rfc"></span></td>
								<td><span ng-bind="u.email"></span></td>
								<td><span ng-bind="u.observaciones"></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div> 
   
  

</div> 

</div>
</body>
</html>
