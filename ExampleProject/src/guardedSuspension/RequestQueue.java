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

import java.util.LinkedList;
import java.util.List;

public class RequestQueue {
	private final List<Request> queue = new LinkedList<>();

	public synchronized Request getRequest() {
		while (this.queue.size() == 0) {
			try {
				wait();
			} catch (final InterruptedException e) {
			}
		}
		return this.queue.remove(0);
	}

	public synchronized void addRequest(final Request request) {
		this.queue.add(request);
		notifyAll();
	}
}
