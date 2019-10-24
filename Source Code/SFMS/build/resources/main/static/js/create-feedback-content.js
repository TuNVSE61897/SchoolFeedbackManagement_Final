var wscrolltop = 0;
var _ctx = $("meta[name='ctx']").attr("content");

$.getScript("models.js", () => { alert('Error loading front-end models') });

//use to generate uniqueId
function generateId() {
    return new Date().getTime();
}


$(".item-list").sortable({
        connectWith: ".question-list-wrapper",
        helper: (e, li) => {
        copyHelper = li.clone().insertAfter(li);
return li.clone();
},
stop: () => {
    copyHelper && copyHelper.remove();
},
appendTo: '.question-list-wrapper',
}).disableSelection();


// $("#question-list").sortable({
//     receive: (ev, ui) => {
//         console.log("received");
//         copyHelper = null;
//         let id = ui.item.attr('id');
//         $(ui.item).removeClass("item");
//         switch (id) {
//             case 'text-ele': {
//                 ui.item.html();
//                 break;
//             }
//             case 'radio-ele': {
//                 ui.item.html();
//                 break;
//             }
//             case 'checkbox-ele': {
//                 ui.item.html();
//                 break;
//             }
//             case 'textarea-ele': {
//                 ui.item.html();
//                 break;
//             }
//         }
//     },
//     items: ">li",
//     placeholder: '.sortable-placeholder',
//     containment: ".question-list-wrapper",
//     forcePlaceholderSize: true,
//     tolerance: false,
//     // scroll: false,
//     start:(event, ui) =>{
//         wscrolltop = $(window).scrollTop();
//         console.log(ui.item.offset);
//         ui.placeholder.width(ui.item.width());
//         ui.placeholder.height(ui.item.height());
//     },
//     sort: (event, ui)=>{
//         ui.helper.css({'top' : ui.position.top + wscrolltop + 'px'});
//     },
//     helper: 'clone',
// }).disableSelection();

function refreshQuestionList() {
    if ($(".list-answer-edit").length > 1) {
        $(".list-answer-edit").sortable("refresh");
    } else {
        initEditAnswerList();
    }
};

function initEditAnswerList() {
    //init list answer inside a question
    $(".list-answer-edit").sortable({
            helper: 'clone',
            handle: ".sort-edit-answer-handle",
            appendTo: ".list-answer-edit",
            containment: ".edit-answer-wrapper",
            stop: (event, ui) => {
            let listEditInput = $(event.target).find("input[class='answer-content-input']");
    let parentContainer = $(event.target).parents(".question-container");
    let listPreviewInput = parentContainer.find(".form-check:not(.form-other)>label>input");
    for (let i = 0; i < listEditInput.length; i++) {
        listPreviewInput[i].nextSibling.nodeValue = $(listEditInput[i]).val();
    }
},
}).disableSelection();
}

