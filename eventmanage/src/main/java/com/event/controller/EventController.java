package com.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.event.exception.CommonException;
import com.event.model.WebRequest;
import com.event.model.WebResponse;
import com.event.service.EventService;
import com.event.transformation.utils.CommonCodes;
import com.google.gson.Gson;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	/**
	 * Creating object for google gson.
	 */
	private Gson gson = new Gson();

	@RequestMapping(value = "/getEvents", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public WebResponse fetchAllEvents() {
		System.out.println("In fetchAllEvents()");
		WebResponse webResponse = new WebResponse();
		try {
			webResponse.setEventMap(eventService.getAllEvents());
		} catch (CommonException e) {
			System.err.println(e);
		}
		System.out.println(gson.toJson(webResponse));

		return webResponse;
	}

	@RequestMapping(value = "/addEvent", method = RequestMethod.POST, consumes = "application/json")
	public String addNewEvent(@RequestBody WebRequest webRequest) {

		try {
			return eventService.addEvent(webRequest);
		} catch (CommonException e) {
			System.err.println(e);
			return CommonCodes.ERROR;
		}

	}

	@RequestMapping(value = "/removeEvent", method = RequestMethod.POST, consumes = "application/json")
	public String removeEvent(WebRequest webRequest) {
		try {
			return eventService.removeEvent(webRequest);
		} catch (CommonException e) {
			System.err.println(e);
			return CommonCodes.ERROR;
		}

	}

}
