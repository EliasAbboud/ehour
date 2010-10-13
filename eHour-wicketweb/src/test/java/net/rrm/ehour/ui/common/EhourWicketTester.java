/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.rrm.ehour.ui.common;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequestCycle;
import org.apache.wicket.util.tester.WicketTester;

/**
 * TODO 
 **/

public class EhourWicketTester extends WicketTester
{
	public EhourWicketTester(WebApplication webapp)
	{
		super(webapp);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.apache.wicket.protocol.http.MockWebApplication#setupRequestAndResponse()
	 */
	public WebRequestCycle setupRequestAndResponse()
	{
		// is ajax
		return setupRequestAndResponse(true);
	}	
}
