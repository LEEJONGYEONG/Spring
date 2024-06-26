package com.oracle.team2.service.DY_Service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DY_Paging {
   private int currentPage = 1; private int rowPage = 30; // 화면에 보여줄 갯 수
   private int pageBlock = 10;
   private int start; private int end;
   private int startPage; private int endPage;
   private int total; private int totalPage;
   
   public DY_Paging(int total, String currentPage1) {
      this.total = total;   // 총 게시글 수
      if(currentPage1 != null) {   // 첫 시작시 null로 오기 때문에 초기값인 1로 유지
         this.currentPage = Integer.parseInt(currentPage1);
      }
      // 총 페이지 수
      totalPage = (int) Math.ceil((double)total / rowPage);        // 시작시 3
      if(this.currentPage>totalPage) {
         this.currentPage = totalPage;
      }
      
      // rowPage는 화면에 가져올 페이지 수
      start = (currentPage - 1) * rowPage +1; // 시작시 1   11 ...
      end = start + rowPage -1;               // 시작시 10   20 ...
      if(end > total) {
         end = total;
      }   // end 오버플로우 시 total수로 고정
      
      
      startPage = currentPage - (currentPage - 1) % pageBlock; // 시작시 1
      endPage = startPage + pageBlock - 1;
      
      if(endPage > totalPage) {
         endPage = totalPage;
      }
   }
}