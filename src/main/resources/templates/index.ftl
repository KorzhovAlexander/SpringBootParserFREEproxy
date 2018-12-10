<#import "macros/navbar.ftl" as navbar>
<#import "macros/tableproxy.ftl" as tableproxy>
<#import "macros/standart.ftl" as standart>
<#include "macros/security.ftl">

<@standart.standart>
<script defer src="/static/js/location.js"></script>
<script defer src="/static/js/buttom_down.js"></script>
<script defer src="/static/js/searchMainStatick.js"></script>
<script defer src="/static/js/ajaxFeedback.js"></script>
<#--HEADER-->
    <@navbar.navbar/>
<section style="height: 100%;">
    <div class="container text-center">
        <h1>Socks Proxy</h1>
        <span class="separator"></span>
        <p class="TextWithMarginTop">Socks proxies that are just checked and updated every 10 minutes</p>
    </div>
    <div class="container py-lg-4">
        <div class="row">
            <table class="table top-cover col-6">
                <thead class="text-center">
                <tr>
                    <th>Param</th>
                    <th>Rezult</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>IPv4</th>
                    <th id="ip" class="text-right"></th>
                </tr>
                <tr>
                    <th>Country</th>
                    <th id="cntry" class="text-right"></th>
                </tr>
                <tr>
                    <th>City</th>
                    <th id="City" class="text-right"></th>
                </tr>
                <tr>
                    <th>OS</th>
                    <th id="OS" class="text-right"></th>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
    <div class="first_pointer d-none d-lg-block">
        <a class="arrow-wrap" href="#NextStep">
            <span class="hint">Proxy List</span>
            <span class="arrow"></span>
        </a>
    </div>
</section>

<section class="pricing">
    <div class="[ price-option price-option--low ] mb-2">
        <div class="price-option__detail">
            <span class="price-option__cost">$0</span>
            <span class="price-option__type">Basic</span>
            <span class="price-option__type">Unlimited</span>
            <span class="price-option__type2">More than 100 proxies.</span>
            <br class="price-option__type2">
        </div>
        <a href="#" class="price-option__purchase">Get</a>
    </div>
    <div class="[ price-option price-option--mid ] mb-2">
        <div class="price-option__detail">
            <span class="price-option__cost">$20</span>
            <span class="price-option__type">V.I.P</span>
            <span class="price-option__type"><b class="text-danger">3 months</b></span>
            <span class="price-option__type2">More than 1000 proxies. Convenient query panel. The best price</span>
        </div>
        <a href="#" class="price-option__purchase">Buy</a>
    </div>
    <div class="[ price-option price-option--high mb-2]">
        <div class="price-option__detail">
            <span class="price-option__cost">$10</span>
            <span class="price-option__type">V.I.P</span>
            <span class="price-option__type">1 months</span>
            <span class="price-option__type2">More than 1000 proxies. Convenient query panel</span>
        </div>
        <a href="#" class="price-option__purchase">Buy</a>
    </div>
</section>

<section>
    <div class="feedback container" style="width: 50%">
        <div class="container text-center">
            <h1>Feedback from site users</h1>
            <p class="text-muted">This feedback was added after checking by the administration.</p>
            <span class="separator mb-3"></span>
        </div>
        <div class="container" style="overflow: auto;max-height:420px;">
<#--            <div class="card mt-3 mx-auto " style="width: 85%;">
                <div class="card-body">
                    <h4 class="card-title ml-2"></h4>
                    <small class="card-subtitle text-muted">honeyiamgood@mail.ru</small>

                    <p class="card-text"></p>
                </div>
            </div>-->
              <#if feedback??>
                  <#list feedback as feedback>
            <div class="card mt-3 mx-auto " style="width: 85%;">
                <div class="card-body ">
                    <h4 class="card-title ml-2">${feedback.theme}</h4>
                    <#if feedback.user.mail??>
                    <small class="card-subtitle text-muted">${feedback.user.mail}</small>
                    </#if>

                    <p class="card-text">${feedback.feedback}</p>
                </div>
            </div>

                  </#list>
              </#if>
        </div>
        <div class="container text-center mt-3">
            <button class="btn btn-dark" data-toggle="modal" data-target="#modalDLGforFeedback">
                Send feedback
            </button>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="table-responsive text-center">
            <h1 id="NextStep" class="text-center">Table Proxy</h1>
            <span class="separator"></span>
            <br>

        <#--TABLE-->
                <@tableproxy.table/>
        </div>
    </div>
</section>

<!--Start script-->
<#--    <canvas id="canvas" class="resizes blure" style="height: max-content; width: max-content">
    </canvas>-->



    <div class="modal fade" id="modalDLGforFeedback" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document" style="pointer-events: auto;">
            <div class="place">
                <div class="modal-header">
                    <h5 class="modal-title">Feedback</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="feedbackForm">
                    <form method="post" id="feedbackform">
                        <div class="form-group">
                            <label for="ThemeFormControlTextarea1">Theme</label>
                            <input type="text" class="form-control" id="ThemeFormControlTextarea1">
                        </div>
                        <!-- if user not exist -->
    <#if !user??>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email address</label>
                            <input type="email" class="form-control" id="exampleFormControlInput1"
                                   placeholder="name@example.com">
                        </div>
    <#else>
                            <div class="form-group">
                                <label for="exampleFormControlInput2">Username</label>
                                <input type="email" class="form-control" id="exampleFormControlInput2" value="${name}"
                                       disabled>
                            </div>
    </#if>

                        <div class="form-group">
                            <label for="MessageFormControlTextarea1">Message</label>
                            <textarea class="form-control" id="MessageFormControlTextarea1" rows="5"></textarea>
                        </div>
                        <input type="submit" class="btn btn-dark" value="Send my feedback">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


<footer class="footer">
    <div class="container pt-3">
        <div class="row">
            <div class="col-sm-2">
                <h2>
                    <img src="/static/images/sh_d.png" style="width: 60px;">
                <#--<span class="logoTextFooter"> KAA security project</span>-->
                </h2>

            </div>
            <div class="col-sm-2">
                <h5>Communications</h5>
                <ul>
                    <li><a href="https://vk.com/solifax"><i class="fa fa-vk" aria-hidden="true"></i> Vkontakte</a></li>
                    <li><a href="#"><i class="fa fa-telegram" aria-hidden="true"></i> Telegram</a></li>
                </ul>
            </div>
        <#---->
            <div class="col-sm-2">
                <h5>Project code</h5>
                <ul>
                    <li><a href="https://github.com/HoneyGood/WebApp"><i class="fa fa-github" aria-hidden="true"></i> Open sours</a></li>
                </ul>
            </div>
            <div class="col-sm-6">
                <h5>Write us</h5>
                <ul>
                    <li><a href="#" data-toggle="modal"
                           data-target="#modalDLGforFeedback"><i class="fa fa-comment" aria-hidden="true"></i> Leave a
                        comment</a></li>
                </ul>
            </div>

        </div>
    </div>
    <div class="container" id="copyright">
        <span class="separator"></span>
        <i class="fa fa-copyright" aria-hidden="true"></i> Korzhov Alexander Alekseevich 2018

    </div>
</footer>


</@standart.standart>