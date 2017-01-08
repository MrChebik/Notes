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

    var passwordConfirm = document.getElementById('passwordConfirm');

    if (passwordConfirm.value != document.getElementById('password').value && passwordConfirm.value != '') {
        passwordConfirm.style.borderColor = 'red';
        error = 1;
    } else {
        passwordConfirm.style.borderColor = 'black';
        error = 0;
    }

    if (passwordConfirm.value == '') {
        error = 1;
    }
}

function checkError() {
    if (error == 0) {
        document.getElementById("form1").submit();
    } else {
        alert("Check your login and password, they must not be red or empty.");
    }
}