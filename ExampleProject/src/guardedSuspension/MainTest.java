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

public class MainTest {

	public static void main(final String[] args) {
		final RequestQueue requestQ = new RequestQueue();
		for (int i = 0; i < 10; i++) {
			new ServerThread(requestQ, "serverThread" + i).start();
		}

		for (int i = 0; i < 10; i++) {
			new ClientThread(requestQ, "ClientThread" + i).start();
		}
	}

}
