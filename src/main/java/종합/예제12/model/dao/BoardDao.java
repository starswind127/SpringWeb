package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao {

    public boolean boardWrite(BoardDto boardDto){
        System.out.println("BoardDao.boardWrite");
        System.out.println("boardDto = " + boardDto);
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
    public List<BoardDto>boardPrint(){
        System.out.println("BoardDao.boardPrint");
        List<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next()){
                BoardDto boardDto = new BoardDto();
                boardDto.setBno( rs.getInt("bno"));
                boardDto.setBcontent( rs.getString ("bcontent"));
                boardDto.setBwriter( rs.getString("bwriter"));
                list.add( boardDto ) ;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public BoardDto boardFind( int bno ){
        try {
            String sql = "select * from board where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, bno);
            ResultSet rs = ps.executeQuery();
            if ( rs.next()){
                BoardDto boardDto = new BoardDto();
                boardDto.setBno( rs.getInt(1));
                boardDto.setBcontent(rs.getString(2));
                boardDto.setBwriter(rs.getString(3));
                return boardDto;
            }
        } catch (Exception e) {System.out.println(e);}
        return null;
    }
    public boolean boardDelete( int bno ){
        System.out.println("BoardDao.boardDelete");
        System.out.println("bno = " + bno);
        try {
            String sql = "delete from board where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if (count == 1) return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean boardUpdate(BoardDto boardDto) {
        try {
            String sql = "Update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardDto.getBcontent());
            ps.setInt(2,boardDto.getBno());
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}
