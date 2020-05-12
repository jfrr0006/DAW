<%@ include file="header.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
	<div class="container">
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Formulario de datos del coche</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">
								
	<c:url value="/formularioCoche" var="destino"/>			
	<form:form method="post" class="form-horizontal" action="${destino}" modelAttribute="datosCoche">

Matrícula:
<div style="margin-bottom: 25px" class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span> 
<form:input path="matricula" class="form-control" />
<form:errors path="matricula" cssClass="text-danger"/>
</div>

Modelo:
<div style="margin-bottom: 25px" class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span> 
<form:input path="modelo" class="form-control" />
<form:errors path="modelo" cssClass="text-danger"/>
</div>

Año:
<div style="margin-bottom: 25px" class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> 
<form:input type="number" path="anho" maxlength="4" class="form-control" />
<form:errors path="anho" cssClass="text-danger"/>
</div>

Kilómetros:
<div style="margin-bottom: 25px" class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-dashboard"></i></span> 
<form:input type="number" path="kilometros" maxlength="6" class="form-control" />
<form:errors path="kilometros" cssClass="text-danger"/>
</div>

				<div style="margin-top: 10px" class="form-group" align='center'>
						<!-- Button -->

						<div class="col-sm-12 controls">
							<form:button  type='submit' class="btn btn-success">Enviar</form:button>
						</div>
				</div>
	</form:form>    
	
		</div>
		</div>
	</div>
</div>