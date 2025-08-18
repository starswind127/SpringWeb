package 종합.예제12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;


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
}
