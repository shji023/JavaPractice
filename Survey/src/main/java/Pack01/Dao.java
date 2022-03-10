package Pack01;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Dao {
	public Boolean setSurvey(DTO dto) {
		String sql =  "insert into survey values(null,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getLiving_region());
			pstmt.setString(5, dto.getRole());
			pstmt.setString(6, dto.getTool());
			pstmt.setString(7, dto.getWts());
			
			int result = pstmt.executeUpdate();

			if(result == 1)
			{
				return true;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
}
