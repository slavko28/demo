<#import "../header.ftl" as h>

<@h.header></@h.header>
<link type="text/css" href="/static/css/create_user.css">

<!-- Page Content -->
<div class="container">
    <br/>
    <div class="col-md-4 col-lg-6 mx-auto">
        <form method="post" action="/#" role="update">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="text-center">
                <h3>${company.shortName}</h3>
                <hr>
            </div>
            <div class="row">


                <div class="col-sm-3 field-label-responsive">
                    <label for="id">Company ID</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-id-card-o"></i></div>
                            <input readOnly type="number" name="id" class="form-control" id="id"
                                   value=${company.id}>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 field-label-responsive">
                    <label for="shortName">Short name</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-id-card-o"></i></div>
                            <input type="text" name="shortName" class="form-control" id="shortName"
                                   value=${company.shortName}>
                        </div>
                    </div>
                </div>

                <div class="col-sm-3 field-label-responsive">
                    <label for="fullName">Full name</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-id-card-o"></i></div>
                            <input type="text" name="fullName" class="form-control" id="fullName"
                                   value=${company.fullName}>
                        </div>
                    </div>
                </div>

                <div class="col-sm-3 field-label-responsive">
                    <label for="cod">Cod.</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                            <input type="text" name="cod" class="form-control" id="cod"
                                   value=${company.companyCod}>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 text-center">
                    <button type="button" class="btn btn-outline-secondary col-5" onclick='window.location.href="/company/all"'><i
                            class="fa fa-undo"></i> Back
                    </button>
                    <button type="submit" class="btn btn-outline-secondary col-5"><i class="fa fa-arrow-circle-up"></i> Update</button>
                </div>
            </div>

        </form>

    </div>
</div>


<@h.footer></@h.footer>
