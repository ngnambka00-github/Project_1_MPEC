var nameContentPath = 'Project_1';
var confirmNo = true;
$(document).ready(function() {
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

    // Thêm màu sắc mới
    $('.modal-themmoimausac .btn-mausac-save').on('click', function() {
        // Lấy dữ liệu từ form
        let tenMauSac = $(this).closest('.modal-themmoimausac').find('#id-tenmausac-themmoi').val();
        let maMau = $(this).closest('.modal-themmoimausac').find('.choose-color input[type="text"]').val();

        // Tạo data
        let data = {tenMauSac, maMau};

        // Call API
        let mauSauObject = ajaxPost(`/${nameContentPath}/admin/api/mausac`, data);

        // Hiển thị thông báo
        resetFormMauSacThemMoi();
        $('.modal-themmoimausac').find('.close').click();
        if (mauSauObject !== null) { // Thêm mới thành công
            // Update lại giao diện
            let listMauSac = ajaxGet(`/${nameContentPath}/admin/api/mausac`);
            updateListMauSac(listMauSac);

            // Show thông báo
            showThongBao(1, "Thêm mới màu sắc thành công!");
        } else { // Thêm mới thất bại
            showThongBao(0, "Thêm mới màu sắc thất bại!");
        }
    });

    // Xóa một màu sắc khỏi danh sách
    $('.modal-chitietmausac .btn-delete-mausac').on('click', function() {
        // Lấy id
        let idMauSac = $(this).closest('.modal-chitietmausac').find('#ma-mau-sac-chinh-sua').val();

        // Thực hiện call API HTTP Delete
        let checkDelete = ajaxDelete(`/${nameContentPath}/admin/api/mausac/${idMauSac}`);

        // Hiển thị thông báo xóa thành công / thất bại
        $(this).closest('.modal-chitietmausac').find('.close').click();
        if (checkDelete) { // Tức là xóa thành công
            // Cập nhập lại giao diện
            let listMauSac = ajaxGet(`/${nameContentPath}/admin/api/mausac`);
            updateListMauSac(listMauSac);

            // show thông báo hiển thị
            showThongBao(1, `Xóa màu sắc ID:${idMauSac} thành công!`);
        } else { // Tức là xóa không thành công
            showThongBao(0, `Xóa màu sắc ID:${idMauSac} thất bại!`);
        }
    });

    // Update lại 1 object màu sắc mới vào danh sách
    $('.modal-chitietmausac .btn-update-mausac').on('click', function() {
        // Lấy dữ liệu
        let idMauSac = parseInt($(this).closest('.modal-chitietmausac').find('#ma-mau-sac-chinh-sua').val());
        let tenMauSac = $(this).closest('.modal-chitietmausac').find('#ten-mau-sac-chinh-sua').val();
        let maMau = $(this).closest('.modal-chitietmausac').find('.choose-color input[type="text"]').val();
        let data = {idMauSac, tenMauSac, maMau};

        // Call API PUT để update màu sắc vào database
        let mauSacUpdate = ajaxPut(`/${nameContentPath}/admin/api/mausac`, data);

        // Xuất thông báo hiển thị
        $(this).closest('.modal-chitietmausac').find('.close').click();
        if (mauSacUpdate !== null) { // update thành công
            // Update dữ liệu lại lên giao diện
            let listMauSac = ajaxGet(`/${nameContentPath}/admin/api/mausac`);
            updateListMauSac(listMauSac);

            // Hiển thị thông báo
            showThongBao(1, `Cập nhập ID:${idMauSac} thành công!`)
        } else { // update không thành công
            showThongBao(0, `Cập nhập ID:${idMauSac} thất bại!`);
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

    // set focus for name_input sau khi mở form modal-themmoimausac
    $('.modal-themmoimausac').on('shown.bs.modal', function(e){
        $(this).find('#id-tenmausac-themmoi').focus();
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

    // Sự kiện khi close modal thêm sản phẩm mới
    $('.modal-themmoidanhmuc').on('hidden.bs.modal', function (e) {
        resetFormDanhMucThemMoi();
    });

    // set focus for name_input sau khi mở form modal-themmoidanhmuc
    $('.modal-themmoidanhmuc').on('shown.bs.modal', function(e){
        $(this).find('#id-themmoi-danhmuc').focus();
    });
    /* ======================= Kết thúc xử lý page danh mục ==================*/


    /* ======================= Xử lý page kích thước =======================*/
    // View chi tiết kích thuớc
    $('body').on('click', '.view-chi-tiet-kich-thuoc', function() {
        // Lấy dữ liệu
        let idKichThuoc = $(this).closest('tr').find('.id-kich-thuoc').text();
        let tenKichThuoc = $(this).closest('tr').find('.ten-kich-thuoc').text();
        let kyHieuKichThuoc = $(this).closest('tr').find('.ky-hieu-kich-thuoc').text();

        // Cập nhập lên form giao diện
        $('.modal-chitietkichthuoc').find('#idkichthuoc-chinhsua').val(idKichThuoc);
        $('.modal-chitietkichthuoc').find('#tenkichthuoc-chinhsua').val(tenKichThuoc);
        $('.modal-chitietkichthuoc').find('#kyhieukichthuoc-chinhsua').val(kyHieuKichThuoc);
    });

    // Chức năng tìm kiếm kích thước
    $('#btn-timkiem-kichthuoc').on('click', function() {
        let noiDung = $(this).closest('.input-group').find('input').val();
        if (noiDung !== '') {
            let listKichThuoc = ajaxGet(`/${nameContentPath}/admin/api/kichthuoc/find/${noiDung}`);
            updateListKichThuoc(listKichThuoc);
        }
    });

    // Chức năng thêm mới đối tượng KichThuoc
    $('.modal-themmoikichthuoc .btn-kichthuoc-save').on('click', function() {
        // Lấy dữ liệu
        let tenKichThuoc = $(this).closest('.modal-themmoikichthuoc').find('#tenkichthuoc-themmoi').val();
        let kyHieu = $(this).closest('.modal-themmoikichthuoc').find('#kyhieukichthuoc-themmoi').val();
        let data = {tenKichThuoc, kyHieu};

        // Call API tạo mới dữ liệu
        let kichThuocObject = ajaxPost(`/${nameContentPath}/admin/api/kichthuoc`, data);

        // Xuất hiển thị thông báo
        resetFormKichThuocThemMoi();
        $('.modal-themmoikichthuoc').find('.close').click();
        if (kichThuocObject !== null) { // thêm object kích thước mới thành công
            // Update giao diện danh sách kích thước mới sau khi thêm
            let listKichThuoc = ajaxGet(`/${nameContentPath}/admin/api/kichthuoc`);
            updateListKichThuoc(listKichThuoc);

            // Hiển thị thông báo
            showThongBao(1, "Thêm mới kích thước thành công!");
        } else { // thêm object kích thước mới thất bại
            showThongBao(0, "Thêm mới kích thước thất bại!");
        }
    });

    // Chức năng xóa đối tượng KichThuoc theo idKichThuoc
    $('.modal-chitietkichthuoc .btn-delete-kichthuoc').on('click', function() {
        // Tìm idKichThuoc
        let idKichThuoc = $(this).closest('.modal-chitietkichthuoc').find('#idkichthuoc-chinhsua').val();

        // Call API thực hiện xóa đối tượng KichThuoc
        let checkDelete = ajaxDelete(`/${nameContentPath}/admin/api/kichthuoc/${idKichThuoc}`);

        // Hiển thị thông báo giao diện thành công / thất bại
        $('.modal-chitietkichthuoc').find('.close').click();
        if (checkDelete) { // Xóa thành công đối tượng KichThuoc
            // Update lại gioa diện sau khi xóa
            let listKichThuoc = ajaxGet(`/${nameContentPath}/admin/api/kichthuoc`);
            updateListKichThuoc(listKichThuoc);

            // Hiển thị thông báo xóa thành công
            showThongBao(1, `Xóa Kích thước ID:${idKichThuoc} thành công!`);
        } else { // Xóa đối tượng KichThuoc thất bại
            showThongBao(0, `Xóa Kích thước ID:${idKichThuoc} thất bại!`);
        }
    });

    // Chức năng update KichThuoc
    $('.modal-chitietkichthuoc .btn-update-kichthuoc').on('click', function() {
        // Lấy dữ liệu
        let idKichThuoc = parseInt($(this).closest('.modal-chitietkichthuoc').find('#idkichthuoc-chinhsua').val());
        let tenKichThuoc = $(this).closest('.modal-chitietkichthuoc').find('#tenkichthuoc-chinhsua').val();
        let kyHieu = $(this).closest('.modal-chitietkichthuoc').find('#kyhieukichthuoc-chinhsua').val();
        let data = {idKichThuoc, tenKichThuoc, kyHieu};

        // Call API update dữ liệu
        let kichThuocObject = ajaxPut(`/${nameContentPath}/admin/api/kichthuoc`, data);

        // // Xuất thông báo lên giao diện
        $('.modal-chitietkichthuoc').find('.close').click();
        if (kichThuocObject !== null) { // update KichThuoc thành công
            // Update lại giao diện sau khi update
            let listKichThuoc = ajaxGet(`/${nameContentPath}/admin/api/kichthuoc`);
            updateListKichThuoc(listKichThuoc);

            // Hiển thị thông báo
            showThongBao(1, `Update Kích thước ID:${idKichThuoc} thành công!`)
        } else { // Update KichThuoc thất bại
            showThongBao(0, `Update Kích thước ID:${idKichThuoc} thất bại!`);
        }
    });

    // Update nội dung danh sách KichThuoc vào table Frontend
    function updateListKichThuoc(listKichThuoc) {
        let table = $('table tbody');
        let innerHTML = '';
        if (listKichThuoc.length != 0) {
            for (let kt of listKichThuoc) {
                innerHTML += `
                <tr>
                    <th scope="row" class="align-middle text-center id-kich-thuoc">${kt.idKichThuoc}</th>
                    <td class="align-middle ten-kich-thuoc">${kt.tenKichThuoc}</td>
                    <td class="align-middle text-center ky-hieu-kich-thuoc">${kt.kyHieu}</td>
                    <td class="align-middle w-25">
                        <button class="btn btn-primary w-100 py-1 view-chi-tiet-kich-thuoc" data-toggle="modal" data-target=".modal-chitietkichthuoc">
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
    }

    // Hàm có chức năng reset lại form Kích Thước - Thêm mới
    function resetFormKichThuocThemMoi() {
        $('.modal-themmoikichthuoc #tenkichthuoc-themmoi').val('');
        $('.modal-themmoikichthuoc #kyhieukichthuoc-themmoi').val('');
    }

    // Sự kiện khi close modal thêm kích thước mới
    $('.modal-themmoikichthuoc').on('hidden.bs.modal', function (e) {
        resetFormKichThuocThemMoi();
    });

    // set focus for name_input sau khi mở form modal-themmoikichthuoc
    $('.modal-themmoikichthuoc').on('shown.bs.modal', function(e){
        $(this).find('#tenkichthuoc-themmoi').focus();
    });
    /* ===================== Kết thúc xử lý page danh mục ==================*/

    /* ======================= Xử lý page danh mục =========================*/
    // Sự kiện change selection DanhMuc
    $('#id-select-danhmuc').on('change', function(e) {
        let idDanhMuc = parseInt($(this).val());
        let listSanPham = null;
        if (idDanhMuc == 0) { // lấy toàn bộ SanPham
            listSanPham = ajaxGet(`/${nameContentPath}/admin/api/sanpham`);
        } else { // lấy SanPham theo idDanhMuc
            listSanPham = ajaxGet(`/${nameContentPath}/admin/api/sanpham/theodanhmuc/${idDanhMuc}`);
        }
        updateListSanPham(listSanPham);
    });

    // Sự kiện tìm kiếm danh sách SanPham theo DanhMuc
    $('#btn-timkiem-sanpham').on('click', function() {
        let idDanhMuc = parseInt($('#id-select-danhmuc').val());
        let noiDung = $(this).closest('.input-group').find('input').val();

        if (noiDung !== '') {
            let listSanPham = ajaxGet(`/${nameContentPath}/admin/api/sanpham/find/${idDanhMuc}/${noiDung}`);
            updateListSanPham(listSanPham);
        }
    });

    // Update list SanPham lên giao diện table
    function updateListSanPham(listSanPham) {
        let table = $('table tbody');
        let innerHTML = '';
        if (listSanPham.length != 0) {
            for (let sp of listSanPham) {
                innerHTML += `
                    <tr>
                        <th scope="row" class="align-middle text-center">${sp.idSanPham}</th>
                        <td class="align-middle">${sp.tenSanPham}</td>
                        <td class="align-middle text-center">${sp.danhMuc.tenDanhMuc}</td>
                        <td class="p-1 align-middle">
                            <img src="/${nameContentPath}/api/getimages/${sp.listHinhAnh[0].tenHinhAnh}" height="60"/>
                            <img src="/${nameContentPath}/api/getimages/${sp.listHinhAnh[1].tenHinhAnh}" height="60"/>
                        </td>
                        <td class="align-middle">${sp.giaSanPham}đ</td>
                        <td class="align-middle text-center">${sp.gioiTinh}</td>`;

                if (sp.idKhuyenMai == null) {
                    innerHTML += `<td class="align-middle text-center"> </td>`;
                } else {
                    innerHTML += `<td class="align-middle text-center">${sp.idKhuyenMai}</td>`;
                }

                innerHTML += `
                    <td class="align-middle text-center">${sp.ngayNhap}</td>
                    <td class="p-1 align-middle">
                        <a class="btn btn-primary w-100 py-1" href="/${nameContentPath}/admin/sanpham/chitiet/${sp.idSanPham}">
                            Xem chi tiết
                            <i class="fas fa-chevron-circle-down"></i>
                        </a>
                    </td>
                </tr>`;
            };
        } else {
            innerHTML = `
                <tr>
                    <td colspan="9" class="text-center align-middle text-danger text-uppercase">
                        <h3 class="mb-0">Không có kết quả</h3>
                    </td>
                </tr>`;
        }
        table.html(innerHTML);
    }
    /* ===================== Kết thúc xử lý page sản phẩm ==================*/
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
};

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
};

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
};

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
};