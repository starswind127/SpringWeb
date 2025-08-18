package 종합.예제12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제12.model.dao.BoardDao;

@Service
public class BoardService {
    @Autowired private BoardDao boardDao;

    public boolean boardWrite (BoardDao boardDao){
        System.out.println("BoardService.boardWrite");
        System.out.println("boardDao = " + boardDao);
        boolean result = BoardDao.boardWrite(boardDto);
        return result;
    }
}
