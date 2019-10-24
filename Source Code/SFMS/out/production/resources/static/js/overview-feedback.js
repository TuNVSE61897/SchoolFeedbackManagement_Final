/**
 * Created by MyPC on 27/02/2018.
 */
var modifyconductorlink = function(data, type, full, meta){
    return "<a class='add-inf-item-link' href='/sfms/modify-feedback/conductor/"+data+"'><i class='fa fa-pencil'></i> Chỉnh sửa </a>"
};
var modifyviewerlink = "<a class='add-inf-item-link'    href='/sfms/modify-feedback-viewers'><i class='fa fa-pencil'></i> Chỉnh sửa </a>";
var linkShow = "<a href='/sfms/modify-feedback/target'><i class='fa fa-plus' style='font-size: 24px'></i>    </a>";
var linkDeleteClazz = "<a href='#' onclick='removeClazzTarget(this)'><i class='fa fa-trash' style='font-size: 24px'></i>    </a>";
var linkDeleteCourse = "<a href='#' onclick='removeCourseTarget(this)'><i class='fa fa-trash' style='font-size: 24px'></i>    </a>";
var linkDeleteMajor = "<a href='#' onclick='removeMajorTarget(this)'><i class='fa fa-trash' style='font-size: 24px'></i>    </a>";
var linkDeleteDepartment = "<a href='#' onclick='removeDepartmentTarget(this)'><i class='fa fa-trash' style='font-size: 24px'></i>    </a>";
// var linkUpdate = "<a href='/sfms/modify-feedback/target'><i class='fa fa-pencil'></i></a>";
var showedTargetTab;
var showedTable;
var _ctx = $("meta[name='ctx']").attr("content");

