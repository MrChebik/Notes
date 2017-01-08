function sendNote() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    
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