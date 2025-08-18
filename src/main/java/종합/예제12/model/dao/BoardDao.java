package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class BoardDao extends Dao {
    public boolean boardWrite(BoardDto boardDto){
        try {
            String sql = "insert into board(bcontent,bwriter)values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) {System.out.println(e);}
        return false;
    }
}
