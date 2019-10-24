$(document).on('click', '.toggle-answer-content', (event) => {
    let icon = $(event.target);
    let questionContainer = $(event.target).parents(".question-card");
    let answerContainer = questionContainer.find(".answer-content-container");
    if (icon.hasClass("fa-chevron-down")) {
        icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");
        answerContainer.slideDown();
    } else {
        icon.removeClass("fa-chevron-up").addClass("fa-chevron-down");
        answerContainer.slideUp();
    }
});

$(document).ready(() => {
    let pieCharts = $(".piechart");

    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var options = {
            title: ''
        };
        for (let i = 0; i < pieCharts.length; i++) {
            let pieChart = $(pieCharts[i]);
            let questionContainer = pieChart.parents(".question-card");
            let chartData = questionContainer.find(".chart-data");
            let chartDataArr = [];
            for (let j = 0; j < chartData.length; j++) {
                let optionContent = $(chartData[j]).attr("data-option-content");
                let selectedCount = $(chartData[j]).attr("data-selected-count");
                chartDataArr.push([(optionContent === "NULL" ? (j + 1) + " Sao" : optionContent), parseInt(selectedCount)]);
            }
            console.log(chartDataArr.toString());
            let data = new google.visualization.DataTable();
            data.addColumn('string', 'content');
            data.addColumn('number', 'selected');
            data.addRows(chartDataArr);
            let chart = new google.visualization.PieChart(document.getElementById(pieChart.attr("id")));
            chart.draw(data, options);
        }

    }
});