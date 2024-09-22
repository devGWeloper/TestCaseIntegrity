package controller;

import dto.DataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.DataService;

import java.util.List;

@Controller
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute DataDTO searchCriteria, Model model) {
        List<DataDTO> results = dataService.searchData(searchCriteria);
        model.addAttribute("results", results);
        return "index :: #dataTable";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("data", new DataDTO());
        return "create-popup";
    }

    @PostMapping("/create")
    public String createData(@ModelAttribute DataDTO data) {
        dataService.createData(data);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String showDetailPopup(@PathVariable Long id, Model model) {
        DataDTO data = dataService.getDataById(id);
        model.addAttribute("data", data);
        return "detail-popup";
    }
}