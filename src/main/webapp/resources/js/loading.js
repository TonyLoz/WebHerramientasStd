
function showLoadingImage() {
    $('body').append('<div class="loading" id="loading-image"></div>');
}

function hideLoadingImage() {
    $('#loading-image').remove();
}