/**
 * Created by mrchebik on 11.08.16.
 */
function submitData(id, elementId) {
    document.getElementById(elementId).value = id;
    document.getElementById("form1").submit();
}