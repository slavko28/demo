<#import "../header.ftl" as h>

<@h.header></@h.header>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<!-- Page Content -->
<div class="container text-center">
    <div class="mt-5 center-block">
        <h4>List of incoming orders</h4>
    </div>
    <table id="data" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th>Order date</th>
            <th>Company</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
        <tr onclick='window.location.href="/order/${order.id}"'>
            <td></td>
            <td>${order.orderDate}</td>
            <td>${order.company.shortName}</td>
            <td>${order.status}</td>
        </tr>
        </#list>
        </tbody>
    </table>

    <div class="col-sm-12 text-center">

        <button type="button" class="btn btn-outline-secondary col-5" onclick="window.location.href='/order'"><i class="fa fa-file-text"></i> Create new order
        </button>
    </div>

</div>

<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="/static/js/data.js"></script>
<@h.footer></@h.footer>
