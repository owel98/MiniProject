

function checkEmail() {

    var e = document.getElementById('txtEmail');
    var pattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!pattern.test(e.value)) {
    alert('Please provide a valid email address');
    e.focus;
    return false;
 }
}