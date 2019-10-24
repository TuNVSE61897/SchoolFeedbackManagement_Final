$(".btn-check-target").click(function () {
    btn = $(this);
    tmp = $(this).val();
    selectObjBtn();
});
function selectObjBtn() {
    if (tmp == "Vô hiệu hóa") {
        btn.removeClass("btn-checked");
        btn.addClass("btn-check-target");
        btn.val("Kích hoạt");
        // alert("haha");
    }
    if (tmp == "Kích hoạt") {
        btn.removeClass("btn-check-target");
        btn.addClass("btn-checked");
        btn.val("Vô hiệu hóa");
    }
}