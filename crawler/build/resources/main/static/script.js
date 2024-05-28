$(function () {
    $("#startDate, #endDate").datepicker({
        dateFormat: 'yy-mm-dd',
        onSelect: function (dateText) {
            // 선택한 날짜를 콘솔에 출력
            console.log(dateText);
        }
    });

    $("#startCrawling").click(function () {
        performAction();
    });
});

function performAction() {
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();

    $.ajax({
        url: '/crawl',
        method: 'GET',
        success: function (response) {
            alert('크롤링을 시작합니다. 시작일: ' + startDate + ', 종료일: ' + endDate);
            console.log(response);
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
        }
    });
}

function updateOptions() {
    var option1Value = $("#option1").val();
    var option2Dropdown = $("#option2");

    // 두 번째 드롭다운 메뉴의 옵션을 초기화
    option2Dropdown.empty();

    // 선택된 첫 번째 드롭다운 메뉴의 값에 따라 두 번째 드롭다운 메뉴의 옵션을 동적으로 추가
    switch (option1Value) {
        case "정치":
            option2Dropdown.append('<option value="옵션1-1">대통령실</option>');
            option2Dropdown.append('<option value="옵션1-2">국회/정당</option>');
            option2Dropdown.append('<option value="옵션1-3">북한</option>');
            break;
        case "경제":
            option2Dropdown.append('<option value="옵션2-1">금융</option>');
            option2Dropdown.append('<option value="옵션2-2">증권</option>');
            option2Dropdown.append('<option value="옵션2-3">부동산</option>');
            break;
        // 이하 각 옵션에 대한 동적 추가
        // ...
        default:
            break;
    }
}
