/**
 * Created by MyPC on 29/01/2018.
 */
var selectedtarget;
var tmp;
$(document).ready(function () {
    $('#tbl-courses').DataTable();
    $('#tbl-lecturers').DataTable();
    $('#tbl-departments').DataTable();
    $('#tbl-subjects').DataTable();
});
$(".btn-check-target").click(function () {
    tmp = $(this).val();
    if (selectedtarget != null) {
        selectedtarget.removeClass("btn-checked");
        selectedtarget.addClass("btn-check-target");
        selectedtarget.val("Chọn");
    }
    if (tmp == "Chọn") {
        selectedtarget = $(this);
        selectedtarget.removeClass("btn-check-target");
        selectedtarget.addClass("btn-checked");
        selectedtarget.val("Đã chọn");
    }
});
// $(".btn-checked").click(function(){
//     selectedtarget.removeClass("btn-checked");
//     selectedtarget.addClass("btn-check-target");
//     selectedtarget.text("Chọn");
//     selectedtarget = null;
// });
