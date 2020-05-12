<%@ include file="header.jsp" %>

<div class="container">
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign In</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">
			
			<form:form modelAttribute="user" method="post"  class="form-horizontal" >
<!-- Formulario del username -->
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					
					<form:input path="username" type="text" class="form-control" placeholder="Username"/>
					<form:errors path="username" cssClass="text-danger"/>
				
				</div>

<!-- Formulario del email -->
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span> 
						
					<form:input path="email" type="text" class="form-control" placeholder="Email"/>
					<form:errors path="email" cssClass="text-danger"/>		
								
				</div>
				
<!-- Formulario del calendario				 -->
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> 
					
					<form:input path="fecha" type="text" class="form-control" placeholder="Fecha de Nacimiento"  onfocus="(this.type='date')" onblur="(this.type='text')"/>
					<form:errors path="fecha" cssClass="text-danger"/>					
					
				</div>
				
<!-- Formulario del movil -->
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span> 
						
					<form:input path="movil" type="text" class="form-control" placeholder="Nº de móvil"/>
					<form:errors path="movil" cssClass="text-danger"/>		
								
				</div>
				
<!-- Formulario del password -->				
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
						
					<form:input path="password" type="password" class="form-control" placeholder="Password"/>
					<form:errors path="password" cssClass="text-danger"/>					
					
				</div>

				<div style="margin-top: 10px" class="form-group" align='center'>
						<!-- Button -->

						<div class="col-sm-12 controls">
							<form:button  type='success' class="btn btn-success">Sign in </form:button>
						</div>
				</div>

				</form:form>
		</div>
		</div>
	</div>
</div>

</body>
</html>
