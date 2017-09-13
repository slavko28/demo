<#import "../header.ftl" as h>

<@h.header></@h.header>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<div class="container text-center">

    <!-- Page Content -->
    <div class="container text-center">
        <label><h3 class="mt-5 center-block">List of users</h3></label>
    </div>

    <table id="data" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th>First name</th>
            <th>Last name</th>
            <th>E-mail</th>
            <th>Role</th>
            <th>Enabled</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr onclick='window.location.href="/user/${user.id}"'>
            <td></td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>
                <#if user.active>
                    <p>active</p>
                <#else>
                    <p>
                        <del>active</del>
                    </p>
                </#if>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<script src="/static/js/data.js"></script>
<@h.footer></@h.footer>
