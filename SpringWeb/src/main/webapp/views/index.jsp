<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP Form</title>

    <link rel="stylesheet" href="style.css"/>

</head>
<body>

<div class="container">
    <h2>Simple Add</h2>

    <form action="add">
        <input type="number" name="num1" placeholder="Enter first number" required>
        <input type="number" name="num2" placeholder="Enter second number" required>
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
