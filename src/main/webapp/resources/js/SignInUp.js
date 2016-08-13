/**
 * Created by mrchebik on 26.07.16.
 */
var error = 1;

function check(id) {
    var element = document.getElementById(id);

    if (element.value.length < 4 || element.value.length > (element.value != password ? 12 : 16)) {
        element.style.borderColor = 'red';
        error = 1;
    } else {
        element.style.borderColor = 'black';
        error = 0;
    }
}

function checkError(id) {
    if (error == 0) {
        document.getElementById("007").value = id;
        document.getElementById("form1").submit();
    } else {
        alert("Check your login and password, they must not be red.");
    }
}