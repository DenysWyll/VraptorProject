<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
   <div style="background-color: red; color: white">
	<c:forEach var="error" items="${error}">
	${error.category} - ${error.message}<br />
	</c:forEach>
	</div>

	<form action='http://localhost:8080/vraptor-blank-project/apartamento/salvar'>
		<input type="number" name="apartamento.numero"
			placeholder="Numero do Apartamento"> 
		<input type="number"
			name="apartamento.quartos" placeholder="Quantidade de quartos">
		<input type="text" name="apartamento.ocupacao"
			placeholder="Tipo de ocupacao"> <input type="submit"
			value="Salvar">
	</form>
	<br>
	
	<form action='http://localhost:8080/vraptor-blank-project/apartamento/pesquisar'>
		 <input type="number" name="pesquisa"
			placeholder="Pesquisa"> 
		 <input type="submit"
			value="Pesquisar">
	</form>
	
	<br>
	
	<table>
	  <c:forEach var="apartamento" items="${apartamentos}">
	   <tr>
	     <td><c:out value="${apartamento.numero}"/></td>   
	     <td><c:out value="${apartamento.ocupacao}"/></td> 
	     <td><c:out value="${apartamento.quartos}"/></td> 
	   </tr>
	  </c:forEach>
	</table>
</body>
</html>