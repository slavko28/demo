<#import "../header.ftl" as h>

<@h.header></@h.header>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<!-- Page Content -->
<div class="container text-center">
    <div class="mt-5 center-block">
        <h4>Manager Home page</h4>
        <h4>${user.name} ${user.lastName}</h4>
        <h4>List of your current orders</h4>
    </div>

    <table id="data" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Order date</th>
            <th>Company</th>
            <th>Status</th>

        </tr>
        </thead>
        <tbody>
        <#list orders as order>
        <tr onclick='window.location.href="#"'>
            <td>${order.orderDate}</td>
            <td>${order.company.shortName}</td>
            <td>${order.status}</td>
        </tr>
        </#list>
        </tbody>
    </table>

    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="/static/js/data.js"></script>

</div>

<@h.footer></@h.footer>
