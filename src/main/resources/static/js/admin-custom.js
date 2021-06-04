var nameContentPath = 'Project_1';
var confirmNo = true;
$(document).ready(function() {
    $('#btn-timkiem-kichthuoc').on('click', function() {
        console.log("abcd");
        showFormConfirm("Bạn có chắc chắn muốn xóa");
    });

    // Customize lại input chọn màu sắc
    $('.choose-color input[type=color]').on('change', function() {
        $('.choose-color input[type=text]').val($(this).val());
    });

    /* ===================================================== */
    /* Sự kiện cho các phần thông báo */
    $('body').on('click', '.xac-minh', function(event) {
        if ($(event.target).hasClass('xac-minh')) {
            $('.xac-minh').addClass("display-none");
            confirmNo = true;
        }
    });
    $('body').on('click', '.xac-minh .noi-dung .noi-dung-chinh .tra-loi .yes', function(event) {
        confirmNo = false;
    });
    $('body').on('click', '.xac-minh .noi-dung .noi-dung-chinh .tra-loi .no', function(event) {
        confirmNo = true;
        $('.xac-minh').addClass("display-none");
    });
    /* Kết thúc phần sự kiện cho các phần thông báo */
    /* ===================================================== */
});

// type = 1 => thông báo thành công
// type = 0 => thông báo thất bại
function showThongBao(type, noiDung) {
    let content = $('.thong-bao .noi-dung-chinh');
    if (type == 1) { // tức là thông báo thất bại
        content.html(`<i class="fas fa-check-circle icon-success"></i>
                <span class="noi-dung-thong-bao">${noiDung}</span>`);
    } else { // tức là thông báo không thành công
        content.html(`<i class="fas fa-exclamation-triangle icon-failture"></i>
                <span class="noi-dung-thong-bao">${noiDung}</span>`);
    }

    $('.thong-bao').removeClass('display-none');
    setTimeout(function() {
        $('.thong-bao').addClass('display-none');
    }, 1300);
}

// Hàm có chức năng hiển thi show nội dung xác minh
function showFormConfirm(noiDung){
    $('.xac-minh').find('.title-span').val(noiDung);
    $('.xac-minh').removeClass('display-none');
}