//init question-list-wrapper
//Khang-san có chỉnh một chút, phần sinh ra các element
$(".question-list-wrapper").sortable({
        items: ".question-container",
        // containment: ".question-list-container",
        axis: 'y',
        tolerance: 'pointer',
        placeholder: 'sortable-placeholder',
        handle: ".toggle-bar-wrapper",
        cursor: "move",
        over: (event, ui) => {
        ui.placeholder.height(ui.item.height());
},
start: (event, ui) => {
    wscrolltop = $(window).scrollTop();
    console.log(ui.item.offset);
    ui.placeholder.width(ui.item.width());
    ui.placeholder.height(ui.item.height());
},
sort: (event, ui) => {
    ui.helper.css({'top': ui.position.top + wscrolltop + 'px'});
},
receive: (ev, ui) => {
    console.log("received");
    copyHelper = null;
    let id = ui.item.attr('id');
    $(ui.item).removeClass("item");
    switch (id) {
        case 'text-ele': {
            ui.item.replaceWith(// replace item with text field question
                "<div class='question-container' id='textfield-question-" + generateId() + "'>" +
                "                        <div class='question-wrapper'>" +
                "                            <div class='toggle-bar-container'>" +
                "                                <div class='toggle-bar-wrapper'>" +
                "                                    <div class='delete-question-holder'>" +
                "                                        <button class='btn-remove-question'><i class='fa fa-trash'></i> Xóa</button>" +
                "                                    </div>" +
                "                                    <div class='expand-edit-question-holder'>" +
                "                                        <i class='btn-expand-edit fa fa-angle-down'></i>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='preview-question-container'>" +
                "                                <div class='preview-question-wrapper'>" +
                "                                    <div class='question-content-container'>" +
                "                                        <div class='question-content-wrapper'>" +
                "                                            <p class='question-content-paragraph'>Nội dung của câu hỏi</p>" +
                "                                            <span class='required-question' style='display:none'><sup>*</sup></span>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                    <div class='answer-container'>" +
                "                                        <div class='answer-wrapper'>" +
                "                                            <div class='form-group row'>" +
                "                                                <input type='text' class='form-control'>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='edit-question-container'>" +
                "                                <div class='edit-question-wrapper'>" +
                "                                    <div class='edit-panel-container'>" +
                "                                        <div class='edit-panel-wrapper'>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Câu hỏi bắt buộc:</label>" +
                "                                                <div class='col-8' style='padding-top: 7px; padding-bottom:7px;'>" +
                "                                                    <input class='required-checkbox' type='checkbox'>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Nội dung: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <textarea class='txtEditQuestion'>Nội dung của câu hỏi?</textarea>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Loại đánh giá: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <select class='form-control select-list-criteria'>" +
                "                                                        <option value='1'>Chuyên cần</option>" +
                "                                                        <option value='2'>Tác phong</option>" +
                "                                                        <option value='3'>Thái độ</option>" +
                "                                                        <option value='4'>Chuyên môn</option>" +
                "                                                    </select>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                        </div>" +
                "                    </div>"
            );
            break;
        }
        case 'radio-ele': {
            ui.item.replaceWith( //replace item with radio question
                "<div class='question-container' id='radio-question-" + generateId() + "'>" +
                "                        <div class='question-wrapper'>" +
                "                            <div class='toggle-bar-container'>" +
                "                                <div class='toggle-bar-wrapper'>" +
                "                                    <div class='delete-question-holder'>" +
                "                                        <button class='btn-remove-question'><i class='fa fa-trash'></i> Xóa</button>" +
                "                                    </div>" +
                "                                    <div class='expand-edit-question-holder'>" +
                "                                        <i class='btn-expand-edit fa fa-angle-down'></i>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='preview-question-container'>" +
                "                                <div class='preview-question-wrapper'>" +
                "                                    <div class='question-content-container'>" +
                "                                        <div class='question-content-wrapper'>" +
                "                                            <p class='question-content-paragraph'>Tốc độ giảng dạy của giảng viên thế nào?" +
                "                                                </p>" +
                "                                            <span class='required-question' style='display:none'><sup>*</sup></span>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                    <div class='answer-container'>" +
                "                                        <div class='answer-wrapper'>" +
                "                                            <div class='form-check'>" +
                "                                                <label class='form-check-label'>" +
                "                                                    <input class='form-check-input' type='radio' disabled> Đáp án 1" +
                "                                                </label>" +
                "                                            </div>" +
                "                                            <div class='form-check'>" +
                "                                                <label class='form-check-label'>" +
                "                                                    <input class='form-check-input' type='radio' disabled> Đáp án 2" +
                "                                                </label>" +
                "                                            </div>" +
                "                                            <div class='form-check'>" +
                "                                                <label class='form-check-label'>" +
                "                                                    <input class='form-check-input' type='radio' disabled> Đáp án 3" +
                "                                                </label>" +
                "                                            </div>" +
                "                                            <div class='form-check form-other disabled'>" +
                "                                                <label class='form-check-label'>" +
                "                                                    <input class='form-check-input' type='radio' disabled>Khác" +
                "                                                    <input type='text' class='other-option-input' disabled>" +
                "                                                </label>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='edit-question-container'>" +
                "                                <div class='edit-question-wrapper'>" +
                "                                    <div class='edit-panel-container'>" +
                "                                        <div class='edit-panel-wrapper'>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Câu hỏi bắt buộc:</label>" +
                "                                                <div class='col-8' style='padding-top: 7px; padding-bottom:7px;'>" +
                "                                                    <input class='required-checkbox' type='checkbox'>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Nội dung: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <textarea class='txtEditQuestion'>Tốc độ giảng dạy của giảng viên thế nào?</textarea>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Loại đánh giá: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <select class='form-control select-list-criteria'>" +
                "                                                        <option value='1'>Chuyên cần</option>" +
                "                                                        <option value='2'>Tác phong</option>" +
                "                                                        <option value='3'>Thái độ</option>" +
                "                                                        <option value='4'>Chuyên môn</option>" +
                "                                                    </select>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Thêm câu trả lời" +
                "                                                    Khác: </label>" +
                "                                                <div class='col-8' style='padding-top: 7px; padding-bottom:7px;'>" +
                "                                                    <input class='other-option-checkbox' type='checkbox'>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='edit-answer-container'>" +
                "                                                <div class='edit-answer-wrapper'>" +
                "                                                    <ul class='list-answer-edit'>" +
                "                                                        <li>" +
                "                                                            <div class='edit-answer-item'>" +
                "                                                                <div class='sort-edit-answer-handle'>" +
                "                                                                    <i class='fa fa-bars'></i>" +
                "                                                                </div>" +
                "                                                                <div class='input-edit-answer-holder'>" +
                "                                                                    <input type='text' class='answer-content-input'" +
                "                                                                           placeholder='Đáp án 1'>" +
                "                                                                    Trọng số: <input type='number' min='0'" +
                "                                                                                     class='weight-input'>" +
                "                                                                </div>" +
                "                                                                <div class='remove-answer-holder'>" +
                "                                                                    <i class='fa fa-close'></i>" +
                "                                                                </div>" +
                "                                                            </div>" +
                "                                                        </li>" +
                "                                                        <li>" +
                "                                                            <div class='edit-answer-item'>" +
                "                                                                <div class='sort-edit-answer-handle'>" +
                "                                                                    <i class='fa fa-bars'></i>" +
                "                                                                </div>" +
                "                                                                <div class='input-edit-answer-holder'>" +
                "                                                                    <input type='text' class='answer-content-input'" +
                "                                                                           placeholder='Đáp án 2'>" +
                "                                                                    Trọng số: <input type='number' min='0'" +
                "                                                                                     class='weight-input'>" +
                "                                                                </div>" +
                "                                                                <div class='remove-answer-holder'>" +
                "                                                                    <i class='fa fa-close'></i>" +
                "                                                                </div>" +
                "                                                            </div>" +
                "                                                        </li>" +
                "                                                        <li>" +
                "                                                            <div class='edit-answer-item'>" +
                "                                                                <div class='sort-edit-answer-handle'>" +
                "                                                                    <i class='fa fa-bars'></i>" +
                "                                                                </div>" +
                "                                                                <div class='input-edit-answer-holder'>" +
                "                                                                    <input type='text' class='answer-content-input'" +
                "                                                                           placeholder='Đáp án 3'>" +
                "                                                                    Trọng số: <input type='number' min='0'" +
                "                                                                                     class='weight-input'>" +
                "                                                                </div>" +
                "                                                                <div class='remove-answer-holder'>" +
                "                                                                    <i class='fa fa-close'></i>" +
                "                                                                </div>" +
                "                                                            </div>" +
                "                                                        </li>" +
                "                                                    </ul>" +
                "                                                    <div class='add-new-answer-wrapper'>" +
                "                                                        <a class='add-new-answer add-new-answer-option'><i" +
                "                                                                class='fa fa-plus'></i> Thêm</a>" +
                "                                                    </div>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                        </div>" +
                "                    </div>"
            );
            refreshQuestionList();
            break;
        }
        case 'checkbox-ele': {
            ui.item.replaceWith( //replace item with checkbox question
                "<div class='question-container' id='checkbox-question-" + generateId() + "'>" +
                "                        <div class='question-wrapper'>" +
                "                            <div class='toggle-bar-container'>" +
                "                                <div class='toggle-bar-wrapper'>" +
                "                                    <div class='delete-question-holder'>" +
                "                                        <button class='btn-remove-question'><i class='fa fa-trash'></i> Xóa</button>" +
                "                                    </div>" +
                "                                    <div class='expand-edit-question-holder'>" +
                "                                        <i class='btn-expand-edit fa fa-angle-down'></i>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='preview-question-container'>" +
                "                                <div class='preview-question-wrapper'>" +
                "                                    <div class='question-content-container'>" +
                "                                        <div class='question-content-wrapper'>" +
                "                                            <p class='question-content-paragraph'>Tốc độ giảng dạy của giảng viên thế nào?" +
                "                                                </p>" +
                "                                            <span class='required-question' style='display:none'><sup>*</sup></span>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                    <div class='answer-container'>" +
                "                                        <div class='answer-wrapper'>" +
                "                                            <div class='form-check'>" +
                "                                                <label class='form-check-label'>" +
                "                                                    <input class='form-check-input' type='checkbox' disabled> Đáp án 1" +
                "                                                </label>" +
                "                                            </div>" +
                "                                            <div class='form-check form-other disabled'>" +
                "                                                <label class='form-check-label'>" +
                "                                                    <input class='form-check-input' type='checkbox' disabled>Khác" +
                "                                                    <input type='text' class='other-option-input' disabled>" +
                "                                                </label>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='edit-question-container'>" +
                "                                <div class='edit-question-wrapper'>" +
                "                                    <div class='edit-panel-container'>" +
                "                                        <div class='edit-panel-wrapper'>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Câu hỏi bắt buộc:</label>" +
                "                                                <div class='col-8' style='padding-top: 7px; padding-bottom:7px;'>" +
                "                                                    <input class='required-checkbox' type='checkbox'>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Nội dung: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <textarea class='txtEditQuestion'>Tốc độ giảng dạy của giảng viên thế nào?</textarea>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Loại đánh giá: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <select class='form-control select-list-criteria'>" +
                "                                                        <option value='1'>Chuyên cần</option>" +
                "                                                        <option value='2'>Tác phong</option>" +
                "                                                        <option value='3'>Thái độ</option>" +
                "                                                        <option value='4'>Chuyên môn</option>" +
                "                                                    </select>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Thêm câu trả lời" +
                "                                                    Khác: </label>" +
                "                                                <div class='col-8' style='padding-top: 7px; padding-bottom:7px;'>" +
                "                                                    <input class='other-option-checkbox' type='checkbox'>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='edit-answer-container'>" +
                "                                                <div class='edit-answer-wrapper'>" +
                "                                                    <ul class='list-answer-edit'>" +
                "                                                        <li>" +
                "                                                            <div class='edit-answer-item'>" +
                "                                                                <div class='sort-edit-answer-handle'>" +
                "                                                                    <i class='fa fa-bars'></i>" +
                "                                                                </div>" +
                "                                                                <div class='input-edit-answer-holder'>" +
                "                                                                    <input type='text' class='answer-content-input'" +
                "                                                                           placeholder='Đáp án 1'>" +
                "                                                                    Trọng số: <input type='number' min='0'" +
                "                                                                                     class='weight-input'>" +
                "                                                                </div>" +
                "                                                                <div class='remove-answer-holder'>" +
                "                                                                    <i class='fa fa-close'></i>" +
                "                                                                </div>" +
                "                                                            </div>" +
                "                                                        </li>" +
                "                                                    </ul>" +
                "                                                    <div class='add-new-answer-wrapper'>" +
                "                                                        <a class='add-new-answer add-new-answer-checkbox'><i" +
                "                                                                class='fa fa-plus'></i> Thêm</a>" +
                "                                                    </div>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                        </div>" +
                "                    </div>"
            );
            refreshQuestionList();
            break;
        }
        case 'textarea-ele': {
            ui.item.replaceWith( //replace item with textarea question
                "<div class='question-container' id='textarea-question-" + generateId() + "'>" +
                "                        <div class='question-wrapper'>" +
                "                            <div class='toggle-bar-container'>" +
                "                                <div class='toggle-bar-wrapper'>" +
                "                                    <div class='delete-question-holder'>" +
                "                                        <button class='btn-remove-question'><i class='fa fa-trash'></i> Xóa</button>" +
                "                                    </div>" +
                "                                    <div class='expand-edit-question-holder'>" +
                "                                        <i class='btn-expand-edit fa fa-angle-down'></i>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='preview-question-container'>" +
                "                                <div class='preview-question-wrapper'>" +
                "                                    <div class='question-content-container'>" +
                "                                        <div class='question-content-wrapper'>" +
                "                                            <p class='question-content-paragraph'>Nội dung của câu hỏi</p>" +
                "                                            <span class='required-question' style='display:none'><sup>*</sup></span>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                    <div class='answer-container'>" +
                "                                        <div class='answer-wrapper'>" +
                "                                            <div class='form-group row'>" +
                "                                                <textarea class='form-control'></textarea>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='edit-question-container'>" +
                "                                <div class='edit-question-wrapper'>" +
                "                                    <div class='edit-panel-container'>" +
                "                                        <div class='edit-panel-wrapper'>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Câu hỏi bắt buộc:</label>" +
                "                                                <div class='col-8' style='padding-top: 7px; padding-bottom:7px;'>" +
                "                                                    <input class='required-checkbox' type='checkbox'>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Nội dung: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <textarea class='txtEditQuestion'>Nội dung của câu hỏi?</textarea>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Loại đánh giá: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <select class='form-control select-list-criteria'>" +
                "                                                        <option value='1'>Chuyên cần</option>" +
                "                                                        <option value='2'>Tác phong</option>" +
                "                                                        <option value='3'>Thái độ</option>" +
                "                                                        <option value='4'>Chuyên môn</option>" +
                "                                                    </select>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                        </div>" +
                "                    </div>"
            );
            break;
        }
        case 'star-ele': {
            ui.item.replaceWith( //replace item with star rating question
                "<div class='question-container' id='star-question-" + generateId() + "'>" +
                "                        <div class='question-wrapper'>" +
                "                            <div class='toggle-bar-container'>" +
                "                                <div class='toggle-bar-wrapper'>" +
                "                                    <div class='delete-question-holder'>" +
                "                                        <button class='btn-remove-question'><i class='fa fa-trash'></i> Xóa</button>" +
                "                                    </div>" +
                "                                    <div class='expand-edit-question-holder'>" +
                "                                        <i class='btn-expand-edit fa fa-angle-down'></i>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='preview-question-container'>" +
                "                                <div class='preview-question-wrapper'>" +
                "                                    <div class='question-content-container'>" +
                "                                        <div class='question-content-wrapper'>" +
                "                                            <p class='question-content-paragraph'>Nội dung của câu hỏi</p>" +
                "                                            <span class='required-question' style='display:none'><sup>*</sup></span>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                    <div class='answer-container'>" +
                "                                        <div class='answer-wrapper'>" +
                "                                            <div class='star-wrapper'>" +
                "                                                <i class='fa fa-star'></i>" +
                "                                                <i class='fa fa-star'></i>" +
                "                                                <i class='fa fa-star'></i>" +
                "                                                <i class='fa fa-star'></i>" +
                "                                                <i class='fa fa-star'></i>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                            <div class='edit-question-container'>" +
                "                                <div class='edit-question-wrapper'>" +
                "                                    <div class='edit-panel-container'>" +
                "                                        <div class='edit-panel-wrapper'>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Câu hỏi bắt buộc:</label>" +
                "                                                <div class='col-8' style='padding-top: 7px; padding-bottom:7px;'>" +
                "                                                    <input class='required-checkbox' type='checkbox'>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Nội dung: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <textarea class='txtEditQuestion'>Nội dung của câu hỏi?</textarea>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                            <div class='form-group row'>" +
                "                                                <label class='col-4 col-form-label text-right'>Loại đánh giá: </label>" +
                "                                                <div class='col-8'>" +
                "                                                    <select class='form-control select-list-criteria'>" +
                "                                                        <option value='1'>Chuyên cần</option>" +
                "                                                        <option value='2'>Tác phong</option>" +
                "                                                        <option value='3'>Thái độ</option>" +
                "                                                        <option value='4'>Chuyên môn</option>" +
                "                                                    </select>" +
                "                                                </div>" +
                "                                            </div>" +
                "                                        </div>" +
                "                                    </div>" +
                "                                </div>" +
                "                            </div>" +
                "                        </div>" +
                "                    </div>"
            );
            break;
        }
    }
},
});


