/**
 * Created by MyPC on 05/02/2018.
 */

$(document).ready(function () {

    $("#list-roles").chosen();
    $("#list-departments").chosen();
    $("#list-majors").chosen();
    $("#list-status").chosen();

    var table = $('#tbl-users').DataTable(
        {
            "ajax": {
                "url": _ctx + "/api/users",
                "dataSrc": "",
            },
            "columns": [
                {"data": "fullname"},
                {"data": "roleByRoleId.roleName"},
                {
                    "data": "departmentByDepartmentId",
                    "render": (data, type, row) => {
                        return data == null ? 'N/A' : data.name;
                    }
                },
                {
                    "data": "majorByMajorId",
                    "render": (data, type, row) => {
                        return data == null ? 'N/A' : data.name;
                    }
                },
                {"data": "mail"},
                {
                    "data": "status",
                    "render": (data, type, row) => {
                        return data ? "<p class='text-success'>Đang hoạt động</p>" : "<p class='text-danger'>Ngưng hoạt động</p>"
                    }
                },
                {
                    "data": "id",
                    "render": (data, type, row) => {
                        return "<a href='" + _ctx + "/users/edit/" + data + "'>Chỉnh sửa <i class='fa fa-pencil'></i> </a>";
                    }
                }

            ],
            "lengthMenu": [[5, 20, 50, -1], [5, 20, 50, "Toàn bộ"]],
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
                },
            }
        }
    );
    setInterval(function () {
        table.ajax.reload(null, false); // user paging is not reset on reload
    }, 10000);

    $(document).on('change', "#list-roles, #list-departments, #list-majors, #list-status", (event) => {
        let value = $(event.target).val();
        let id = $(event.target).attr("id");
        switch (id) {
            case "list-roles": {
                table.column(1).search(value).draw();
                break;
            }
            case "list-departments": {
                table.column(2).search(value).draw();
                break;
            }
            case "list-majors": {
                table.column(3).search(value).draw();
                break;
            }
            case "list-status": {
                table.column(5).search(value).draw();
                break;
            }
        }
    });
});