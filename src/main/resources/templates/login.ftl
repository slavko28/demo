<#import "header.ftl" as h>


<@h.header>
</@h.header>
<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/static/css/loginStyle.css"/>

<section class="container">
    <section class="login-form">
        <form method="post" action="/login" role="login">

            <img src="/static/images/logo.png" class="img-responsive" alt="" />
            <input type="email" name="email" placeholder="Email" required class="form-control input-lg" />
            <input type="password" name="password" placeholder="Password" required class="form-control input-lg" />
            <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
            <div>
                <a href="/user/create">Create account</a> or <a href="#">reset password</a>
            </div>
        </form>

    </section>
</section>

<#--<script src="/static/vendor/jquery/jquery.min.js"></script>-->
<#--<script src="/static/vendor/bootstrap/js/bootstrap.min.js"></script>-->


<@h.footer></@h.footer>
