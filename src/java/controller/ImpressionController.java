
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Impression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImpressionController {
    @RequestMapping(value = "/impression", method = RequestMethod.GET)
    public String createForm(ModelMap model){
        
        model.addAttribute("impression", new Impression());
        try {
            model.addAttribute("impressions", Impression.allImpresions());
        } catch (Exception ex) {
            Logger.getLogger(ImpressionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "impression";
    
    }
    
    @RequestMapping(value = "/impression", method = RequestMethod.POST)
    public String addImpression(@ModelAttribute("impression") Impression impression, ModelMap model){
      
        try {
            impression.insertImpression();
            createForm(model);
        } catch (Exception ex) {
            Logger.getLogger(ImpressionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "impression";
}
}
