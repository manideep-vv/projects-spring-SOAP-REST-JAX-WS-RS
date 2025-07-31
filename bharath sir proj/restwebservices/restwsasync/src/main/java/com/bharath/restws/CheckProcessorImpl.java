package com.bharath.restws;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.bharath.restws.model.ChecksList;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processChecks(AsyncResponse response, ChecksList checksList) {
		// logic
		new Thread() {
			public void run() {
				if (checksList == null || checksList.getChecks() == null || checksList.getChecks().size() == 0) {
					response.resume(new BadRequestException());
				}
				response.resume(true);
			}
		}.start();

	}

}