$(document).on("click", ".btn-remove-question", (event) => {
    let parentContainer = $(event.target).parents(".question-container");
parentContainer.slideUp("normal", () => {
    parentContainer.remove()
});
});

$(document).on("click", ".add-new-answer-option", (event) => {
    let parentQuestionContainer = $(event.target).parents(".question-container");
let listPreviewAnswer = parentQuestionContainer.find(".answer-wrapper");
let listEditAnswer = parentQuestionContainer.find(".list-answer-edit");
var editQuestion = "<li>" +
    "<div class='edit-answer-item'>" +
    "<div class='sort-edit-answer-handle'>" +
    "<i class='fa fa-bars'></i>" +
    "</div>" +
    "<div class='input-edit-answer-holder'>" +
    "<input type='text' class='answer-content-input' value='Đáp án " + (listEditAnswer.find("li").length + 1) + "'>" +
    " Trọng số: <input type='number' min='0' class='weight-input' value='1'>" +
    "</div>" +
    "<div class='remove-answer-holder'>" +
    "<i class='fa fa-close'></i>" +
    "</div>" +
    "</div>" +
    "</li >";
let previewQuestion = "<div class='form-check'>" +
    "<label class='form-check-label'>" +
    "<input class='form-check-input' type='radio' disabled> Đáp án " + (listEditAnswer.find("li").length + 1) +
    "</label>" +
    "</div>";
$(previewQuestion).insertAfter(listPreviewAnswer.find(".form-check:not(.form-other)").last());
listEditAnswer.append(editQuestion);
});

