<#import "../header.ftl" as h>

<@h.header></@h.header>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<!-- Page Content -->
<div class="container text-center">
    <div class="mt-5 center-block">
        <h4>Companies</h4>
    </div>

    <table id="data" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th>Short name</th>
            <th>Full name</th>
            <th>Cod</th>
        </tr>
        </thead>
        <tbody>
        <#list companies as company>
        <tr onclick='window.location.href="/company/${company.id}"'>
            <td></td>
            <td>${company.fullName}</td>
            <td>${company.shortName}</td>
            <td class="num">${company.companyCod}</td>
        </tr>
        </#list>
        </tbody>
    </table>

    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="/static/js/data.js"></script>

</div>

<@h.footer></@h.footer>
