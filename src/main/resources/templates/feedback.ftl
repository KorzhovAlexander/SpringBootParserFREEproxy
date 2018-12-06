<#import "macros/standart.ftl" as standart>
<#import "macros/navbar.ftl" as navbar>

<@standart.standart>
    <@navbar.navbar/>
<div class="container">
    <div class="row" style="padding-top: 100px">

  <#if feedback??>
            <#list feedback as feedback>
<form method="post" action="/feedback">
<div class="card mt-3 mx-2 " style=" <#if feedback.add>box-shadow: 0 0 2px blue</#if>">
    <div class="card-body ">
        <h5 class="card-title">${feedback.theme}</h5>
<#if feedback.user.mail??>
    <h6 class="card-subtitle mb-2 text-muted">${feedback.user.mail}</h6>
</#if>

        <p class="card-text">${feedback.feedback}</p>
        <div class="row">
            <div class="col-6">
                <input type="submit" class="btn btn-link" value="Published" name="Published">
            </div>
        <input type="submit" class="btn btn-link" value="Delete" name="Delete">
        </div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="hidden" value="${feedback.idfeedback}" name="idfeedback">
    </div>
</div>
</form>
            </#list>
  </#if>
    </div></div>


</@standart.standart>