var confirmNo = true;

$(document).ready(function(){
    let heightScreen = $(window).height();
    let widthScreen = $(window).width();
 
    /* ===================================================================== */ 
    /* Khu vực sử lý sự kiện scroll */
    $(window).scroll(function(event) {
        let positionBody = $('html, body').scrollTop();

        // Sử lý cho thanh navbar 
        if (positionBody + 120 > heightScreen) {
            $('.header .header__box--image img')
                .attr(
                    {
                        'src': '/images/logo_bg_black.svg'
                    }
                );
            $('.header').addClass('header-bg-black');
        } else {
            $('.header .header__box--image img')
                .attr(
                    {
                        'src': '/images/logo_bg_white.svg'
                    }
                );
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


    // thực hiện code jquery
    $(".header .header-menu .menu-header-icon a").click(function(event) {
        $(".show-menu").removeClass("display-none");
        // $(".show-menu").find('.box-menu').css('background', 'linear-gradient(to right, white 50%, white 50%)');
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

    // hàng mới test
    $('.btn-hang-moi').on('click', function() {
        showFormConfirm('Bạn có chắc chắn muốn xóa?');
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
        parent.prev().html(content);
        parent.addClass('set-none-visible');

        // Sử lý tiếp Ajax
    });
    // Sự kiện cho button add
    $('.san-pham-item > .box-images > .bang-size > .ben-phai').on('click', function() {
        alert("Chọn thêm sản phẩm");
        // Sử lý tiếp Ajax
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
});

// hàm thông báo hiển thị thêm 1 sản phẩm mới vào giỏ hàng
function thongBaoThemSanPhamMoi() {
    $('.them-san-pham').removeClass('display-none');
    setTimeout(function() {
        $('.them-san-pham').addClass('display-none');
    }, 1300);
}

// type = 1 => thông báo thành công
// type = 0 => thông báo thất bại
function thongBao(type, noiDung) {
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