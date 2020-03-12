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
        <form method="post" enctype="multipart/form-data" action="/users">
         <div>
           <label for="file">Choose file to upload users</label>
           <input type="file" id="file" name="file" multiple>
         </div>
         <div>
           <button>Submit</button>
         </div>
        </form>
    </div>
    <div class="container">
        <form method="post" enctype="multipart/form-data" action="/companies">
         <div>
           <label for="file">Choose file to upload companies</label>
           <input type="file" id="file" name="file" multiple>
         </div>
         <div>
           <button>Submit</button>
         </div>
        </form>
    </div>
    <div class="container">
        <form method="post" enctype="multipart/form-data" action="/phones">
         <div>
           <label for="file">Choose file to upload phones</label>
           <input type="file" id="file" name="file" multiple>
         </div>
         <div>
           <button>Submit</button>
         </div>
        </form>
    </div>

    <div class="container">
         <a href="/users">Show users</a>
    </div>
</body>
</html>