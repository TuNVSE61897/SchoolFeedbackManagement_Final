var table;
$(document).ready(() => {
    table = $("#tblFeedback").DataTable({
        "lengthMenu": [[5, 20, 50, -1], [5, 20, 50, "Toàn bộ"]],
        "columnDefs": [
            // {"targets": [4], "visible": false},
            // {"targets":[]}
        ],
        "language": {
            "decimal": "",
            "emptyTable": "Không kết quả nào được tìm thấy",
            "info": "Hiển thị từ _START_ tới _END_ trong số _TOTAL_ kết quả",
            "infoEmpty": "Hiển thị 0 tới 0 trong số 0 kết quả",
            "infoFiltered": "(lọc từ _MAX_ kết quả)",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Hiển thị _MENU_ kết quả mỗi trang",
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
    });
});

$(document).on('click', '.btn-filter', (event) => {
    let value = $(event.target).val();
    table.column(4).search(value).draw();
    $(".btn-filter.active").removeClass("active");
    $(event.target).addClass("active");
});

// $(document).on('change', '#filter-scope', (event)=>{
//     let value = $(event.target).val();
//     table.column(4).search(value).draw();
// });
