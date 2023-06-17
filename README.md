# 🖥 API 명세서

[EMP정보체계_기능명세서_개발일정관리.xlsx](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e353af16-8e48-4020-99ea-7f3003637054/EMP%EC%A0%95%EB%B3%B4%EC%B2%B4%EA%B3%84_%EA%B8%B0%EB%8A%A5%EB%AA%85%EC%84%B8%EC%84%9C_%EA%B0%9C%EB%B0%9C%EC%9D%BC%EC%A0%95%EA%B4%80%EB%A6%AC.xlsx)

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

