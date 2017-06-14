/*JSLint browser: true*/
/*global $, jQuery*/

$('document').ready(function () {
    "use strict";

    $('#search-select').change(function () {
        var str = "";
        $('#search-select').find('option:selected').each(function () {
            str = $(this).text();
        });
        $('#search-input').text(str);
    }).change();
});