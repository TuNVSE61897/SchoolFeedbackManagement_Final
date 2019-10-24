var _ctx = $("meta[name='ctx']").attr("content");
var currentPageIndex = 0;
const feedbackPage = $(".feedback-page");
var currentPage = $(feedbackPage[currentPageIndex]);
var btnPagination = $(".btn-pagination");
var numOfPage = parseInt(feedbackPage.length);
var progressBar = $(".progress-bar");

$(document).ready(() => {
    currentPageIndex = 0;
const feedbackPage = $(".feedback-page");
currentPage = $(feedbackPage[currentPageIndex]);
btnPagination = $(".btn-pagination");
numOfPage = parseInt(feedbackPage.length);
progressBar = $(".progress-bar");
progress = ((currentPageIndex + 1) / numOfPage).toFixed(2) * 100;
progressBar.css('width', progress + "%").text(progress + "%");

$(document).on('click', ".btn-pagination", (el) => {
    const value = $(el.target).val();
currentPage.removeClass("page-active");
if (value == "next") {
    if (currentPageIndex < numOfPage - 1) {
        currentPageIndex++;
    }
    if (currentPageIndex == numOfPage - 1) {
        $(el.target).attr("disabled", true);
        $(".btn-submit").attr("disabled", false);
    }
    $(btnPagination[0]).attr("disabled", false);
} else {
    if (currentPageIndex > 0) {
        currentPageIndex--;
    }
    if (currentPageIndex == 0) {
        $(el.target).attr("disabled", true);
    }
    $(".btn-submit").attr("disabled", true);
    $(btnPagination[1]).attr("disabled", false);
}
var progress = ((currentPageIndex + 1) / numOfPage).toFixed(2) * 100;
progressBar.css('width', progress + "%").text(progress + "%");
currentPage = $(feedbackPage[currentPageIndex]);
currentPage.addClass("page-active");
});

$(document).on('mouseover', ".star-rating", (el) => {
    let formRatingContainer = $(el.target).parents(".form-rating");
let listIcon = formRatingContainer.find(".star-rating");
let listInput = formRatingContainer.find(".input-star");
formRatingContainer.find(".star-rating.checked").removeClass("checked");
let index = listIcon.index($(el.target));
//console.log(index);
for (let i = 0; i <= index; i++) {
    $(listIcon[i]).addClass("checked");
    $(listInput[i]).attr("checked", false);
}
$(listInput[index]).attr("checked", true);
});

$(document).on('change', ".other-option", (el) => {
    var otherOptionInput = $(el.target).parents(".form-check").find(".other-option-input-wrapper");
if ($(el.target).is(":checked")) {
    otherOptionInput.addClass("checked");
} else {
    otherOptionInput.removeClass("checked");
}
});
$(document).on('click', "#btn-submit-form", (el) => {
    let listQuestionContainer = $("[class*='question-']");
let data = [];
let allDone = true;
for (let i = 0; i < listQuestionContainer.length; i++) {
    let questionContainer = $(listQuestionContainer[i]);
    let answerBlock = questionContainer.find(".answer-block");
    let classesNames = answerBlock.attr("class");
    let classSplitted = classesNames.split(" ");
    let questionType = classSplitted[1];
    let isRequired = $(questionContainer).hasClass("required");
    switch (questionType) {
        case 'CheckBox': {
            if (isRequired && (answerBlock.find(".form-check-input:checked").length === 0)) {
                allDone = false;
                questionContainer.addClass("not-answered");
            } else if (answerBlock.find(".form-check-input:checked").length === 0) {
                //DO NOTHING
            } else {
                let option = answerBlock.find(".form-check-input:not(.other-option):checked");
                for (let j = 0; j < option.length; j++) {
                    let optionId = parseInt($(option[j]).attr("value"));
                    let content = {"optionnByOptionnId": optionId};
                    data.push(content);
                    questionContainer.removeClass("not-answered");
                }
                if (answerBlock.find(".form-check-input.other-option").is(":checked")) {
                    let otherOption = answerBlock.find(".other-option-input");
                    let value = otherOption.val().trim();
                    if (value.length === 0) {
                        allDone = false;
                        questionContainer.addClass("not-answered");
                    } else {
                        let optionId = parseInt(otherOption.attr("name"));
                        let content = {"optionnByOptionnId": optionId, "answerContent": value};
                        data.push(content);
                        questionContainer.removeClass("not-answered");
                    }
                }
            }
            break;
        }
        case 'Radio': {
            if (isRequired && (answerBlock.find(".form-check-input:checked").length === 0)) {
                allDone = false;
                questionContainer.addClass("not-answered");
            } else if (answerBlock.find(".form-check-input:checked").length === 0) {
                //DO NOTHING
            } else {
                let option = answerBlock.find(".form-check-input:checked");
                if (option.hasClass("other-option")) {
                    let otherOption = answerBlock.find(".other-option-input");
                    let value = otherOption.val().trim();
                    if (value.length === 0) {
                        allDone = false;
                        questionContainer.addClass("not-answered");
                    } else {
                        let optionId = parseInt(otherOption.attr("name"));
                        let content = {"optionnByOptionnId": optionId, "answerContent": value};
                        data.push(content);
                        questionContainer.removeClass("not-answered");
                    }
                } else {
                    let optionId = parseInt(option.attr("value"));
                    let content = {"optionnByOptionnId": optionId};
                    data.push(content);
                    questionContainer.removeClass("not-answered");
                }
            }
            break;
        }
        case 'TextArea': {
            let textarea = questionContainer.find("textarea");
            let value = textarea.val().trim();
            //console.log(value);
            if (isRequired && value.length === 0) {
                allDone = false;
                questionContainer.addClass("not-answered");
            } else if (value.length === 0) {
                // DO NOTHING
            } else {
                let optionId = parseInt(textarea.attr("name"));
                let content = {"optionnByOptionnId": optionId, "answerContent": value};
                data.push(content);
                questionContainer.removeClass("not-answered");
            }
            break;
        }
        case 'Text': {
            let textfield = questionContainer.find("input[type='text']");
            let value = textfield.val().trim();
            //console.log(value);
            if (isRequired && value.length === 0) {
                allDone = false;
                questionContainer.addClass("not-answered");
            } else if (value.length === 0) {
                // DO NOTHING
            } else {
                let optionId = parseInt(textfield.attr("name"));
                let content = {"optionnByOptionnId": optionId, "answerContent": value};
                data.push(content);
            }
            break;
        }
        case 'Star': {
            if (isRequired && (answerBlock.find(".input-star:checked").length === 0)) {
                allDone = false;
                questionContainer.addClass()
            } else if (answerBlock.find(".input-star:checked").length === 0) {
                // DO NOTHING
            } else {
                let option = answerBlock.find(".input-star:checked");
                let optionId = parseInt(option.attr("value"));
                let content = {"optionnByOptionnId": optionId};
                data.push(content);
                questionContainer.removeClass("not-answered");
            }
            break;
        }
    }
}
//console.log(data);
if (allDone) {
    $(".warning-text").removeClass("show");
    $.ajax({
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify({"answers": data}),
        url: _ctx + "/conduct-feedback/save",
            success: (data, status, xhr) => {
            if (xhr.status === 200) {
                window.location.href = _ctx + "/conduct-feedback/list"
    } else if (xhr.status === 403) {
        window.location.href = _ctx + "/logout"
    } else {
        $(".warning-text").append(data);
    }
}
});
} else {
    $(".warning-text").addClass("show");
    $("#confirmModal").modal('hide');
    $('html, body').animate({
        scrollTop: 0
    }, 1000);
}
});
});
