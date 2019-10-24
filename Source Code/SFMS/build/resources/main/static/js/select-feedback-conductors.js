/**
 * Created by MyPC on 29/01/2018.
 */
var tmp, btn;
$(document).ready(function () {
    $('#tbl-staffs').DataTable(
        {
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy",
                "info": "Hiển thị từ _START_ tới _END_ trong số _TOTAL_ kết quả",
                "infoEmpty": "Hiển thị 0 tới 0 trong số 0 kết quả",
                "infoFiltered": "(filtered from _MAX_ total entries)",
                "infoPostFix": "",
                "thousands": ",",
                "lengthMenu": "_MENU_ kết quả mỗi trang",
                "loadingRecords": "Đang tải...",
                "processing": "Đang xử lý...",
                "search": "Tìm:",
                "zeroRecords": "Không tìm thấy kết quả phù hợp",
                "paginate": {
                    "first": "Đầu",
                    "last": "Cuối",
                    "next": "Sau",
                    "previous": "Trước"
                },
                "aria": {
                    "sortAscending": ": kích hoạt để sắp xếp tăng dần",
                    "sortDescending": ": kích hoạt để sắp xếp giảm dần"
                }
            }
        }
    );
    $('#tbl-lecturers').DataTable(
        {
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy",
                "info": "Hiển thị từ _START_ tới _END_ trong số _TOTAL_ kết quả",
                "infoEmpty": "Hiển thị 0 tới 0 trong số 0 kết quả",
                "infoFiltered": "(filtered from _MAX_ total entries)",
                "infoPostFix": "",
                "thousands": ",",
                "lengthMenu": "_MENU_ kết quả mỗi trang",
                "loadingRecords": "Đang tải...",
                "processing": "Đang xử lý...",
                "search": "Tìm:",
                "zeroRecords": "Không tìm thấy kết quả phù hợp",
                "paginate": {
                    "first": "Đầu",
                    "last": "Cuối",
                    "next": "Sau",
                    "previous": "Trước"
                },
                "aria": {
                    "sortAscending": ": kích hoạt để sắp xếp tăng dần",
                    "sortDescending": ": kích hoạt để sắp xếp giảm dần"
                }
            }
        }
    );
    $('#tbl-departments').DataTable(
        {
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy",
                "info": "Hiển thị từ _START_ tới _END_ trong số _TOTAL_ kết quả",
                "infoEmpty": "Hiển thị 0 tới 0 trong số 0 kết quả",
                "infoFiltered": "(filtered from _MAX_ total entries)",
                "infoPostFix": "",
                "thousands": ",",
                "lengthMenu": "_MENU_ kết quả mỗi trang",
                "loadingRecords": "Đang tải...",
                "processing": "Đang xử lý...",
                "search": "Tìm:",
                "zeroRecords": "Không tìm thấy kết quả phù hợp",
                "paginate": {
                    "first": "Đầu",
                    "last": "Cuối",
                    "next": "Sau",
                    "previous": "Trước"
                },
                "aria": {
                    "sortAscending": ": kích hoạt để sắp xếp tăng dần",
                    "sortDescending": ": kích hoạt để sắp xếp giảm dần"
                }
            }
        }
    );
    $('#tbl-students').DataTable(
        {
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy",
                "info": "Hiển thị từ _START_ tới _END_ trong số _TOTAL_ kết quả",
                "infoEmpty": "Hiển thị 0 tới 0 trong số 0 kết quả",
                "infoFiltered": "(filtered from _MAX_ total entries)",
                "infoPostFix": "",
                "thousands": ",",
                "lengthMenu": "_MENU_ kết quả mỗi trang",
                "loadingRecords": "Đang tải...",
                "processing": "Đang xử lý...",
                "search": "Tìm:",
                "zeroRecords": "Không tìm thấy kết quả phù hợp",
                "paginate": {
                    "first": "Đầu",
                    "last": "Cuối",
                    "next": "Sau",
                    "previous": "Trước"
                },
                "aria": {
                    "sortAscending": ": kích hoạt để sắp xếp tăng dần",
                    "sortDescending": ": kích hoạt để sắp xếp giảm dần"
                }
            }
        }
    );
    $('#tbl-classes').DataTable(
        {
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy",
                "info": "Hiển thị từ _START_ tới _END_ trong số _TOTAL_ kết quả",
                "infoEmpty": "Hiển thị 0 tới 0 trong số 0 kết quả",
                "infoFiltered": "(filtered from _MAX_ total entries)",
                "infoPostFix": "",
                "thousands": ",",
                "lengthMenu": "_MENU_ kết quả mỗi trang",
                "loadingRecords": "Đang tải...",
                "processing": "Đang xử lý...",
                "search": "Tìm:",
                "zeroRecords": "Không tìm thấy kết quả phù hợp",
                "paginate": {
                    "first": "Đầu",
                    "last": "Cuối",
                    "next": "Sau",
                    "previous": "Trước"
                },
                "aria": {
                    "sortAscending": ": kích hoạt để sắp xếp tăng dần",
                    "sortDescending": ": kích hoạt để sắp xếp giảm dần"
                }
            }
        }
    );
});

$(".btn-check-all").click(function () {
    tmp = $(this).val();
    btn = $(".btn-check-all");
    if (tmp == "Chọn tất cả") {
        btn.removeClass("btn-check-all");
        btn.addClass("btn-checked-all");
        btn.val("Bỏ chọn hết");
        btn = $(".btn-check-target");
        tmp = "Chọn";
        selectObjBtn();
    }
    if (tmp == "Bỏ chọn hết") {
        // alert("hihi");
        btn.removeClass("btn-checked-all");
        btn.addClass("btn-check-all");
        btn.val("Chọn tất cả");
        btn = $(".btn-checked");
        tmp = "Đã chọn";
        selectObjBtn();
    }

});

$(".btn-check-target").click(function () {
    btn = $(this);
    tmp = $(this).val();
    selectObjBtn();
});

function selectObjBtn() {
    if (tmp == "Đã chọn") {
        btn.removeClass("btn-checked");
        btn.addClass("btn-check-target");
        btn.val("Chọn");
        btn = $(".btn-checked-all");
        btn.removeClass("btn-checked-all");
        // alert("haha");
        btn.addClass("btn-check-all");
        btn.val("Chọn tất cả");
    }
    if (tmp == "Chọn") {
        btn.removeClass("btn-check-target");
        btn.addClass("btn-checked");
        btn.val("Đã chọn");
    }
}
// $(".btn-checked").click(function(){
//     selectedtarget.removeClass("btn-checked");
//     selectedtarget.addClass("btn-check-target");
//     selectedtarget.text("Chọn");
//     selectedtarget = null;
// });
