$(function () {
    'use strict';
    // Switch Between Login & Signup
    $('.box .bar div').click(function () {
        $(this).addClass('selected').siblings().removeClass('selected');
        $('form').hide();
        $('.' + $(this).data('class')).fadeIn(100);
    });
    $('textarea').click(function () {
        $('#op').fadeIn(200);
    });
    $('.op, #insert').click(function () {
        $('.op').fadeOut(200);
        /*if ($('.mycontainer .cont2 textarea').val() != "") {
            return confirm('Are You Sure?');
        }*/
    });
});
$(document).keyup(function (e) {
    if (e.keyCode === 27) {
        $(".op").fadeOut();
        $('.mycontainer .cont2 textarea').blur();
    };
});

