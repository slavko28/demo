<#import "../header.ftl" as h>

<@h.header></@h.header>

<link type="text/css" href="/static/css/create_user.css">

<!-- Page Content -->
<div class="container">
    <br/>
    <div class="col-md-4 col-lg-6 mx-auto">
        <form method="post" action="/detail/update" role="form">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="text-center">
                <h4>Detail's of order id: ${id} </h4>
                <hr>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="name">Detail's ID</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input readOnly type="number" name="id" class="form-control" id="name"
                                   value=${detail.id}>
                        </div>
                    </div>
                </div>

                <div class="col-sm-3 field-label-responsive">
                    <label for="completeDate">Date of complete</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input readonly type="datetime-local" name="completeDate" class="form-control" id="completeDate"
                                   value=${detail.completeDate}>
                        </div>
                    </div>
                </div>

                <div class="col-sm-3 field-label-responsive">
                    <label for="carrier">Carrier</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input readonly type="text" name="carrier" class="form-control" id="carrier"
                                   value=${detail.carrier.shortName}>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="truck">Truck / Num</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input readOnly type="text" name="truck" class="form-control" id="truck"
                                   value="${detail.truck.model} / ${detail.truck.licensePlate}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="trailer">Trailer / Num</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input readOnly type="text" name="trailer" class="form-control" id="trailer"
                                   value="${detail.trailer.model} / ${detail.trailer.licensePlate}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3 field-label-responsive">
                    <label for="driver">Driver</label>
                </div>
                <div class="col-sm-9">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input readOnly type="text" name="driver" class="form-control" id="driver"
                                   value="${detail.driver.firstName} ${detail.driver.lastName} ">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 text-center">
                    <button type="button" class="btn btn-outline-secondary col-5" onclick='window.location.href="/manager"'><i
                            class="fa fa-undo"></i> Back
                    </button>
                    <button type="submit" class="btn btn-outline-secondary col-5"><i class="fa fa-pen"></i> Edit</button>
                </div>
            </div>

        </form>

    </div>
</div>



<@h.footer></@h.footer>
