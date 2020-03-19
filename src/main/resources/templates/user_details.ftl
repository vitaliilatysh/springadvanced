<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Greetings</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center text-info">Phone directory</h2><hr/>
         <p>Username: ${user.userName}</p>
         <p>First name: ${user.firstName}</p>
         <p>Last name: ${user.lastName}</p>
         <p>Roles:</p>
         <#list user.roles as role>
           <p>${role}</p>
         </#list>
    </div>
</body>
</html>