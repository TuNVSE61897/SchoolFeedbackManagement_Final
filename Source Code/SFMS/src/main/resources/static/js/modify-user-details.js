$(document).ready(() => {
    let initTarget = [];
    initValue();
    checkRoleValue();

    function initValue() {
        initTarget = getFormValue();
    }

    function checkRoleValue() {
        let value = $("select[name='roleByRoleId']>option:selected").text();
        let departmentSelect = $("select[name='departmentByDepartmentId']");
        let departmentOption = departmentSelect.find("option");
        let majorSelect = $("select[name='majorByMajorId']");
        if (value === "Học sinh") {
            majorSelect.attr("disabled", false);
            departmentSelect.attr("disabled", true);
            for (let i = 0; i < departmentOption.length; i++) {
                if ($(departmentOption[i]).text() === "N/A") {
                    $(departmentOption[i]).attr("selected", true);
                }
            }
        } else if (value === "Giảng viên") {
            majorSelect.attr("disabled", false);
            departmentSelect.attr("disabled", false).attr("readonly", true);
            for (let i = 0; i < departmentOption.length; i++) {
                if ($(departmentOption[i]).text() === "Đào Tạo") {
                    $(departmentOption[i]).attr("selected", true);
                }
            }
        } else {
            departmentSelect.attr("disabled", false).attr("readonly", false);
            majorSelect.attr("disabled", true);
        }
    }

    $(document).on('click', '.btn-save', event => {
        submitForm(false);
    });
    $(document).on('click', '.btn-save-and-go-back', event => {
        submitForm(true);
    });

    function submitForm(goBack) {
        let input = $("input.error");
        if (input.length > 0) {
            return false;
        } else {
            let data = getFormValue();
            let type = initTarget["id"] > 0 ? "PUT" : "POST";
            $.ajax({
                type: type,
                url: _ctx + "/api/users",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data),
                success: (data, status, xhr) => {
                    console.log(goBack);
                    if (xhr.status === 200) {
                        if (goBack) {
                            window.location.href = _ctx + "/users";
                        } else {
                            window.location.reload();
                        }
                    }
                }
            });
        }
    }

    function getFormValue() {
        let arrayValue = $("#form-user").serializeArray();
        let result = {};
        $(arrayValue).each(function (i, field) {
            result[field.name] = field.value;
        });
        return result;

    }

    $(document).on('change', 'select[name="roleByRoleId"]', event => {
        let value = $(event.target).find("option:selected").text();
        let departmentSelect = $("select[name='departmentByDepartmentId']");
        let departmentOption = departmentSelect.find("option");
        let majorSelect = $("select[name='majorByMajorId']");
        if (value === "Học sinh") {
            majorSelect.attr("disabled", false);
            departmentSelect.attr("disabled", true);
            for (let i = 0; i < departmentOption.length; i++) {
                if ($(departmentOption[i]).text() === "N/A") {
                    $(departmentOption[i]).attr("selected", true);
                }
            }
        } else if (value === "Giảng viên") {
            majorSelect.attr("disabled", false);
            departmentSelect.attr("disabled", false).attr("readonly", true);
            for (let i = 0; i < departmentOption.length; i++) {
                if ($(departmentOption[i]).text() === "Đào Tạo") {
                    $(departmentOption[i]).attr("selected", true);
                }
            }
        } else {
            departmentSelect.attr("disabled", false).attr("readonly", false);
            majorSelect.attr("disabled", true);
        }
    });

    $(document).on('keyup', 'input[name="confirmPassword"],input[name="password"]', event => {
        let passwordElement = $('input[name="password"]');
        let confirmPasswordElement = $('input[name="confirmPassword"]');
        let password = passwordElement.val();
        let confirmPassword = confirmPasswordElement.val();
        if (password === confirmPassword) {
            confirmPasswordElement.removeClass("error");
            $(".confirm-password-help").css("display", "none");
        } else {
            confirmPasswordElement.addClass("error");
            $(".confirm-password-help").css("display", "inline-block");
        }
    });
    $(document).on('blur', 'input[name="mail"]', event => {
        let value = $(event.target).val();
        let currentInput = $(event.target).parents(".form-group").find(".form-control");
        let currentHelp = $(".email-help");
        if (value === "") {
            currentInput.addClass("error");
        }
        else if (value === initTarget["mail"]) {
            currentHelp.css("display", "none");
            currentInput.removeClass("error");
        } else {
            $.ajax({
                type: "get",
                url: _ctx + "/api/users/email?email=" + value,
                success: (data, status, xhr) => {
                    if (xhr.status === 200) {
                        currentHelp.css("display", "none");
                        currentInput.removeClass("error");
                    } else {
                        currentHelp.css("display", "inline-block");
                        currentInput.addClass("error");
                    }
                }
            });
        }
    });

    $(document).on('blur', 'input[name="code"]', event => {
        let value = $(event.target).val();
        let currentInput = $(event.target).parents(".form-group").find(".form-control");
        let currentHelp = $(".code-help");
        if (value === "") {
            currentInput.addClass("error");
        }
        else if (value === initTarget["code"]) {
            currentHelp.css("display", "none");
            currentInput.removeClass("error");
        } else {
            $.ajax({
                type: "get",
                url: _ctx + "/api/users/code?code=" + value,
                success: (data, status, xhr) => {
                    if (xhr.status === 200) {
                        currentHelp.css("display", "none");
                        currentInput.removeClass("error");
                    } else {
                        currentHelp.css("display", "inline-block");
                        currentInput.addClass("error");
                    }
                }
            });
        }
    });

    $(document).on('blur', 'input[name="username"]', event => {
        let value = $(event.target).val();
        let currentInput = $(event.target).parents(".form-group").find(".form-control");
        let currentHelp = $(".username-help");
        if (value === "") {
            currentInput.addClass("error");
        }
        else if (value === initTarget["username"]) {
            currentHelp.css("display", "none");
            currentInput.removeClass("error");
        } else {
            $.ajax({
                type: "get",
                url: _ctx + "/api/users/username?username=" + value,
                success: (data, status, xhr) => {
                    if (xhr.status === 200) {
                        currentHelp.css("display", "none");
                        currentInput.removeClass("error");
                    } else {
                        currentHelp.css("display", "inline-block");
                        currentInput.addClass("error");
                    }
                }
            });
        }
    });

    $(document).on('click', '.btn-cancel', event => {
        window.location.reload();
    });

});