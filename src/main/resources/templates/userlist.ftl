<#import "macros/standart.ftl" as standartTemplate>
<#import "macros/navbar.ftl" as nav>
<#--<#include "macros/security.ftl">-->
<@standartTemplate.standart>
<@nav.navbar/>
<section>
<div class="container text-center">
<table class="table">
    <thead class="text-center font-weight-bold">
    <tr>
        <td>idUser</td>
        <td>Username</td>
        <td>Password</td>
        <td>NameRole</td>
        <td>New Role</td>
    </tr>
    </thead>
    <tbody>
<#list userlist as user>

    <tr class="formForEdit">
        <td class="iduser">${user.idUser}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <#if user.role??>
        <td>${user.role.nameRole}</td>
        <td>
            <form action="/setuser" method="POST" name="roleName">
                <select name="idRole" class="form-control form-control-sm idrole">
                    <#list rolelist as role>
                        <option class="idRole" value="${role.idRole}">${role.nameRole}</option>
                    </#list>
                </select>
                <input type="hidden" name="username" value="${user.username}">
                <input type="hidden" value="${_csrf.token}" name="_csrf" class="csrf">
                <input type="submit" class="btn btn-sm btn-secondary col align-self-center"  value="Apply">
            </form>



        </td>
        <#else> <td><i>null</i></td>

            <td>
                <form action="/" method="POST" name="roleName" class="formForEdit">
                    <select name="roleName" class="form-control form-control-sm idrole">
                    <#list rolelist as role>
                        <option class="idRole" value="${role.idRole}">${role.nameRole}</option>
                    </#list>
                    </select>
                    <input type="hidden" value="${_csrf.token}" name="_csrf" class="csrf">
                    <input type="submit" class="btn btn-sm btn-secondary col align-self-center" value="Apply">
                </form>
            </td>
        </#if>
    </tr>
</#list>

    </tbody>
</table>
</div>
</section>
</@standartTemplate.standart>