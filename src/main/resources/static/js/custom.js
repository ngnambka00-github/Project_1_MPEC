var nameContentPath = 'Project_1';
var confirmNo = true;
$(document).ready(function(){
    var heightScreen = $(window).height();
    var widthScreen = $(window).width();

    // upldate list danh mục của sản phẩm
    updateListDanhMuc();

    // Thực hiện cập nhập giỏ hàng nếu có
    firstLoadPageWithSessionGioHang();

    /* ===================================================================== */ 
    /* Khu vực sử lý sự kiện scroll */
    $(window).scroll(function(event) {
        let positionBody = $('html, body').scrollTop();

        // Sử lý cho thanh navbar 
        if (positionBody + 120 > heightScreen) {
            $('.header .header__box--image img')
                .attr(
                    {
                        'src': `/${nameContentPath}/images/logo_black.png`
                    }
                );
            $('.header').find('.box-shopping .so-luong').css('background', '#03a9f4');
            $('.header').addClass('header-bg-black');
        } else {
            $('.header .header__box--image img')
                .attr(
                    {
                        'src': `/${nameContentPath}/images/logo_white.png`
                    }
                );
            $('.header').find('.box-shopping .so-luong').css('background', '#f30e4d');
            $('.header').removeClass('header-bg-black');
        }

        // Sử lý cho button scroll to top
        if (positionBody > heightScreen * 1.2) {
            $('.scroll-to-top > .box-icon')
                .addClass('box-icon-show')
                .removeClass('box-icon-hide');

        } else {
            $('.scroll-to-top > .box-icon')
                .addClass('box-icon-hide')
                .removeClass('box-icon-show');

        }
    });

    $('.scroll-to-top > .box-icon').click(function(event) {
        $('html,body').animate(
            {
                scrollTop: 0
            }, 
            {
                duration: 1200, 
                fillMode: 'forwards', 
                complete: function(options) { }
            }
        );
    });
    /* Kết thúc xử lý sự kiện liên quan đến scroll */
    /* ===================================================================== */ 

    /* Thực hiện click vào icon-logo cửa hàng */
    $('.header .header__box--image img').on('click', function() {
        window.location.href = `/${nameContentPath}/`;
    });
    /* Kết thúc hiện click vào icon-logo cửa hàng */

    // thực hiện code jquery
    $(".header .header-menu .menu-header-icon a").click(function(event) {
        $(".show-menu").removeClass("display-none");
        $(".show-menu").find('.box-menu').addClass('change-background-color');
        event.preventDefault();
    });

    $('body').on('click', '.show-menu', function(event) {
        if ($(event.target).hasClass('show-menu')) {
            $(".show-menu").addClass("display-none");     
            $(".show-menu").find('.box-menu').removeClass('change-background-color');
        }
    });

    // Tạo sự kiện click cho button giỏ hàng
    $('.header .header_search .box-shopping .fa-shopping-cart').click(function() {
        $('.show-gio-hang').removeClass('display-none');
    });
    // Tạo sự kiện đóng tab giỏ hàng
    $('.close-gio-hang').click(function() {
        $('.show-gio-hang').addClass('display-none');
    });
    $('body').on('click', '.show-gio-hang', function(event) {
        if ($(event.target).hasClass('show-gio-hang')) {
            $(".show-gio-hang").addClass("display-none");     
        }
    });


    /* ===================================================================== */ 
    /* Các sự kiện cho phần đăng nhập user */ 
    $('.header .header_search .box-user .fa-user').click(function() {
        $('.show-dang-nhap').removeClass('display-none');
        console.log("fdsaf");
    });
    // Tạo sự kiện đóng tab close đăng nhập
    $('.close-dang-nhap').click(function() {
        $('.show-dang-nhap').addClass('display-none');
    });
    $('body').on('click', '.show-dang-nhap', function(event) {
        if ($(event.target).hasClass('show-dang-nhap')) {
            $(".show-dang-nhap").addClass("display-none");     
        }
    });
    // Chuyển sang form đăng ký 
    $('.show-dang-nhap > .content-dang-nhap > .form-content > .kind-button > .btn-dang-ky').click(function() {
        $(".show-dang-nhap").addClass("display-none");     
        $(".show-dang-ky").removeClass("display-none");     
    });
    /* Kết thúc phần các sự kiện cho phần đăng nhập user */ 
    /* ===================================================================== */ 



    /* ===================================================================== */ 
    /* Tạo các sự kiện cho phần đăng ký User */
    $('body').on('click', '.show-dang-ky', function(event) {
        if ($(event.target).hasClass('show-dang-ky')) {
            $('.show-dang-ky').addClass('display-none');
        }
    });
    // Tạo sự kiện đóng tab close đăng ký 
    $('.close-dang-ky').click(function() {
        $('.show-dang-ky').addClass('display-none');
    });
    // Chuyển sang form đăng nhập
    $(`.show-dang-ky > .content-dang-ky > .form-content > .kind-button > .btn-dang-nhap, 
        .show-dang-ky > .content-dang-ky > .title-dang-ky span.span-title > .previous-dang-nhap`).click(function() {
        $(".show-dang-nhap").removeClass("display-none");     
        $(".show-dang-ky").addClass("display-none");           
    });
    /* Kết thúc phần tạo sự kiện cho đăng ký User mới */ 
    /* ===================================================================== */ 



    /* ===================================================================== */ 
    // Hiệu ứng slide cho phần quảng cáo giảm giá 
    var timeNextSlide = 5000;
    // Thực hiện cho slide quảng cáo các chương trình khuyến mãi chạy tự động nếu không thao tác gì
    function nextSlideAuto() {
        let buttonNext = $('.slide-giam-gia .button-dieu-huong > .next');
        // Ngăn vừa việc click quá nhiều cùng 1 lúc
        buttonNext.addClass('no-click');

        // Lấy vị trí của slide hiện tại 
        let indexSlideCurrent = $('.slide-giam-gia .danh-sach-slide .slide.active').index() + 1; 

        // Tìm slide đang có active 
        // -> biến mất thẻ hiện tại sang trái 
        // -> xuất hiện thẻ kế tiếp sang trái
        let slideTiepTheo = $('.slide-giam-gia .danh-sach-slide .slide.active').next();

        // Nễu có slide tiếp theo thì next
        // Không có thì trả về cái đầu tiên
        if (slideTiepTheo.length) {
            // Active cho phím chuyển slide ở dưới bottom 
            $('.slide-giam-gia .button-dieu-huong > .bottom > li')
                .removeClass('active-button-slide');
            $(`.slide-giam-gia .button-dieu-huong > .bottom > li:nth-child(${indexSlideCurrent + 1})`)
                .addClass('active-button-slide');

            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-trai');
                })

            slideTiepTheo
                .addClass('active')
                .addClass('xuat-hien-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-trai');

                    // Khi kết thúc animation thì mới cho click tiếp 
                    buttonNext.removeClass('no-click');
                });
                
            
        } else {
            // Active cho phím chuyển slide ở dưới bottom 
            $('.slide-giam-gia .button-dieu-huong > .bottom > li')
                .removeClass('active-button-slide');
            $(`.slide-giam-gia .button-dieu-huong > .bottom > li:first-child`)
                .addClass('active-button-slide');

            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-trai');
                });

            $('.slide-giam-gia .danh-sach-slide .slide:first-child')
                .addClass('active')
                .addClass('xuat-hien-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-trai');

                    // Khi kết thúc animation thì mới cho click tiếp 
                    buttonNext.removeClass('no-click');
                });
        }
    }

    var handelInterval = setInterval(nextSlideAuto, timeNextSlide);

    // Hiệu ứng next
    $('.slide-giam-gia .button-dieu-huong > .next').click(function() {
        clearInterval(handelInterval);

        let buttonNext = $(this);
        // Ngăn vừa việc click quá nhiều cùng 1 lúc
        buttonNext.addClass('no-click');

        // Lấy vị trí của slide hiện tại 
        let indexSlideCurrent = $('.slide-giam-gia .danh-sach-slide .slide.active').index() + 1; 

        // Tìm slide đang có active 
        // -> biến mất thẻ hiện tại sang trái 
        // -> xuất hiện thẻ kế tiếp sang trái
        let slideTiepTheo = $('.slide-giam-gia .danh-sach-slide .slide.active').next();

        // Nễu có slide tiếp theo thì next
        // Không có thì trả về cái đầu tiên
        if (slideTiepTheo.length) {
            // Active cho phím chuyển slide ở dưới bottom 
            $('.slide-giam-gia .button-dieu-huong > .bottom > li')
                .removeClass('active-button-slide');
            $(`.slide-giam-gia .button-dieu-huong > .bottom > li:nth-child(${indexSlideCurrent + 1})`)
                .addClass('active-button-slide');

            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-trai');
                })

            slideTiepTheo
                .addClass('active')
                .addClass('xuat-hien-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-trai');

                    // Khi kết thúc animation thì mới cho click tiếp 
                    buttonNext.removeClass('no-click');
                    handelInterval = setInterval(nextSlideAuto, timeNextSlide);
                });
                
            
        } else {
            // Active cho phím chuyển slide ở dưới bottom 
            $('.slide-giam-gia .button-dieu-huong > .bottom > li')
                .removeClass('active-button-slide');
            $(`.slide-giam-gia .button-dieu-huong > .bottom > li:first-child`)
                .addClass('active-button-slide');

            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-trai');
                });

            $('.slide-giam-gia .danh-sach-slide .slide:first-child')
                .addClass('active')
                .addClass('xuat-hien-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-trai');

                    // Khi kết thúc animation thì mới cho click tiếp 
                    buttonNext.removeClass('no-click');
                    handelInterval = setInterval(nextSlideAuto, timeNextSlide);
                });
        }
    });


    // Hiệu ứng previous
    $('.slide-giam-gia .button-dieu-huong > .previous').on('click', function() {
        clearInterval(handelInterval);

        let buttonPrevious = $(this);
        // Ngăn vừa việc click quá nhiều cùng 1 lúc
        buttonPrevious.addClass('no-click');

        // Lấy vị trí của slide hiện tại 
        let indexSlideCurrent = $('.slide-giam-gia .danh-sach-slide .slide.active').index() + 1; 

        // Tìm slide đang có active 
        // -> biến mất thẻ hiện tại sang trái 
        // -> xuất hiện thẻ kế tiếp sang trái
        let slideTiepTheo = $('.slide-giam-gia .danh-sach-slide .slide.active').prev();

        // Nễu có slide tiếp theo thì next
        // Không có thì trả về cái đầu tiên
        if (slideTiepTheo.length) {
            // Active cho phím chuyển slide ở dưới bottom 
            $('.slide-giam-gia .button-dieu-huong > .bottom > li')
                .removeClass('active-button-slide');
            $(`.slide-giam-gia .button-dieu-huong > .bottom > li:nth-child(${indexSlideCurrent - 1})`)
                .addClass('active-button-slide');

            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-phai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-phai');
                });

            slideTiepTheo
                .addClass('active')
                .addClass('xuat-hien-sang-phai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-phai');

                    // Khi kết thúc animation thì mới cho click tiếp 
                    buttonPrevious.removeClass('no-click');
                    handelInterval = setInterval(nextSlideAuto, timeNextSlide);
                });
                
            
        } else {
            // Active cho phím chuyển slide ở dưới bottom 
            $('.slide-giam-gia .button-dieu-huong > .bottom > li')
                .removeClass('active-button-slide');
            $(`.slide-giam-gia .button-dieu-huong > .bottom > li:last-child`)
                .addClass('active-button-slide');

            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-phai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-phai');
                });

            $('.slide-giam-gia .danh-sach-slide .slide:last-child')
                .addClass('active')
                .addClass('xuat-hien-sang-phai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-phai');

                    // Khi kết thúc animation thì mới cho click tiếp 
                    buttonPrevious.removeClass('no-click');
                    handelInterval = setInterval(nextSlideAuto, timeNextSlide);
                });
        }
    });


    // sự kiện click vào các button chấm tròn ở dưới slide quảng cáo 
    $('.slide-giam-gia .button-dieu-huong > .bottom > li').click(function() {
        clearInterval(handelInterval); 

        let indexButtonClick = $(this).index();
        let currentSlide = $('.slide-giam-gia .danh-sach-slide .slide.active').index();
        
        // Active cho button ở bottom chả slide
        $('.slide-giam-gia .button-dieu-huong > .bottom > li')
            .removeClass('active-button-slide');
        $(`.slide-giam-gia .button-dieu-huong > .bottom > li:nth-child(${indexButtonClick + 1})`)
            .addClass('active-button-slide');    

        // chạy slide theo hướng của button next
        if (indexButtonClick > currentSlide) {
            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-trai');
                });

            $(`.slide-giam-gia .danh-sach-slide .slide:nth-child(${indexButtonClick + 1})`)
                .addClass('active')
                .addClass('xuat-hien-sang-trai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-trai');
                    handelInterval = setInterval(nextSlideAuto, timeNextSlide);
                });;

        } 
        // Chạy slide theo hướng của buton previous
        else if (indexButtonClick < currentSlide) {
            $('.slide-giam-gia .danh-sach-slide .slide.active')
                .addClass('bien-mat-sang-phai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('active')
                        .removeClass('bien-mat-sang-phai');
                });

            $(`.slide-giam-gia .danh-sach-slide .slide:nth-child(${indexButtonClick + 1})`)
                .addClass('active')
                .addClass('xuat-hien-sang-phai')
                .one('webkitAnimationEnd', function() {
                    $(this).removeClass('xuat-hien-sang-phai');
                    handelInterval = setInterval(nextSlideAuto, timeNextSlide);
                });;
        }
    });
    // Kết thúc phần tạo hiệu ứng slide cho quảng cáo giảm giá 
    /* ===================================================== */ 



    /* ===================================================== */ 
    /* Javascript cho phần sản phẩm bán chay */

    // => Phần chọn vào item để xem chi tiết sản phẩm
    $(`.san-pham-item > .san-pham-detail > .danh-sach-mau-sac, 
        .san-pham-item > .box-images > .bang-size`).click(function(event) {
        event.preventDefault();
    });
    // Sự kiện change color của từng sản phẩm
    $('.san-pham-item > .san-pham-detail > .danh-sach-mau-sac > .mau-sac-detail').on('click',function(event) {
        // Xử lý hiển thị 
        event.preventDefault();
        let nodeParent = $(this)
            .closest('.danh-sach-mau-sac');
        nodeParent.find('.mau-sac-detail').removeClass('active-border-color');
        $(this).addClass('active-border-color');

        // Xử lý Ajax
        let idSanPham = $(this).attr('data-id-san-pham');
        let idMauSac = $(this).attr('data-id-mau-sac');

        let boxImage1 = $(this).closest('.san-pham-detail')
            .prev().find('.box-image').first().find('img');
        let boxImage2 = $(this).closest('.san-pham-detail')
            .prev().find('.box-image').last().find('img');
        let boxSizes = $(this).closest('.san-pham-detail').prev().find('.bang-chon-size');

        let objectColor = ajaxGet(`/${nameContentPath}/api/thongtin_sp/${idSanPham}/${idMauSac}`);

        if (objectColor != null) {
            boxImage1.attr({
                'src': `/${nameContentPath}${objectColor.listHinhAnh[0].imagePath}`
            });
            boxImage2.attr({
                'src': `/${nameContentPath}${objectColor.listHinhAnh[1].imagePath}`
            });

            let innerKichThuoc = '';
            for (let kt of objectColor.listKichThuoc) {
                if (kt.soLuong != 0) {
                    innerKichThuoc += `<span data-id-kich-thuoc="${kt.idKichThuoc}">${kt.kyHieu}</span>`
                }
            }
            boxSizes.html(innerKichThuoc);
        }
    });
    // Sự kiện cho sự thay đổi lựa chọn tên size của sản phẩm 
    $('.san-pham-item > .box-images > .bang-size > .ben-trai').on('mouseover', function() {
        $(this).find('.bang-chon-size').removeClass('set-none-visible');
    });
    $('.san-pham-item > .box-images > .bang-size > .ben-trai').on('mouseout', function() {
        $(this).find('.bang-chon-size').addClass('set-none-visible');
    });
    $('.san-pham-item > .box-images > .bang-size > .ben-trai .bang-chon-size  span').on('click', function(){
        let parent = $(this).parent();
        let content = $(this).text();
        let idKichThuoc = $(this).attr('data-id-kich-thuoc');

        parent.prev().html(content);
        parent.prev().attr('data-id-kich-thuoc', idKichThuoc);
        parent.addClass('set-none-visible');
    });

    // Sự kiện cho button add
    $('.san-pham-item > .box-images > .bang-size > .ben-phai').on('click', function() {
        // Tìm các thông tin về idSanPham / idMauSac / idKichThuoc
        let idSanPham = $(this).closest('.san-pham-item')
                                .find('.danh-sach-mau-sac .mau-sac-detail.active-border-color')
                                .attr('data-id-san-pham');
        let idMauSac = $(this).closest('.san-pham-item')
                                .find('.danh-sach-mau-sac .mau-sac-detail.active-border-color')
                                .attr('data-id-mau-sac');;
        let idKichThuoc = $(this).closest('.san-pham-item').find('.chon-size').attr('data-id-kich-thuoc');

        if (idKichThuoc === undefined) {
            showThongBao(0, 'Vui lòng chọn "Kích thước"!');
            return;
        }

        // Lấy đối tượng chiTietSanPham
        let chiTietSP = ajaxGet(`/${nameContentPath}/api/chitietsanpham/${idSanPham}/${idMauSac}/${idKichThuoc}`);

        // Hiển thị thông báo
        showThongBaoThemSanPhamMoi(chiTietSP);

        // Thêm mới vào giỏ hàng và session
        let idChiTietSanPham = chiTietSP.idChiTietSanPham;
        let gioHang = ajaxGet(`/${nameContentPath}/api/savesession/${idChiTietSanPham}`);
        updateGioHang(gioHang);
    });


    // Sự kiện cho việc click vào next và previous cho phần sản phẩm bán chạy nhất
    var indexCurrentSPBanChay = 1;
    function nextSanPhamInterval() {
        let count = $('.wrapper-danh-sach > .danh-sach-san-pham > .wrap-inner > .san-pham-item').length;

        if (indexCurrentSPBanChay >= count) {
            indexCurrentSPBanChay = 0;
        }

        $(".wrapper-danh-sach > .danh-sach-san-pham > .wrap-inner")
            .animate(
                {
                    left: `-${ 22 * indexCurrentSPBanChay }vw`
                }, 
                { 
                    duration: 500, 
                    fillMode: 'forwards', 
                    complete: function(options){ }
                }
            );
        indexCurrentSPBanChay += 1;
    }

    var handelAutoNextSanPham = setInterval(nextSanPhamInterval, 3000);

    $('.wrapper-danh-sach > .dieu-huong > .left').click(function() {
        clearInterval(handelAutoNextSanPham);

        let buttonLeft = $(this);
        buttonLeft.addClass('no-click');

        let count = $('.wrapper-danh-sach > .danh-sach-san-pham > .wrap-inner > .san-pham-item').length;
        indexCurrentSPBanChay -= 1;
        if (indexCurrentSPBanChay <= 1) {
            indexCurrentSPBanChay = 1;
        }

        $(".wrapper-danh-sach > .danh-sach-san-pham > .wrap-inner")
            .animate(
                {
                    left: `-${ (indexCurrentSPBanChay - 1) * 22}vw`
                }, 
                {
                    duration: 500, 
                    filMode: 'forwards', 
                    complete: function(options) {
                        handelAutoNextSanPham = setInterval(nextSanPhamInterval, 3000);
                        buttonLeft.removeClass('no-click');
                    }
                }
            );
    });
    $('.wrapper-danh-sach > .dieu-huong > .right').on('click', function() {
        clearInterval(handelAutoNextSanPham);

        let buttonRight = $(this);
        buttonRight.addClass('no-click');

        let count = $('.wrapper-danh-sach > .danh-sach-san-pham > .wrap-inner > .san-pham-item').length;

        if (indexCurrentSPBanChay >= count) {
            indexCurrentSPBanChay = count - 1;
        }

        $(".wrapper-danh-sach > .danh-sach-san-pham > .wrap-inner")
            .animate(
                {
                    left: `-${ 22 * indexCurrentSPBanChay }vw`
                }, 
                {
                    duration: 500, 
                    fillMode: 'forwards', 
                    complete: function(options) {
                        handelAutoNextSanPham = setInterval(nextSanPhamInterval, 3000);
                        buttonRight.removeClass('no-click');
                    }
                }
            );
        indexCurrentSPBanChay += 1;
    });


    // Sự kiện cho việc click vào next và previous cho phần sản phẩm đã xem
    var indexCurrentSPDaXem = 1;
    $('.san-pham-da-xem > .dieu-huong > .left').click(function() {
        let buttonLeft = $(this);
        buttonLeft.addClass('no-click');

        let count = $('.san-pham-da-xem > .danh-sach-san-pham > .wrap-inner > .san-pham-item').length;
        indexCurrentSPDaXem -= 1;

        if (indexCurrentSPDaXem <= 1) {
            indexCurrentSPDaXem = 1;
        }

        $(".san-pham-da-xem> .danh-sach-san-pham > .wrap-inner")
            .animate(
                {
                    left: `-${ (indexCurrentSPDaXem - 1) * 22 }vw`
                }, 
                {
                    duration: 500, 
                    filMode: 'forwards', 
                    complete: function(options) {
                        buttonLeft.removeClass('no-click');
                    }
                }
            );
    });
    $('.san-pham-da-xem > .dieu-huong > .right').on('click', function() {
        let buttonRight = $(this);
        buttonRight.addClass('no-click');

        let count = $('.san-pham-da-xem > .danh-sach-san-pham > .wrap-inner > .san-pham-item').length;

        if (indexCurrentSPDaXem >= count) {
            indexCurrentSPDaXem = count - 1;
        }

        $(".san-pham-da-xem > .danh-sach-san-pham > .wrap-inner")
            .animate(
                {
                    left: `-${ 22 * indexCurrentSPDaXem }vw`
                }, 
                {
                    duration: 500, 
                    fillMode: 'forwards', 
                    complete: function(options) {
                        buttonRight.removeClass('no-click');
                    }
                }
            );
        indexCurrentSPDaXem += 1;
    });
    /* Kết thúc phần javascipt cho phẩn sản phẩm bán chạy */ 
    /* ===================================================== */


    /* ===================================================== */
    /* Javascipt cho phần chi tiết sản phẩm */  
    // Chọn từng kích thước sản phẩm
    $('body').on('click', '.detail-item .detail-item-size .item-size', function() {
        $('.detail-item .detail-item-size .item-size').removeClass('active-border');
        $(this).addClass('active-border');

        // Xử lý Ajax
    });

    // Chọn màu cho từng sản phẩm
    $('.detail-item .detail-item-common .box-image img').on('click', function() {
        $('.detail-item .detail-item-common .box-image img').removeClass('active-border');
        $(this).addClass('active-border');

        // Xử lý Ajax
        let idSanPham = $(this).attr('data-id-san-pham');
        let idMauSac = $(this).attr('data-id-mau-sac');

        let boxImages = $(this).closest('.detail-item').prev();
        let boxSizes = $(this).closest('.detail-item').find('.detail-item-size');

        let objectColor = ajaxGet(`/${nameContentPath}/api/thongtin_sp/${idSanPham}/${idMauSac}`);
        if (objectColor != null) {
            let htmlBoxImages = '';
            for (let ha of objectColor.listHinhAnh) {
                htmlBoxImages += `
                        <div class="box-image">
                            <img src="/${nameContentPath}${ha.imagePath}" alt="" class="image">
                        </div>`;
            }
            boxImages.html(htmlBoxImages);

            let htmlBoxSizes = '';
            let checkActiveBorder = false;
            for (let kt of objectColor.listKichThuoc) {
                if (kt.soLuong == 0) {
                    htmlBoxSizes += `
                        <button class="item-size none-pointer" data-id-kich-thuoc="${kt.idKichThuoc}">${kt.kyHieu}</button>`;
                } else {
                    if (!checkActiveBorder) {
                        htmlBoxSizes += `
                            <button class="item-size active-border" data-id-kich-thuoc="${kt.idKichThuoc}">${kt.kyHieu}</button>`;
                        checkActiveBorder = true;
                    } else {
                        htmlBoxSizes += `
                            <button class="item-size" data-id-kich-thuoc="${kt.idKichThuoc}">${kt.kyHieu}</button>`;
                    }
                }
            }
            boxSizes.html(htmlBoxSizes);
        }
    });

    // Thêm sản phẩm vào giỏ hàng
    $('.btn-themsanpham-gioihang').on('click', function() {
        // Lấy ra màu sắc và kích thước được chọn
        let imageTag = $(this).closest('.detail-item').find('img.active-border');
        let sizeTag = $(this).closest('.detail-item').find('button.item-size.active-border');

        // Lấy idSanPham / idMauSac / idKichThuoc
        let idSanPham = parseInt(imageTag.attr('data-id-san-pham'));
        let idMauSac = parseInt(imageTag.attr('data-id-mau-sac'));
        let idKichThuoc = parseInt(sizeTag.attr('data-id-kich-thuoc'));

        // Lấy đối tượng chiTietSanPham
        let chiTietSP = ajaxGet(`/${nameContentPath}/api/chitietsanpham/${idSanPham}/${idMauSac}/${idKichThuoc}`);

        // Hiển thị thông báo
        showThongBaoThemSanPhamMoi(chiTietSP);

        // Thêm mới vào giỏ hàng và session
        let idChiTietSanPham = chiTietSP.idChiTietSanPham;
        let gioHang = ajaxGet(`/${nameContentPath}/api/savesession/${idChiTietSanPham}`);
        updateGioHang(gioHang);
    });

    // Xóa 1 sản phẩm khỏi giỏi hàng
    $('body').on('click', '.show-gio-hang .item-san-pham .delete', function() {
        let idChiTietSanPham = $(this).closest('.item-san-pham').attr('data-id-chi-tiet-san-pham');
        let listGioHang = ajaxGet(`/${nameContentPath}/api/customsession/${idChiTietSanPham}/1`);
        updateGioHang(listGioHang);
    });

    // Tăng số lượng
    $('body').on('click', '.show-gio-hang .item-san-pham .so-luong .tang-so-luong', function() {
        let idChiTietSanPham = $(this).closest('.item-san-pham').attr('data-id-chi-tiet-san-pham');
        let listGioHang = ajaxGet(`/${nameContentPath}/api/customsession/${idChiTietSanPham}/2`);
        updateGioHang(listGioHang);
    });

    // Giảm số lượng
    $('body').on('click', '.show-gio-hang .item-san-pham .so-luong .giam-so-luong', function() {
        // Kiểm tra số lượng sản phẩm hiện tại
        let soLuong = parseInt($(this).next().text());
        if (soLuong == 1) {
            return;
        }
        let idChiTietSanPham = $(this).closest('.item-san-pham').attr('data-id-chi-tiet-san-pham');
        let listGioHang = ajaxGet(`/${nameContentPath}/api/customsession/${idChiTietSanPham}/3`);
        updateGioHang(listGioHang);
    });

    /* Kết thúc phần javascipt cho phần chi tiết sản phẩm */
    /* ===================================================== */


    /* ===================================================== */
    /* Sự kiện cho các phần thông báo */
    // hàng mới test
    $('.btn-hang-moi').on('click', function() {
        showThongBaoThemSanPhamMoi();
    });
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

