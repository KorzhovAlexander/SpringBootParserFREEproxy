<#macro tableREZ>
    <div class="row text-center">

        <div class="container col-6" style="text-align: right">
            <#list query as q>
                ${q.proxy}:${q.port}<br>
            </#list>
        </div>
        <div class="container col-6" style="text-align: left">
            <#list query as q>
                ${q.code}<br>
            </#list>
        </div>

        <!--<div class="container col-6" style="text-align: right">{{#query}}{{username}}<br>{{/query}}</div>-->
    </div>
</#macro>