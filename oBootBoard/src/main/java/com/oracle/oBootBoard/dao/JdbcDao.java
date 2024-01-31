package com.oracle.oBootBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.oracle.oBootBoard.dto.BDto;

public class JdbcDao implements BDao {
	
	// JDBC 사용
	private final DataSource dataSource;
	
	public JdbcDao (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private Connection getConnection() {
		return DataSourceUtils.getConnection(dataSource);
	}

	@Override
	public ArrayList<BDto> boardList() {
		ArrayList<BDto> bList = new ArrayList<BDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";	
			pstmt = conn.prepareStatement(sql);
			System.out.println("BDao query ->" + sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// BDto bDto = new BDto();
				// bDto.setbId(rs.getInt("bId"));
				// bDto.setbName(rs.getString("bName"));
				// bDto.setbTitle(rs.getString("bTitle"));
				// bDto.setbContent(rs.getString("bContent"));
				// bDto.setbDate(rs.getTimestamp("bDate"));
				// bDto.setbHit(rs.getInt("bHit"));
				// bDto.setbGroup(rs.getInt("bGroup"));
				// bDto.setbStep(rs.getInt("bStep"));
				// bDto.setbIndent(rs.getInt("bIndent"));
				
				// 생성자 방식으로
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				BDto bDto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				bList.add(bDto);
			}
			
		} catch (SQLException e) {
			System.out.println("list dataSource ->" + e.getMessage());
		} finally {
			try {
				if (rs !=null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn !=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bList;
	} // boardList ()

	public static void write(String bName, String bTitle, String bContent) {
		// 1. Insert Into mvc_board
		// 2 prepareStatement
		// 3. mvc_board_seq
		// 4. bId , bGroup 같게
		// 5.  bStep, bIndent, bDate --> 0, 0 , sysdate
		
	}
	
} // class
