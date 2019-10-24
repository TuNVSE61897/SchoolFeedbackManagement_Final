// $(document).ready(() => { //b�? vô document.ready để khi nào trang load xong thì sẽ bắt đầu render cái bảng
//     // Khởi tạo dataTable
//     $("#availableTemplate").DataTable({
//         // tùy chỉnh ngôn ngữ
//         "language": {
//             "lengthMenu": "_MENU_ bản ghi/trang", //Chỉnh lại chữ của cái thanh ch�?n số bản ghi hiển thị/trang
//             "emptyTable": "Không có dữ liệu nào trong bảng", // Bảng trống không có dữ liệu
//             "info": "_START_ - _END_ trên _TOTAL_ bản ghi", // dòng dưới bên trái cái bảng hiện thông tin v�? số record
//             "search": "Tìm kiếm", // cái dòng chữ bên trái thanh search
//             "zeroRecords": "Không tìm thấy bản ghi phù hợp", // Khi search k có kết quả thì sẽ trả v�? dòng này
//             "paginate": {
//                 "first": "Đầu", // nút quay lại trang đầu
//                 "last": "Cuối", // nút tới trang cuối
//                 "next": "Sau", // nút trang kế tiếp
//                 "previous": "Trước" // nút trang trước
//             },
//             "infoFiltered": "(Lọc từ _MAX_ bản ghi)",
//             "select":{
//                 rows:"",
//             }
//         },
//         // Số record / trang
//         "lengthMenu": [[5, 10, 50, -1], [5, 10, 50, "Tất cả"]],
//         // responsive
//         "responsive": true,
//         "select": 'single'
//     });
// });
// $(window).resize(() => {
//     if ($(window).outerWidth() < 992) {
//         $(".preview-arrow").removeClass("fa-arrow-right")
//             .addClass("fa-arrow-down");
//     } else {
//         $(".preview-arrow").removeClass("fa-arrow-down")
//             .addClass("fa-arrow-right");
//     }
// });
// $(".btn-preview").on('click', (el)=>{
//     $(".loading-container").addClass("container-active");
//     $(".template-container").addClass("container-fade");
//     setTimeout(()=>{
//         $(".loading-container").removeClass("container-active");
//         $(".template-container").removeClass("container-fade");
//     }, 3000)
// });

var templateThumbnail = $(".template-thumbnail");
var _ctx = $("meta[name='ctx']").attr("content");

$(".thumbnail-content").on('mouseenter', (el)=>{
    // var currentlySelected = $(".template-thumbnail.active");
    // currentlySelected.removeClass("active");
    // $(el.target).addClass("active");
    $(el.target).closest(".template-thumbnail").addClass("active");
});
$(".template-thumbnail").on('mouseleave', (el)=>{
    $(".template-thumbnail.active").removeClass("active");
});
$(".create-new-wrapper, .create-new-container").on('click', (el)=>{
    $("#modalCreateNew").modal('toggle');
});

//$(".btn-preview").on('click', (el)=>{
$(".btn-preview").click(function() {
   // alert('hello');
   // let parentContainer = $(el.target).parents(".thumbnail-action");
    var templateID = $(this).siblings('input').val();
   // alert(test);
   //alert($('button').siblings($('input[id="templateID"]')).val());
   $.ajax({
        url: _ctx +'/preview-feedback/' + templateID,
        dataType: 'html',
        success: function(data) {
            document.getElementById('templateID').value = templateID;
            $("#modalTemplateContent").innerHTML = "";
            $("#modalTemplateContent").append(data);
            $('#modalTemplate').modal('toggle');
        },
        error: (err) => alert(err)
    });

   /* $.ajax({
        url:_ctx +'/conduct-feedback/47',
        dataType: 'html'
    }).done(function(data){
        $("#modalTemplateContent").load(_ctx +'/conduct-feedback/47 #conduct-feedback-container');
        $('#modalTemplate').modal('toggle');
    })*/

      /*  success: function(response){
            //do what ever you want here to extract the part you want
            alert('hello 2');
            $('#modalTemplateContent').load(url);
            $('#modalTemplate').modal('toggle');
        }'*/
  //  });
   // $("#modalTemplate").modal('toggle');
});

