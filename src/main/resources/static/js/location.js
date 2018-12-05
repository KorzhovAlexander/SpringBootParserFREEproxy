/*{
"geobytesforwarderfor": "",
    "geobytesremoteip": "116.12.250.1",
    "geobytesipaddress": "116.12.250.1",
    "geobytescertainty": "99",
    "geobytesinternet": "SA",
    "geobytescountry": "Saudi Arabia",
    "geobytesregionlocationcode": "SASH",
    "geobytesregion": "Ash Sharqiyah",
    "geobytescode": "SH",
    "geobyteslocationcode": "SASHJUBA",
    "geobytescity": "Jubail",
    "geobytescityid": "13793",
    "geobytesfqcn": "Jubail, SH, Saudi Arabia",
    "geobyteslatitude": "27.004999",
    "geobyteslongitude": "49.660999",
    "geobytescapital": "Riyadh ",
    "geobytestimezone": "+03:00",
    "geobytesnationalitysingular": "Saudi Arabian ",
    "geobytespopulation": "22757092",
    "geobytesnationalityplural": "Saudis",
    "geobytesmapreference": "Middle East ",
    "geobytescurrency": "Saudi Riyal",
    "geobytescurrencycode": "SAR",
    "geobytestitle": "Saudi Arabia"
}*/


//http://gd.geobytes.com/GetCityDetails?callback=?

var browser = navigator.userAgent;
var br = String;
$.ajax({
    url:'http://gd.geobytes.com/GetCityDetails?callback=?',
    type:'get',
    dataType:'json'
}).done(function(data) {
    $( "#ip" ).html( data.geobytesremoteip );
    $( "#cntry" ).html( data.geobytescountry );
    $( "#City" ).html( data.geobytescity );

    /*    if (browser.indexOf('Chrome') !== -1) br= 'Google Chrome';
        if (browser.indexOf('Firefox') !== -1) br= 'Firefox';
        if (browser.indexOf('Opera') !== -1) br= 'Opera';
        if (browser.indexOf('Safari') !== -1) br= 'Safari';
        if (browser.indexOf('MSIE') !== -1) br= 'Internet Explorer';*/

    var OSName="Unknown OS";
    if (navigator.appVersion.indexOf("Win")!==-1) OSName="Windows";
    if (navigator.appVersion.indexOf("Mac")!==-1) OSName="MacOS";
    if (navigator.appVersion.indexOf("X11")!==-1) OSName="UNIX";
    if (navigator.appVersion.indexOf("Linux")!==-1) OSName="Linux";

    $( "#OS" ).html( OSName );



});
