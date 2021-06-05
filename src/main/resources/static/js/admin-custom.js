var nameContentPath = 'Project_1';
var confirmNo = true;
$(document).ready(function() {
    $('#btn-timkiem-kichthuoc').on('click', function () {
        showFormConfirm("Bạn có chắc chắn muốn xóa");
    });

    // Customize lại input chọn màu sắc
    $('.choose-color input[type=color]').on('change', function () {
        $('.choose-color input[type=text]').val($(this).val());
    });

    /* ===================================================== */
    /* Sự kiện cho các phần thông báo */
    $('body').on('click', '.xac-minh', function (event) {
        if ($(event.target).hasClass('xac-minh')) {
            $('.xac-minh').addClass("display-none");
            confirmNo = true;
        }
    });
    $('body').on('click', '.xac-minh .noi-dung .noi-dung-chinh .tra-loi .yes', function (event) {
        confirmNo = false;
    });
    $('body').on('click', '.xac-minh .noi-dung .noi-dung-chinh .tra-loi .no', function (event) {
        confirmNo = true;
        $('.xac-minh').addClass("display-none");
    });
    /* Kết thúc phần sự kiện cho các phần thông báo */
    /* ===================================================== */

    /*===================== Xử lý page màu sắc ======================*/
    // View chi tiết màu sắc
    $('body').on('click', '.view-chi-tiet-mau-sac', function () {
        // Lấy dữ liệu
        let idMauSac = $(this).closest('tr').find('.id-mau-sac').text();
        let tenMauSac = $(this).closest('tr').find('.ten-mau-sac').text();
        let maMauSac = $(this).closest('tr').find('.ma-mau-sac').text();

        // update dữ liệu vào form
        $('.modal-chitietmausac').find('#ma-mau-sac-chinh-sua').val(idMauSac);
        $('.modal-chitietmausac').find('#ten-mau-sac-chinh-sua').val(tenMauSac);
        $('.modal-chitietmausac').find('.choose-color input[type="color"]').val(maMauSac);
        $('.modal-chitietmausac').find('.choose-color input[type="text"]').val(maMauSac);
    });

    // Tìm kiếm màu sắc theo tên
    $('#btn-timkiem-mausac').on('click', function () {
        let noiDung = $(this).closest('.input-group').find('input').val();
        if (noiDung !== '') {
            let listMauSac = ajaxGet(`/${nameContentPath}/admin/api/mausac/find/${noiDung}`);
            updateListMauSac(listMauSac);
        }
    });

    // update chi tiết màu sắc theo listMauSac truyền vào
    function updateListMauSac(listMauSac) {
        let table = $('table tbody');
        let innerHTML = '';
        if (listMauSac.length != 0) {
            for (let ms of listMauSac) {
                innerHTML += `
                    <tr>
                        <th scope="row" class="align-middle text-center id-mau-sac">${ms.idMauSac}</th>
                        <td class="align-middle ten-mau-sac">${ms.tenMauSac}</td>
                        <td class="align-middle text-center ma-mau-sac">${ms.maMau}</td>
                        <td class="align-middle p-1">
                            <button class="w-100 btn" style="background: ${ms.maMau}">
                                <span style="opacity: 0">.</span>
                            </button>
                        </td>
                        <td class="p-1 align-middle">
                            <button class="btn btn-primary w-100 py-1 view-chi-tiet-mau-sac" data-toggle="modal" data-target=".modal-chitietmausac">
                                Xem chi tiết
                                <i class="fas fa-chevron-circle-down"></i>
                            </button>
                        </td>
                    </tr>`;
            };
        } else {
            innerHTML = `
                <tr>
                    <td colspan="5" class="text-center align-middle text-danger text-uppercase">
                        <h3 class="mb-0">Không có kết quả</h3>
                    </td>
                </tr>`;
        }
        table.html(innerHTML);
    }

    // Reset form thêm mới của modal màu sắc
    function resetFormMauSacThemMoi() {
        $('.modal-themmoimausac').find('#id-tenmausac-themmoi').val('');
        $('.modal-themmoimausac').find('.choose-color input[type="color"]').val('#000000');
        $('.modal-themmoimausac').find('.choose-color input[type="text"]').val('');
    };

    // Sự kiện reset form khi thoát khoải form thêm màu sắc mới
    $('.modal-themmoimausac').on('hidden.bs.modal', function (e) {
        resetFormMauSacThemMoi();
    });
    /*================= Kết thúc xử lý page màu sắc =====================*/


    /* ========================= Xử lý page danh mục =======================*/
    // Sự kiện cho việc tìm kiếm danh mục
    $('#btn-timkiem-danhmuc').on('click', function() {
        let noiDung = $(this).closest('.input-group').find('input').val();
        if (noiDung !== '') {
            let listDanhMuc = ajaxGet(`/${nameContentPath}/admin/api/danhmuc/find/${noiDung}`);
            updateListDanhMuc(listDanhMuc);
        }
    });

    // View chi tiết từng danh mục
    $('body').on('click', '.view-chi-tiet-danh-muc', function () {
        // Lấy dữ liệu
        let idDanhMuc = $(this).closest('tr').find('.id-danh-muc').text();
        let tenDanhMuc = $(this).closest('tr').find('.ten-danh-muc').text();
        let moTaDanhMuc = $(this).closest('tr').find('.mo-ta-danh-muc').text();

        // Update lại vào form
        $('.modal-chitietdanhmuc').find('#ma-danh-muc-chinh-sua').val(idDanhMuc);
        $('.modal-chitietdanhmuc').find('#ten-danh-muc-chinh-sua').val(tenDanhMuc);
        $('.modal-chitietdanhmuc').find('#mo-ta-danh-muc-chinh-sua').val(moTaDanhMuc);
    });

    // Thêm mới danh mục
    $('.modal-themmoidanhmuc .btn-danhmuc-save').on('click', function() {
        let tenDanhMuc = $('.modal-themmoidanhmuc').find('input[type="text"]').val();
        let moTa = $('.modal-themmoidanhmuc').find('textarea').val();
        let data = {
            tenDanhMuc: tenDanhMuc,
            moTa: moTa
        };

        let value = ajaxPost(`/${nameContentPath}/admin/api/danhmuc`, data);

        // Thực hiện reset và close modal
        resetFormDanhMucThemMoi();
        $('.modal-themmoidanhmuc').find('.close').click();
        // Xuất thông báo
        if (value != null) {
            let listDanhMuc = ajaxGet(`/${nameContentPath}/admin/api/danhmuc`);
            updateListDanhMuc(listDanhMuc);

            showThongBao(1, "Thêm danh mục thành công!");
        } else {
            showThongBao(0, "Thêm danh mục thất bại!");
        }

    });

    // Xóa một danh mục khỏi danh sách
    $('.modal-chitietdanhmuc .btn-delete-danhmuc').on('click', function(){
        // Tìm id của danh mục
        let idDanhMuc = $(this).closest('.modal-chitietdanhmuc')
            .find('#ma-danh-muc-chinh-sua').val();

        // Thực hiện xóa trong database
        let checkDelete = ajaxDelete(`/${nameContentPath}/admin/api/danhmuc/${idDanhMuc}`);

        // thông báo xóa thành công / thất bại
        $('.modal-chitietdanhmuc').find('.close').click();
        if (checkDelete) {
            let listDanhMuc = ajaxGet(`/${nameContentPath}/admin/api/danhmuc`);
            updateListDanhMuc(listDanhMuc);

            showThongBao(1, `Xóa danh muc ID:${idDanhMuc} thành công!`);
        } else {
            showThongBao(0, `Xóa danh muc ID:${idDanhMuc} thất bại!`);
        }
    });

    // Update 1 danh mục
    $('.modal-chitietdanhmuc .btn-update-danhmuc').on('click', function(){
        // Lấy dữ liệu
        let idDanhMuc = parseInt($(this).closest('.modal-chitietdanhmuc')
            .find('#ma-danh-muc-chinh-sua').val());
        let tenDanhMuc = $(this).closest('.modal-chitietdanhmuc')
            .find('#ten-danh-muc-chinh-sua').val();
        let moTa = $(this).closest('.modal-chitietdanhmuc')
            .find('#mo-ta-danh-muc-chinh-sua').val();
        let data = {idDanhMuc, tenDanhMuc, moTa};

        // Truy xuất database
        let danhMuc = ajaxPut(`/${nameContentPath}/admin/api/danhmuc`, data);

        // thông báo update thành công / thất bại
        $('.modal-chitietdanhmuc').find('.close').click();
        if (danhMuc != null) {
            let listDanhMuc = ajaxGet(`/${nameContentPath}/admin/api/danhmuc`);
            updateListDanhMuc(listDanhMuc);

            showThongBao(1, `Cập nhập danh muc ID:${idDanhMuc} thành công!`);
        } else {
            showThongBao(0, `Cập nhập danh muc ID:${idDanhMuc} thất bại!`);
        }
    });

    // Update list danh muc lên frontend
    function updateListDanhMuc(listDanhMuc) {
        let table = $('table tbody');
        let innerHTML = '';
        if (listDanhMuc.length != 0) {
            for (let dm of listDanhMuc) {
                innerHTML += `
            <tr>
                <th scope="row" class="align-middle text-center id-danh-muc">${dm.idDanhMuc}</th>
                <td class="align-middle ten-danh-muc">${dm.tenDanhMuc}</td>
                <td class="align-middle mo-ta-danh-muc">${dm.moTa}</td>
                <td class="p-1 align-middle w-25">
                    <button class="btn btn-primary w-100 py-1 view-chi-tiet-danh-muc" data-toggle="modal" data-target=".modal-chitietdanhmuc">
                        Xem chi tiết
                        <i class="fas fa-chevron-circle-down"></i>
                    </button>
                </td>
            </tr>`;
            };
        } else {
            innerHTML = `
                <tr>
                    <td colspan="4" class="text-center align-middle text-danger text-uppercase">
                        <h3 class="mb-0">Không có kết quả</h3>
                    </td>
                </tr>`;
        }
        table.html(innerHTML);
    };

    // Reset form thêm mới của modal danh mục
    function resetFormDanhMucThemMoi() {
        $('.modal-themmoidanhmuc').find('#id-themmoi-danhmuc').val('');
        $('.modal-themmoidanhmuc').find('#mota-themmoi-danhmuc').val('');
    };

    // Sự kiện khi toán modal thêm sản phẩm mới
    $('.modal-themmoidanhmuc').on('hidden.bs.modal', function (e) {
        resetFormDanhMucThemMoi();
    });
    /* ======================= Kết thúc xử lý page danh mục ==================*/

    $('.view-chi-tiet-kich-thuoc').on('click', function() {

    });
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
    }, 1500);
}

// Hàm có chức năng hiển thi show nội dung xác minh
function showFormConfirm(noiDung){
    $('.xac-minh').find('.title-span').val(noiDung);
    $('.xac-minh').removeClass('display-none');
}

// AJAX GET and return data object
function ajaxGet(url) {
    let result = null;
    $.ajax({
        url: url,
        type: 'GET',
        contentType: 'application/json',
        async: false,
        timeout:5000,
        success: function(value) {
            result = value;
        }
    });
    return result;
}

// Ajax POST and return data hợp lệ
function ajaxPost(url, data){
    let result = null;
    $.ajax({
        url: url,
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        async: false,
        data: JSON.stringify(data),
        timeout: 5000,
        success: function (value) {
            result = value;
        }
    });
    return result;
}

function ajaxDelete(url) {
    let result = null;
    $.ajax({
        url: url,
        type: 'DELETE',
        contentType: 'application/json',
        timeout: 5000,
        async: false,
        success: function (value) {
            result = !value.active;
        }
    });
    return result;
}

function ajaxPut(url, data) {
    let result = null;
    $.ajax({
        url: url,
        type: 'PUT',
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json',
        async: false,
        timeout:5000,
        success: function(value) {
            result = value;
        }
    });
    return result;
}