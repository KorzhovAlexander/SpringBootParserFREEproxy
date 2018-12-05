function checkPassword() {
    if ($('input[name=password]').val().length >= 30 || $('input[name=password]').val() == 0)
        $('input[name=password]').attr('style', "border-color: red")
    else
        $('input[name=password]').removeAttr('style')


    if ($('input[name=password2]').val().length >= 30 || $('input[name=password2]').val() == 0)
        $('input[name=password2]').attr('style', "border-color: red")
    else
        $('input[name=password2]').removeAttr('style')

}


function checkUsername() {
    //username
    if ($('input[name=username]').val().length >= 30 || $('input[name=username]').val() == 0||$('#errorDiv').length)
        $('input[name=username]').attr('style', "border-color: red")
    else
        $('input[name=username]').removeAttr('style')
}

function checkErrors() {

    if ($('.login-card input').is('[style="border-color: red"]'))
        $('input[value=Register]').attr('disabled', 'disabled')
    else $('input[value=Register]').removeAttr('disabled')
}

$("input").keyup(function () {
    //eq password

    // language=JQuery-CSS
    if ($('input[name=password]').val() !== $('input[name=password2]').val())
        $('input[type=password]').attr('style', "border-color: red")
    else {
        $('input[type=password]').removeAttr('style')
        checkPassword();
    }
    //email
    if ($('input[name=mail]').val().length >= 30 || $('input[name=mail]').val() == 0)
        $('input[name=mail]').attr('style', "border-color: red")
    else
        $('input[name=mail]').removeAttr('style')

checkUsername();
checkErrors();
})