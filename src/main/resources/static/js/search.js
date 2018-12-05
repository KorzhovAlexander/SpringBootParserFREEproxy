
$(document).ready(function () {

    $('#formForSearch').submit(function (event) {
        event.preventDefault();
        startSearch();
        
    })
    
});

function startSearch(){
    var search={};
    search['SeachEdit']=$('#SeachEdit').val();
    search['id']=$('#iduser').val();

    $.ajaxSetup({
        headers:
            { 'X-CSRF-TOKEN': $('#csrf').val() }
    });


    $.ajax({
        url:'/content',
        type:'post',
        data: search,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: (function (data) {


            var output = "<textarea class=\"form-control\" rows=\"7\">";
            if ($('#GetProxy').is(":checked") && $('#GetPort').is(":checked")) {
                for (var i in data.rez) {
                    output += data.rez[i].proxy + ":" + data.rez[i].port + "\n";
                }
            }

            output += "</textarea>";
            $('#containerRez').html(output);

        }),

    });


        /*        $('#containerRez').html(JSON.stringify(rez.type))
                $('#containerRez').html(JSON.valueOf(rez.type))*/


        // $('#containerRez').html(JSON.stringify(data))
        //  $("#containerRez").html(JSON.stringify(data.proxy));






}

