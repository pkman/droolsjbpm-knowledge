/*
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.api.runtime.manager.audit;

import java.util.Date;
/**
 * Audit view of node instance where each node instance (in most of the cases) will have two entries:
 * <ul>
 * 	<li>when node instance was triggered</li>
 * 	<li>when node instance was left - completed</li>
 *</ul>
 */
public interface NodeInstanceLog {
	
	/**
	 * Indicates that node instance was triggered
	 */
	public static final int TYPE_ENTER = 0;
	
	/**
	 * Indicates that node instance was left (it's no more active)
	 */
	public static final int TYPE_EXIT = 1;

	/**
	 * Process instance identifier
	 * @return
	 */
    Long getProcessInstanceId();

    /**
	 * Process id of the definition
	 * @return
	 */
    String getProcessId();

    /**
     * Unique identifier of the node instance
     * @return
     */
    String getNodeInstanceId();
    
    /**
     * Identifier of the node which usually is the unique identifier from process definition,
     * but can be unique identifier assigned by the engine when unique id is not available
     * @return
     */
	String getNodeId();
	
	/**
	 * Name of the node from process definition
	 * @return
	 */
	String getNodeName();

	/**
	 * Date on when this node was triggered
	 * @return
	 */
	Date getDate();
	
	/**
	 * Identifier of work item that this node refers to, might be null if it's not work item based node
	 * @return
	 */
	Long getWorkItemId();

	/**
	 * Incoming or outgoing connection identifier (sequence flow) for given node.
	 * Incoming or outgoing depends on the type of the node instance log entry where 
	 * <ul>
	 * 	<li>entry type will contain incoming sequence flow</li>
	 * 	<li>exit type will contain outgoing sequence flow</li>
	 * </ul>
	 * @return
	 * 
	 * @see NodeInstanceLog#getType()
	 */
    String getConnection();

    /**
	 * External (optional) identifier associated with this process instance
	 * @return
	 */
    String getExternalId();

    /**
     * Node type that indicates what sort of activity it was e.g. Human Task, Script Task, etc
     * @return
     */
    String getNodeType();
    
    /**
     * Type of the node instance log entry - Entry or Exit
     * @return
     * @see NodeInstanceLog#TYPE_ENTER
     * @see NodeInstanceLog#TYPE_EXIT
     */
	Integer getType();
    
}