// Load giỏ hàng khi load lại page => Nếu giỏ hàng có sản phẩm
function firstLoadPageWithSessionGioHang() {
    let gioHang = ajaxGet(`/${nameContentPath}/api/getsessiongiohang`);
    updateGioHang(gioHang);
}

// Update thông tin của giỏ hàng
function updateGioHang(listGioHang) {
    let danhSachGioHang = $('.show-gio-hang').find('.danh-sach-gio-hang');
    let tongTienTag = $('.show-gio-hang').find('.tong-tien span:nth-child(2)');
    let titleGioHangTag = $('.show-gio-hang').find('.title-gioi-hang .span-title');

    if (listGioHang == null) {
        danhSachGioHang.html('');
        tongTienTag.html('0đ');
        titleGioHangTag.html('giỏ hàng (0)');
        $('.show-gio-hang').find('.submit-dat-hang').addClass('none-event');

        // icon thông báo hiện số lượng sản phẩm trong giỏ hàng
        $('.header').find('.box-shopping .so-luong').addClass('display-none');
        return;
    }

    $('.show-gio-hang').find('.submit-dat-hang').removeClass('none-event');
    let tongTien = 0;
    let tongSoLuongSanPham = 0;

    // Update frontend list giỏ hang
    let innerItemGioHangText = '';
    for (let gh of listGioHang) {
        tongTien += gh.chiTietSanPham.sanPham.giaSanPham * gh.soLuong;
        tongSoLuongSanPham += gh.soLuong;

        innerItemGioHangText += `
            <div class="item-san-pham" data-id-chi-tiet-san-pham="${gh.chiTietSanPham.idChiTietSanPham}">
                <div class="item-san-pham-img">
                    <img src="/${nameContentPath}/getimages/images/mau_san_pham/${gh.chiTietSanPham.sanPham.listHinhAnh[0].tenHinhAnh}" alt="">
                </div>
                <div class="item-content">
                    <a class="title-san-pham" href="/${nameContentPath}/sanpham/chitiet/${gh.chiTietSanPham.sanPham.idSanPham}">${gh.chiTietSanPham.sanPham.tenSanPham.toUpperCase()}</a>
                    <span class="ma-san-pham">Mã: SP${gh.chiTietSanPham.sanPham.idSanPham}</span>
                    <div class="option-san-pham">
                        <div class="mau-sac" style="background: ${gh.chiTietSanPham.mauSac.maMau}"></div>
                        <div class="size-san-pham">${gh.chiTietSanPham.kichThuoc.kyHieu}</div>
                        <div class="so-luong">
                            <span class="giam-so-luong">-</span>
                            <span class="so-luong-thuc">${gh.soLuong}</span>
                            <span class="tang-so-luong">+</span>
                        </div>
                    </div>

                    <div class="delete-price">
                        <span class="delete"><i class="far fa-trash-alt"></i></span>
                        <span class="total-money">${formatTienTe(gh.chiTietSanPham.sanPham.giaSanPham, 0)}đ</span>
                    </div>

                    <div class="discount-price">
                        <span class="discount">
                            <i class="fas fa-tag"></i>
                            <i class="text-giam-gia">Giảm giá</i>
                        </span>
                        <span class="total-money">000,000đ</span>
                    </div>
                </div>
            </div>`;
    }
    $('.header').find('.box-shopping .so-luong').text(tongSoLuongSanPham);
    $('.header').find('.box-shopping .so-luong').removeClass('display-none');

    titleGioHangTag.html(`Giỏ hàng (${tongSoLuongSanPham})`);
    danhSachGioHang.html(innerItemGioHangText);
    tongTienTag.html(`${formatTienTe(tongTien, 0)}đ`);
}

