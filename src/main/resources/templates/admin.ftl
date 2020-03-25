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
        <form method="post" enctype="multipart/form-data" action="/files">
         <div>
           <label for="file">Choose json files</label>
           <input type="file" id="file" name="file" multiple>
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
         </div>
         <div>
           <button>Submit</button>
         </div>
        </form>
    </div>

    <div class="container">
         <a href="/users">Show users</a><br>
         <a href="/phones">Show phones</a><br>
         <a href="/companies">Show companies</a>
    </div>
</body>
</html>