$(document).on("click", ".add-new-answer-checkbox", (event) => {
    let parentQuestionContainer = $(event.target).parents(".question-container");
let listPreviewAnswer = parentQuestionContainer.find(".answer-wrapper");
let listEditAnswer = parentQuestionContainer.find(".list-answer-edit");
var editQuestion = "<li>" +
    "<div class='edit-answer-item'>" +
    "<div class='sort-edit-answer-handle'>" +
    "<i class='fa fa-bars'></i>" +
    "</div>" +
    "<div class='input-edit-answer-holder'>" +
    "<input type='text' class='answer-content-input' value='Đáp án " + (listEditAnswer.find("li").length + 1) + "'>" +
    " Trọng số: <input type='number' min='0' class='weight-input' value='1'>" +
    "</div>" +
    "<div class='remove-answer-holder'>" +
    "<i class='fa fa-close'></i>" +
    "</div>" +
    "</div>" +
    "</li >";
let previewQuestion = "<div class='form-check'>" +
    "<label class='form-check-label'>" +
    "<input class='form-check-input' type='checkbox' disabled> Đáp án " + (listEditAnswer.find("li").length + 1) +
    "</label>" +
    "</div>";
$(previewQuestion).insertAfter(listPreviewAnswer.find(".form-check:not(.form-other)").last());
listEditAnswer.append(editQuestion);
});

