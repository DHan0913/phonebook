package himedia.phonebook.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.phonebook.exceptions.MainControllerException;
import himedia.phonebook.repositories.vo.PhonebookVo;
import himedia.phonebook.services.PhonebookService;

@Controller
public class PhonebookController {

	private static final Logger logger = LoggerFactory.getLogger(PhonebookController.class);

	@Autowired
	private PhonebookService phonebookService;

	@GetMapping({ "", "/", "/phonebook" })
	public String main(Model model) {
		logger.debug("폰북 메인 페이지");
		List<PhonebookVo> list = phonebookService.getMessageList();
		model.addAttribute("list", list);
		return "phonebook/list";
	}

    @PostMapping("/delete")
    public String deletePhonebookEntry(@RequestParam("id") Long id) {
        boolean deleted = phonebookService.delete(id);
        if (deleted) {
            return "redirect:/phonebook"; // 삭제 후 목록 페이지로 리다이렉트
        } else {
            // 삭제 실패 시 처리할 내용 추가
            return "error-page";
        }
    }
    
    @GetMapping("/addform")
    public String showAddForm(Model model) {
        logger.debug("주소록 추가 폼 요청");
        model.addAttribute("phonebookVo", new PhonebookVo());
        return "phonebook/addform"; 
    }

	@GetMapping("/except")
	@ResponseBody
	public String raiseExcept() {
		throw new MainControllerException("메인 컨트롤러에서 예외가 발생했습니다!");
	}
}
