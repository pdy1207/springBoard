getTitlAll();
getEmpAll(1);

//사원 수 평균급여 부서 수 보너스 합

function getTitlAll(){
    $.ajax({
        //url : 백엔드 주소
        url : 'http://localhost:8080/api/d1/emp',
        //type : 백엔드에 어떤걸 요청할지 타입을 정함.
        //GET:select POST:insert PATCH:update DELETE:delete
        type : 'GET',
        //dataType : 서버에서 return 하는 데이터 타입 지정 
        dataType : 'json',
        success : function(response){

            $('#studentsCnt').append(response.empCount); //사원수
            $('#boardCnt').append(response.empSalAvg); //사원 평균급여
            $('#writerCnt').append(response.deptCount); //부서 수
            $('#viewsCnt').append(response.empCommSum); //보너스 합
           
        }
    });
}

//사원 추가 

function getEmpInsert(){
    var empno = $('#i_empno').val();
    var ename = $('#i_ename').val();
    var job = $('#i_job').val();
    var sal = $('#i_sal').val();
    var comm = $('#i_comm').val();
    var deptno = $('#i_deptno').val();

    if(empno == ''){
        alert('사원 번호를 입력하세요')
        $('#i_empno').focus();
        return false;
    }
    if(ename == ''){
        alert('사원 이름을 입력하세요')
        $('#i_ename').focus();
        return false;
    }
    if(job == ''){
        alert('사원 직업을 입력하세요')
        $('#i_job').focus();
        return false;
    }
    if(sal == ''){
        alert('사원 급여를 입력하세요')
        $('#i_sal').focus();
        return false;
    }
    if(comm == ''){
        alert('사원 보너스를 입력하세요')
        $('#i_comm').focus();
        return false;
    }
    if(deptno == ''){
        alert('사원 부서번호를 입력하세요')
        $('#i_deptno').focus();
        return false;
    }

    var jsonData = {
        "empno" : empno,
        "ename" : ename,
        "job" : job,
        "sal" : sal,
        "comm" : comm,
        "deptno" : deptno
    };
    console.log(jsonData);
    $.ajax({
        url : 'http://localhost:8080/api/d1/emp',
        type : 'POST',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsonData),
        success : function(response){
            console.log(response);
        if(response > 0){
            alert("사원 등록");
            location.reload(); //자바 스크립트에서 제공해주는 새로 고침
        }
        else{
            alert("이미 가입되었습니다.");
        }
     
    }
    }); 
}
//전체 사원 조회하는 함수
function getEmpAll(pageNum){
    $.ajax({
        url : 'http://localhost:8080/api/d1/emppageall?page='+pageNum,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            $('#empData').empty(); //기존걸 지우고 업한다!! 
            $('.pagination').empty();
            console.log(response);
         //for문을 이용해서 배열 출력하기
         //배열하고 for문은 친구!!
         //response 배열
         var html = '';
         for(var i=0; i<response.list.length; i++){
            html += '<tr onclick="getEmpByEmpno('+response.list[i].empno+')"><td>'+response.list[i].empno+'</td><td>'+response.list[i].ename+'</td><td>'+response.list[i].job+'</td><td>'+response.list[i].sal+
            '</td><td>'+response.list[i].hiredate+'</td><td>'+response.list[i].dname+'</td></tr>'
        }
         $('#empData').append(html); //table 바인딩 작업!
         var paginationHtml ='';
         if(response.hasPreviousPage){ // 이전 버튼 여부 확인
            paginationHtml += '<a onclick="getEmpAll('+(pageNum-1)+')">Previous</a>';
         }
         for(var i=0; i<response.navigatepageNums.length; i++){ //총 보여줄 페이지
            var page = response.navigatepageNums[i];
            paginationHtml += '<a onclick="getEmpAll('+page+')">'+page+'</a>';
         }
         if(response.hasNextPage){//다음 버튼 여부 확인
            paginationHtml += '<a onclick="getEmpAll('+(pageNum+1)+')">Next</a>';
         }
         $('.pagination').append(paginationHtml); //페이지 바인딩 작업
        
        }  
         
    });
}

//클릭한 사원 번호는?

function getEmpByEmpno(empno){
    console.log('클릭한 사원 번호는 ? ' +empno);
    $.ajax({
      url : 'http://localhost:8080/api/d1/empall/'+empno,
      type : 'GET',
      dataType : 'json',
      success : function(response){
          console.log(response); 
          $('.update-popup').css('display','block');
          //데이터 바인딩
          $('#u_empno').val(response.empno);
          $('#u_ename').val(response.ename);
          $('#u_job').val(response.job);
          $('#u_sal').val(response.sal);
          $('#u_comm').val(response.comm);
          $('#u_deptno').val(response.deptno);
      }
  });
}

//사원 정보 수정(==insert)

function getEmpUpdate(){
    var empno = $('#u_empno').val();
    var ename = $('#u_ename').val();
    var job = $('#u_job').val();
    var sal = $('#u_sal').val();
    var comm = $('#u_comm').val();
    var deptno = $('#u_deptno').val();

    var jsonData = {
        "empno" : empno,
        "ename" : ename,
        "job" : job,
        "sal" : sal,
        "comm" : comm,
        "deptno" : deptno
    };
    $.ajax({
        url : 'http://localhost:8080/api/d1/emp',
        type : 'PATCH',
        contentType : 'application/json',
        dataType : 'json',
        data : JSON.stringify(jsonData),
        success : function(response){
            console.log(response);
        if(response > 0)
            alert("사원 수정 완료.");
            location.reload(); //자바 스크립트에서 제공해주는 새로 고침
        }
        
    }); 
}
//사원 삭제 
//데이터는 곧 자산 실제로 기업에서는 데이터를 삭제하지 않고,
// 삭제 여부 컬럼을 추가해서 타로티한 회원 Y 현재 회원 N로 관리한다.
function getEmpUseUpdate(){
    var empno = $('#u_empno').val();
    var ename = $('#u_ename').val();
    $.ajax({
        url : 'http://localhost:8080/api/d1/empall/empno/'+empno,
        type : 'PATCH',
        dataType : 'json',
        success : function(response){
        if(response > 0)
            alert(ename + " 삭제 되었습니다.");
            location.reload(); 
            //자바 스크립트에서 제공해주는 새로 고침
        }
        
    }); 
}
//엑셀 만드는 함수  
function downloadExcelFile(){
    console.log('excel downloaad!')
    location.href= 'http://localhost:8080/excel/download'
}