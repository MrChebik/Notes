function sendNote() {
    $.ajax({
        type : "POST",
        contentType : "application/json; charset=utf-8",
        url : window.location.pathname,
        data : JSON.stringify({
            title : $("#titleId").val(),
            text : $("#textId").val()
        }),
        complete: function () {
            $("#titleId").val("");
            $("#textId").val("");
        }
    });
}