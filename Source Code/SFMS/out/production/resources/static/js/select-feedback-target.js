/**
 * Created by MyPC on 29/01/2018.
 */
var modifyconductorlink = "<a class='add-inf-item-link' href='/sfms/modify-feedback-conductors'><i class='fa fa-pencil'></i> Chỉnh sửa </a>";
var modifyviewerlink = "<a class='add-inf-item-link'    href='/sfms/modify-feedback-viewers'><i class='fa fa-pencil'></i> Chỉnh sửa </a>";
var btnAddClazz = "<input class='btn active btn-check-target' type='button' onclick='addClazzTarget(this)' value='Chọn'/>"
var btnAddCourse = "<input class='btn active btn-check-target' type='button' onclick='addCourseTarget(this)' value='Chọn'/>"
var btnAddMajor = "<input class='btn active btn-check-target' type='button' onclick='addMajorTarget(this)' value='Chọn'/>"
var btnAddDepartment = "<input class='btn active btn-check-target' type='button' onclick='addDepartmentTarget(this)' value='Chọn'/>"
var btnRemoveClazz = "<input class='btn active btn-checked' type='button' onclick='removeClazzTarget(this)' value='Bỏ chọn'/>"
var btnRemoveCourse = "<input class='btn active btn-checked' type='button' onclick='removeCourseTarget(this)' value='Bỏ chọn'/>"
var btnRemoveMajor = "<input class='btn active btn-checked' type='button' onclick='removeMajorTarget(this)' value='Bỏ chọn'/>"
var btnRemoveDepartment = "<input class='btn active btn-checked' type='button' onclick='removeDepartmentTarget(this)' value='Bỏ chọn'/>"
var showedTargetTab;
var showedTable;
var tmp;
var targets;
// var ;
$(document).ready(function () {
    switch ($('#typeId').val()) {
        case '1':
            showedTargetTab = $('#nav-major');
            showedTargetTab.addClass("show active");
            loadMajorTable();
            // showedTable = $("#tbl-majors");
            break;
        case '2':
            showedTargetTab = $('#nav-course');
            showedTargetTab.addClass("show active");
            loadCourseTable();
            // showedTable = $("#tbl-courses");
            break;
        case '3':
            showedTargetTab = $('#nav-clazz');
            showedTargetTab.addClass("show active");
            loadClazzTable();
            // showedTable = $("#tbl-clazzes");
            break;
        case '4':
            showedTargetTab = $('#nav-department');
            showedTargetTab.addClass("show active");
            loadDepartmentTable();
            // showedTable = $("#tbl-departments");
            break;
        default :
            showedTargetTab = $('#nav-major');
            showedTargetTab.addClass("show active");
            loadMajorTable();
            // showedTable = $("#tbl-majors");
            break;
    }
});

var selected_clazz_to_button = function(data, type, full, meta) {
    if(targets.length==0)return btnAddClazz;
    for (var c in targets){
        let target = targets[c];
        console.log(target["id"]);
        console.log(data);
        if(data==target["id"])return btnRemoveClazz;
    }
    return btnAddClazz;
    // $.each(targets, function(index, value){
    //     if(data==value["id"])return btnRemoveClazz;
    // })
    // return btnAddClazz;
}

var selected_to_button = function(data, type, full, meta) {

    return btnAddClazz;
}
function reloadTable() {
    // alert("hehe");
    setTimeout(function () {
        showedTable.ajax.reload(null, false);// reload without come back to the first page
    }, 200); //reload the table after 0.2s
}

