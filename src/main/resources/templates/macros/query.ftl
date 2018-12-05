<#macro query userid>
<script src="/static/js/search.js" type="application/javascript"></script>
    <div class="searchForm text-center">
        <div class="modal-header">
            <h1>ViP Proxy parser</h1>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
        </div>
        <div class="modal-body">
        <form class="my-6" id="formForSearch">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="GetProxy" name="GetProxy" checked>
                <label class="form-check-label" for="GetProxy">GetProxy</label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="GetPort" name="GetPort" checked>
                <label class="form-check-label" for="GetPort">GetPort</label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="GetCountry" name="GetCountry" disabled>
                <label class="form-check-label" for="GetCountry">GetCountry (disabled)</label>
            </div>

            <div class="form-group mt-4">
                <label for="exampleInputEmail1">Country Code</label>
                <input name="SeachEdit" class="form-control" id="SeachEdit" aria-describedby="Annotation" placeholder="Enter Country ID">
                <small id="Annotation" class="form-text text-muted">Example for "Italy": IT</small>
            </div>

            <div>
                <input type="hidden" name="id" value="${userid}" id="iduser">
                <input type="hidden" name="_csrf" value="${_csrf.token}" id="csrf">
                <BUTTON type="submit" class="btn btn-danger mb-4 mt-2">Start Search</button>
            </div>
        </form>
        <div class="container" id="containerRez">
        </div>
        </div>
    </div>


</#macro>