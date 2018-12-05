
$("input").keyup(function () {
    //eq password

    // language=JQuery-CSS
    if ($('input[name=password]').val() == 0)
        $('input[name=password]').attr('style', "border-color: red")
    else {
        $('input[name=password]').removeAttr('style')
    }

    //username
    if ($('input[name=username]').val().length >= 30 || $('input[name=username]').val() == 0)
        $('input[name=username]').attr('style', "border-color: red")
    else
        $('input[name=username]').removeAttr('style')

    if ($('.login-card input').is('[style="border-color: red"]'))
        $('input[value="Log in"]').attr('disabled', 'disabled')
    else $('input[value="Log in"]').removeAttr('disabled')
})