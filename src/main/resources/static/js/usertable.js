$("i.fa-ban").click(function(){
    var el = $(this).parent().parent().text();
    var arr = el.split('\n');
    $('form[name=banuser] > input[name=iduser]').val(arr[1].trim())
    $('form[name=banuser]').submit();
})

$("i.fa-trash").click(function(){
    var el = $(this).parent().parent().text();
    var arr = el.split('\n');
    $('form[name=deleteuser] > input[name=iduser]').val(arr[1].trim())
    $('form[name=deleteuser]').submit();
})


$("i.fa-pencil").click(function(){
    var el = $(this).parent().parent().text();
    var arr = el.split('\n');
    $('form[name=updateuser] > input[name=iduser]').val(arr[1].trim())
    $('form[name=updateuser] > div > input[name=email]').val(arr[2].trim())
    $('form[name=updateuser] > div > input[name=username]').val(arr[3].trim())
    $('form[name=updateuser] > div > input[name=password]').val('VALUE ENCRYPTED')
    $('form[name=updateuser] > div > input[name=nameRole]').val(arr[5].trim())
    scroll()

    /*    alert(arr[1]) //id
        alert(arr[2]) // email
        alert(arr[3]) //username
        alert(arr[4]) //password
        alert(arr[5]) //role*/
});

function scroll() {
    $('html, body').animate({scrollTop: $('form[name=updateuser]').offset().top}, 300);
}
