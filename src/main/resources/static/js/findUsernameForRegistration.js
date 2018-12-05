$('input[name=username]').change(function () {
    var username = {};
    username['username'] = $('input[name=username]').val();

    $.ajaxSetup({
        headers:
            {'X-CSRF-TOKEN': $('input[name=_csrf]').val()}
    });
    $.ajax({
        url: '/Register/getUserExist',
        type: 'post',
        data: username,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: (function (data) {
            if (data) {
                if (!$('#errorDiv').length)
                    $('<div id="errorDiv" class="form-text small container">This Username already use</div>').insertAfter('input[name=username]')
            }
            else
                $('#errorDiv').remove()
            checkUsername();
            checkErrors();
        })

    });
})