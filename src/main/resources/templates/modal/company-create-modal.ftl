<#macro company_create pagetitle="TTTrans-Logictic" >

<div class="modal fade" id="new_Company" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Create new company</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                </form>
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-outline-secondary"> Create</button>
            </div>
        </div>
    </div>
</div>
</#macro>
