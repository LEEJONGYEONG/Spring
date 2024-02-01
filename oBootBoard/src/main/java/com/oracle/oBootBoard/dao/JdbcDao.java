package com.oracle.oBootBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.ui.Model;

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

	@Override
	public void write(String bName, String bTitle, String bContent) {
		// 1. Insert Into mvc_board
		// 2 prepareStatement
		// 3. mvc_board_seq
		// 4. bId , bGroup 같게
		// 5.  bStep, bIndent, bDate --> 0, 0 , sysdate
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String query = 
					"Insert Into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent, bDate ) "
							+ "Values (mvc_board_seq.nextval,?, ?, ?, 0, mvc_board_seq.currval,  0, 0 , sysdate)";
			System.out.println("BDao write  query-->" + query );
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("write  dataSource-->" + e.getMessage() );
			e.printStackTrace();
		} finally {
			try { 
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}				
	}
	
	@Override
	public BDto contentView(String strId) {
		upHit(strId);
		BDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from mvc_board where bId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strId));
			rs = pstmt.executeQuery();

			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		System.out.println("JdbcDao dto.getbName->"+dto.getbName());
		return dto;
	}

	private void upHit(String strId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update mvc_board set bHit = bHit + 1 where bId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void modify(String bId, String bName, String bTitle, String bContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			System.out.println("BDao modify query->" + sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId));
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}	
	}

	@Override
	public BDto replyView(String strId) {
		BDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println("replyView strId->"+strId);
			String sql = "select * from mvc_board where bId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			System.out.println("replyView sql->"+sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				System.out.println("replyView bGroup->"+bGroup);
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} 
		return dto;
	}

	@Override
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		// 홍해 기적
		replyShape(bGroup, bStep);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String query = 
					"Insert Into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
							+ "Values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			System.out.println("BDao reply  query-->" + query );
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("reply  dataSource-->" + e.getMessage() );
			e.printStackTrace();
		} finally {
			try { 
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	private void replyShape(String strGroup, String strStep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(1, Integer.parseInt(strStep));
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("reply  dataSource-->" + e.getMessage() );
			e.printStackTrace();
		} finally {
			try { 
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String bId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String query = "delete from mvc_board where bId = ?";
			pstmt = conn.prepareStatement(query);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("reply  dataSource-->" + e.getMessage() );
			e.printStackTrace();
		} finally {
			try { 
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
} // class
