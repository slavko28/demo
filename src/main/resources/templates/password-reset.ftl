<#import "header.ftl" as h>
<#-- @ftlvariable name="errorMessage" type="java.util.Optional<String>" -->
<#-- @ftlvariable name="successMessage" type="java.util.Optional<String>" -->
<@h.header></@h.header>
<link type="text/css" href="/static/css/create_user.css">

<!-- Page Content -->
<div class="container">
    <br/>
    <div class="col-md-4 col-lg-6 mx-auto">
        <div class="text-center">
            <h3>Password reset</h3>
            <#if errorMessage??>
                <p class="text-danger">${errorMessage}</p>
            <#elseif successMessage??>
                <p>${successMessage}</p>
            </#if>
        </div>
        <form class="form" role="form" method="post" action="/reset">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-at"></i></div>
                            <input type="email" name="email" class="form-control" id="email"
                                   placeholder="your.email@example.com" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-outline-secondary col-5 ">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                         Reset
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

<@h.footer></@h.footer>
