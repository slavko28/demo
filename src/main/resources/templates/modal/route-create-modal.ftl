<#macro route_create pagetitle="TTTrans-Logictic" >

<div class="modal fade" id="new_Route" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Create new route</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
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
                                        <select id="routePointType" name="routePointType"
                                                class="form-control form-control-sm"
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
                                        <input type="text" name="country" class="form-control form-control-sm"
                                               id="country"
                                               required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <label for="zipCode">Zip Code</label>
                                <div class="form-group">
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <input type="text" name="zipCode" class="form-control form-control-sm"
                                               id="zipCode">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <label for="region">Region</label>
                                <div class="form-group">
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <input type="text" name="region" class="form-control form-control-sm"
                                               id="region"
                                               required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <label for="locality">Locality</label>
                                <div class="form-group">
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <input type="text" name="locality" class="form-control form-control-sm"
                                               id="locality"
                                               required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <label for="street">Street</label>
                                <div class="form-group">
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <input type="text" name="street" class="form-control form-control-sm"
                                               id="street">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <label for="number">Number</label>
                                <div class="form-group">
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <input type="text" name="number" class="form-control form-control-sm"
                                               id="number">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <label for="addressType">Address type</label>
                                <div class="form-group">
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <select id="addressType" name="addressType" class="form-control form-control-sm"
                                                required>
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
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-outline-secondary"> Create</button>
            </div>
        </div>
    </div>
</div>
</#macro>
