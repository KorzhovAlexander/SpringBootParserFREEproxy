$('th>input').keyup(function(){
    var message={}
    message['proxy']=$('tfoot>tr>th>input').val()
    message['port']=''
    message['code']=''

    $.ajaxSetup({
        headers:
            {'X-CSRF-TOKEN': $('input[name=_csrf]').val()}
    });
    $.ajax({
        url:'/',
        type:'post',
        data: message,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: (function (data) {
            $('.table-striped tbody tr').remove()
/*
*                             <td>49.156.35.230</td>
                            <td>61647</td>
                            <td>KH</td>
                            <td>Socks4</td>
                            <td class="hm">Anonymous</td>
                            <td class="hm">Yes!!!</td>
                            <td class="hd">6 seconds ago!!!</td>*/


            var output = "";
            for (var i in data.rezult) {output +=
                "<tr>" +
                "<td>"+ data.rezult[i].proxy + "</td>" +
                "<td>" + data.rezult[i].port +"</td>" +
                "<td>"+ data.rezult[i].code + "</td>"+
                "<td>"+ data.rezult[i].type + "</td>" +
                "<td>Anonymous</td>"+
                "<td>Yes!!!</td>"+
                "<td>6 seconds ago!!!</td>"+
                "</tr>";
            }
            $('.table-striped>tbody').html(output);
        })
    })

})