$(document).on("click", ".btn-expand-edit", (event) => {
    let parentContainer = $(event.target).closest(".question-container");
let parentWrapper = parentContainer.find(".question-wrapper");
let previewQuestion = parentWrapper.find(".preview-question-container");
let editQuestionContainer = parentWrapper.find(".edit-question-container");
$(event.target).toggleClass("fa-angle-down fa-angle-up");
editQuestionContainer.slideToggle();
});

$(document).on("change", ".required-checkbox", (event) => {
    let checkbox = $(event.target);
let parentContainer = checkbox.parents(".question-container");
let requireQuestion = parentContainer.find(".required-question");
if (checkbox.is(":checked")) {
    requireQuestion.show();
} else {
    requireQuestion.hide();
}
});

$(document).on("keyup", ".txtEditQuestion", (event) => {
    let txtEditQuestion = $(event.target);
let parentContainer = txtEditQuestion.parents(".question-container");
let questionContent = parentContainer.find(".question-content-paragraph");
var value = txtEditQuestion.val();
questionContent.html(value);
});

$(document).on("click", ".remove-answer-holder>i.fa-close", (event) => {
    let parentContainer = $(event.target).parents(".question-container");
let listAnswer = parentContainer.find(".form-check");
let parentListItem = $(event.target).parents("li");
let listEditAnswerContainer = $(event.target).parents(".list-answer-edit");
if (listEditAnswerContainer.find(".edit-answer-item").length > 1) {
    let index = listEditAnswerContainer.find("li").index(parentListItem);
    parentListItem.fadeOut(500, () => {
        parentListItem.remove()
});
    let removeAnswer = $(listAnswer.get(index));
    removeAnswer.fadeOut(500, () => {
        removeAnswer.remove()
});
}
});

