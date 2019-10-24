/**
 * Created by MyPC on 29/01/2018.
 */
var tmp;
$(document).ready(function () {
    $('#tbl-staffs').DataTable();
    $('#tbl-lecturers').DataTable();
    $('#tbl-departments').DataTable();
    $('#tbl-students').DataTable();
    $('#tbl-classes').DataTable();
});
$(".btn-check-target").click(function () {
    tmp = $(this).val();
    if (tmp == "Đã chọn") {
        $(this).removeClass("btn-checked");
        $(this).addClass("btn-check-target");
        $(this).val("Chọn");
    }
    if (tmp == "Chọn") {
        $(this).removeClass("btn-check-target");
        $(this).addClass("btn-checked");
        $(this).val("Đã chọn");
    }
});
// $(".btn-checked").click(function(){
//     selectedtarget.removeClass("btn-checked");
//     selectedtarget.addClass("btn-check-target");
//     selectedtarget.text("Chọn");
//     selectedtarget = null;
// });
