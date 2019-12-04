package manhtk.practise.controller;

import manhtk.practise.model.Phone;
import manhtk.practise.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/create")
    public ModelAndView createPhone(){
        ModelAndView modelAndView = new ModelAndView("phone/create");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }
    @RequestMapping(value = "/savePhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  void savePhone(@RequestBody Phone phone){
        phoneService.save(phone);
    }

    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Phone> Phones() {
        return phoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView listPhone() {
        ModelAndView modelAndView = new ModelAndView("phone/list");
        modelAndView.addObject("phones", Phones());
        return modelAndView;
    }

    //	Delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deletePhone(@PathVariable Long id) {
        phoneService.remove(id);
    }

    //Edit
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editPhonePage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("phone/edit");
        Phone phone = phoneService.findById(id);
        modelAndView.addObject("Phone", phone);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void editPhone(@PathVariable long id,
                                     @RequestBody Phone phone) {
        phone.setId(id);
        phoneService.save(phone);
    }
}
