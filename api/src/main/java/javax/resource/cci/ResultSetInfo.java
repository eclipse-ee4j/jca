/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javax.resource.cci;


import javax.resource.ResourceException;

/** 
 * The interface <code>javax.resource.cci.ResultSetInfo</code> provides
 * information on the support provided for ResultSet by a connected 
 * EIS instance. A component calls the method 
 * <code>Connection.getResultInfo</code> to get the ResultSetInfo instance. 
 * 
 * <p>A CCI implementation is not required to support 
 * <code>javax.resource.cci.ResultSetInfo</code> interface. The 
 * implementation of this interface is provided only if the CCI 
 * supports the ResultSet facility.
 * 
 * @version     0.9
 * @author      Rahul Sharma
 * @see         javax.resource.cci.Connection
 * @see         java.sql.ResultSet
 * @see         javax.resource.cci.ConnectionMetaData
 */

public interface ResultSetInfo {
  
  /** 
   * Indicates whether or not a visible row update can be detected 
   * by calling the method <code>ResultSet.rowUpdated</code>.
   *
   * @param   type    type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return          true if changes are detected by the result set 
   *                  type; false otherwise
   * @see     java.sql.ResultSet#rowUpdated
   * @throws  ResourceException   Failed to get the information
   */
  public 
  boolean updatesAreDetected(int type)  throws ResourceException;

  /** 
   * Indicates whether or not a visible row insert can be detected
   * by calling ResultSet.rowInserted.
   *
   * @param   type    type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return          true if changes are detected by the result set 
   *                  type; false otherwise
   * @see     java.sql.ResultSet#rowInserted
   * @throws  ResourceException   Failed to get the information
   */
  public 
  boolean insertsAreDetected(int type)  throws ResourceException;
	
  /** 
   * Indicates whether or not a visible row delete can be detected by
   * calling ResultSet.rowDeleted.  If deletesAreDetected
   * returns false, then deleted rows are removed from the ResultSet.
   *
   * @param   type    type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return          true if changes are detected by the result set 
   *                  type; false otherwise
   * @see     java.sql.ResultSet#rowDeleted
   * @throws  ResourceException   Failed to get the information
   */
  public
  boolean deletesAreDetected(int type)  throws ResourceException;
  
  /** 
   * Indicates whether or not a resource adapter supports a type
   * of ResultSet.
   *     
   * @param   type  type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return        true if ResultSet type supported; false otherwise
   * @throws  ResourceException   Failed to get the information
   */
  public 
  boolean supportsResultSetType(int type) throws ResourceException;

  /** 
   * Indicates whether or not a resource adapter supports the 
   * concurrency type in combination with the given ResultSet type/
   *
   * @param   type        type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @param   concurrency ResultSet concurrency type defined in
   *                      java.sql.ResultSet
   * @return  true if the specified combination supported; false otherwise
   * @throws  ResourceException   Failed to get the information
   */
  public 
  boolean supportsResultTypeConcurrency(int type,
					int concurrency)  throws ResourceException;


  /** 
   * Indicates whether updates made by others are visible.
   *
   * @param    type       type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return              true if updates by others are visible for the
   *                      ResultSet type; false otherwise
   * @throws  ResourceException   Failed to get the information
   */
  public
  boolean othersUpdatesAreVisible(int type)  throws ResourceException;

  /**
   * Indicates whether deletes made by others are visible.
   *
   * @param    type       type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return              true if deletes by others are visible for the
   *                      ResultSet type; false otherwise
   * @throws  ResourceException   Failed to get the information
   */
  public
  boolean othersDeletesAreVisible(int type)  throws ResourceException;
    
  /**
   * Indicates whether inserts made by others are visible.
   *
   * @param    type       type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return              true if inserts by others are visible for the
   *                      ResultSet type; false otherwise
   * @throws  ResourceException   Failed to get the information
   */
  public
  boolean othersInsertsAreVisible(int type) throws ResourceException;


  /**
   * Indicates whether a ResultSet's own updates are visible.
   *
   * @param    type       type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return              true if updates are visible for the ResultSet
   *                      type; false otherwise
   * @throws  ResourceException   Failed to get the information
   */
  public
  boolean ownUpdatesAreVisible(int type) throws ResourceException;

  /** 
   * Indicates whether a ResultSet's own inserts are visible.
   *
   * @param    type       type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return              true if inserts are visible for the ResultSet
   *                      type; false otherwise
   * @throws  ResourceException   Failed to get the information
   */  
  public 
  boolean ownInsertsAreVisible(int type) throws ResourceException;

  /**
   * Indicates whether a ResultSet's own deletes are visible.
   *
   * @param    type       type of the ResultSet i.e. ResultSet.TYPE_XXX
   * @return              true if inserts are visible for the ResultSet
   *                      type; false otherwise
   * @throws  ResourceException   Failed to get the information
   */  
  public 
  boolean ownDeletesAreVisible(int type) throws ResourceException;

}
