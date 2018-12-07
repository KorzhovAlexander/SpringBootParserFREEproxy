<#import "macros/standart.ftl" as standartTemplate>
<#import "macros/navbar.ftl" as nav>
<#--<#include "macros/security.ftl">-->
<@standartTemplate.standart>
<@nav.navbar/>
<section>
<table class="table top-cover col-8">
    <thead class="text-center font-weight-bold">
    <tr>
        <td class="d-none">idUser</td>
        <td>Email</td>
        <td>Username</td>
        <td>Password</td>
        <td>Name Role</td>
        <td>Edit</td>
    </tr>
    </thead>
    <tbody>
<#list userlist as user>

    <tr>
        <td class="d-none">${user.idUser?c}</td>
        <td>${(user.mail)!}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.role.nameRole}</td>
        <td class="row">
            <i class="fa fa-pencil ml-1" aria-hidden="true"></i>
            <i class="fa fa-trash ml-1" aria-hidden="true"></i>
            <i class="fa fa-ban ml-1" aria-hidden="true"></i>
        </td>
    </tr>
</#list>
    </tbody>
</table>
</section>
</@standartTemplate.standart>