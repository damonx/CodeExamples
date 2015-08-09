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

public class ServerThread extends Thread {
	private final RequestQueue requestQueue;

	public ServerThread(final RequestQueue requestQueue, final String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	@Override
	public void run() {
		while (true) {
			final Request request = this.requestQueue.getRequest();
			final FutureData future = (FutureData) request.getResponse();

			final RealData realData = new RealData(request.getName());
			future.setRealData(realData);
			System.out.println(Thread.currentThread().getName() + " handles " + request);
		}
	}
}
