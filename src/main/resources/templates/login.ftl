<#import "header.ftl" as h>
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->


<@h.header>
</@h.header>
<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900"
      rel="stylesheet" type="text/css" xmlns="http://www.w3.org/1999/html">
<link rel="stylesheet" type="text/css" href="/static/css/loginStyle.css"/>

<section class="container">
    <section class="login-form">
        <form method="post" action="/login" role="login">
            <img src="/static/images/logo.png" class="img-responsive" alt="" />

            <input type="email" name="email" placeholder="Email" required class="form-control input-lg" />
            <input type="password" name="password" placeholder="Password" required class="form-control input-lg" />
            <div class="text-center">
                <label for="remember-me" class="label">Remember me</label>
                <input type="checkbox" name="remember-me" id="remember-me" class="custom-radio"/>
            </div>
            <button type="submit" name="go" style="background-color: #4c7eba" class="btn btn-lg btn-primary btn-block">
                Sign in
            </button>
            <div>
                <a href="/user/create">Create account</a> or <a href="#">reset password</a>
            </div>
        </form>
    </section>
    <div class="text-center">
    <#if error.isPresent()>
        <p class="text-danger">The email or password you have entered is invalid, try again.</p>
    </#if>
    </div>
</section>



<@h.footer></@h.footer>