$("#filter-clazz-lecturer").change(function () {
    loadClazzTable();
});
$("#filter-clazz-major").change(function () {
    loadClazzTable();
});
$("#filter-clazz-semester").change(function () {
    loadClazzTable();
});
$("#filter-clazz-course").change(function () {
    loadClazzTable();
});
// $("#filter-clazz-lecturer").change(function(){alert("hihi");loadClazzTable();});
// $("#filter-clazz-major").change(function(){alert("hihi");loadClazzTable();});
// $("#filter-clazz-semester").change(function(){alert("hihi");loadClazzTable();});
// $("#filter-clazz-course").change(function(){alert("hihi");loadClazzTable();});
function loadDepartmentTable() {
    $('#tbl-departments').DataTable().destroy();
    $('#tbl-departments').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/targets/departments",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [
                {
                    "data": "id",
                    "render": selected_to_button
                },
                {"data": "name"},
                {//column for modify conductor
                    "data": null,
                    "defaultContent": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": null,
                    "defaultContent": modifyviewerlink
                }
            ],
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy. <a href='/sfms/modify-feedback/target'>Thêm đối tượng</a>",
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
}
function loadMajorTable() {
    $('#tbl-majors').DataTable().destroy();
    $('#tbl-majors').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/targets/majors",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [
                {
                    "data": "id",
                    "render": selected_to_button
                },
                {"data": "name"},
                {"data": "code"},
                {//column for modify conductor
                    "data": null,
                    "defaultContent": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": null,
                    "defaultContent": modifyviewerlink
                }
            ],
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy. <a href='/sfms/modify-feedback/target'>Thêm đối tượng</a>",
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
}
function loadCourseTable() {
    $('#tbl-courses').DataTable().destroy();
    $('#tbl-courses').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/targets/courses",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [
                {
                    "data": "id",
                    "render": selected_to_button
                },
                {"data": "name"},
                {"data": "code"},
                {//column for modify conductor
                    "data": null,
                    "defaultContent": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": null,
                    "defaultContent": modifyviewerlink
                }
                // {
                //     "data": "majorCoursesById",
                //     "render": function(data, type, row, meta){
                //
                //     }
                // }
            ],
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy. <a href='/sfms/modify-feedback/target'>Thêm đối tượng</a>",
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
}
function loadClazzTable() {
    $('#tbl-clazzes').DataTable().destroy();
    // var filter = {
    //     "majorName": $("#filter-clazz-major").val(),
    //     "courseName": $("#filter-clazz-course").val(),
    //     "semesterTitle": $("#filter-clazz-semester").val(),
    //     "lecturerName": $("#filter-clazz-lecturer").val()
    // }
    // console.log(filter);
    loadClazzTargets();
    showedTable = $('#tbl-clazzes').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/clazzes/" + $("#filter-clazz-major").val() + "/" + $("#filter-clazz-course").val() + "/" + $("#filter-clazz-semester").val() + "/" + $("#filter-clazz-lecturer").val(),
                "dataSrc": "",
                "type": "GET",
                // "dataType": "json",
                // "contentType": "application/json",
                // "data": JSON.stringify(filter)
            },
            "columns": [ //define columns for the table
                // data for the cell from the returned list
                {
                    "data": "id",
                    "render": selected_clazz_to_button
                },
                {"data": "className"},
                {"data": "courseByCourseId.name"},
                {"data": "courseByCourseId.code"},
                {"data": "semesterBySemesterId.title"},
                {"data": "userByLecturerId.fullname"},
                {//column for modify conductor
                    "data": null,
                    "defaultContent": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": null,
                    "defaultContent": modifyviewerlink
                }
            ],
            "language": {
                "decimal": "",
                "emptyTable": "Không kết quả nào được tìm thấy. <a href='/sfms/modify-feedback/target'>Thêm đối tượng</a>",
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
}
function loadClazzTargets() {
    $.ajax({
            url: '/sfms/api/modify-feedback/list/targets/clazzes',
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data, status, xhr) {
                targets = data;
                console.log(targets);
            },
            error: function (xhr) {
                alert(xhr.message);
            }
        }
    )
}
function addTarget(target){
    $.ajax({
        url: '/sfms/api/modify-feedback/add/target',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(target),
        success: function (data, status, xhr) {
            if (xhr.status === 200) {
                loadClazzTargets();
                console.log("targets now"+targets)
                reloadTable();
            }
        },
        error: function () {
            alert("fuck")
        }
    })
}
function addClazzTarget(el) {
    var data = $("#tbl-clazzes").DataTable().row($(el).parents('tr')).data();
    var clazz = {"id": data.id};
    addTarget(clazz);
}
function removeTarget(target) {
    $.ajax({
        url: '/sfms/api/modify-feedback/remove/target',
        type: 'DELETE',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(target),
        success: function (data, status, xhr) {
            if (xhr.status === 200) {
                loadClazzTargets();
                reloadTable();
            }
        },
        error: function () {
            alert("fuck")
        }
    })
}
function removeClazzTarget(el) {
    var data = $("#tbl-clazzes").DataTable().row($(el).parents('tr')).data();
    var clazz = {"id": data.id};
    removeTarget(clazz);
}
function removeCourseTarget(el) {
    var data = $("#tbl-courses").DataTable().row($(el).parents('tr')).data();
    var course = {"id": data.id};
    removeTarget(course);
}
function removeMajorTarget(el) {
    var data = $("#tbl-majors").DataTable().row($(el).parents('tr')).data();
    var major = {"id": data.id};
    removeTarget(major);
}
function removeDepartmentTarget(el) {
    var data = $("#tbl-departments").DataTable().row($(el).parents('tr')).data();
    var department = {"id": data.id};
    removeTarget(department);
}
// $(".btn-checked").click(function(){
//     selectedtarget.removeClass("btn-checked");
//     selectedtarget.addClass("btn-check-target");
//     selectedtarget.text("Chọn");
//     selectedtarget = null;
// });
// $(".btn-check-target").click(function () {
//     tmp = $(this).val();
//     if (selectedtarget != null) {
//         selectedtarget.removeClass("btn-checked");
//         selectedtarget.addClass("btn-check-target");
//         selectedtarget.val("Chọn");
//     }
//     if (tmp == "Chọn") {
//         selectedtarget = $(this);
//         selectedtarget.removeClass("btn-check-target");
//         selectedtarget.addClass("btn-checked");
//         selectedtarget.val("Đã chọn");
//     }
// });