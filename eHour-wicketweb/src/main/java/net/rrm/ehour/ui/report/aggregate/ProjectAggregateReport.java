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

package net.rrm.ehour.ui.report.aggregate;

import java.io.Serializable;

import net.rrm.ehour.report.criteria.ReportCriteria;
import net.rrm.ehour.report.reports.element.AssignmentAggregateReportElement;
import net.rrm.ehour.report.reports.element.ReportElement;
import net.rrm.ehour.ui.common.report.ReportConfig;
import net.rrm.ehour.ui.report.AbstractAggregateReport;
import net.rrm.ehour.ui.report.aggregate.node.CustomerNode;
import net.rrm.ehour.ui.report.aggregate.node.ProjectNode;
import net.rrm.ehour.ui.report.aggregate.node.UserEndNode;
import net.rrm.ehour.ui.report.node.ReportNode;
import net.rrm.ehour.ui.report.node.ReportNodeFactory;

/**
 * Project aggregate report
 * Created on Mar 12, 2009, 3:30:33 PM
 * @author Thies Edeling (thies@te-con.nl) 
 *
 */
public class ProjectAggregateReport extends AbstractAggregateReport
{
	private static final long serialVersionUID = 6073113076906501807L;

	/**
	 * 
	 * @param reportData
	 */
	public ProjectAggregateReport(ReportCriteria reportCriteria)
	{
		super(reportCriteria, ReportConfig.AGGREGATE_PROJECT);
	}

	/*
	 * (non-Javadoc)
	 * @see net.rrm.ehour.ui.report.aggregate.AggregateReport#getReportNodeFactory()
	 */
	@Override
	public ReportNodeFactory getReportNodeFactory()
	{
    	return new ReportNodeFactory()
	    {
	        @Override
	        public ReportNode createReportNode(ReportElement element, int hierarchyLevel)
	        {
	        	AssignmentAggregateReportElement aggregate = (AssignmentAggregateReportElement)element;
	        	
	            switch (hierarchyLevel)
	            {
	                case 0:
	                    return new ProjectNode(aggregate, hierarchyLevel);
	                case 1:
	                    return new CustomerNode(aggregate, hierarchyLevel);
	                case 2:
	                    return new UserEndNode(aggregate, hierarchyLevel);
	                default:
	                	throw new RuntimeException("Hierarchy level too deep");
	            }
	
	            
	        }
	
	        /**
	         * Only needed for the root node, customer
	         * @param aggregate
	         * @return
	         */
	
	        public Serializable getElementId(ReportElement element)
	        {
	        	AssignmentAggregateReportElement aggregate = (AssignmentAggregateReportElement)element;
	        	
	            return aggregate.getProjectAssignment().getProject().getPK();
	        }
	    };
	}
}
