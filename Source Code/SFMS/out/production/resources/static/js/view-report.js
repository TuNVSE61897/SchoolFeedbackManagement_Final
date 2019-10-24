var currentlySelectedTable = $("#tblDep");

var depTable = $("#tblDep");
var majorTable = $("#tblMajor");
var courseTable = $("#tblCourse");
var classTable = $("#tblClass");

var filterSort = "Asc";

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


function sortTable(filterSort) {
    let depRows = $("#tblDep tbody tr").detach().get();
    let majorRows = $("#tblMajor tbody tr").detach().get();
    let courseRows = $("#tblCourse tbody tr").detach().get();
    let classesRows = $("#tblClass tbody tr").detach().get();
    switch (filterSort) {
        case 'Asc': {
            depRows.sort(compareAsc);
            majorRows.sort(compareAsc);
            courseRows.sort(compareAsc);
            classesRows.sort(compareAsc);
            break;
        }
        case 'Des': {
            depRows.sort(compareDes);
            majorRows.sort(compareDes);
            courseRows.sort(compareDes);
            classesRows.sort(compareDes);
            break;
        }
    }
    depTable.append(depRows);
    majorTable.append(majorRows);
    courseTable.append(courseRows);
    classTable.append(classesRows);
}


$(document).on('change', "#filter-scope", (event) => {
    let value = $(event.target).val();
    currentlySelectedTable.fadeOut(100);
    // currentlySelectedTable.css("display", "none");
    switch (value) {
        case 'Phòng ban': {
            currentlySelectedTable = $("#tblDep");
            break;
        }
        case 'Chuyên ngành': {
            currentlySelectedTable = $("#tblMajor");
            break;
        }
        case 'Môn học': {
            currentlySelectedTable = $("#tblCourse");
            break;
        }
        case 'Lớp': {
            currentlySelectedTable = $("#tblClass");
            break;
        }
    }
    currentlySelectedTable.fadeIn(500);
});

$(document).on('change', "#filter-sort", (event) => {
    filterSort = $(event.target).val().trim();
    sortTable(filterSort);

});