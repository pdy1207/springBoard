getLogsAll(1);

function getLogsAll(pageNum){
    $.ajax({
        url: 'http://localhost:8080/api/d1/logs?page='+pageNum,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            $('#boardData').empty();
            $('.pagination').empty();
            console.log(response);
            var html = '';
            for(var i=0; i<response.list.length; i++){
                html += '<tr onclick="getPopup('+response.list[i].logId+')"><td>'+response.list[i].logId+'</td><td>'+response.list[i].ip+'</td><td>'+response.list[i].url
                +'</td><td>'+response.list[i].httpMethod+'</td><td>'+response.list[i].createAt+'</td></tr>'
            }
            $('#boardData').append(html);
            var paginationHtml ='';
            if(response.hasPreviousPage){ // 이전 버튼 여부 확인
               paginationHtml += '<a onclick="getLogsAll('+(pageNum-1)+')">Previous</a>';
            }
            for(var i=0; i<response.navigatepageNums.length; i++){ //총 보여줄 페이지
               var page = response.navigatepageNums[i];
               paginationHtml += '<a id="PageNum'+page+'" onclick="getLogsAll('+page+')">'+page+'</a>';
            }
            if(response.hasNextPage){//다음 버튼 여부 확인
               paginationHtml += '<a onclick="getLogsAll('+(pageNum+1)+')">Next</a>';
            }
            $('.pagination').append(paginationHtml); //페이지 바인딩 작업 
            $('#PageNum'+pageNum).css('backgroundColor','#46649B');
            $('#PageNum'+pageNum).css('color','#fff');
        }
    });
}
//로그함수 클릭하였을때..... + 카카오 맵

function getPopup(logId){
    $('.logs-popup').css('display', 'block');
    $('#map').empty();
    $.ajax({
        url : 'http://localhost:8080/api/d1/logs/'+logId,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response)
            //데이터 바인딩
            $('#ip').val(response.ip);
            $('#createAt').val(response.createAt);
        }
    });
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(36.3286904, 127.4229992), // 지도의 중심좌표 (DW 학원 기준)
            level: 4 // 지도의 확대 레벨
        };
    
    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    
    // 마커가 표시될 위치입니다
    var markerPosition  = new kakao.maps.LatLng(36.3286904, 127.4229992);
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    
    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
}