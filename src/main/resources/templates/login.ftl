<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="" name="description">
    <meta content="Mark Otto, Jacob Thornton, and Bootstrap contributors" name="author">
    <meta content="Jekyll v3.8.6" name="generator">
    <title>Custom login page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity=\sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
	<link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
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
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <form class="form-signin" method="post" action="login">
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <p><input type='checkbox' name='remember-me'/> Remember me on this computer.</p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</body>
</html>