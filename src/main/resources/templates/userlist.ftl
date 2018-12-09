<#import "macros/standart.ftl" as standartTemplate>
<#import "macros/navbar.ftl" as nav>
<#--<#include "macros/security.ftl">-->
<@standartTemplate.standart>

    <@nav.navbar/>
        <script defer src="/static/js/usertable.js"></script>


<section>
    <table class="table top-cover col-8" id="mars">
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
<section>

    <div class="container">
        <!-- delete -->
        <form method="post" action="/deleteuser" name="deleteuser">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="iduser">
        </form>

        <!-- ban -->
        <form method="post" action="/banuser" name="banuser">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="iduser">
        </form>
        <div class="container col-6">
            <!-- update -->
            <form method="post" action="/updateuser" name="updateuser" class="text-center">
                <h1 >Update user</h1>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="iduser" value="">
                <div class="form-group mt-4">
                    <small class="form-text text-muted">Email</small>
                    <input type="email" name="email" class="form-control">
                </div>
                <div class="form-group mt-4">
                    <small class="form-text text-muted">Username</small>
                    <input type="text" name="username" class="form-control">
                </div>
                <div class="form-group mt-4">
                    <small class="form-text text-muted">Password</small>
                    <input type="text" name="password" class="form-control">
                </div>
                <div class="form-group mt-4">
                    <small class="form-text text-muted">Role</small>
                    <input type="text" name="nameRole" class="form-control">
                </div>
                <input type="submit" name="btn submit" class="btn btn-dark" value="Update">
            </form>
        </div>
    </div>
</section>

</@standartTemplate.standart>