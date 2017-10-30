<#import "header.ftl" as h>
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->


<@h.header></@h.header>
<link type="text/css" href="/static/css/create_user.css">

<!-- Page Content -->
<div class="container">
    <br/>
    <div class="col-md-4 col-lg-6 mx-auto">
        <div class="text-center">
            <h3>Registration Form</h3>
        </div>
        <form class="form" role="form" method="post" action="/user/create">

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                            <input type="text" name="name" class="form-control" id="name"
                                   placeholder="First name" pattern="[a-zA-Z]+"
                                   oninvalid="setCustomValidity('Please enter your name.')" required>
                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                            <input type="text" name="lastName" class="form-control" id="LastName"
                                   placeholder="Last Name" pattern="[a-zA-Z]+"
                                   oninvalid="setCustomValidity('Please enter your last name.')" required>
                        </div>
                    </div>
                </div>
            </div>
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
        <#if error??>
            <div class="text-center">
                <p class="text-danger">${error}</p>
            </div>
        </#if>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-phone"></i></div>
                            <input type="tel" name="phoneNumber" class="form-control" id="phoneNumber"
                                   placeholder="(123)456-78-90" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user-secret"></i></div>
                            <select id="role" name="role" class="form-control" required>
                                <option value="MANAGER">MANAGER</option>
                                <option value="ACCOUNTANT">ACCOUNTANT</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

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
                            <input type="password" name="passwordRepeated" class="form-control" id="confirm_password"
                                   placeholder="Confirm password" required>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-outline-secondary col-5 ">
                        <i class="fa fa-user-plus"></i>
                         Sign up
                    </button>
                </div>
            </div>
        </form>

    </div><!-- /.col-lg-12 -->
</div>

<script src="/static/js/create_user.js"></script>

<@h.footer></@h.footer>
