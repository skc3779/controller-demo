package two.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TwoWelcomeController extends MultiActionController  {

	private static final Logger log = LoggerFactory.getLogger(TwoWelcomeController.class);

	@RequestMapping
	public ModelAndView one(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView("twoPage");
		model.addObject("msg", "TwoWelcomeController.one");		
		return model;
	}

	/**
	 * 오류 테스트
	 * @return
	 * @throws Exception
	 */
	@RequestMapping
	public ModelAndView two() throws Exception {
		ModelAndView model = new ModelAndView("twoPage");
		model.addObject("msg", "TwoWelcomeController.two");		
		return model;
	}

	@RequestMapping
	public ModelAndView doPage(HttpServletRequest request,
								HttpServletResponse response) throws Exception {

		log.info("{}", "doPage");
		ModelAndView model = new ModelAndView("twoPage");
		model.addObject("msg", "TwoWelcomeController.doPage");
		return model;
	}

	@RequestMapping
	public ModelAndView jsonOut(HttpServletRequest request,
							 HttpServletResponse response) throws Exception {

		String data = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8.name());
		log.info("jsonOut:data:{}", data);
		Map < String, Object > map = new HashMap<>();

		map.put("ok", true);
		map.put("data", "");
		map.put("data", "success!!");
		return new ModelAndView("", map);
	}

	@RequestMapping
	public ModelAndView jsonIn(HttpServletRequest request,
								HttpServletResponse response) throws Exception {

		String data = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8.name());
		log.info("jsonIn:data:{}", data);


		Map < String, Object > map = new HashMap<>();
		map.put("ok", true);
		map.put("data", "");
		map.put("data", "success!!");

		return new ModelAndView("", map);
	}

}
