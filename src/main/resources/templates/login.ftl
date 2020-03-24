<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="" name="description">
    <meta content="Mark Otto, Jacob Thornton, and Bootstrap contributors" name="author">
    <meta content="Jekyll v3.8.6" name="generator">
    <title>Welcome page</title>

    <link href="https://getbootstrap.com/docs/4.4/examples/sign-in/" rel="canonical">

    <!-- Bootstrap core CSS -->
<link crossorigin="anonymous" href="/docs/4.4/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" rel="stylesheet">

    <!-- Favicons -->
<link href="/docs/4.4/assets/img/favicons/apple-touch-icon.png" rel="apple-touch-icon" sizes="180x180">
<link href="/docs/4.4/assets/img/favicons/favicon-32x32.png" rel="icon" sizes="32x32" type="image/png">
<link href="/docs/4.4/assets/img/favicons/favicon-16x16.png" rel="icon" sizes="16x16" type="image/png">
<link href="/docs/4.4/assets/img/favicons/manifest.json" rel="manifest">
<link color="#563d7c" href="/docs/4.4/assets/img/favicons/safari-pinned-tab.svg" rel="mask-icon">
<link href="/docs/4.4/assets/img/favicons/favicon.ico" rel="icon">
<meta content="/docs/4.4/assets/img/favicons/browserconfig.xml" name="msapplication-config">
<meta content="#563d7c" name="theme-color">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <form class="form-signin" method="post" action="/login">
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
<p><input type='checkbox' name='remember-me'/> Remember me on this computer.</p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</form>
</body>
</html>