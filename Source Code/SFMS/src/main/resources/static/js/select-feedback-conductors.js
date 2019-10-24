/**
 * Created by MyPC on 29/01/2018.
 */
var tmp, btn, showedTable, displayingTable, conductors;
var btnAdd = "<input class='btn active btn-check-target' type='button' onclick='addConductor(this)' value='Chọn'/>"
var btnRemove = "<input class='btn active btn-checked' type='button' onclick='removeConductor(this)' value='Bỏ chọn'/>"
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
    loadStudents();

});

function reloadTable() {
    // alert("hehe");
    setTimeout(function () {
        showedTable.ajax.reload(null, false);// reload without come back to the first page
    }, 200); //reload the table after 0.2s
}

var selected_to_button = function (data, type, full, meta) {
    // if(conductors.length==0)return btnAddClazz;
    for (var c in conductors) {
        let conductor = conductors[c];


        if (data == conductor["id"])return btnRemove;
    }
    return btnAdd;
    // $.each(targets, function(index, value){
    //     if(data==value["id"])return btnRemoveClazz;
    // })
    // return btnAddClazz;
}
var major_to_majorName = function (data, type, full, meta) {
    if (data["code"] != null && data["name"] != null)return data["code"] + ' - ' + data["name"];
    if (data["name"] != null)return data["name"];
    return data["code"]
}

var studentClazzes_to_courses = function (data, type, full, meta) {
    // if(data.length==0)return '';
    var courses = '', clazz, course;

    var recs = new Array(100);
    for (var studentClazz in data) {
        let sc = data[studentClazz];

        clazz = sc["clazzByClazzId"];

        course = clazz["courseByCourseId"];

        // courses = courses + "" + course["code"] +" - "+course["name"]+ ", ";
        if (!recs.includes(course["code"])) {
            recs.push(course["code"]);
            courses = courses + "" + course["code"] + ", ";
        }
    }

    // alert(courses);
    return courses;
}

var studentClazzes_to_semesters = function (data, type, full, meta) {
    // if(data.length==0)return '';
    var semesters = '', clazz, semester;
    var recs = new Array(100);
    for (var studentClazz in data) {
        let sc = data[studentClazz];

        clazz = sc["clazzByClazzId"];

        semester = clazz["semesterBySemesterId"];
        if (!recs.includes(semester["title"])) {
            recs.push(semester["title"]);
            semesters = semesters + semester["title"] + ", ";
        }
    }

    return semesters;
}

var studentClazzes_to_lecturers = function (data, type, full, meta) {
    // if(data.length==0)return '';
    var lecturers = '', clazz, lecturer;
    var recs = new Array(100);
    for (var studentClazz in data) {
        let sc = data[studentClazz];

        clazz = sc["clazzByClazzId"];

        lecturer = clazz["userByLecturerId"];
        if (!recs.includes(lecturer["code"])) {
            recs.push(lecturer["code"]);
            lecturers = lecturers + lecturer["code"] + " - " + lecturer["name"] + ", ";
        }
    }

    return lecturers;
}

var studentClazzes_to_clazzes = function (data, type, full, meta) {
    // if(data.length==0)return '';
    var clazzes = '', clazz;
    var recs = new Array(100);
    for (var studentClazz in data) {
        let sc = data[studentClazz];

        clazz = sc["clazzByClazzId"];

        if (!recs.includes(clazz["className"])) {
            recs.push(clazz["className"]);
            clazzes = clazzes + "" + clazz["className"] + ", ";
        }
    }

    return clazzes;
}
function loadConductors() {
    $.ajax({
            url: '/sfms/api/modify-feedback/list/conductors/' + $("#targetId").val(),
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data, status, xhr) {
                conductors = data;

            },
            error: function (xhr) {
                alert(xhr.message);
            }
        }
    )
}

function addConductor(el) {
    var data = displayingTable.DataTable().row($(el).parents('tr')).data();
    var conductor = {"id": data.id};
    console.log(conductor);
    $.ajax({
        url: '/sfms/api/modify-feedback/add/conductor/'+$("#targetId").val(),
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(conductor),
        success: function (data, status, xhr) {
            if (xhr.status === 200) {
                loadConductors();
                // console.log("conductors now"+conductors)
                reloadTable();
            }
        },
        error: function () {
            // alert("fuck")
        }
    })
}

function removeConductor(el) {
    var data = displayingTable.DataTable().row($(el).parents('tr')).data();
    var conductor = {"id": data.id};
    $.ajax({
        url: '/sfms/api/modify-feedback/remove/conductor/'+$("#targetId").val(),
        type: 'DELETE',
        // dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(conductor),
        success: function (data, status, xhr) {
            if (xhr.status === 200) {
                loadConductors();
                console.log("conductors now"+conductors)
                reloadTable();
            }
        },
        error: function () {
            alert("fuck")
        }
    })
}

function loadStudents() {
    $('#tbl-students').DataTable().destroy();
    loadConductors();
    displayingTable = $('#tbl-students');
    showedTable = $('#tbl-students').DataTable(
        {
            "ajax": {
                "url": "/sfms/api/modify-feedback/list/students",
                "dataSrc": "",
                "type": "GET"
            },
            "columns": [
                {"data": "id", "render": selected_to_button},
                {"data": "fullname"},
                {"data": "code"},
                {
                    "data": "majorByMajorId",
                    "render": major_to_majorName
                },
                {
                    "data": "studentClazzesById",
                    "render": studentClazzes_to_courses
                },
                {
                    "data": "studentClazzesById",
                    "render": studentClazzes_to_semesters,
                    "visible": false
                },
                {
                    "data": "studentClazzesById",
                    "render": studentClazzes_to_lecturers,
                    "visible": false
                },
                {
                    "data": "studentClazzesById",
                    "render": studentClazzes_to_clazzes
                }
            ],
            // initComplete: function () {
            //     this.api().columns([1]).every(function () {
            //         var column = this;
            //         var input = $('<input type="text" value="" list="listType"/>')
            //                 .appendTo($(column.header()))
            //                 .on('change keyup keydown', function () {
            //                     var val = $.fn.dataTable.util.escapeRegex(
            //                         $(this).val()
            //                     );
            //                     column
            //                     // .search(val ? '^' + val + '$' : '', true, false)
            //                         .search(val)
            //                         .draw();
            //                 })
            //             ;
            //         var opts = new Array(column.data().length);
            //         var datalist = $('<datalist id="listType"></datalist>').appendTo($(column.header()))
            //             .on("change", function () {
            //                 var val = $.fn.dataTable.util.escapeRegex(
            //                     $(this).val()
            //                 );
            //                 // alert(val);
            //                 column
            //                 // .search(val ? '^' + val + '$' : '', true, false)
            //                     .search(val)
            //                     .draw();
            //             });
            //         datalist.append('<option value=""></option>');
            //         column.data().unique().sort().each(function (d, j) {
            //             if (!opts.includes(d["description"])) {
            //                 opts.push(d["description"]);
            //                 datalist.append('<option value="' + d["description"] + '">' + d["description"] + '</option>')
            //             }
            //         });
            //     });
            // },
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
}
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
