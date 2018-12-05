function sendFeedback() {
    var message = {};
    message['theme'] = $('#ThemeFormControlTextarea1').val();
    message['feedback'] =$('#MessageFormControlTextarea1').val();
    message['email'] =$('#exampleFormControlInput1').val();

    $.ajaxSetup({
        headers:
            { 'X-CSRF-TOKEN': $('input[name=_csrf]').val() }
    })

    $.ajax({
        url:'/feedbacksend',
        type:'post',
        data: message,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: (function (data) {
            var output='<div class="alert alert-info" role="alert">Your feedback apply</div>'
            if(data){
                $('#feedbackForm').html(output);
            }
        })
    })

}


    $('#feedbackform').submit(function (event) {
        event.preventDefault();
        sendFeedback();
    })


