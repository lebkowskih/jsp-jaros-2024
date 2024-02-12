<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jaros 2024 Projekt</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div class="max-w-3xl mx-auto">
		<form action="/" method="POST">
			<label for="word" class="block text-sm font-medium leading-6 text-gray-900">Hasło</label>
			<input type="text" name="word" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"/>
			<button class="mt-2 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">Wyślij</button>
		</form>
		<div>
		<%@ page import="java.util.List" %>
		<%@ page import="java.sql.SQLException" %>
		<%@ page import="pl.jaros.Models.ProductDAO" %>
		<%@ page import="pl.jaros.Models.Product" %>
		

		<% 
		    String word = request.getParameter("word");
		    ProductDAO productDAO = new ProductDAO();
		    List<Product> products = null;
		    
		    if (word != null && !word.isEmpty()) {
		        try {
		            products = productDAO.getAllProducts();
		        } catch (SQLException e) {
		            e.printStackTrace(); // Handle exception appropriately
		        }
		    }
		%>

		<!-- Display products if products list is not null -->
		<% if (products != null) { %>
		    <% for (Product product : products) { %>
		    
			<div class="mx-auto block max-w-sm  mb-4 p-6 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700">
				<h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white"><%= product.getName() %></h5>
				<p class="font-normal text-gray-700 dark:text-gray-400"><%= product.getPrice() %> - <%= product.getSupplier() %></p>
			</div>
		    <% } %>
		<% } %>
		
		</div>
	</div>
</body>
</html>