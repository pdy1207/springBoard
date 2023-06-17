# 🖥 API !


<details>
   <summary> 
     <h2>GET</h2> 
  </summary>
  
  - /api/d1/emp 
  
        : 사원 수 / 평균 급여/ 부서 수 / 보너스 합
  
  - /api/d1/emp 
  
        : 사원 수 / 평균 급여/ 부서 수 / 보너스 합
    
  - /emppageall?page=+pageNum 
  
        : 전체 사원 조회 
    
  - /api/d1/empall/+empno 
  
        : 선택한 사원 번호
    
  - /api/d1/deptpage?page=+pageNum 
  
        : 부서 전체
    
  - /api/d1/dept/+deptno 
  
        : 선택한 부서
    
  - /api/d1/logs?page=+pageNum 
  
        : 접속자 히스토리
    
  - /api/d1/logs/+logId 
  
        : 선택한 접속자
</details>

<details>
   <summary> 
     <h2>POST</h2> 
  </summary>

 - /api/d1/emp 
  
        : 사원 추가

 - /api/d1/dept 
  
        : 부서 추가
  
</details>
    
<details>
   <summary> 
     <h2>PATCH</h2> 
  </summary>
  
  - /api/d1/emp 
  
          : 사원 정보 수정

  - /api/d1/dept 
  
          : 부서 수정

  - /api/d1/empall/empno/+empno 
  
            : 사원 삭제   
  
  - /api/d1/dept/+deptno 
  
            : 부서 삭제

        데이터는 곧 자산 그러므로 데이터를 삭제하지 않고,
        삭제 여부 컬럼을 추가해서 탈퇴한 회원 Y 현재 회원 N로 관리한다.
  
</details>

