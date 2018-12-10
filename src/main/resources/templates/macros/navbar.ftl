<#macro navbar >
    <#include "security.ftl">
<header id="header">
    <nav class="navbar navbar-expand-md fixed-top dark_nav navbar-dark">
        <a class="navbar-brand" href="/"><img src="/static/images/sh_d.png" style="width: 30px;height: 30px"> KAA</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home <span class="sr-only">(Home)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/FAQ">FAQ <span class="sr-only">(FAQ)</span></a>
                </li>

                <#if user??>
                    <#if role=="Admin">
                        <li class="nav-item active">
                            <a class="nav-link" href="/feedback">feedback <span class="sr-only">(AllFeedback)</span></a>
                        </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/users">UserList <span class="sr-only">(AllUsers)</span></a>
                </li>
                    </#if>
                </#if>
            <#--                <li class="nav-item">
                                <a class="nav-link" href="#">Link</a>

                                                    {{#user}}
                                                        <form action="/user/{{user}}" method="get" class="nav-link">
                                                            <input type="submit" class="btn btn-outline-info my-2 my-sm-0" value="My page">
                                                        </form>
                                                    {{/user}}

                            </li>-->
                <li class="nav-item">
                    <a class="nav-link disabled" href="/#">All proxy</a>
                </li>
            </ul>

            <!--            <form class="form-inline mt-2 mt-md-0" method="get">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" href="/LogIn">LogIn</button>
                        </form>-->

            <#if user??>
                        <button class="button btn btn-outline-warning mr-3 my-sm-0" data-toggle="modal"
                                data-target="#modalDLGforSearch">VIP Searching
                        </button>

            <form action="/logout" method="post" class="my-2 my-sm-0">
                <input type="submit" class="btn btn-outline-info " value="${name} Logout">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
            <#else>
                        <button class="button btn btn-outline-warning mr-3 my-sm-0" data-toggle="modal"
                                data-target="#modalDLG">VIP Searching
                        </button>
            <#--<button class="btn btn-outline-info my-2 my-sm-0" onclick="location.href='/login'">Log In</button>-->
                                <button type="button" class="btn btn-outline-info my-2 my-sm-0" data-toggle="modal"
                                        data-target="#modalDLG">Log In
                                </button>
            </#if>
        </div>
    </nav>

</header>
    <#import "auft.ftl" as auf >
<!-- Modal -->
<div class="modal fade" id="modalDLG" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">

    <div class="modal-dialog modal-dialog-centered" role="document" style="pointer-events: auto;">
                <@auf.auf "/login" />
    </div>
</div>

    <#if user??>
        <#import "query.ftl" as quer>
    <div class="modal fade" id="modalDLGforSearch" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document" style="pointer-events: auto;">
                <@quer.query id />
        </div>
    </div>
    </#if>
</#macro>