// Sự kiện update toàn bộ danh mục của sản phẩm
function updateListDanhMuc() {
    let danhMuc = $('.danh-muc-chi-tiet');
    let objectDanhMuc = ajaxGet(`/${nameContentPath}/api/listdanhmuc`);
    if (objectDanhMuc != null) {
        let htmlDanhMuc = ``;
        for (let dm of objectDanhMuc) {
            htmlDanhMuc += `
                    <li>
                        <a href="/${nameContentPath}/sanpham/danhmuc/${dm.idDanhMuc}" class="change-color-animate">${dm.tenDanhMuc}</a>
                    </li>`;
        }
        danhMuc.html(htmlDanhMuc);
    }
}

// hàm thông báo hiển thị thêm 1 sản phẩm mới vào giỏ hàng
function showThongBaoThemSanPhamMoi(chiTietSP) {
    let sanPhamObj = chiTietSP.sanPham;
    let mauSacObj = chiTietSP.mauSac;
    let kichThuocObj = chiTietSP.kichThuoc;
    let listHinhAnh = sanPhamObj.listHinhAnh;

    // // Update thông tin lên frontend => thông báo
    $('.them-san-pham').find('.item-content .title-san-pham').text(sanPhamObj.tenSanPham.toUpperCase());
    $('.them-san-pham').find('.item-content .ma-san-pham').text(`Mã sản phẩm: SP${sanPhamObj.idSanPham}`);
    $('.them-san-pham').find('.item-content .mau-san-pham').text(`Màu: ${mauSacObj.tenMauSac}`);
    $('.them-san-pham').find('.item-content .size-san-pham').text(`Size: ${kichThuocObj.kyHieu}`);
    $('.them-san-pham').find('.item-content .total-money').text(`Giá tiền: ${sanPhamObj.giaSanPham}đ`);
    $('.them-san-pham').find('.item-san-pham-img img').attr('src', `/${nameContentPath}/getimages/images/mau_san_pham/${listHinhAnh[0].tenHinhAnh}`);

    $('.them-san-pham').removeClass('display-none');
    setTimeout(function() {
        $('.them-san-pham').addClass('display-none');
    }, 1300);
}

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
            if (typeof(value) == 'string') {
                value = JSON.parse(value);
            }
            result = value;
        }
    });
    return result;
};

// Hàm định dạng tiền tệ
function formatTienTe(num, numFixed) {
    return num.toFixed(numFixed).replace(/./g, function(c, i, a) {
        return i > 0 && c !== "." && (a.length - i) % 3 === 0 ? "," + c : c;
    });
}