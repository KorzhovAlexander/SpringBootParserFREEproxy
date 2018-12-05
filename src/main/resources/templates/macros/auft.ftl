<#macro auf type>

<#if type=="/login">
<!--name="login"-->
<div class="login-card">
<#--    <h1></h1><br>-->
    <div class="modal-header">
        <h1>Log-in</h1>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
        </button>
    </div>
<#--        <#if !user??>
        <div class="alert alert-danger" role="alert">
            This is a danger alert—check it out!
        </div>
        </#if>-->
    <div class="modal-body">

    <form action="${type}" method="post">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="usernameHelp"><i class="fa fa-user-circle-o fa-fw" aria-hidden="true"></i></span>
            </div>
            <input type="text" class="form-control" name="username" aria-describedby="usernameHelp" placeholder="Username">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="passwordHelp"><i class="fa fa-unlock-alt fa-fw" aria-hidden="true"></i></span>
            </div>
            <input type="password" class="form-control" name="password" aria-describedby="passwordHelp" placeholder="Password">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit"  class="btn btn-dark" value="Log in">
    </form>

    <div class="login-help">
        <a href="/Register">Register</a> • <a href="/">Main Page</a>
    </div>
</div>
</div>
<script src="/static/js/monitoringLoginForm.js"></script>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->
<#elseif type=="/Register">
<div class="login-card">
    <h1>Register</h1><br>

    <form action="${type}" method="post">
<#--        <input type="text" name="username">
        <input type="password" name="password">
        <input type="email" name="email">

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit"  class="login login-submit" value="Register">-->

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="emailHelp"><i class="fa fa-envelope-o fa-fw "></i></span>
        </div>
        <input type="email" class="form-control" name="mail" aria-describedby="emailHelp" placeholder="Enter email">
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="usernameHelp"><i class="fa fa-user-circle-o fa-fw" aria-hidden="true"></i></span>
        </div>
        <input type="text" class="form-control" name="username" aria-describedby="usernameHelp" placeholder="Username">
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="passwordHelp"><i class="fa fa-unlock-alt fa-fw" aria-hidden="true"></i></span>
        </div>
        <input type="password" class="form-control" name="password" aria-describedby="passwordHelp" placeholder="Password">
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="passwordHelp2"><i class="fa fa-lock fa-fw" aria-hidden="true"></i></span>
        </div>
        <input type="password" class="form-control" name="password2" aria-describedby="passwordHelp2" placeholder="Repeat password">
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit"  class="btn btn-dark" value="Register">
    </form>

    <div class="login-help">
        <a href="/login">Log-in</a> • <a href="/">Main Page</a>
    </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->
<script src="/static/js/findUsernameForRegistration.js"></script>
<script src="/static/js/monitoringRegistrationForm.js"></script>
<#elseif type=="/logout">
<div class="container m-md-6 text-center">
    <button class="btn btn-primary" onclick="location.href='/'">Main page</button>

    <form action="${type}" class="m-lg-3" method="post">
        <input type="submit" class="btn bg-warning" value="Sign Out">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>
</#if>
</#macro>