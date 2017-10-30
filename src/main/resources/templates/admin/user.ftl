<#import "../header.ftl" as h>

<@h.header></@h.header>
<link type="text/css" href="/static/css/create_user.css">

<!-- Page Content -->
<div class="container">
    <br/>
    <div class="col-md-4 col-lg-6 mx-auto">
        <form method="post" action="/user/update" role="login">
            <div class="text-center">
                    <h3>${user.name} ${user.lastName}</h3>
                    <hr>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="name">User ID</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-id-card-o"></i></div>
                            <input readOnly type="number" name="id" class="form-control" id="name"
                                   value=${user.id}>
                        </div>
                    </div>
                </div>

                <div class="col-sm-3 field-label-responsive">
                    <label for="name">First Name</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                            <input type="text" name="name" class="form-control" id="name"
                                   value="${user.name}">
                        </div>
                    </div>
                </div>

                <div class="col-sm-3 field-label-responsive">
                    <label for="lastName">Last Name</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                            <input type="text" name="lastName" class="form-control" id="LastName"
                                   value="${user.lastName}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="email">E-mail</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-at"></i></div>
                            <input readOnly type="email" name="email" class="form-control" id="email"
                                   value="${user.email}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="email">Phone No.</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-phone"></i></div>
                            <input type="text" name="phoneNumber" class="form-control" id="email"
                                   value="${user.phoneNumber}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="role">User role</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-spinner"></i></div>
                            <select id="role" name="role" class="form-control">
                                <option value=${user.role}>${user.role}</option>
                            <#if user.role!="ADMIN">
                                <option value="ADMIN">ADMIN</option>
                            </#if>
                            <#if user.role!="MANAGER">
                                <option value="MANAGER">MANAGER</option>
                            </#if>
                            <#if user.role!="ACCOUNTANT">
                                <option value="ACCOUNTANT">ACCOUNTANT</option>
                            </#if>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="active">Enabled</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-check-square"></i></div>
                            <select id="active" name="active" class="form-control">
                            <#if user.active>
                                <option value="true">true</option>
                            <#else>
                                <option value="false">false</option>
                            </#if>
                            <#if !user.active>
                                <option value="true">true</option>
                            <#else>
                                <option value="false">false</option>
                            </#if>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 text-center">
                    <button type="button" class="btn btn-outline-secondary col-5" onclick='window.location.href="/admin/user/all"'><i
                            class="fa fa-undo"></i> Back
                    </button>
                    <button type="submit" class="btn btn-outline-secondary col-5"><i class="fa fa-arrow-circle-up"></i> Update</button>
                </div>
            </div>

        </form>

    </div>
</div>


<@h.footer></@h.footer>
