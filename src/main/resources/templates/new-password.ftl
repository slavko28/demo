<#import "header.ftl" as h>
<#-- @ftlvariable name="errorMessage" type="java.util.Optional<String>" -->
<#-- @ftlvariable name="token" type="java.util.Optional<String>" -->
<@h.header></@h.header>
<link type="text/css" href="/static/css/create_user.css">
<link rel="stylesheet" type="text/css" href="/static/css/loginStyle.css"/>

<!-- Page Content -->
<div class="container">
    <section class="login-form">

    <#if errorMessage??>
        <h5>${errorMessage}</h5>
    <#else>
        <div class="text-center">
            <h3>Create new password</h3>
        </div>
    <form class="form" role="form" method="post" action="/reset/pass">
        <input type="hidden" name="token" value=${token}>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                        <input type="password" name="password" class="form-control" id="password"
                               placeholder="Enter you password" required>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                        <input type="password" name="passwordRepeated" class="form-control"
                               id="confirm_password"
                               placeholder="Confirm password" required>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 text-center">
                <button type="submit" class="btn btn-outline-secondary col-5 ">
                    <i class="fa fa-check-circle-o" aria-hidden="true"></i>
                    Confirm
                </button>
            </div>
        </div>
    </#if>
    </form>
    </section>
</div>

<script src="/static/js/create_user.js"></script>

<@h.footer></@h.footer>
