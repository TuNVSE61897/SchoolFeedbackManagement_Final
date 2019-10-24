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


    $('.btn-pagination').on('click', $(".btn-pagination"), (el) => {
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

    
});

