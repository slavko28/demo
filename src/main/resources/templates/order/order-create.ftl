<#import "../header.ftl" as h>
<#import "../modal/company-create-modal.ftl" as company_modal>
<#import "../modal/manager-create-modal.ftl" as manager_modal>
<#import "../modal/cargo-create-modal.ftl" as cargo_modal>
<#import "../modal/route-create-modal.ftl" as route_modal>

<@h.header></@h.header>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<#--<link type="text/css" href="/static/css/create_user.css">-->
<link type="text/css" href="/static/css/order-create.css">


<!-- Page Content -->
<br/>
<div class="text-center">
    <h3><strong>Create new order</strong></h3>
    <hr>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <form class="form" role="form" method="post" action="/order">
                <div class="row">
                    <div class="col-md-4 field-label-responsive">
                        <label for="orderDate">Date</label>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <input type="datetime-local" name="orderDate" class="form-control" id="orderDate">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4 field-label-responsive">
                        <label for="budget">Budget</label>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <input type="number" name="budget" class="form-control" id="budget" placeholder="0.00">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4 field-label-responsive">
                        <label for="loadingType">Loading Type</label>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <select id="loadingType" name="loadingType" class="form-control" required>
                                    <option value="CRANE">CRANE</option>
                                    <option value="LATERAL_LOADING">LATERAL_LOADING</option>
                                    <option selected value="BACK_LOADING">BACK_LOADING</option>
                                    <option value="IN_BULK">IN_BULK</option>
                                    <option value="MANUAL">MANUAL</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 field-label-responsive">
                        <label for="company">Company</label>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <select id="company" name="company" class="form-control" required>
                                    <option>Select or add new</option>
                                <#list companies as company>
                                    <option value=${company.id}>${company.shortName}</option>
                                </#list>
                                </select>
                                <span class="input-group-btn">
                                    <button type="button" data-toggle="modal" data-target="#new_Company"
                                            class="btn btn-outline-secondary btn-add">
                                            <i class="fa fa-plus"></i>
                                    </button>
                                </span>
                                <@company_modal.company_create></@company_modal.company_create>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 field-label-responsive">
                        <label for="companyManager">Manager</label>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <select id="companyManager" name="companyManager" class="form-control" required>
                                    <option>Select or add new</option>

                                <#--//TODO: Add filing up by Ajax request by company ID -->

                                </select>
                                <span class="input-group-btn">
                                    <button type="button" data-toggle="modal" data-target="#new_Manager"
                                            class="btn btn-outline-secondary btn-add">
                                            <i class="fa fa-plus"></i>
                                    </button>
                                </span>
                                <@manager_modal.manager_create></@manager_modal.manager_create>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 field-label-responsive">
                        <label for="cargo">Cargo</label>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <select id="cargo" name="cargo" class="form-control" required>
                                    <option>Select or add new</option>

                                <#--//TODO: Add filing up by Ajax request by company ID -->

                                </select>
                                <span class="input-group-btn">
                                    <button type="button" data-toggle="modal" data-target="#new_Cargo"
                                            class="btn btn-outline-secondary btn-add">
                                            <i class="fa fa-plus"></i>
                                    </button>
                                </span>
                                <@cargo_modal.cargo_create></@cargo_modal.cargo_create>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2 field-label-responsive">
                        <label for="orderDetail">Detail</label>
                    </div>
                    <div class="col-md-10">
                        <div class="form-group">
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <textarea id="orderDetail" name="orderDetail" class="form-control"
                                          placeholder="Please, add additional order's detail here"
                                          required></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-8">
            <div class="text-center">
                <h4>Route</h4>
                <hr>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <select id="route" name="route" class="form-control" required>
                                <option>Select or add new</option>
                            <#list routs as route>
                                <option value=${route.id}><#list route.routePoint as point>
                                ${point.type} ${point.address.locality} ${point.address.region} |
                                </#list>.
                                </option>
                            </#list>
                            </select>
                            <span class="input-group-btn">
                                    <button type="button" data-toggle="modal" data-target="#new_Route"
                                            class="btn btn-outline-secondary btn-add">
                                            <i class="fa fa-plus"></i>
                                    </button>
                            </span>
                        <@route_modal.route_create></@route_modal.route_create>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table id="data" class="display" cellspacing="0" width="100%">
                        <thead>
                        <th></th>
                        <th>Point type</th>
                        <th>Country</th>
                        <th>Zip code</th>
                        <th>Region</th>
                        <th>Locality</th>
                        <th>Street</th>
                        <th>Number</th>
                        <th>Address type</th>
                        </thead>
                        <tbody id="data-table">

                        </tbody>
                    </table>
                </div>
            </div>

        <#------------------------------------------------------->
        </div>

    <#----------------------ROUTE---------------------------->

    </div>
    <div class="row">
        <div class="col-md-12">

            <div class="text-center">
                <h4>Route details</h4>
                <hr>
            </div>

            <div class="row">
                <div class="col-md-2">
                    <label for="routePointType">Type</label>
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <select id="routePointType" name="routePointType" class="form-control form-control-sm"
                                    required>
                                <option value="CARGO_RECEIVING">RECEIVING</option>
                                <option value="CARGO_DELIVERY">DELIVERY</option>
                                <option value="BORDER_CROSSING">CROSSING</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-md-1">
                    <label for="country">Country</label>
                    <div class="form-group">
                        <div class="">
                            <input type="text" name="country" class="form-control form-control-sm" id="country"
                                   required>
                        </div>
                    </div>
                </div>
                <div class="col-md-1">
                    <label for="zipCode">Zip Code</label>
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input type="text" name="zipCode" class="form-control form-control-sm" id="zipCode">
                        </div>
                    </div>
                </div>
                <div class="col-md-1">
                    <label for="region">Region</label>
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input type="text" name="region" class="form-control form-control-sm" id="region" required>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <label for="locality">Locality</label>
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input type="text" name="locality" class="form-control form-control-sm" id="locality"
                                   required>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <label for="street">Street</label>
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input type="text" name="street" class="form-control form-control-sm" id="street">
                        </div>
                    </div>
                </div>
                <div class="col-md-1">
                    <label for="number">Number</label>
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <input type="text" name="number" class="form-control form-control-sm" id="number">
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <label for="addressType">Address type</label>
                    <div class="form-group">
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <select id="addressType" name="addressType" class="form-control form-control-sm" required>
                                <option value="PRODUCTION">PRODUCTION</option>
                                <option value="STORAGE">STORAGE</option>
                            </select>
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-outline-secondary btn-add btn-sm"><i
                                        class="fa fa-plus"></i></button></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<#------------------------------------------------------->
    <div class="col-md-12 text-center">

        <button type="submit" class="btn btn-outline-secondary col-5"><i class="fa fa-file-text"></i> Create Order
        </button>
    </div>
</div>

<script src="/static/js/order-create.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<@h.footer></@h.footer>
