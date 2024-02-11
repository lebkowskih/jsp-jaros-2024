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
		<!-- Display data if it exists -->
	    <% 
	        String word = request.getParameter("word");
	        if (word != null && !word.isEmpty()) { 
	    %>
	        <div>Data submitted: <%= word %></div>
	    <% } %>
		</div>
	</div>
</body>
</html>