$(document).on("change", ".other-option-checkbox", (event) => {
    let parentContainer = $(event.target).parents(".question-container");
let otherQuestionContainer = $(parentContainer).find(".form-other");
if ($(event.target).is(":checked")) {
    otherQuestionContainer.removeClass("disabled");
} else {
    otherQuestionContainer.addClass("disabled");
}
});

$(document).on("keyup", ".answer-content-input", (event) => {
    let value = $(event.target).val();
let parentContainer = $(event.target).parents(".question-container");
let listAnswer = parentContainer.find(".form-check:not(.form-other)");
let parentListItem = $(event.target).parents("li");
let listEditAnswerContainer = $(event.target).parents(".list-answer-edit");
let index = listEditAnswerContainer.find("li").index(parentListItem);
listAnswer.find(".form-check-input")[index].nextSibling.nodeValue = value;
});

var numOfQuestion = 0;

function initAnswersPanel(answerPanel) {
    $(answerPanel).sortable({
            // connectWith: ".list-widget",
            receive: (ev, ui) => {
            console.log($(ev.target).find('li').length);
    copyHelper = null;
    if ($(ev.target).find('li').length > 1) {
        ui.item.remove();
    } else {
        let id = ui.item.attr('id');
        switch (id) {
            case 'text-ele': {
                ui.item.html("<div class='form-group'>" +
                    "<label class='control-label'>Nhập câu trả lời của bạn vào đây</label>" +
                    "<input type='text' class='form-control'>" +
                    "</div>");
                break;
            }
            case 'radio-ele': {
                ui.item.html("<div class='form-check'>" +
                    "<label class='form-check-label'>" +
                    "<input class='form-check-input' type='radio' checked> Đáp án 1" +
                    "</label>" +
                    "</div>" +
                    "<div class='form-check'>" +
                    "<label class='form-check-label'>" +
                    "<input class='form-check-input' type='radio'> Đáp án 2" +
                    "</label>" +
                    "</div>" +
                    "<div class='form-check'>" +
                    "<label class='form-check-label'>" +
                    "<input class='form-check-input' type='radio'> Đáp án 3" +
                    "</label>" +
                    "</div>");
                break;
            }
            case 'checkbox-ele': {
                ui.item.html("<div class='form-check'>" +
                    "<label class='form-check-label'>" +
                    "<input class='form-check-input' type='checkbox' checked> Đáp án 1" +
                    "</label>" +
                    "</div>");
                break;
            }
            case 'textarea-ele': {
                ui.item.html("<div class='form-group'>" +
                    "<label class='control-label'>Nhập câu trả lời của bạn vào đây</label>" +
                    "<textarea class='form-control'></textarea>" +
                    "</div>")
            }
        }
    }
},
    over: () => {
        removeIntent = false;
    },
    out: () => {
        removeIntent = true;
    },
    beforeStop: (event, ui) => {
        if (removeIntent == true) {
            ui.item.remove();
        }
    }
}).disableSelection();
}

