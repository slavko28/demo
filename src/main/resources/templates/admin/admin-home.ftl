<#import "../header.ftl" as h>
<#-- @ftlvariable name="currentUser" type="com.toptop.domain.CurrentUser" -->

<@h.header></@h.header>

<!-- Page Content -->
<div class="container text-center">
    <h1 class="mt-5 center-block">Admin Home page</h1>

<#if currentUser?? >
    <h1>OK !</h1>
</#if>
</div>



<@h.footer></@h.footer>
