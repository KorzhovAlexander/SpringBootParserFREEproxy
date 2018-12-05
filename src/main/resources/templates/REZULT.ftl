<#import "macros/auft.ftl" as auf>
<#import "macros/tableREZ.ftl" as table>
<#--<#import "macros/navbar.ftl" as nav>-->
<#import "macros/standart.ftl" as standart>

<@standart.standart>
<#--<@nav.navbar/>-->
<@auf.auf "/logout" />

<div class="container text-center">
    <h1>Rez</h1>
    <span class="separator"></span>
    <p class="TextWithMarginTop">Final rez</p>
</div>

<@table.tableREZ/>



</@standart.standart>