$(".btn-add-new").on('click', (event) => {
    var html = "<li>" +
        "<div class='container'>" +
        "<div class='toggle-bar'>" +
        "<select>" +
        "<option>Chuyên cần</option>" +
        "<option>Tác phong</option>" +
        "<option>Chuyên môn</option>" +
        "<option>Thái độ</option>" +
        "<option>Kiến thức</option>" +
        "</select>" +
        // "<button class='btn btn-remove-question'>Xóa</button> " +
        "</div>" +
        "<div class='question'>" +
        "<textarea class='form-control' placeholder='Nhập câu hỏi'></textarea>" +
        "</div>" +
        "<div class='answers-container'>" +
        "<p>Kéo loại câu hỏi của bạn vào khung dưới</p>" +
        "<div class='field-action'>" +
        "<button class='btn-edit-answer'><i class='fa fa-fw fa-pencil'></i></button>" +
        "<button class='btn-remove-answer' onclick='removeAnswer(event)'><i class='fa fa-fw fa-remove'></i></button>" +
        "</div>" +
        "<ul class='answers-panel'>" +
        "</ul>" +
        "</div>" +
        "</li>";
let domNode = $(html);
domNode.hide();
// $(html).hide().appendTo($(".questions-list")).slideDown("fast");
$(".questions-list").append(domNode);
domNode.slideDown("fast");
let answerPanel = $(domNode).find(".answers-panel");
initAnswersPanel(answerPanel);
numOfQuestion++;
});

