<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    role = user.getRole().getNameRole()
    id=user.getIdUser()
    >
<#else>
    <#assign
    name = "unknown"
    role = false
    >
</#if>