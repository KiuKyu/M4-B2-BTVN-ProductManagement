<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 21-Mar-22
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Product List</h1>
<button type="button" class="btn btn-secondary">
    <a href="/products/add">
        Add new product
    </a>
</button>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Product's name</th>
        <th scope="col">Product's price</th>
        <th scope="col">Product's description</th>
        <th scope="col">Product's image</th>
        <th scope="col" colspan="2">Product's image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}" varStatus="loop">
        <tr>
            <th>${loop.count}</th>
            <td>
                <a href="/products/${product.id}">${product.name}</a>
            </td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
                <img style="height: 100px" src="${product.image}" alt="${product.name}">
            </td>
            <td>
                <button type="button" class="btn btn-warning">
                    <a href="/products/edit/${product.id}">Edit</a>
                </button>
            </td>
            <td>
                <button type="button" class="btn btn-danger">
                    <a href="/products/delete/${product.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