// $("#sortable").disableSelection();
// function dragstart_handler(ev){
//     console.log("dragStart");
//     ev.dataTransfer.setData("text", ev.target.id);
//     ev.dropEffect="copy";
// }
// function dragover_handler(ev){
//     ev.preventDefault();
//     ev.dataTransfer.dropEffect = "copy";
// }
// function drop_handler(ev){
//     ev.preventDefault();
//     var data = ev.dataTransfer.getData("text");
//     var originalElem = document.getElementById(data);
//     var clonedElem = originalElem.cloneNode(true);
//     clonedElem.className += " ui-state-default";
//     console.log(clonedElem);
//     console.log(data);
//     $(ev.target)
//         .find("ul")
//         .append(clonedElem);
// }

//Start Add/edit/remove question
//test
class Feedback {
    constructor(id) {
        this.id = id;
        this.questions = [];
    }
}

class Question {

    /**
     * @param options Array of options contents
     * @param type Type of question
     * */
    constructor(title, options, type, required, criteriaId, requireOther) {
        this.questionContent = title;
        this.optionCreateModel = options;
        this.type = type;
        this.required = required;
        this.criteriaId = criteriaId;
        this.requireOther = requireOther;
    }

}

class Option {
    constructor(content, weight) {
        this.optionContent = content;
        this.point = weight;
    }
}

function getQuestions() {
    var feedbackID = document.getElementById("feedbackID").innerHTML;
  //  alert(feedbackID);

    let feedback = new Feedback(feedbackID);

    //Lấy hết các div chứa question
    let allQuestions = $("div[class='question-container']");

    for (var i = 0; i < allQuestions.length; ++i) {
        //Lấy id của div để biết thuộc loại question nào
        let id = allQuestions[i].getAttribute("id");

        //Lấy title của question
        let title = allQuestions[i].querySelector("p[class='question-content-paragraph']").innerHTML.trim();

        //Có require hay không
        let required = allQuestions[i].querySelector("input[class='required-checkbox']").checked;

        //Loại criteria
        let criteriaId = allQuestions[i].querySelector("select[class='form-control select-list-criteria']").value;


        if (id.indexOf("radio-question") >= 0) {
            //Có cần option khác
            let requireOther = allQuestions[i].querySelector("input[class='other-option-checkbox']");
            let optionDivs = allQuestions[i].querySelectorAll("input[class='answer-content-input']");
            let weightDivs = allQuestions[i].querySelectorAll("input[class='weight-input']");
            let options = [];
            for (var j = 0; j < optionDivs.length; ++j) {
                options.push(new Option(optionDivs[j].value, weightDivs[j].value));
            }

            feedback.questions.push(new Question(title, options, "Radio", required, criteriaId, requireOther.checked));
        }
        else if (id.indexOf("checkbox-question") >= 0) {
            //Có cần option khác
            let requireOther = allQuestions[i].querySelector("input[class='other-option-checkbox']");
            let optionDivs = allQuestions[i].querySelectorAll("input[class='answer-content-input']");
            let weightDivs = allQuestions[i].querySelectorAll("input[class='weight-input']");
            let options = [];
            for (var j = 0; j < optionDivs.length; ++j) {
                options.push(new Option(optionDivs[j].value, weightDivs[j].value));
            }
            feedback.questions.push(new Question(title, options, "CheckBox", required, criteriaId, requireOther.checked));
        }
        else if (id.indexOf("textfield-question") >= 0) {
            feedback.questions.push(new Question(title, null, "Text", required, criteriaId, false));
        }
        else if (id.indexOf("textarea-question") >= 0) {
            feedback.questions.push(new Question(title, null, "TextArea", required, criteriaId, false));
        }
        else if (id.indexOf("star-question") >= 0) {
            feedback.questions.push(new Question(title, null, "Star", required, criteriaId, false));
        }
    }

    console.log(feedback);
    saveFeedback(feedback);
}

function saveFeedback(feedback) {
    var ctx = "${pageContext.request.contextPath}";
    $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: '/sfms/api/feedbacks/save-question',
            type: 'POST',
            data: JSON.stringify(feedback),
            success: function(data) {
                window.location.href = _ctx + "/modify-feedback/overview";
            },
            error: (err) => alert(err)
});
}