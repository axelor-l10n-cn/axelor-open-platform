/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2005-2014 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.script;

import org.junit.Assert;
import org.junit.Test;

public class TestContext extends ScriptTest {

	private String message = "Hello world...";

	public String hello() {
		return message;
	}

	@Test
	public void testConfigContext() {

		ScriptBindings bindings = new ScriptBindings(this.context());
		ScriptHelper helper = new GroovyScriptHelper(bindings);

		Object hello = helper.eval("hello");
		Object world = helper.eval("world");
		Object result = helper.eval("hello.hello()");

		Assert.assertNotNull(hello);
		Assert.assertNotNull(world);
		Assert.assertNotNull(result);

		Assert.assertTrue(hello instanceof TestContext);
		Assert.assertEquals(message, world);
		Assert.assertEquals(message, result);
	}
}
