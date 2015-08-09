/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2015).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package guardedSuspension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClientThread extends Thread {

	private final RequestQueue requestQueue;
	private final List<Request> myRequest = new ArrayList<Request>();

	public ClientThread(final RequestQueue requestQueue, final String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			final Request request = new Request("Request ID: " + i + " Thread Name: " + Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			request.setResponse(new FutureData());
			this.requestQueue.addRequest(request);
			this.myRequest.add(request);
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}

			for (final Request r : this.myRequest) {
				System.out.println("ClientThread Name is: " + Thread.currentThread().getName() + " Response is: "
						+ r.getResponse().getResult());
			}

		}

	}

}
