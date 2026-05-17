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

    <form action="/emp">
        <input type="name" name="name" placeholder="Enter name" required>
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
