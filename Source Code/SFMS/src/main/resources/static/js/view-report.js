$(document).ready(() => { //b�? vô document.ready để khi nào trang load xong thì sẽ bắt đầu render cái bảng
    // Khởi tạo dataTable
    $("#availableTemplate").DataTable({
        // tùy chỉnh ngôn ngữ
        "language": {
            "lengthMenu": "_MENU_ bản ghi/trang", //Chỉnh lại chữ của cái thanh ch�?n số bản ghi hiển thị/trang
            "emptyTable": "Không có dữ liệu nào trong bảng", // Bảng trống không có dữ liệu
            "info": "_START_ - _END_ trên _TOTAL_ bản ghi", // dòng dưới bên trái cái bảng hiện thông tin v�? số record
            "search": "", // cái dòng chữ bên trái thanh search
            "zeroRecords": "Không tìm thấy bản ghi phù hợp", // Khi search k có kết quả thì sẽ trả v�? dòng này
            "paginate": {
                "first": "�?ầu", // nút quya lại trang đầu
                "last": "Cuối", // nút tới trang cuối
                "next": "Sau", // nút trang kế tiếp
                "previous": "Trước" // nút trang trước
            }
        },
        // Số record / trang
        "lengthMenu": [[5, 10, 50, -1], [5, 10, 50, "Tất cả"]],
        // responsive
        "responsive": true
    });
});
$(window).resize(() => {
    if ($(window).outerWidth() < 992) {
        $(".preview-arrow").removeClass("fa-arrow-right")
            .addClass("fa-arrow-down");
    } else {
        $(".preview-arrow").removeClass("fa-arrow-down")
            .addClass("fa-arrow-right");
    }
});
$(".btn-preview").on('click', (el)=>{
    $(".loading-container").addClass("container-active");
    $(".template-container").addClass("container-fade");
    setTimeout(()=>{
        $(".loading-container").removeClass("container-active");
        $(".template-container").removeClass("container-fade");
    }, 3000)
});