$(document).ready(function () {
    loadMajorTable();
    // loadCourseTable();
    loadClazzTable();
    loadDepartmentTable();
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
    setStartEndConstraint();
    // changeStart();
});
function loadDepartmentTable() {
    $('#tbl-departments').DataTable().destroy();
    showedTable = $('#tbl-departments').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/targets/departments",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [
                {"data": "name"},
                {//column for modify conductor
                    "data": "id",
                    "render": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": null,
                    "defaultContent": modifyviewerlink
                },
                {//column for view detail-update-delete
                    "data": null,
                    "defaultContent": linkShow + '  ' + linkDeleteDepartment
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
    showedTable = $('#tbl-majors').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/targets/majors",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [
                {"data": "name"},
                {"data": "code"},
                {//column for modify conductor
                    "data": "id",
                    "render": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": null,
                    "defaultContent": modifyviewerlink
                },
                {//column for view detail-update-delete
                    "data": null,
                    "defaultContent": linkShow + '  ' + linkDeleteMajor
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
    showedTable = $('#tbl-courses').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/targets/courses",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [
                {"data": "name"},
                {"data": "code"},
                {//column for modify conductor
                    "data": "id",
                    "render": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": null,
                    "defaultContent": modifyviewerlink
                },
                {//column for view detail-update-delete
                    "data": null,
                    "defaultContent": linkShow + '  ' + linkDeleteCourse
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
    showedTable = $('#tbl-clazzes').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/targets/clazzes",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [ //define columns for the table
                // data for the cell from the returned list
                {
                    "data": "id",
                    "visible": false //hide the column processID
                },
                {"data": "courseByCourseId.name"},
                {"data": "courseByCourseId.code"},
                {"data": "semesterBySemesterId.title"},
                {"data": "className"},
                {"data": "userByLecturerId.fullname"},
                {//column for modify conductor
                    "data": "id",
                    "render": modifyconductorlink
                },
                {//column for modifyviewer
                    "data": "id",
                    "defaultContent": modifyviewerlink
                },
                {//column for view detail-update-delete
                    "data": null,
                    "defaultContent": linkShow + '  ' + linkDeleteClazz
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
// function reloadDepartmentTable() {
//     setTimeout(function () {
//         $('#tbl-deparments').DataTable().ajax.reload(null, false);// reload without come back to the first page
//     }, 200); //reload the table after 0.2s
// }
// function reloadMajorTable() {
//     setTimeout(function () {
//         $('#tbl-majors').DataTable().ajax.reload(null, false);// reload without come back to the first page
//     }, 200); //reload the table after 0.2s
// }
// function reloadCourseTable() {
//     setTimeout(function () {
//         $('#tbl-courses').DataTable().ajax.reload(null, false);// reload without come back to the first page
//     }, 200); //reload the table after 0.2s
// }
// function reloadClazzTable() {
//     setTimeout(function () {
//         $('#tbl-clazzes').DataTable().ajax.reload(null, false);// reload without come back to the first page
//     }, 200); //reload the table after 0.2s
// }

function reloadTable() {
    setTimeout(function () {
        showedTable.ajax.reload(null, false);// reload without come back to the first page
    }, 200); //reload the table after 0.2s
}

$("#feedback-title").focusout(function () {
    $.ajax(
        {
            url: "/sfms/api/modify-feedback/title",
            type: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify({"feedbackName": $("#feedback-title").val()}),
            success: function (data, status, xhr) {

            },
            error: function (data, status, xhr) {

            }
        }
    );
})

$("#feedback-description").focusout(function () {
    $.ajax(
        {
            url: "/sfms/api/modify-feedback/description",
            type: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify({"feedbackDes": $("#feedback-description").val()}),
            success: function (data, status, xhr) {

            },
            error: function (data, status, xhr) {

            }
        }
    );
})

$("#startdate").change(function () {
    changeStart();
})

$("#enddate").change(function () {
    changeEnd();
})

$("#typeId").change(function () {
    let typeData = {
        "id": $("#typeId").val(),
    }
    $.ajax(
        {
            url: "/sfms/api/modify-feedback/type",
            type: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(typeData),
            success: function (data, status, xhr) {
                switch (data.typeByTypeId.description) {
                    case "Chuyên ngành":
                        // loadMajorTable();
                        showedTargetTab.removeClass("show active");
                        showedTargetTab = $('#nav-major');
                        showedTargetTab.addClass("show active");
                        loadCourseTable();
                        break;
                    case "Môn học":
                        loadCourseTable();
                        showedTargetTab.removeClass("show active");
                        showedTargetTab = $('#nav-course');
                        showedTargetTab.addClass("show active");
                        loadCourseTable();
                        break;
                    case "Lớp":
                        loadClazzTable();
                        showedTargetTab.removeClass("show active");
                        showedTargetTab = $('#nav-clazz');
                        showedTargetTab.addClass("show active");
                        loadClazzTable();
                        break;
                    case "Phòng ban":
                        loadDepartmentTable()
                        showedTargetTab.removeClass("show active");
                        showedTargetTab = $('#nav-department');
                        showedTargetTab.addClass("show active");
                        loadDepartmentTable()
                        break;
                    default:
                        showedTargetTab.removeClass("show active");
                        showedTargetTab = $('#nav-major');
                        showedTargetTab.addClass("show active");
                        loadMajorTable();
                        break;
                }
            },
            error: function (xhr) {
               alert("fuck");
            }
        }
    );
})

$("#semesterId").change(function () {

    changeSemester();
})

function changeSemester() {
    let semesterData = {
        "id": $("#semesterId").val(),
        // "title": '',
        // "endDate": '',
        // "startDate": ''
    };
    console.log(semesterData);
    $.ajax(
        {
            url: "/sfms/api/modify-feedback/semester",
            type: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(semesterData),
            success: function (data, status, xhr) {
                if (data.startDate != null) {
                    let startd = new Date(parseInt(data.startDate));
                    $("#startdate").attr(
                        {
                            "min": $.datepicker.formatDate('yy-mm-dd', startd),
                        }
                    );
                    $("#enddate").attr(
                        {
                            "min": $.datepicker.formatDate('yy-mm-dd', startd),
                        }
                    );
                }
                if (data.endDate != null) {
                    let endd = new Date(parseInt(data.endDate));
                    $("#startdate").attr(
                        {
                            "max": $.datepicker.formatDate('yy-mm-dd', endd)
                        }
                    );
                    $("#enddate").attr(
                        {
                            "max": $.datepicker.formatDate('yy-mm-dd', endd)
                        }
                    );
                }
                $("#startdate").val('');
                $("#enddate").val('');
            },
            error: function (result) {
                //alert("fuck");
            }
        }
    )
    ;
}

function changeStart() {
    let feedbackData = {
        "startDate": $("#startdate").val()
    }
    $.ajax(
        {
            url: "/sfms/api/modify-feedback/start",
            type: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(feedbackData),
            success: function (data, status, xhr) {
                if (data.startDate != null) {
                    $("#enddate").attr(
                        {
                            "min": $.datepicker.formatDate('yy-mm-dd', new Date(parseInt(data.startDate))),
                        }
                    );
                    $("#enddate").val($.datepicker.formatDate('yy-mm-dd', new Date(parseInt(data.endDate))))
                }
            },
            error: function (xhr) {
              //  alert("ihi")
            }
        }
    );
}

function changeEnd() {
    let feedbackData = {
        "endDate": $("#enddate").val()
    }
    $.ajax(
        {
            url: "/sfms/api/modify-feedback/end",
            type: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(feedbackData),
            success: function (data, status, xhr) {
      //          alert("hehe")
            },
            error: function (result) {
           //     alert("ihi")
            }
        }
    );
}

function setStartEndConstraint() {
    $.ajax(
        {
            url: "/sfms/api/modify-feedback/get",
            type: "GET",
            dataType: 'json',
            // contentType: 'application/json',
            // data: JSON.stringify(semesterData),
            success: function (data, status, xhr) {
                if (data.semesterBySemesterId != null) {
                    let startd = new Date(parseInt(data.semesterBySemesterId.startDate));
                    let endd = new Date(parseInt(data.semesterBySemesterId.endDate));
                    $("#startdate").attr(
                        {
                            "min": $.datepicker.formatDate('yy-mm-dd', startd),
                            "max": $.datepicker.formatDate('yy-mm-dd', endd)
                        }
                    );
                    if (data.startDate != null) {
                        let startd = new Date(parseInt(data.startDate))
                    }
                    $("#enddate").attr(
                        {
                            "min": $.datepicker.formatDate('yy-mm-dd', startd),
                            "max": $.datepicker.formatDate('yy-mm-dd', endd)
                        }
                    );
                }
            },
            error: function (result) {
               // alert("fuck");
            }
        }
    );
}

$("#btnSave").click(function () {
    var opt = $('input[name="save-option"]:checked', '#save-opt').val();
    alert(opt);
    $.ajax({
        url: '/sfms/api/modify-feedback/save/option/' + opt,
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data, status, xhr) {
            if (xhr.status === 200) {
                window.location.href = "/sfms/conduct-feedback/list";
            }
        },
        error: function () {
            alert("fuck")
        }
    });
})

$("#btnCancel").click(function () {
    $.ajax({
        url: '/sfms/api/cancel',
        type: 'DELETE',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data, status, xhr) {
            if (xhr.status === 200) {
                window.location.href = "/sfms/view-list-feedback";
            }
        },
        error: function () {
       //    alert("fuck")
        }
    });
})

$("#previewContent").click(function () {
    var feedbackID = document.getElementById("feedbackID").innerHTML;
    $.ajax({
        url: _ctx + '/preview-feedback/' + feedbackID,
        dataType: 'html',
        success: function (data) {
            $(".feedback-content").innerHTML = "";
            //     $("#modalTemplateFooter").innerHTML = "";
            //    $("#modalTemplateFooter").append("<input hidden class='form-control' value='" + templateID + "' type='text' name='templateID'>");
            $(".feedback-content").append(data);
            $('#FBContentModal').modal('toggle');
        },
        error: (err) => alert(err)
    });
});


function removeTarget(target) {
    $.ajax({
        url: '/sfms/api/modify-feedback/remove/target',
        type: 'DELETE',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(target),
        success: function (data, status, xhr) {
            if (xhr.status === 200) {
                reloadTable();
            }
        },
        error: function () {
          //  alert("fuck")
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
