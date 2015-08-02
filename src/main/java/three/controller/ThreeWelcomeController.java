package three.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThreeWelcomeController {

	private static final Logger log = LoggerFactory.getLogger(ThreeWelcomeController.class);

	@RequestMapping(value="/controller/threewelcome/one/{one}", method=RequestMethod.GET)
	public ModelAndView one(@PathVariable("one")String one, HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		ModelAndView model = new ModelAndView("threePage");
		model.addObject("msg", "ThreeWelcomeController.one"+":"+one);		
		return model;
	}

	@RequestMapping(value="/controller/threewelcome/two", method=RequestMethod.GET)
	@ResponseBody
	public Object two() throws Exception {		
		return new ResultData(true, "ThreeWelcomeController.two");
	}

	@RequestMapping(value="/controller/threewelcome/three", method=RequestMethod.POST)
	@ResponseBody
	public Object three(@RequestBody String jsonString, @RequestParam("name") String name) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();

		//jsonString = StringEscapeUtils

		log.info("jsonString:{}", jsonString);
		log.info("jsonString decode:{}", URLDecoder.decode(jsonString,"utf-8"));
		log.info("name:{}", name);
		//Map map = objectMapper.readValue(jsonString, Map.class);
		//log.info("map.size:{}", map.size());

		return new ResultData(true, "ThreeWelcomeController.three");
	}

	class ResultData {
		Boolean ok;
		String data;
		public ResultData(Boolean ok, String data) {
			this.ok = ok;
			this.data = data;
		}
		public String getData() {
			return this.data;
		}		
		public void setData(String data) {
			this.data = data;
		}
		public Boolean getOk() {
			return this.ok;
		}
		public void setOk(Boolean ok) {
			this.ok = ok;
		}
	}
}
