package 종합.예제12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dao.BoardDao;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

import java.util.List;


@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired private BoardService boardService;

    @PostMapping("")
    public boolean boardWrite(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.boardWrite");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.boardWrite ( boardDto );
        return result;
    }
    @GetMapping("")
    public List<BoardDto> boardPrint(){
        System.out.println("BoardController.boardPrint");
        List<BoardDto> result = boardService.boardPrint();
        return result;
    }
    @GetMapping("/find")
    public BoardDto boardFind(@RequestParam int bno){
        System.out.println("BoardController.boardFind");
        System.out.println("bno = " + bno);
        BoardDto result = boardService.boardFind(bno);
        return result;
    }
    @DeleteMapping("")
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        boolean result = boardService.boardDelete(bno);
        return result;
    }
    @PutMapping("")
    public boolean boardUpdate( @RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.boardUpdate(boardDto);
        return result;

    }
}
