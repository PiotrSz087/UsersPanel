function modalFunction() {
    var modal = document.getElementById('myModal');
    var span = document.getElementsByClassName("close")[0];

    modal.style.display = "block";

    // close modal by click 'x'
    span.onclick = function() {
        modal.style.display = "none";
    };

    // close modal by click page area
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };
}
