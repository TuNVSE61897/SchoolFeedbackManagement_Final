var filters = {
    status: null,
    scope: null,
};
var filterSort = "Asc";
var table = $("#tblFeedback");
$(document).ready(() => {
    sortTable(filterSort);
});

function compareAsc(row1, row2) {
    let v1, v2;
    v1 = $(row1).find("td:eq(0)").text();
    v2 = $(row2).find("td:eq(0)").text();
    return v1.localeCompare(v2);
}

function compareDes(row1, row2) {
    let v1, v2;
    v1 = $(row1).find("td:eq(0)").text().toLowerCase();
    v2 = $(row2).find("td:eq(0)").text().toLowerCase();
    let result = v1.localeCompare(v2);
    if (result !== 0) result = -result;
    return result;
}

function compareSemAsc(row1, row2) {
    let v1, v2;
    v1 = parseInt($(row1).find("td:eq(1)").data("start-date"));
    v2 = parseInt($(row2).find("td:eq(1)").data("start-date"));
    return v1 - v2;
}

function compareSemDes(row1, row2) {
    let v1, v2;
    v1 = parseInt($(row1).find("td:eq(1)").data("start-date"));
    v2 = parseInt($(row2).find("td:eq(1)").data("start-date"));
    return v2 - v1;
}

function updateFilter() {
    // let row = $(".feedback-table-row");
    $('.feedback-table-row').hide().filter(function () {
        let
            self = $(this),
            result = true; // not guilty until proven guilty
        console.log(self);
        Object.keys(filters).forEach(function (filter) {
            if (filters[filter] && (filters[filter] != 'All')) {
                result = result && filters[filter] === self.data(filter);
            }
        });

        return result;
    }).show();
}

function changeFilter(filterName) {
    filters[filterName] = $(this).val();
    updateFilter();
}

$(document).on('change', '#filter-scope', (event) => {
    changeFilter.call($(event.target), 'scope');
});
$(document).on('change', '#filter-status', (event) => {
    changeFilter.call($(event.target), 'status');
});

function sortTable(filterSort) {
    let rows = $(".feedback-table-row").detach().get();
    switch (filterSort) {
        case 'Asc': {
            rows.sort(compareAsc);
            break;
        }
        case 'Des': {
            rows.sort(compareDes);
            break;
        }
        case 'semAsc': {
            rows.sort(compareSemAsc);
            break;
        }
        case 'semDes': {
            rows.sort(compareSemDes);
            break;
        }
    }
    table.append(rows);
}

$(document).on('change', "#filter-sort", (event) => {
    filterSort = $(event.target).val().trim();
    sortTable(filterSort);
});