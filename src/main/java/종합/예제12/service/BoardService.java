package 종합.예제12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import 종합.예제12.model.dao.BoardDao;
import 종합.예제12.model.dto.BoardDto;

import java.util.List;

@Service
public class BoardService {

    @Autowired private BoardDao boardDao;

    public boolean boardWrite (BoardDto boardDto){
        System.out.println("BoardService.boardWrite");
        System.out.println("boardDao = " + boardDao);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    }
    public List<BoardDto> boardPrint(){
        System.out.println("BoardService.boardPrint");
        List<BoardDto> result = boardDao.boardPrint();

        return result;
    }
    public BoardDto boardFind(int bno){
        System.out.println("BoardService.boardFind");
        System.out.println("bno = " + bno);
        BoardDto result = boardDao.boardFind(bno);
        return result;
    }
    public boolean boardDelete(int bno){
        System.out.println("BoardService.boardDelete");
        System.out.println("bno = " + bno);
        boolean result = boardDao.boardDelete(bno);
        return result;
    }
    public boolean boardUpdate(BoardDto boardDto){
        System.out.println("BoardService.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardDao.boardUpdate(boardDto);
        return result;

    }
}
